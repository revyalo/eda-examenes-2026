from __future__ import annotations

import shutil
import textwrap
from pathlib import Path

from reportlab.lib import colors
from reportlab.lib.pagesizes import A4
from reportlab.lib.styles import ParagraphStyle, getSampleStyleSheet
from reportlab.lib.units import cm
from reportlab.platypus import Paragraph, SimpleDocTemplate, Spacer, Table, TableStyle


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
BASE = ROOT / "Esqueletos" / "Implementación - Esqueleto"
OUT = ROOT / "EDA_Examenes_2026" / "07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS"


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).lstrip(), encoding="utf-8")


def slug(text: str) -> str:
    repl = str.maketrans("áéíóúüñÁÉÍÓÚÜÑ", "aeiouunAEIOUUN")
    clean = text.translate(repl)
    out = []
    for ch in clean:
        out.append(ch.lower() if ch.isalnum() else "_")
    return "_".join(part for part in "".join(out).split("_") if part)


def copy_professor_base(project: Path, include_env: bool = True) -> None:
    project.mkdir(parents=True, exist_ok=True)
    shutil.copy2(BASE / "pom.xml", project / "pom.xml")
    if include_env:
        src = BASE / "src/main/java/es/urjc/grafo/EDA"
        dst = project / "src/main/java/es/urjc/grafo/EDA"
        for child in src.iterdir():
            if child.name == "examen":
                continue
            shutil.copytree(
                child,
                dst / child.name,
                ignore=shutil.ignore_patterns(".DS_Store", "target", "out", ".idea"),
                dirs_exist_ok=True,
            )


IMPLEMENTATION_GROUPS = {
    "grafos_prioritarios": [
        ("shortestDistanceLessOrEqual", "Grafo", "Alta", "Dado un grafo, origen, destino y n, devolver la distancia minima si es <= n; si no, -1."),
        ("verticesAtDistanceK", "Grafo", "Media-alta", "Devolver todos los vertices exactamente a distancia k desde un vertice inicial."),
        ("verticesWithinDistanceK", "Grafo", "Media-alta", "Devolver todos los vertices alcanzables con distancia <= k."),
        ("graphSquareWithoutDuplicates", "Grafo", "Alta", "Construir G^2, anadiendo aristas entre nodos a distancia 2 o menor, evitando bucles y duplicados."),
        ("limitedBFSPath", "Grafo", "Alta", "Devolver el camino real entre dos vertices si existe con longitud <= n."),
        ("isConnectedWithLimit", "Grafo", "Alta", "Comprobar si desde cualquier vertice se puede llegar a todos los demas con distancia maxima <= k."),
        ("eccentricity", "Grafo", "Alta", "Dado un vertice, devolver la mayor distancia minima desde el a cualquier otro vertice."),
        ("graphDiameter", "Grafo", "Alta", "Calcular el diametro de un grafo no dirigido no ponderado."),
        ("centralVertex", "Grafo", "Alta", "Devolver el vertice con menor excentricidad."),
        ("isTreeGraph", "Grafo", "Media-alta", "Comprobar si un grafo no dirigido es arbol: conexo y con n - 1 aristas."),
        ("hasCycleUndirected", "Grafo", "Alta", "Detectar si hay ciclos en un grafo no dirigido usando DFS/BFS con padre."),
        ("connectedComponents", "Grafo", "Alta", "Devolver el numero de componentes conexas."),
        ("largestConnectedComponentSize", "Grafo", "Alta", "Devolver el tamano de la mayor componente conexa."),
        ("removeIsolatedVertices", "Grafo", "Media-alta", "Eliminar todos los vertices sin aristas incidentes y devolver cuantos se han eliminado."),
        ("complementaryIfConnected", "Grafo", "Alta", "Construir el complementario solo si el grafo original es conexo; si no, devolver null."),
    ],
    "grafos_avanzados": [
        ("kClosure", "Grafo", "Muy alta", "Construir un grafo con arista entre u y v si existe camino de longitud <= k, optimizando con BFS por vertice."),
        ("minimumBroadcastRoot", "Grafo", "Muy alta", "Elegir el vertice que minimiza el maximo nivel de difusion."),
        ("broadcastTreeFrom", "Grafo", "Muy alta", "Construir el arbol BFS de difusion desde un vertice inicial."),
        ("sameConnectedComponent", "Grafo", "Media", "Comprobar si dos vertices pertenecen a la misma componente sin recorrer mas de lo necesario."),
        ("bridgesSimpleVersion", "Grafo", "Muy alta", "Devolver las aristas cuya eliminacion desconecta el grafo."),
        ("isBipartite", "Grafo", "Alta", "Colorear el grafo con BFS en dos colores y detectar conflictos."),
        ("distanceMapFromVertex", "Grafo", "Alta", "Devolver un mapa vertice -> distancia minima desde un origen."),
        ("reachableIgnoringVertex", "Grafo", "Alta", "Comprobar si dos vertices siguen conectados al eliminar temporalmente un vertice prohibido."),
        ("countShortestPaths", "Grafo", "Muy alta", "Contar cuantos caminos minimos hay entre dos vertices."),
        ("graphPowerEdgesCount", "Grafo", "Alta", "Sin construir el grafo potencia, devolver cuantas aristas tendria G^k."),
    ],
    "arboles_binarios_y_generales": [
        ("isAlmostComplete", "Arbol binario", "Alta", "Comprobar si el arbol es casi completo."),
        ("isMinHeap", "Arbol binario", "Alta", "Comprobar la propiedad de prioridad padre-hijos sin exigir casi completitud."),
        ("isHeap", "Arbol binario", "Alta", "Comprobar casi completo + propiedad de prioridad."),
        ("heapDegreeViolation", "Arbol binario", "Alta", "Devolver el primer nodo que viola la propiedad de monticulo."),
        ("lastNodeInLevelOrder", "Arbol binario", "Media-alta", "Devolver el ultimo nodo en recorrido por niveles."),
        ("isCompleteUntilLevel", "Arbol binario", "Alta", "Comprobar si todos los niveles salvo quizas el ultimo estan completos."),
        ("width", "Arbol", "Media-alta", "Devolver el maximo numero de nodos en un mismo nivel."),
        ("levelWithMoreNodes", "Arbol", "Media-alta", "Devolver el nivel con mas nodos."),
        ("areCousins", "Arbol binario", "Alta", "Dos nodos son primos si estan al mismo nivel y tienen distinto padre."),
        ("lowestCommonAncestor", "Arbol binario", "Alta", "Devolver el ancestro comun mas bajo de dos posiciones."),
        ("isBalanced", "Arbol binario", "Alta", "Comprobar si para todo nodo las alturas de subarboles difieren como mucho en 1."),
        ("diameter", "Arbol binario", "Muy alta", "Longitud del camino mas largo entre dos nodos."),
        ("removeLeaves", "Arbol", "Alta", "Eliminar todas las hojas y devolver cuantas se han borrado."),
        ("pruneBelowDepth", "Arbol", "Alta", "Eliminar todos los nodos a profundidad mayor que k."),
        ("mirrorCopy", "Arbol binario", "Media-alta", "Crear una copia especular del arbol sin modificar el original."),
        ("isMirrorOf", "Arbol binario", "Media-alta", "Comprobar si dos arboles son espejo."),
        ("hasSameShape", "Arbol binario", "Media", "Comprobar si dos arboles tienen la misma forma ignorando valores."),
        ("areIdenticalIgnoringLeaves", "Arbol binario", "Alta", "Comparar solo nodos internos."),
        ("descendantsAtDistanceK", "Arbol", "Alta", "Devolver descendientes exactamente a distancia k de un nodo."),
        ("degreeDistribution", "Arbol general", "Alta", "Devolver cuantos nodos hay de grado 0, 1, 2, etc."),
    ],
    "iteradores": [
        ("InordenIteratorWithRemove", "Iterador arbol binario", "Alta", "Implementar remove en un iterador inorden."),
        ("ReverseInordenBTIteratorWithRemove", "Iterador arbol binario", "Muy alta", "Implementar remove en un iterador inorden inverso."),
        ("SkipLeavesIterator", "Iterador arbol", "Media-alta", "Iterador que recorre solo nodos internos."),
        ("LeafIterator", "Iterador arbol", "Media-alta", "Iterador que devuelve solo hojas."),
        ("LevelLimitedIterator", "Iterador arbol", "Alta", "Iterador BFS que solo devuelve nodos hasta un nivel maximo."),
        ("BetweenLevelsIterator", "Iterador arbol", "Alta", "Iterador que devuelve nodos entre niveles min y max."),
        ("WithoutSiblingIteratorVariant", "Iterador arbol", "Alta", "Iterador que devuelve nodos que no tienen hermanos."),
        ("InternalNodeIteratorWithRemove", "Iterador arbol", "Muy alta", "Iterador de nodos internos con remove correcto."),
        ("BreadthFirstEvenLevelIterator", "Iterador arbol", "Alta", "Iterador que devuelve solo nodos en niveles pares."),
        ("PathIterator", "Iterador arbol", "Muy alta", "Iterar desde un nodo hasta la raiz o desde raiz hasta un nodo objetivo."),
    ],
    "abb_avl_diccionarios": [
        ("rangeCount", "ABB / diccionario ordenado", "Alta", "Contar entradas con clave entre k1 y k2."),
        ("removeRange", "ABB", "Muy alta", "Eliminar todos los elementos en un rango."),
        ("floor", "ABB", "Alta", "Mayor clave menor o igual que k."),
        ("ceiling", "ABB", "Alta", "Menor clave mayor o igual que k."),
        ("predecessor", "ABB", "Alta", "Devolver el predecesor de una clave."),
        ("successor", "ABB", "Alta", "Devolver el sucesor de una clave."),
        ("kSmallest", "ABB", "Alta", "Devolver los k menores elementos en orden."),
        ("isBST", "Arbol binario", "Alta", "Comprobar si un arbol binario cualquiera cumple propiedad de ABB."),
        ("mergeWithoutDuplicates", "ABB", "Muy alta", "Fusionar dos ABB evitando claves repetidas."),
        ("splitByKey", "ABB", "Muy alta", "Separar en dos arboles: claves menores que k y mayores/iguales."),
        ("heightIfInserted", "ABB", "Media-alta", "Devolver a que profundidad se insertaria una clave sin insertarla."),
        ("countRepeatedKeys", "Diccionario ordenado", "Alta", "Si admite repetidos, contar cuantas entradas hay con la misma clave."),
        ("findAllInRange", "Diccionario ordenado", "Alta", "Devolver todas las entradas entre dos claves, incluyendo repetidas."),
        ("isAVL", "AVL", "Muy alta", "Comprobar propiedad ABB + balance AVL + alturas correctas."),
        ("firstUnbalancedNode", "AVL", "Muy alta", "Devolver el primer nodo que rompe el balance AVL."),
    ],
}


