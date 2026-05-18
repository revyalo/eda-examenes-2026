from __future__ import annotations

import runpy
import textwrap
from pathlib import Path


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
TRAINING = ROOT / "EDA_Examenes_2026" / "07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS"
INDIVIDUAL_GENERATOR = ROOT / "EDA_Examenes_2026" / "00_ANALISIS" / "generar_esqueletos_individuales_entrenamiento.py"

helpers = runpy.run_path(str(INDIVIDUAL_GENERATOR))
copy_base = helpers["copy_base"]
write = helpers["write"]
graph_method = helpers["graph_method"]
tree_method = helpers["tree_method"]


def graph_class(class_name: str, methods: list[str], extra_methods: str = "") -> str:
    method_code = "\n".join(graph_method(name) for name in methods)
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Edge;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;

        import java.util.Map;

        public class {class_name} {{
        {method_code}
        {extra_methods}
        }}
    """


def tree_class(class_name: str, methods: list[str]) -> str:
    method_code = "\n".join(tree_method(name) for name in methods)
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.Tree;
        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Comparator;
        import java.util.Map;

        public class {class_name} {{
        {method_code}
        }}
    """


def iterator_class(class_name: str, description: str) -> str:
    return f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Iterator;

        public class {class_name}<E> implements Iterator<Position<E>> {{

            private final BinaryTree<E> tree;

            public {class_name}(BinaryTree<E> tree) {{
                this.tree = tree;
            }}

            @Override
            public boolean hasNext() {{
                // TODO: preparar el siguiente nodo valido para {description}.
                throw new UnsupportedOperationException("TODO: hasNext en {class_name}");
            }}

            @Override
            public Position<E> next() {{
                // TODO: devolver el siguiente nodo del recorrido pedido.
                throw new UnsupportedOperationException("TODO: next en {class_name}");
            }}

            @Override
            public void remove() {{
                // TODO: eliminar correctamente el ultimo nodo devuelto.
                throw new UnsupportedOperationException("TODO: remove en {class_name}");
            }}
        }}
    """


def graph_fixture() -> str:
    return """
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
    """


def write_exam_01() -> None:
    base = TRAINING / "03_EXAMENES_PROPUESTOS" / "examen_propuesto_01_nivel_enero_2026"
    project = base / "esqueleto"
    copy_base(project, include_env=True)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen"
    test = project / "src/test/java/es/urjc/grafo/EDA/examen"
    extra = """
        public static <V, E> AdjacencyMapGraph<V, E> kPowerOptimized(AdjacencyMapGraph<V, E> graph, int k) {
            // TODO: construir G^k usando un BFS por vertice, evitando bucles y duplicados.
            throw new UnsupportedOperationException("TODO: kPowerOptimized");
        }
    """
    write(main / "GraphOperationsExam01.java", graph_class("GraphOperationsExam01", ["verticesWithinDistanceK"], extra))
    write(main / "TreeOperationsExam01.java", tree_class("TreeOperationsExam01", ["isAlmostComplete"]))
    write(main / "LeafLevelOrderIteratorWithRemove.java", iterator_class("LeafLevelOrderIteratorWithRemove", "hojas en anchura"))
    write(test / "GraphOperationsExam01Test.java", f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class GraphOperationsExam01Test {{
            @Test
            void verticesWithinDistanceKDebeImplementarse() {{
                {graph_fixture()}
                assertNotNull(GraphOperationsExam01.verticesWithinDistanceK(graph, a, 2));
            }}

            @Test
            void kPowerOptimizedDebeImplementarse() {{
                {graph_fixture()}
                assertNotNull(GraphOperationsExam01.kPowerOptimized(graph, 2));
            }}
        }}
    """)
    write(test / "TreeOperationsExam01Test.java", """
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertTrue;

        class TreeOperationsExam01Test {
            @Test
            void isAlmostCompleteDebeImplementarse() {
                LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                Position<Integer> root = tree.addRoot(1);
                tree.insertLeft(root, 2);
                tree.insertRight(root, 3);
                assertTrue(TreeOperationsExam01.isAlmostComplete(tree));
            }
        }
    """)
    write(test / "LeafLevelOrderIteratorWithRemoveTest.java", """
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertFalse;

        class LeafLevelOrderIteratorWithRemoveTest {
            @Test
            void hasNextDebeImplementarse() {
                LeafLevelOrderIteratorWithRemove<Integer> it = new LeafLevelOrderIteratorWithRemove<>(new LinkedBinaryTree<>());
                assertFalse(it.hasNext());
            }
        }
    """)
    write_exam_readme(project, "Examen propuesto 01 - nivel enero 2026", [
        "GraphOperationsExam01.verticesWithinDistanceK",
        "GraphOperationsExam01.kPowerOptimized",
        "TreeOperationsExam01.isAlmostComplete",
        "LeafLevelOrderIteratorWithRemove.remove",
    ])