CASE_USE_EXERCISES = [
    ("URJCNetServicesTTL", "URJCNetServices 2: red de routers con TTL", ["HashMap<String, Router> routers", "HashMap<String, HashSet<String>> conexiones", "HashMap<String, Mensaje> mensajes", "TreeMap<LocalDateTime, HashSet<String>> mensajesPorFecha"], ["addRouter", "addConnection", "recibirMensaje", "routersAlcanzables", "borrarMensajesAntiguos", "routerMasConectado"]),
    ("CNIContactosIndirectos", "CNI: detector de contactos indirectos", ["HashMap<String, Agente> agentes", "HashMap<String, HashSet<String>> contactos", "HashMap<String, HashSet<String>> contactosPorZona", "TreeMap<LocalDateTime, HashSet<String>> interaccionesPorFecha"], ["addAgente", "registrarContacto", "hanInteractuado", "posibleCadenaContagio", "grupoDeAgente", "interaccionesAntesDe"]),
    ("RegistroCNPAvanzado", "Registro CNP avanzado", ["HashMap<String, Opositor> opositoresPorDni", "HashMap<String, HashSet<String>> opositoresPorProvincia", "TreeSet<Opositor> rankingPorNota", "TreeMap<Double, HashSet<String>> opositoresPorNota"], ["addOpositor", "actualizarNota", "top", "aptosPorProvincia", "opositoresEntreNotas", "eliminarOpositor"]),
    ("RedElectricaSinGraph", "Red electrica sin Graph", ["HashMap<String, Estacion> estaciones", "HashMap<String, HashSet<String>> red", "HashMap<String, HashSet<String>> estacionesPorArea", "TreeSet<Estacion> estacionesPorConsumo"], ["addEstacion", "connect", "estanConectadas", "areaAislada", "estacionMasCritica", "estacionesAlcanzables"]),
    ("RedP2PBusquedaArchivos", "Red P2P con busqueda de archivos", ["HashMap<String, Nodo> nodos", "HashMap<String, HashSet<String>> conexiones", "HashMap<String, HashSet<String>> archivosPorNodo", "HashMap<String, HashSet<String>> nodosPorArchivo"], ["addNode", "addConnection", "addFile", "buscarArchivo", "nodosConArchivo", "nodoMasCompartidor"]),
    ("URJCFlightsSinGraph", "URJCFlights sin Graph", ["HashMap<String, Aeropuerto> aeropuertos", "HashMap<String, HashSet<String>> vuelosSalientes", "HashMap<String, HashSet<String>> vuelosEntrantes", "TreeMap<LocalDateTime, HashSet<String>> vuelosPorHora", "HashMap<String, Vuelo> vuelosPorCodigo"], ["addAirport", "addFlight", "hayVueloDirecto", "hayConexionConEscalas", "vuelosEntreFechas", "aeropuertoConMasSalidas"]),
    ("LigaDeportivaRanking", "Liga deportiva y ranking de equipos", ["HashMap<String, Equipo> equipos", "HashMap<String, HashSet<String>> jugadoresPorEquipo", "TreeSet<Equipo> rankingEquipos", "TreeMap<Integer, HashSet<String>> equiposPorPuntos", "PriorityQueue<Partido> partidosPendientes"], ["addEquipo", "registrarResultado", "topEquipos", "equiposConPuntosEntre", "programarPartido", "siguientePartido"]),
    ("JuegoLucesAvanzado", "Juego de las luces avanzado", ["HashMap<String, Bombilla> bombillas", "HashMap<String, HashSet<String>> conexiones", "HashSet<String> encendidas", "PriorityQueue<EventoLuz> eventos"], ["addBombilla", "connect", "toggle", "propagar", "encendidasEnComponente", "programarEvento"]),
    ("RedSocialSinGraph", "Red social sin usar Graph", ["HashMap<String, Persona> personas", "HashMap<String, HashSet<String>> seguidos", "HashMap<String, HashSet<String>> seguidores", "TreeSet<Persona> rankingPopularidad", "HashMap<String, HashSet<String>> personasPorCiudad"], ["addPersona", "seguir", "dejarDeSeguir", "sonAmigos", "sugerencias", "influencerCiudad"]),
    ("SyntheticIntelModelos", "Synthetic Intel: red de modelos de IA", ["HashMap<String, ModeloIA> modelos", "HashMap<String, HashSet<String>> dependencias", "HashMap<String, HashSet<String>> modelosPorEmpresa", "TreeSet<ModeloIA> rankingPrecision", "TreeMap<Double, HashSet<String>> modelosPorPrecision"], ["addModelo", "addDependencia", "dependeDirectamente", "dependeIndirectamente", "topModelos", "modelosEntrePrecision"]),
    ("TraductorWebPrioridades", "Traductor web con prioridades", ["HashMap<String, HashMap<String, String>> traducciones", "HashMap<String, HashSet<String>> palabrasPorIdioma", "TreeSet<EntradaDiccionario> entradasOrdenadas", "PriorityQueue<SolicitudTraduccion> solicitudesPendientes"], ["addTraduccion", "traducir", "palabrasDeIdioma", "solicitarTraduccion", "procesarSiguienteSolicitud", "palabrasEntre"]),
    ("CensoURJCMunicipios", "Censo URJC por municipios", ["HashMap<String, Habitante> habitantesPorDni", "HashMap<String, HashSet<String>> habitantesPorMunicipio", "TreeMap<Integer, HashSet<String>> habitantesPorEdad", "TreeSet<Municipio> municipiosPorPoblacion"], ["addHabitante", "removeHabitante", "habitantesMunicipio", "habitantesEntreEdades", "municipioMasPoblado", "moverHabitante"]),
    ("HospitalTriajeEspecialidades", "Hospital con triaje y especialidades", ["HashMap<String, Paciente> pacientes", "HashMap<String, HashSet<String>> pacientesPorEspecialidad", "PriorityQueue<Paciente> colaTriaje", "TreeMap<LocalDateTime, HashSet<String>> pacientesPorLlegada"], ["registrarPaciente", "siguientePaciente", "pacientesEspecialidad", "pacientesAntesDe", "cambiarPrioridad", "altaPaciente"]),
    ("AlergiasCentrosSanitarios", "Alergias y centros sanitarios", ["HashMap<String, Centro> centros", "HashMap<String, HashSet<String>> centrosPorPueblo", "HashMap<String, HashSet<String>> centrosPorAlergia", "TreeSet<Centro> rankingCentrosPorPacientes"], ["addCentro", "registrarAlergia", "centrosDePueblo", "centrosParaAlergia", "mejorCentro", "topCentros"]),
    ("HipergrafoProyectosParticipantes", "Hipergrafo de proyectos y participantes usando solo mapas", ["HashMap<String, Proyecto> proyectos", "HashMap<String, Participante> participantes", "HashMap<String, HashSet<String>> participantesPorProyecto", "HashMap<String, HashSet<String>> proyectosPorParticipante"], ["addProyecto", "addParticipante", "asignar", "participantesRelacionados", "proyectosComunes", "grupoExpandido"]),
]


def method_return(method: str) -> str:
    if method.startswith(("add", "registrar", "recibir", "programar", "solicitar", "asignar", "connect", "seguir", "dejar", "toggle", "pujar", "actualizar", "cambiar", "mover", "remove", "alta", "eliminar", "borrar")):
        return "void"
    if method.startswith(("han", "hay", "estan", "son", "dependeDirectamente", "dependeIndirectamente", "posible", "areaAislada")):
        return "boolean"
    if method.startswith(("top", "routers", "grupo", "interacciones", "aptos", "opositores", "estaciones", "buscar", "nodos", "vuelos", "equipos", "encendidas", "sugerencias", "modelos", "palabras", "habitantes", "pacientes", "centros", "participantes", "proyectos")):
        return "Iterable<String>"
    return "String"


def case_method(method: str, title: str) -> str:
    ret = method_return(method)
    params = "String id"
    if method in {"addConnection", "connect", "seguir", "dejarDeSeguir", "addDependencia", "asignar", "registrarAlergia"}:
        params = "String a, String b"
    elif method in {"registrarContacto"}:
        params = "String a, String b, LocalDateTime fecha"
    elif method in {"actualizarNota", "modelosEntrePrecision"}:
        params = "String id, double valor"
    elif method in {"top", "topEquipos", "topModelos", "topCentros"}:
        params = "int n"
    elif method in {"borrarMensajesAntiguos", "interaccionesAntesDe", "vuelosEntreFechas", "pacientesAntesDe"}:
        params = "LocalDateTime fecha"
    elif method in {"hayConexionConEscalas", "routersAlcanzables", "estacionesAlcanzables", "buscarArchivo", "propagar", "grupoExpandido"}:
        params = "String origen, int limite"
    elif method in {"registrarResultado"}:
        params = "String e1, String e2, int p1, int p2"
    elif method in {"addTraduccion"}:
        params = "String idioma, String palabra, String traduccion"
    elif method in {"palabrasEntre"}:
        params = "String ini, String fin"
    elif method in {"opositoresEntreNotas"}:
        params = "double min, double max"
    elif method in {"habitantesEntreEdades", "equiposConPuntosEntre"}:
        params = "int min, int max"
    body = 'throw new UnsupportedOperationException("TODO: completar ' + method + ' - ' + title.replace('"', "'") + '");'
    if ret == "void":
        return f"""
        public void {method}({params}) {{
            // TODO: actualizar todos los indices necesarios.
            {body}
        }}
        """
    return f"""
    public {ret} {method}({params}) {{
        // TODO: usar las estructuras indicadas en el enunciado.
        {body}
    }}
    """