def write_exam_02() -> None:
    base = TRAINING / "03_EXAMENES_PROPUESTOS" / "examen_propuesto_02_mas_dificil"
    project = base / "esqueleto"
    copy_base(project, include_env=True)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen"
    test = project / "src/test/java/es/urjc/grafo/EDA/examen"
    write(main / "GraphOperationsExam02.java", graph_class("GraphOperationsExam02", ["graphDiameter", "centralVertex"]))
    write(main / "TreeOperationsExam02.java", tree_class("TreeOperationsExam02", ["isHeap"]))
    write(main / "InternalNodeIteratorWithRemove.java", iterator_class("InternalNodeIteratorWithRemove", "nodos internos"))
    write(test / "GraphOperationsExam02Test.java", f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class GraphOperationsExam02Test {{
            @Test
            void graphDiameterDebeImplementarse() {{
                {graph_fixture()}
                assertEquals(2, GraphOperationsExam02.graphDiameter(graph));
            }}

            @Test
            void centralVertexDebeImplementarse() {{
                {graph_fixture()}
                assertNotNull(GraphOperationsExam02.centralVertex(graph));
            }}
        }}
    """)
    write(test / "TreeOperationsExam02Test.java", """
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import java.util.Comparator;

        import static org.junit.jupiter.api.Assertions.assertTrue;

        class TreeOperationsExam02Test {
            @Test
            void isHeapDebeImplementarse() {
                LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                Position<Integer> root = tree.addRoot(1);
                tree.insertLeft(root, 2);
                tree.insertRight(root, 3);
                assertTrue(TreeOperationsExam02.isHeap(tree, Comparator.naturalOrder()));
            }
        }
    """)
    write(test / "InternalNodeIteratorWithRemoveTest.java", """
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertFalse;

        class InternalNodeIteratorWithRemoveTest {
            @Test
            void hasNextDebeImplementarse() {
                InternalNodeIteratorWithRemove<Integer> it = new InternalNodeIteratorWithRemove<>(new LinkedBinaryTree<>());
                assertFalse(it.hasNext());
            }
        }
    """)
    write_exam_readme(project, "Examen propuesto 02 - mas dificil que enero", [
        "GraphOperationsExam02.graphDiameter",
        "GraphOperationsExam02.centralVertex",
        "TreeOperationsExam02.isHeap",
        "InternalNodeIteratorWithRemove.remove",
    ])


def write_exam_03() -> None:
    base = TRAINING / "03_EXAMENES_PROPUESTOS" / "examen_propuesto_03_estilo_diciembre_subido"
    project = base / "esqueleto"
    copy_base(project, include_env=True)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen"
    test = project / "src/test/java/es/urjc/grafo/EDA/examen"
    extra = """
        public static <V, E> boolean isConnected(AdjacencyMapGraph<V, E> graph) {
            // TODO: comprobar si todos los vertices pertenecen a una unica componente conexa.
            throw new UnsupportedOperationException("TODO: isConnected");
        }
    """
    write(main / "GraphOperationsExam03.java", graph_class("GraphOperationsExam03", ["hasCycleUndirected"], extra))
    write(main / "TreeOperationsExam03.java", tree_class("TreeOperationsExam03", ["hasSameShape", "diameter"]))
    write(test / "GraphOperationsExam03Test.java", f"""
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class GraphOperationsExam03Test {{
            @Test
            void isConnectedDebeImplementarse() {{
                {graph_fixture()}
                assertTrue(GraphOperationsExam03.isConnected(graph));
            }}

            @Test
            void hasCycleUndirectedDebeImplementarse() {{
                {graph_fixture()}
                assertFalse(GraphOperationsExam03.hasCycleUndirected(graph));
            }}
        }}
    """)
    write(test / "TreeOperationsExam03Test.java", """
        package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class TreeOperationsExam03Test {
            @Test
            void hasSameShapeDebeImplementarse() {
                LinkedBinaryTree<Integer> a = new LinkedBinaryTree<>();
                Position<Integer> ar = a.addRoot(1);
                a.insertLeft(ar, 2);
                LinkedBinaryTree<String> b = new LinkedBinaryTree<>();
                Position<String> br = b.addRoot("A");
                b.insertLeft(br, "B");
                assertTrue(TreeOperationsExam03.hasSameShape(a, b));
            }

            @Test
            void diameterDebeImplementarse() {
                LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                Position<Integer> root = tree.addRoot(1);
                tree.insertLeft(root, 2);
                tree.insertRight(root, 3);
                assertEquals(2, TreeOperationsExam03.diameter(tree));
            }
        }
    """)
    write_exam_readme(project, "Examen propuesto 03 - estilo diciembre subido", [
        "GraphOperationsExam03.isConnected",
        "GraphOperationsExam03.hasCycleUndirected",
        "TreeOperationsExam03.hasSameShape",
        "TreeOperationsExam03.diameter",
    ])


def case_exam_source() -> str:
    return """
        package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.Comparator;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;

        public class SistemaMensajesRed {

            private final HashMap<String, MensajeEvento> eventosPorCodigo = new HashMap<>();
            private final HashSet<String> codigosActivos = new HashSet<>();
            private final PriorityQueue<MensajeEvento> colaPrioridad = new PriorityQueue<>(new MensajeEventoComparator());
            private final TreeMap<LocalDateTime, HashSet<String>> eventosPorFecha = new TreeMap<>();
            private final HashMap<String, HashSet<String>> conexiones = new HashMap<>();

            public record MensajeEvento(String codigo, LocalDateTime fecha, int prioridad, String origen, String destino) {
            }

            public static class MensajeEventoComparator implements Comparator<MensajeEvento> {
                @Override
                public int compare(MensajeEvento a, MensajeEvento b) {
                    // TODO: ordenar por fecha ascendente, prioridad descendente y codigo ascendente.
                    throw new UnsupportedOperationException("TODO: compare MensajeEvento");
                }
            }

            public boolean registrarEvento(MensajeEvento evento) {
                // TODO: insertar sin repetidos y actualizar HashMap, HashSet, TreeMap y PriorityQueue.
                throw new UnsupportedOperationException("TODO: registrarEvento");
            }

            public boolean cancelarEvento(String codigo) {
                // TODO: eliminar de todos los indices sincronizados.
                throw new UnsupportedOperationException("TODO: cancelarEvento");
            }

            public MensajeEvento buscarEvento(String codigo) {
                // TODO: buscar por codigo en tiempo esperado constante.
                throw new UnsupportedOperationException("TODO: buscarEvento");
            }

            public Iterable<MensajeEvento> eventosHasta(LocalDateTime fecha) {
                // TODO: consultar eventos con fecha menor o igual usando TreeMap.
                throw new UnsupportedOperationException("TODO: eventosHasta");
            }

            public void conectar(String origen, String destino) {
                // TODO: crear una conexion no dirigida usando HashMap + HashSet.
                throw new UnsupportedOperationException("TODO: conectar");
            }

            public boolean hayConexionConDistanciaMenorOIgual(String origen, String destino, int k) {
                // TODO: BFS limitado sobre el grafo manual de conexiones.
                throw new UnsupportedOperationException("TODO: hayConexionConDistanciaMenorOIgual");
            }
        }
    """


def write_exam_04() -> None:
    base = TRAINING / "03_EXAMENES_PROPUESTOS" / "examen_propuesto_04_casos_de_uso"
    project = base / "esqueleto"
    copy_base(project, include_env=False)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen/casos"
    test = project / "src/test/java/es/urjc/grafo/EDA/examen/casos"
    write(main / "SistemaMensajesRed.java", case_exam_source())
    write(test / "SistemaMensajesRedTest.java", """
        package es.urjc.grafo.EDA.examen.casos;

        import org.junit.jupiter.api.Test;

        import java.time.LocalDateTime;

        import static org.junit.jupiter.api.Assertions.*;

        class SistemaMensajesRedTest {
            @Test
            void comparadorDebeImplementarse() {
                SistemaMensajesRed.MensajeEvento a = new SistemaMensajesRed.MensajeEvento("A", LocalDateTime.of(2026, 1, 1, 10, 0), 2, "R1", "R2");
                SistemaMensajesRed.MensajeEvento b = new SistemaMensajesRed.MensajeEvento("B", LocalDateTime.of(2026, 1, 1, 11, 0), 5, "R1", "R3");
                assertTrue(new SistemaMensajesRed.MensajeEventoComparator().compare(a, b) < 0);
            }

            @Test
            void registrarYBuscarEventoDebeImplementarse() {
                SistemaMensajesRed sistema = new SistemaMensajesRed();
                SistemaMensajesRed.MensajeEvento evento = new SistemaMensajesRed.MensajeEvento("M1", LocalDateTime.now(), 3, "R1", "R2");
                assertTrue(sistema.registrarEvento(evento));
                assertEquals(evento, sistema.buscarEvento("M1"));
            }

            @Test
            void eventosHastaDebeImplementarse() {
                SistemaMensajesRed sistema = new SistemaMensajesRed();
                assertNotNull(sistema.eventosHasta(LocalDateTime.now()));
            }

            @Test
            void conexionLimitadaDebeImplementarse() {
                SistemaMensajesRed sistema = new SistemaMensajesRed();
                sistema.conectar("R1", "R2");
                sistema.conectar("R2", "R3");
                assertTrue(sistema.hayConexionConDistanciaMenorOIgual("R1", "R3", 2));
            }
        }
    """)
    write(project / "README.md", """
        # Examen propuesto 04 - casos de uso

        ## Enunciado

        Implementa un sistema de mensajes/eventos sobre una red manual de nodos.
        Debes usar las estructuras indicadas en el esqueleto:

        - `HashMap` para busqueda por codigo.
        - `HashSet` para evitar repetidos y representar vecinos.
        - `TreeMap` para consultas por fecha.
        - `PriorityQueue` para prioridad de eventos.

        ## Que debe completar el alumno

        - `MensajeEventoComparator.compare`.
        - `registrarEvento`.
        - `cancelarEvento`.
        - `buscarEvento`.
        - `eventosHasta`.
        - `conectar`.
        - `hayConexionConDistanciaMenorOIgual`.

        ## Tests

        Ejecuta:

        ```bash
        mvn test
        ```

        Los tests fallan inicialmente por TODO esperado.
    """)


def write_exam_readme(project: Path, title: str, tasks: list[str]) -> None:
    write(project / "README.md", f"""
        # {title}

        ## Enunciado

        Completa los bloques del examen sin cambiar firmas publicas y usando las estructuras del entorno del profesor.

        ## Ejercicios incluidos

        {chr(10).join("- `" + task + "`" for task in tasks)}

        ## Tests

        Ejecuta:

        ```bash
        mvn test
        ```

        Los tests fallan inicialmente por TODO esperado.
    """)


def main() -> None:
    write_exam_01()
    write_exam_02()
    write_exam_03()
    write_exam_04()


if __name__ == "__main__":
    main()