def build_implementation_project() -> None:
    project = OUT / "01_IMPLEMENTACION_PURA" / "proyecto_implementacion"
    copy_professor_base(project)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen"
    tests = project / "src/test/java/es/urjc/grafo/EDA/examen"

    graph_methods = "\n".join(
        graph_method(name) for name, *_ in IMPLEMENTATION_GROUPS["grafos_prioritarios"]
    )
    graph_hard_methods = "\n".join(
        graph_method(name) for name, *_ in IMPLEMENTATION_GROUPS["grafos_avanzados"]
    )
    tree_methods = "\n".join(
        tree_method(name) for name, *_ in IMPLEMENTATION_GROUPS["arboles_binarios_y_generales"]
    )
    ordered_methods = "\n".join(
        ordered_method(name) for name, *_ in IMPLEMENTATION_GROUPS["abb_avl_diccionarios"]
    )

    write(main / "GraphOperationsTraining.java", f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Edge;
        import es.urjc.grafo.EDA.graphs.Vertex;

        import java.util.Map;

        public class GraphOperationsTraining {{
        {graph_methods}
        }}
    """)
    write(main / "GraphAdvancedOperationsTraining.java", f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Edge;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;

        import java.util.Map;

        public class GraphAdvancedOperationsTraining {{
        {graph_hard_methods}
        }}
    """)
    write(main / "TreeOperationsTraining.java", f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.Tree;
        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Comparator;
        import java.util.Map;

        public class TreeOperationsTraining {{
        {tree_methods}
        }}
    """)
    write(main / "OrderedStructuresTraining.java", f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        public class OrderedStructuresTraining<K extends Comparable<K>, V> {{
        {ordered_methods}
        }}
    """)

    for name, *_ in IMPLEMENTATION_GROUPS["iteradores"]:
        constructor = "BinaryTree<E> tree"
        extra_fields = "private final BinaryTree<E> tree;"
        assign = "this.tree = tree;"
        if name in {"LevelLimitedIterator"}:
            constructor = "BinaryTree<E> tree, int maxLevel"
            extra_fields += "\n    private final int maxLevel;"
            assign += "\n        this.maxLevel = maxLevel;"
        if name in {"BetweenLevelsIterator"}:
            constructor = "BinaryTree<E> tree, int minLevel, int maxLevel"
            extra_fields += "\n    private final int minLevel;\n    private final int maxLevel;"
            assign += "\n        this.minLevel = minLevel;\n        this.maxLevel = maxLevel;"
        write(main / f"{name}.java", f"""
            package es.urjc.grafo.EDA.examen;

            import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
            import es.urjc.grafo.EDA.utils.Position;

            import java.util.Iterator;
            import java.util.NoSuchElementException;

            public class {name}<E> implements Iterator<Position<E>> {{

                {extra_fields}

                public {name}({constructor}) {{
                    {assign}
                }}

                @Override
                public boolean hasNext() {{
                    // TODO: preparar y consultar el siguiente nodo valido.
                    throw new UnsupportedOperationException("TODO: hasNext en {name}");
                }}

                @Override
                public Position<E> next() {{
                    // TODO: devolver el siguiente nodo segun el recorrido indicado.
                    throw new UnsupportedOperationException("TODO: next en {name}");
                }}

                @Override
                public void remove() {{
                    // TODO: si el enunciado lo pide, eliminar el ultimo nodo devuelto manteniendo el iterador consistente.
                    throw new UnsupportedOperationException("TODO: remove en {name}");
                }}
            }}
        """)

    write(tests / "GraphOperationsTrainingTest.java", """
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

        class GraphOperationsTrainingTest {
            @Test
            void shortestDistanceLessOrEqualDebeImplementarse() {
                AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
                Vertex<String> a = graph.insertVertex("A");
                Vertex<String> b = graph.insertVertex("B");
                graph.insertEdge(a, b, "AB");
                assertEquals(1, GraphOperationsTraining.shortestDistanceLessOrEqual(graph, a, b, 2));
            }
        }
    """)
    write(tests / "TreeOperationsTrainingTest.java", """
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertTrue;

        class TreeOperationsTrainingTest {
            @Test
            void isAlmostCompleteDebeImplementarse() {
                assertTrue(TreeOperationsTraining.isAlmostComplete(new LinkedBinaryTree<>()));
            }
        }
    """)
    write(tests / "IteratorTrainingTest.java", """
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertFalse;

        class IteratorTrainingTest {
            @Test
            void leafIteratorDebeImplementarse() {
                LeafIterator<Integer> it = new LeafIterator<>(new LinkedBinaryTree<>());
                assertFalse(it.hasNext());
            }
        }
    """)
    write(tests / "OrderedStructuresTrainingTest.java", """
        package es.urjc.grafo.EDA.examen;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

        class OrderedStructuresTrainingTest {
            @Test
            void rangeCountDebeImplementarse() {
                OrderedStructuresTraining<Integer, String> dict = new OrderedStructuresTraining<>();
                assertEquals(0, dict.rangeCount(1, 5));
            }
        }
    """)
    write(project / "README.md", """
        # Proyecto de implementación pura

        Estructura aplicada igual que en los esqueletos recientes del profesor:

        - `src/main/java/es/urjc/grafo/EDA`
        - clases de examen en `src/main/java/es/urjc/grafo/EDA/examen`
        - tests en `src/test/java/es/urjc/grafo/EDA/examen`
        - `pom.xml` Java 21 + JUnit Jupiter 5.8.1

        No hay soluciones. Cada método principal tiene TODO y lanza `UnsupportedOperationException`.
    """)


def graph_method(name: str) -> str:
    returns = {
        "shortestDistanceLessOrEqual": "int",
        "verticesAtDistanceK": "Iterable<Vertex<V>>",
        "verticesWithinDistanceK": "Iterable<Vertex<V>>",
        "graphSquareWithoutDuplicates": "AdjacencyMapGraph<V, E>",
        "limitedBFSPath": "Iterable<Vertex<V>>",
        "isConnectedWithLimit": "boolean",
        "eccentricity": "int",
        "graphDiameter": "int",
        "centralVertex": "Vertex<V>",
        "isTreeGraph": "boolean",
        "hasCycleUndirected": "boolean",
        "connectedComponents": "int",
        "largestConnectedComponentSize": "int",
        "removeIsolatedVertices": "int",
        "complementaryIfConnected": "AdjacencyMapGraph<V, E>",
        "kClosure": "AdjacencyMapGraph<V, E>",
        "minimumBroadcastRoot": "Vertex<V>",
        "broadcastTreeFrom": "LinkedTree<Vertex<V>>",
        "sameConnectedComponent": "boolean",
        "bridgesSimpleVersion": "Iterable<Edge<E>>",
        "isBipartite": "boolean",
        "distanceMapFromVertex": "Map<Vertex<V>, Integer>",
        "reachableIgnoringVertex": "boolean",
        "countShortestPaths": "int",
        "graphPowerEdgesCount": "int",
    }
    params = {
        "shortestDistanceLessOrEqual": "AdjacencyMapGraph<V, E> graph, Vertex<V> origin, Vertex<V> destination, int n",
        "verticesAtDistanceK": "AdjacencyMapGraph<V, E> graph, Vertex<V> origin, int k",
        "verticesWithinDistanceK": "AdjacencyMapGraph<V, E> graph, Vertex<V> origin, int k",
        "graphSquareWithoutDuplicates": "AdjacencyMapGraph<V, E> graph",
        "limitedBFSPath": "AdjacencyMapGraph<V, E> graph, Vertex<V> origin, Vertex<V> destination, int n",
        "isConnectedWithLimit": "AdjacencyMapGraph<V, E> graph, int k",
        "eccentricity": "AdjacencyMapGraph<V, E> graph, Vertex<V> vertex",
        "graphDiameter": "AdjacencyMapGraph<V, E> graph",
        "centralVertex": "AdjacencyMapGraph<V, E> graph",
        "isTreeGraph": "AdjacencyMapGraph<V, E> graph",
        "hasCycleUndirected": "AdjacencyMapGraph<V, E> graph",
        "connectedComponents": "AdjacencyMapGraph<V, E> graph",
        "largestConnectedComponentSize": "AdjacencyMapGraph<V, E> graph",
        "removeIsolatedVertices": "AdjacencyMapGraph<V, E> graph",
        "complementaryIfConnected": "AdjacencyMapGraph<V, E> graph",
        "kClosure": "AdjacencyMapGraph<V, E> graph, int k",
        "minimumBroadcastRoot": "AdjacencyMapGraph<V, E> graph",
        "broadcastTreeFrom": "AdjacencyMapGraph<V, E> graph, Vertex<V> origin",
        "sameConnectedComponent": "AdjacencyMapGraph<V, E> graph, Vertex<V> a, Vertex<V> b",
        "bridgesSimpleVersion": "AdjacencyMapGraph<V, E> graph",
        "isBipartite": "AdjacencyMapGraph<V, E> graph",
        "distanceMapFromVertex": "AdjacencyMapGraph<V, E> graph, Vertex<V> origin",
        "reachableIgnoringVertex": "AdjacencyMapGraph<V, E> graph, Vertex<V> origin, Vertex<V> destination, Vertex<V> forbidden",
        "countShortestPaths": "AdjacencyMapGraph<V, E> graph, Vertex<V> origin, Vertex<V> destination",
        "graphPowerEdgesCount": "AdjacencyMapGraph<V, E> graph, int k",
    }
    return f"""
    public static <V, E> {returns[name]} {name}({params[name]}) {{
        // TODO: completar siguiendo el enunciado del ejercicio {name}.
        throw new UnsupportedOperationException("TODO: {name}");
    }}
    """


def tree_method(name: str) -> str:
    signatures = {
        "isAlmostComplete": "public static <E> boolean isAlmostComplete(BinaryTree<E> tree)",
        "isMinHeap": "public static <E> boolean isMinHeap(BinaryTree<E> tree, Comparator<E> comparator)",
        "isHeap": "public static <E> boolean isHeap(BinaryTree<E> tree, Comparator<E> comparator)",
        "heapDegreeViolation": "public static <E> Position<E> heapDegreeViolation(BinaryTree<E> tree, Comparator<E> comparator)",
        "lastNodeInLevelOrder": "public static <E> Position<E> lastNodeInLevelOrder(BinaryTree<E> tree)",
        "isCompleteUntilLevel": "public static <E> boolean isCompleteUntilLevel(BinaryTree<E> tree)",
        "width": "public static <E> int width(Tree<E> tree)",
        "levelWithMoreNodes": "public static <E> int levelWithMoreNodes(Tree<E> tree)",
        "areCousins": "public static <E> boolean areCousins(BinaryTree<E> tree, Position<E> a, Position<E> b)",
        "lowestCommonAncestor": "public static <E> Position<E> lowestCommonAncestor(BinaryTree<E> tree, Position<E> a, Position<E> b)",
        "isBalanced": "public static <E> boolean isBalanced(BinaryTree<E> tree)",
        "diameter": "public static <E> int diameter(BinaryTree<E> tree)",
        "removeLeaves": "public static <E> int removeLeaves(Tree<E> tree)",
        "pruneBelowDepth": "public static <E> int pruneBelowDepth(Tree<E> tree, int k)",
        "mirrorCopy": "public static <E> LinkedBinaryTree<E> mirrorCopy(BinaryTree<E> tree)",
        "isMirrorOf": "public static <E> boolean isMirrorOf(BinaryTree<E> a, BinaryTree<E> b)",
        "hasSameShape": "public static <E, F> boolean hasSameShape(BinaryTree<E> a, BinaryTree<F> b)",
        "areIdenticalIgnoringLeaves": "public static <E> boolean areIdenticalIgnoringLeaves(BinaryTree<E> a, BinaryTree<E> b)",
        "descendantsAtDistanceK": "public static <E> Iterable<Position<E>> descendantsAtDistanceK(Tree<E> tree, Position<E> origin, int k)",
        "degreeDistribution": "public static <E> Map<Integer, Integer> degreeDistribution(Tree<E> tree)",
    }
    return f"""
    {signatures[name]} {{
        // TODO: completar siguiendo el enunciado del ejercicio {name}.
        throw new UnsupportedOperationException("TODO: {name}");
    }}
    """


def ordered_method(name: str) -> str:
    signatures = {
        "rangeCount": "public int rangeCount(K k1, K k2)",
        "removeRange": "public int removeRange(K k1, K k2)",
        "floor": "public K floor(K key)",
        "ceiling": "public K ceiling(K key)",
        "predecessor": "public K predecessor(K key)",
        "successor": "public K successor(K key)",
        "kSmallest": "public Iterable<K> kSmallest(int k)",
        "isBST": "public static <E extends Comparable<E>> boolean isBST(BinaryTree<E> tree)",
        "mergeWithoutDuplicates": "public void mergeWithoutDuplicates(OrderedStructuresTraining<K, V> other)",
        "splitByKey": "public Iterable<OrderedStructuresTraining<K, V>> splitByKey(K key)",
        "heightIfInserted": "public int heightIfInserted(K key)",
        "countRepeatedKeys": "public int countRepeatedKeys(K key)",
        "findAllInRange": "public Iterable<V> findAllInRange(K min, K max)",
        "isAVL": "public static <E extends Comparable<E>> boolean isAVL(BinaryTree<E> tree)",
        "firstUnbalancedNode": "public static <E extends Comparable<E>> Position<E> firstUnbalancedNode(BinaryTree<E> tree)",
    }
    return f"""
    {signatures[name]} {{
        // TODO: completar siguiendo el enunciado del ejercicio {name}.
        throw new UnsupportedOperationException("TODO: {name}");
    }}
    """


def build_cases_project() -> None:
    project = OUT / "02_CASOS_DE_USO" / "proyecto_casos_de_uso"
    copy_professor_base(project, include_env=False)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen/casos"
    tests = project / "src/test/java/es/urjc/grafo/EDA/examen/casos"
    for class_name, title, structures, methods in CASE_USE_EXERCISES:
        fields = "\n".join("    private final " + s + " = new " + collection_init(s) + ";" for s in structures)
        method_code = "\n".join(case_method(m, title) for m in methods)
        domain_records = "\n\n".join(domain_record(name) for name in domain_types_for(structures))
        write(main / f"{class_name}.java", f"""
            package es.urjc.grafo.EDA.examen.casos;

            import java.time.LocalDateTime;
            import java.util.HashMap;
            import java.util.HashSet;
            import java.util.PriorityQueue;
            import java.util.TreeMap;
            import java.util.TreeSet;

            public class {class_name} {{

            {fields}

            {domain_records}

            {method_code}
            }}
        """)
        write(tests / f"{class_name}Test.java", f"""
            package es.urjc.grafo.EDA.examen.casos;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

            class {class_name}Test {{

                @Test
                void primerMetodoDebeImplementarse() {{
                    {class_name} servicio = new {class_name}();
                    assertDoesNotThrow(() -> servicio.{sample_case_call(methods[0])});
                }}
            }}
        """)

    write(project / "README.md", """
        # Proyecto de casos de uso

        Cada clase representa un caso de uso completo. Se usan las estructuras permitidas indicadas:

        - `HashMap`
        - `HashSet`
        - `TreeMap`
        - `TreeSet`
        - `PriorityQueue`

        No hay soluciones. Los métodos principales tienen TODO y lanzan `UnsupportedOperationException`.
    """)


def collection_init(struct: str) -> str:
    if struct.startswith("HashMap"):
        return "HashMap<>()"
    if struct.startswith("HashSet"):
        return "HashSet<>()"
    if struct.startswith("TreeMap"):
        return "TreeMap<>()"
    if struct.startswith("TreeSet"):
        return "TreeSet<>()"
    if struct.startswith("PriorityQueue"):
        return "PriorityQueue<>()"
    return "HashMap<>()"


def sample_case_call(method: str) -> str:
    if method in {"addConnection", "connect", "seguir", "dejarDeSeguir", "addDependencia", "asignar", "registrarAlergia"}:
        return f'{method}("A", "B")'
    if method == "registrarContacto":
        return f'{method}("A", "B", java.time.LocalDateTime.now())'
    if method == "addTraduccion":
        return f'{method}("es", "hola", "hello")'
    if method == "registrarResultado":
        return f'{method}("A", "B", 1, 0)'
    if method.startswith("top"):
        return f"{method}(1)"
    return f'{method}("A")'


def domain_types_for(structures: list[str]) -> list[str]:
    ignored = {"String", "HashSet", "HashMap", "TreeMap", "TreeSet", "PriorityQueue", "Integer", "Double", "LocalDateTime"}
    found: list[str] = []
    current = ""
    for struct in structures:
        for ch in struct:
            if ch.isalnum() or ch == "_":
                current += ch
            else:
                if current and current[0].isupper() and current not in ignored and current not in found:
                    found.append(current)
                current = ""
        if current and current[0].isupper() and current not in ignored and current not in found:
            found.append(current)
        current = ""
    return found or ["Elemento"]


def domain_record(name: str) -> str:
    return f"""
        public record {name}(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<{name}> {{
            @Override
            public int compareTo({name} other) {{
                int cmp = Integer.compare(other.prioridad, this.prioridad);
                if (cmp != 0) {{
                    return cmp;
                }}
                cmp = Double.compare(other.valor, this.valor);
                if (cmp != 0) {{
                    return cmp;
                }}
                return this.id.compareTo(other.id);
            }}
        }}
    """


def write_exercise_readmes() -> None:
    all_rows = []
    for group, exercises in IMPLEMENTATION_GROUPS.items():
        for name, structure, difficulty, idea in exercises:
            folder = OUT / "01_IMPLEMENTACION_PURA" / "ejercicios" / group / slug(name)
            class_hint = {
                "grafos_prioritarios": "GraphOperationsTraining",
                "grafos_avanzados": "GraphAdvancedOperationsTraining",
                "arboles_binarios_y_generales": "TreeOperationsTraining",
                "abb_avl_diccionarios": "OrderedStructuresTraining",
            }.get(group, name)
            write(folder / "README.md", f"""
                # {name}

                - Tipo: implementación pura
                - Estructura: {structure}
                - Dificultad: {difficulty}
                - Esqueleto: `01_IMPLEMENTACION_PURA/proyecto_implementacion/src/main/java/es/urjc/grafo/EDA/examen/{class_hint}.java`

                ## Enunciado

                {idea}

                ## Qué debe completar el alumno

                Completa el método o clase `{name}` sin cambiar su firma pública.
                Mantén las invariantes de la estructura y usa recorridos BFS/DFS, recursión o comparadores cuando proceda.

                ## Casos que deberían comprobarse

                - Estructura vacía.
                - Un solo elemento o vértice.
                - Varios elementos.
                - Casos límite de `k`, `n` o rangos.
                - Entradas nulas si el estilo del examen lo contempla.
            """)
            all_rows.append((name, "implementacion", structure, difficulty, class_hint))

    for class_name, title, structures, methods in CASE_USE_EXERCISES:
        folder = OUT / "02_CASOS_DE_USO" / "ejercicios" / slug(class_name)
        write(folder / "README.md", f"""
            # {title}

            - Tipo: caso de uso
            - Clase de esqueleto: `02_CASOS_DE_USO/proyecto_casos_de_uso/src/main/java/es/urjc/grafo/EDA/examen/casos/{class_name}.java`
            - Estructuras permitidas/principales:

            {chr(10).join("- `" + s + "`" for s in structures)}

            ## Enunciado

            Implementa el gestor del dominio usando las estructuras indicadas. No uses una clase `Graph`; las relaciones deben representarse con `HashMap` y `HashSet` cuando el caso sea una red.

            ## Métodos que debe completar el alumno

            {chr(10).join("- `" + m + "`" for m in methods)}

            ## Criterios esperados

            - Mantener todos los índices sincronizados.
            - No admitir duplicados cuando el identificador ya exista.
            - Actualizar correctamente `TreeSet` y `PriorityQueue` cuando cambia el atributo que ordena.
            - Resolver consultas por rango con `TreeMap`.
            - Usar BFS manual sobre `HashMap<String, HashSet<String>>` cuando haya relaciones de red.
        """)
        all_rows.append((title, "caso_de_uso", ", ".join(s.split("<")[0] for s in structures), "Alta", class_name))

    write(OUT / "04_INDICES" / "INDICE_EJERCICIOS.md", "\n".join([
        "# Índice de ejercicios nuevos",
        "",
        "| Ejercicio | Tipo | Estructura | Dificultad | Esqueleto |",
        "|---|---|---|---|---|",
        *[f"| {a} | {b} | {c} | {d} | `{e}` |" for a, b, c, d, e in all_rows],
        "",
    ]))


def write_exam_proposals() -> None:
    proposals = [
        ("examen_propuesto_01_nivel_enero_2026", "Nivel enero 2026", [
            ("GraphOperations", "3", "verticesWithinDistanceK(g, v, k)"),
            ("GraphOperations", "3", "kPowerOptimized(g, k) / kClosure(g, k)"),
            ("TreeOperations", "3", "isAlmostComplete(tree)"),
            ("Iterator", "1", "remove() en iterador por niveles solo de hojas"),
        ]),
        ("examen_propuesto_02_mas_dificil", "Más difícil que enero", [
            ("GraphOperations", "3", "graphDiameter(g)"),
            ("GraphOperations", "3", "centralVertex(g)"),
            ("TreeOperations", "2", "isHeap(tree)"),
            ("Iterator", "2", "InternalNodeIteratorWithRemove"),
        ]),
        ("examen_propuesto_03_estilo_diciembre_subido", "Estilo diciembre subido", [
            ("GraphOperations", "3", "connectedComponents(g) / isConnected(g)"),
            ("GraphOperations", "3", "hasCycleUndirected(g)"),
            ("TreeOperations", "2", "hasSameShape(t1, t2)"),
            ("TreeOperations", "2", "diameter(tree)"),
        ]),
        ("examen_propuesto_04_casos_de_uso", "Orientado a casos de uso", [
            ("Comparator", "1", "Comparador por fecha, prioridad y código"),
            ("Entity class", "2", "Gestión de mensajes/eventos sin repetidos"),
            ("Service class", "3", "Alta/baja/búsqueda con mapas"),
            ("Network class", "4", "Consulta de conexión a distancia <= k"),
        ]),
    ]
    for slug_name, title, rows in proposals:
        write(OUT / "03_EXAMENES_PROPUESTOS" / slug_name / "README.md", "\n".join([
            f"# {title}",
            "",
            "| Bloque | Puntos | Ejercicio |",
            "|---|---:|---|",
            *[f"| {a} | {b} | {c} |" for a, b, c in rows],
            "",
            "## Instrucciones",
            "",
            "Usa los esqueletos de `01_IMPLEMENTACION_PURA/proyecto_implementacion` o `02_CASOS_DE_USO/proyecto_casos_de_uso` como base.",
            "No mezcles soluciones: completa solo los métodos pedidos y ejecuta los tests.",
        ]))


def write_root_docs() -> None:
    write(OUT / "README.md", """
        # Entrenamiento intensivo: nuevos ejercicios de examen EDA

        Esta carpeta contiene ejercicios nuevos basados en el estilo de los exámenes analizados.

        ## Organización

        - `00_GUIA_REPASO`: guía general en Markdown y PDF.
        - `01_IMPLEMENTACION_PURA`: ejercicios de grafos, árboles, iteradores, ABB/AVL y diccionarios ordenados.
        - `02_CASOS_DE_USO`: casos de uso con `HashMap`, `HashSet`, `TreeMap`, `TreeSet` y `PriorityQueue`.
        - `03_EXAMENES_PROPUESTOS`: combinaciones tipo examen.
        - `04_INDICES`: índice general.

        ## Cómo usarlo

        1. Lee el README del ejercicio.
        2. Abre el proyecto Maven del bloque.
        3. Completa el método/clase indicada.
        4. Ejecuta `mvn test`.

        No hay soluciones incluidas.
    """)
    write(OUT / "04_INDICES" / "ESTRUCTURAS_CASOS_USO.md", """
        # Plantilla mental para casos de uso

        | Necesidad | Estructura |
        |---|---|
        | Buscar por ID, DNI, matrícula, código | `HashMap<K,V>` |
        | Evitar duplicados | `HashSet<E>` |
        | Mantener orden por fecha, nota, precio, distancia | `TreeMap<K,V>` |
        | Mantener ranking de objetos | `TreeSet<E>` |
        | Sacar siempre el más urgente/prioritario | `PriorityQueue<E>` |

        ## Grafo no dirigido con mapas

        ```java
        HashMap<String, Objeto> objetos = new HashMap<>();
        HashMap<String, HashSet<String>> adyacencias = new HashMap<>();
        ```

        ## Grafo dirigido con mapas

        ```java
        HashMap<String, HashSet<String>> salientes = new HashMap<>();
        HashMap<String, HashSet<String>> entrantes = new HashMap<>();
        ```

        ## Índice secundario

        ```java
        HashMap<String, HashSet<String>> idsPorCategoria = new HashMap<>();
        TreeMap<LocalDateTime, HashSet<String>> idsPorFecha = new TreeMap<>();
        ```

        Recuerda: si cambias un campo que participa en `TreeSet` o `PriorityQueue`, normalmente tienes que quitar y volver a insertar el objeto.
    """)


GUIDE_MD = """
# Guía rápida de repaso EDA: árboles, grafos y Java de examen

## 1. Mentalidad de examen

Antes de programar, identifica:

- qué estructura gobierna el problema;
- cuál es la clave de búsqueda;
- qué índices secundarios necesitas mantener;
- qué invariante no puedes romper;
- qué casos límite hay: vacío, un elemento, duplicados, null, raíz, hoja, grafo desconectado.

En implementación pura no sustituyas la estructura pedida por otra. En casos de uso, sí debes elegir bien entre `HashMap`, `HashSet`, `TreeMap`, `TreeSet` y `PriorityQueue`.

## 2. Java usado en la asignatura

Patrón típico:

```java
public static <V, E> boolean metodo(AdjacencyMapGraph<V, E> graph, Vertex<V> v) {
    if (graph == null || v == null) {
        throw new IllegalArgumentException();
    }
    // TODO
}
```

Ideas clave:

- usa genéricos (`<E>`, `<V,E>`, `<K,V>`);
- respeta firmas públicas;
- usa `Position<E>` para árboles;
- usa `Vertex<V>` y `Edge<E>` para grafos;
- usa `Comparator<E>` cuando el orden no es natural;
- `UnsupportedOperationException` es correcto en esqueletos, no en soluciones finales.

## 3. Árboles generales

Un árbol se razona siempre desde:

- raíz;
- padre;
- hijos;
- hojas;
- profundidad;
- altura;
- grado.

Recorrido recursivo típico:

```java
private static <E> int size(Tree<E> t, Position<E> p) {
    int total = 1;
    for (Position<E> child : t.children(p)) {
        total += size(t, child);
    }
    return total;
}
```

BFS por niveles:

```java
Queue<Position<E>> q = new LinkedList<>();
q.add(t.root());
while (!q.isEmpty()) {
    Position<E> p = q.poll();
    for (Position<E> child : t.children(p)) {
        q.add(child);
    }
}
```

## 4. Árboles binarios

En binarios piensa en:

- hijo izquierdo;
- hijo derecho;
- nodo con 0, 1 o 2 hijos;
- subárbol izquierdo;
- subárbol derecho.

Patrones:

- `isSymmetric`: comparar espejo izquierdo/derecho.
- `areIdentical`: comparar elemento y estructura a la vez.
- `hasSameShape`: comparar solo estructura.
- `isBalanced`: cada nodo necesita alturas de hijos.
- `diameter`: máximo entre diámetro izquierdo, derecho y camino que pasa por la raíz.

Para montículos:

1. estructura casi completa;
2. orden padre-hijo según comparador.

Si falla cualquiera, no es heap.

## 5. Iteradores de árbol

Un iterador necesita estado:

- pendientes por visitar;
- último devuelto;
- si `remove()` puede ejecutarse;
- qué pasa si se borra un subárbol.

Errores típicos:

- visitar nodos que ya no están en el árbol;
- permitir dos `remove()` seguidos;
- no lanzar `NoSuchElementException` cuando no hay siguiente;
- cambiar el árbol y no actualizar la cola/pila interna.

## 6. Grafos del entorno

En `AdjacencyMapGraph` piensa en:

- `vertices()`;
- `edges()`;
- `opposite(v, e)`;
- `incidentEdges(v)`;
- `areAdjacent(u, v)`;
- `insertVertex`;
- `insertEdge`.

BFS base:

```java
HashSet<Vertex<V>> visited = new HashSet<>();
HashMap<Vertex<V>, Integer> dist = new HashMap<>();
Queue<Vertex<V>> q = new LinkedList<>();
visited.add(start);
dist.put(start, 0);
q.add(start);
while (!q.isEmpty()) {
    Vertex<V> u = q.poll();
    for (Edge<E> e : graph.incidentEdges(u)) {
        Vertex<V> w = graph.opposite(u, e);
        if (!visited.contains(w)) {
            visited.add(w);
            dist.put(w, dist.get(u) + 1);
            q.add(w);
        }
    }
}
```

Este patrón sirve para:

- distancia mínima;
- vértices a distancia k;
- componentes conexas;
- diámetro;
- centro;
- bipartito;
- caminos mínimos.

## 7. Grafos con HashMap y HashSet en casos de uso

Grafo no dirigido:

```java
HashMap<String, HashSet<String>> adj = new HashMap<>();

adj.get(a).add(b);
adj.get(b).add(a);
```

Grafo dirigido:

```java
HashMap<String, HashSet<String>> salientes = new HashMap<>();
HashMap<String, HashSet<String>> entrantes = new HashMap<>();
```

BFS manual:

```java
HashSet<String> visitados = new HashSet<>();
Queue<String> cola = new LinkedList<>();
visitados.add(origen);
cola.add(origen);
```

## 8. Estructuras permitidas para casos de uso

| Necesidad | Estructura |
|---|---|
| Buscar por identificador | `HashMap` |
| Evitar repetidos | `HashSet` |
| Consultar rangos por clave | `TreeMap` |
| Ranking estable | `TreeSet` |
| Prioridad / urgencia | `PriorityQueue` |

Trampa clave: `TreeSet` y `PriorityQueue` no se reordenan mágicamente si cambias el campo usado para ordenar. Quita y vuelve a insertar.

## 9. Checklist antes de entregar

- ¿Compila?
- ¿He mantenido firmas públicas?
- ¿He probado vacío y un elemento?
- ¿He probado duplicados?
- ¿He probado grafo desconectado?
- ¿He probado raíz y hojas?
- ¿He actualizado todos los índices?
- ¿He quitado y reinsertado en `TreeSet`/`PriorityQueue` si cambia la prioridad?
- ¿Puedo explicar la complejidad?
"""


def build_guide() -> None:
    guide_dir = OUT / "00_GUIA_REPASO"
    write(guide_dir / "GUIA_REPASO_EDA.md", GUIDE_MD)
    pdf_path = guide_dir / "GUIA_REPASO_EDA.pdf"

    styles = getSampleStyleSheet()
    styles.add(ParagraphStyle(name="CodeBlock", fontName="Courier", fontSize=8, leading=10, backColor=colors.whitesmoke, borderColor=colors.lightgrey, borderWidth=0.5, borderPadding=5))
    doc = SimpleDocTemplate(str(pdf_path), pagesize=A4, rightMargin=1.6 * cm, leftMargin=1.6 * cm, topMargin=1.4 * cm, bottomMargin=1.4 * cm)
    story = []
    in_code = False
    code_lines = []
    for raw in GUIDE_MD.splitlines():
        line = raw.rstrip()
        if line.startswith("```"):
            if in_code:
                story.append(Paragraph("<br/>".join(l.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;") for l in code_lines), styles["CodeBlock"]))
                story.append(Spacer(1, 0.15 * cm))
                code_lines = []
                in_code = False
            else:
                in_code = True
            continue
        if in_code:
            code_lines.append(line or " ")
            continue
        if not line:
            story.append(Spacer(1, 0.12 * cm))
        elif line.startswith("# "):
            story.append(Paragraph(line[2:], styles["Title"]))
        elif line.startswith("## "):
            story.append(Paragraph(line[3:], styles["Heading2"]))
        elif line.startswith("- "):
            story.append(Paragraph("• " + line[2:], styles["BodyText"]))
        elif line.startswith("|"):
            continue
        else:
            story.append(Paragraph(line.replace("`", ""), styles["BodyText"]))
    doc.build(story)


def main() -> None:
    if OUT.exists():
        shutil.rmtree(OUT)
    OUT.mkdir(parents=True)
    write_root_docs()
    write_exercise_readmes()
    write_exam_proposals()
    build_implementation_project()
    build_cases_project()
    build_guide()


if __name__ == "__main__":
    main()
