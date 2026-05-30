from __future__ import annotations

import shutil
import textwrap
from dataclasses import dataclass
from pathlib import Path


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
BASE = ROOT / "EDA_Examenes_2026" / "08_PRACTICA_ORDENADA_POR_PDF" / "03_CASOS_DE_USO_LIMPIOS_NUEVOS"
PKG = "es.urjc.grafo.EDA.examen.casoslimpios"
PKG_PATH = Path("es/urjc/grafo/EDA/examen/casoslimpios")


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).lstrip(), encoding="utf-8")


def pom() -> str:
    return """
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <groupId>es.urjc.grafo.EDA</groupId>
            <artifactId>caso-uso-limpio</artifactId>
            <version>1.0-SNAPSHOT</version>
            <properties>
                <maven.compiler.source>21</maven.compiler.source>
                <maven.compiler.target>21</maven.compiler.target>
                <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            </properties>
            <dependencies>
                <dependency>
                    <groupId>org.junit.jupiter</groupId>
                    <artifactId>junit-jupiter</artifactId>
                    <version>5.8.1</version>
                    <scope>test</scope>
                </dependency>
            </dependencies>
            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-surefire-plugin</artifactId>
                        <version>3.0.0-M5</version>
                    </plugin>
                </plugins>
            </build>
        </project>
    """


@dataclass
class Exercise:
    folder: str
    title: str
    focus: str
    recommended: list[str]
    classes: dict[str, str]
    service: str
    tests: str


def domain(source: str) -> str:
    return f"package {PKG};\n\n{source.strip()}\n"


def service(class_name: str, methods: str, recommended: list[str]) -> str:
    rec = "\n".join(f"    // - {item}" for item in recommended)
    return f"""
        package {PKG};

        import java.time.LocalDate;
        import java.time.LocalDateTime;

        public class {class_name} {{

            // TODO: declara aqui los atributos privados que necesites.
            // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.
            // Estructuras recomendadas para este caso:
        {rec}

            public {class_name}() {{
                // TODO: inicializa aqui tus estructuras cuando las declares.
            }}

        {methods}
        }}
    """


def test(class_name: str, body: str) -> str:
    return f"""
        package {PKG};

        import org.junit.jupiter.api.Test;

        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.List;
        import java.util.Set;

        import static org.junit.jupiter.api.Assertions.*;

        class {class_name}Test {{

            private static <E> List<E> toList(Iterable<E> values) {{
                List<E> result = new ArrayList<>();
                for (E value : values) {{
                    result.add(value);
                }}
                return result;
            }}

            private static <E> Set<E> toSet(Iterable<E> values) {{
                return new HashSet<>(toList(values));
            }}

        {body}
        }}
    """


def exercises() -> list[Exercise]:
    return [
        Exercise(
            "01_urjcnetservices_routers_limpio",
            "URJCNetServices limpio: routers, mensajes y TTL",
            "Grafo manual con routers, mensajes por fecha y consultas por distancia.",
            [
                "HashMap<String, Router> para buscar routers por id",
                "HashMap<String, HashSet<String>> para conexiones no dirigidas",
                "HashMap<String, Mensaje> para mensajes por id",
                "TreeMap<LocalDateTime, HashSet<String>> para mensajes por fecha",
            ],
            {
                "Router.java": domain("""
                    public record Router(String id, String ip, String zona, int prioridad) {
                    }
                """),
                "Mensaje.java": domain("""
                    import java.time.LocalDateTime;

                    public record Mensaje(String id, String origen, String destino, LocalDateTime fecha, int prioridad) {
                    }
                """),
            },
            service("URJCNetServicesLimpio", """
                public boolean addRouter(Router router) {
                    // TODO: anadir router si no existe y rechazar null/duplicados.
                    throw new UnsupportedOperationException("TODO: addRouter");
                }

                public boolean addConnection(String router1, String router2) {
                    // TODO: conectar dos routers existentes sin duplicar aristas.
                    throw new UnsupportedOperationException("TODO: addConnection");
                }

                public boolean recibirMensaje(Mensaje mensaje) {
                    // TODO: guardar mensaje e indexarlo por fecha.
                    throw new UnsupportedOperationException("TODO: recibirMensaje");
                }

                public Iterable<Router> routersAlcanzables(String origen, int ttl) {
                    // TODO: BFS limitado; devolver routers a distancia <= ttl, incluyendo origen.
                    throw new UnsupportedOperationException("TODO: routersAlcanzables");
                }

                public Iterable<Mensaje> mensajesHasta(LocalDateTime fecha) {
                    // TODO: devolver mensajes con fecha <= fecha.
                    throw new UnsupportedOperationException("TODO: mensajesHasta");
                }

                public Router routerCentral() {
                    // TODO: devolver el router con menor distancia maxima al resto; null si no conexo.
                    throw new UnsupportedOperationException("TODO: routerCentral");
                }
            """, [
                "HashMap<String, Router>",
                "HashMap<String, HashSet<String>>",
                "HashMap<String, Mensaje>",
                "TreeMap<LocalDateTime, HashSet<String>>",
            ]),
            test("URJCNetServicesLimpio", """
                @Test
                void altaDuplicadosYConexiones() {
                    URJCNetServicesLimpio net = new URJCNetServicesLimpio();
                    Router a = new Router("A", "10.0.0.1", "Norte", 2);
                    Router b = new Router("B", "10.0.0.2", "Norte", 1);
                    assertTrue(net.addRouter(a));
                    assertTrue(net.addRouter(b));
                    assertFalse(net.addRouter(a));
                    assertTrue(net.addConnection("A", "B"));
                    assertFalse(net.addConnection("A", "B"));
                    assertFalse(net.addConnection("A", "Z"));
                }

                @Test
                void ttlYMensajesPorFecha() {
                    URJCNetServicesLimpio net = new URJCNetServicesLimpio();
                    net.addRouter(new Router("A", "10.0.0.1", "N", 1));
                    net.addRouter(new Router("B", "10.0.0.2", "N", 1));
                    net.addRouter(new Router("C", "10.0.0.3", "S", 1));
                    net.addConnection("A", "B");
                    net.addConnection("B", "C");
                    assertEquals(2, toList(net.routersAlcanzables("A", 1)).size());

                    LocalDateTime d1 = LocalDateTime.of(2026, 1, 1, 10, 0);
                    LocalDateTime d2 = LocalDateTime.of(2026, 1, 2, 10, 0);
                    net.recibirMensaje(new Mensaje("M1", "A", "B", d1, 1));
                    net.recibirMensaje(new Mensaje("M2", "A", "C", d2, 2));
                    assertEquals(1, toList(net.mensajesHasta(d1)).size());
                }

                @Test
                void routerCentralEnRedConexa() {
                    URJCNetServicesLimpio net = new URJCNetServicesLimpio();
                    Router a = new Router("A", "1", "N", 1);
                    Router b = new Router("B", "2", "N", 1);
                    Router c = new Router("C", "3", "N", 1);
                    net.addRouter(a);
                    net.addRouter(b);
                    net.addRouter(c);
                    net.addConnection("A", "B");
                    net.addConnection("B", "C");
                    assertEquals(b, net.routerCentral());
                }
            """),
        ),
        Exercise(
            "02_registro_cnp_limpio",
            "Registro CNP limpio: opositores, ranking y rangos",
            "Mapas por DNI, ranking por nota, indices por provincia y consultas por rango.",
            [
                "HashMap<String, Opositor> para DNI",
                "HashMap<String, HashSet<String>> para provincia",
                "TreeMap<Double, HashSet<String>> para nota media",
                "TreeSet<Opositor> para ranking",
            ],
            {
                "Notas.java": domain("""
                    public record Notas(double teoria, double fisica, double psicotecnico) {
                        public double media() {
                            return (teoria + fisica + psicotecnico) / 3.0;
                        }
                    }
                """),
                "Opositor.java": domain("""
                    public record Opositor(String dni, String nombre, String provincia, Notas notas) {
                    }
                """),
            },
            service("RegistroCNPLimpio", """
                public boolean addOpositor(Opositor opositor) {
                    // TODO: insertar si no existe DNI y actualizar indices.
                    throw new UnsupportedOperationException("TODO: addOpositor");
                }

                public Opositor getOpositor(String dni) {
                    // TODO: buscar por DNI.
                    throw new UnsupportedOperationException("TODO: getOpositor");
                }

                public boolean actualizarNotas(String dni, Notas notas) {
                    // TODO: actualizar notas y reindexar ranking/rango.
                    throw new UnsupportedOperationException("TODO: actualizarNotas");
                }

                public Iterable<Opositor> aptosPorProvincia(String provincia, double notaMinima) {
                    // TODO: filtrar opositores de una provincia con media >= notaMinima.
                    throw new UnsupportedOperationException("TODO: aptosPorProvincia");
                }

                public Iterable<Opositor> opositoresEntreNotas(double min, double max) {
                    // TODO: devolver opositores con media en [min, max].
                    throw new UnsupportedOperationException("TODO: opositoresEntreNotas");
                }

                public Iterable<Opositor> top(int n) {
                    // TODO: devolver los n mejores por nota media, desempate por DNI.
                    throw new UnsupportedOperationException("TODO: top");
                }
            """, [
                "HashMap<String, Opositor>",
                "HashMap<String, HashSet<String>>",
                "TreeMap<Double, HashSet<String>>",
                "TreeSet<Opositor>",
            ]),
            test("RegistroCNPLimpio", """
                @Test
                void altaBusquedaYDuplicados() {
                    RegistroCNPLimpio registro = new RegistroCNPLimpio();
                    Opositor ana = new Opositor("111A", "Ana", "Madrid", new Notas(8, 7, 9));
                    assertTrue(registro.addOpositor(ana));
                    assertFalse(registro.addOpositor(ana));
                    assertEquals(ana, registro.getOpositor("111A"));
                    assertNull(registro.getOpositor("000Z"));
                }

                @Test
                void rankingRangosYProvincia() {
                    RegistroCNPLimpio registro = new RegistroCNPLimpio();
                    registro.addOpositor(new Opositor("111A", "Ana", "Madrid", new Notas(8, 7, 9)));
                    registro.addOpositor(new Opositor("222B", "Luis", "Madrid", new Notas(4, 5, 6)));
                    registro.addOpositor(new Opositor("333C", "Eva", "Toledo", new Notas(9, 9, 9)));
                    assertEquals(1, toList(registro.aptosPorProvincia("Madrid", 7.0)).size());
                    assertEquals(2, toList(registro.opositoresEntreNotas(7.0, 10.0)).size());
                    assertEquals("333C", toList(registro.top(1)).get(0).dni());
                    assertTrue(registro.actualizarNotas("222B", new Notas(10, 10, 10)));
                    assertEquals("222B", toList(registro.top(1)).get(0).dni());
                }
            """),
        ),
        Exercise(
            "03_cni_contactos_limpio",
            "CNI limpio: contactos indirectos",
            "Grafo manual de personas, contactos por fecha/minutos y BFS limitado.",
            [
                "HashMap<Integer, Agente> para agentes",
                "HashMap<Integer, HashSet<Integer>> para contactos",
                "TreeMap<LocalDate, HashSet<Contacto>> para fechas",
                "HashSet<Integer> para visitados en BFS",
            ],
            {
                "Agente.java": domain("""
                    public record Agente(int id, String nombre, String zona) {
                    }
                """),
                "Contacto.java": domain("""
                    import java.time.LocalDate;

                    public record Contacto(int personaA, int personaB, LocalDate fecha, int minutos) {
                    }
                """),
            },
            service("CNIContactosLimpio", """
                public boolean addAgente(Agente agente) {
                    // TODO: registrar agente sin duplicados.
                    throw new UnsupportedOperationException("TODO: addAgente");
                }

                public boolean registrarContacto(Contacto contacto) {
                    // TODO: guardar contacto e indexar por fecha.
                    throw new UnsupportedOperationException("TODO: registrarContacto");
                }

                public boolean contactoDirecto(int a, int b) {
                    // TODO: comprobar contacto directo.
                    throw new UnsupportedOperationException("TODO: contactoDirecto");
                }

                public Iterable<Agente> grupoDeRiesgo(int origen, LocalDate desde, int minutosMinimos) {
                    // TODO: BFS usando solo contactos con fecha >= desde y minutos >= minutosMinimos.
                    throw new UnsupportedOperationException("TODO: grupoDeRiesgo");
                }

                public boolean posibleCadena(int origen, int destino, int maxSaltos) {
                    // TODO: comprobar si hay camino con longitud <= maxSaltos.
                    throw new UnsupportedOperationException("TODO: posibleCadena");
                }
            """, [
                "HashMap<Integer, Agente>",
                "HashMap<Integer, HashSet<Integer>>",
                "TreeMap<LocalDate, HashSet<Contacto>>",
            ]),
            test("CNIContactosLimpio", """
                @Test
                void contactosYCadena() {
                    CNIContactosLimpio cni = new CNIContactosLimpio();
                    cni.addAgente(new Agente(1, "A", "N"));
                    cni.addAgente(new Agente(2, "B", "N"));
                    cni.addAgente(new Agente(3, "C", "S"));
                    LocalDate dia = LocalDate.of(2026, 1, 1);
                    assertTrue(cni.registrarContacto(new Contacto(1, 2, dia, 15)));
                    assertTrue(cni.registrarContacto(new Contacto(2, 3, dia, 15)));
                    assertTrue(cni.contactoDirecto(1, 2));
                    assertTrue(cni.posibleCadena(1, 3, 2));
                    assertEquals(3, toList(cni.grupoDeRiesgo(1, dia, 10)).size());
                }
            """),
        ),
        Exercise(
            "04_red_p2p_limpia",
            "Red P2P limpia: nodos, conexiones y archivos",
            "Grafo manual con indices directos e inversos de archivos.",
            [
                "HashMap<String, Nodo> para nodos",
                "HashMap<String, HashSet<String>> para conexiones",
                "HashMap<String, HashSet<String>> para archivos por nodo",
                "HashMap<String, HashSet<String>> para nodos por archivo",
            ],
            {
                "Nodo.java": domain("""
                    public record Nodo(String id, String ip, int capacidad) {
                    }
                """),
            },
            service("RedP2PLimpia", """
                public boolean addNode(Nodo nodo) {
                    // TODO: insertar nodo y preparar sus indices.
                    throw new UnsupportedOperationException("TODO: addNode");
                }

                public boolean connect(String a, String b) {
                    // TODO: conectar nodos existentes.
                    throw new UnsupportedOperationException("TODO: connect");
                }

                public boolean addFile(String nodo, String archivo) {
                    // TODO: registrar archivo en nodo e indice inverso.
                    throw new UnsupportedOperationException("TODO: addFile");
                }

                public Iterable<Nodo> buscarArchivo(String origen, String archivo, int ttl) {
                    // TODO: BFS hasta ttl y devolver nodos alcanzables que tienen el archivo.
                    throw new UnsupportedOperationException("TODO: buscarArchivo");
                }

                public boolean shutdownNode(String nodo) {
                    // TODO: eliminar nodo de todos los indices y conexiones.
                    throw new UnsupportedOperationException("TODO: shutdownNode");
                }
            """, [
                "HashMap<String, Nodo>",
                "HashMap<String, HashSet<String>>",
                "HashMap<String, HashSet<String>> para archivos",
            ]),
            test("RedP2PLimpia", """
                @Test
                void busquedaArchivoConTTL() {
                    RedP2PLimpia red = new RedP2PLimpia();
                    red.addNode(new Nodo("A", "1.1.1.1", 10));
                    red.addNode(new Nodo("B", "2.2.2.2", 10));
                    red.addNode(new Nodo("C", "3.3.3.3", 10));
                    red.connect("A", "B");
                    red.connect("B", "C");
                    red.addFile("C", "eda.pdf");
                    assertEquals(0, toList(red.buscarArchivo("A", "eda.pdf", 1)).size());
                    assertEquals(1, toList(red.buscarArchivo("A", "eda.pdf", 2)).size());
                    assertTrue(red.shutdownNode("B"));
                    assertEquals(0, toList(red.buscarArchivo("A", "eda.pdf", 3)).size());
                }
            """),
        ),
        Exercise(
            "05_urjc_flights_limpio",
            "URJCFlights limpio: vuelos dirigidos y escalas",
            "Grafo dirigido con vuelos por codigo y por fecha.",
            [
                "HashMap<String, Aeropuerto> para aeropuertos",
                "HashMap<String, Vuelo> para vuelos",
                "HashMap<String, HashSet<String>> para salidas",
                "HashMap<String, HashSet<String>> para entradas",
                "TreeMap<LocalDateTime, HashSet<String>> para fechas",
            ],
            {
                "Aeropuerto.java": domain("""
                    public record Aeropuerto(String codigo, String ciudad) {
                    }
                """),
                "Vuelo.java": domain("""
                    import java.time.LocalDateTime;

                    public record Vuelo(String codigo, String origen, String destino, LocalDateTime salida) {
                    }
                """),
            },
            service("URJCFlightsLimpio", """
                public boolean addAirport(Aeropuerto aeropuerto) {
                    // TODO: registrar aeropuerto.
                    throw new UnsupportedOperationException("TODO: addAirport");
                }

                public boolean addFlight(Vuelo vuelo) {
                    // TODO: registrar vuelo dirigido e indices.
                    throw new UnsupportedOperationException("TODO: addFlight");
                }

                public boolean vueloDirecto(String origen, String destino) {
                    // TODO: comprobar si hay vuelo directo.
                    throw new UnsupportedOperationException("TODO: vueloDirecto");
                }

                public boolean conexionConMaxEscalas(String origen, String destino, int maxEscalas) {
                    // TODO: BFS dirigido; maxEscalas=0 implica vuelo directo.
                    throw new UnsupportedOperationException("TODO: conexionConMaxEscalas");
                }

                public Iterable<Vuelo> vuelosEntre(LocalDateTime inicio, LocalDateTime fin) {
                    // TODO: devolver vuelos en rango temporal.
                    throw new UnsupportedOperationException("TODO: vuelosEntre");
                }
            """, [
                "HashMap<String, Aeropuerto>",
                "HashMap<String, Vuelo>",
                "HashMap<String, HashSet<String>> salidas/entradas",
                "TreeMap<LocalDateTime, HashSet<String>>",
            ]),
            test("URJCFlightsLimpio", """
                @Test
                void escalasYFechas() {
                    URJCFlightsLimpio flights = new URJCFlightsLimpio();
                    flights.addAirport(new Aeropuerto("MAD", "Madrid"));
                    flights.addAirport(new Aeropuerto("BCN", "Barcelona"));
                    flights.addAirport(new Aeropuerto("PAR", "Paris"));
                    LocalDateTime ahora = LocalDateTime.of(2026, 1, 1, 10, 0);
                    flights.addFlight(new Vuelo("F1", "MAD", "BCN", ahora));
                    flights.addFlight(new Vuelo("F2", "BCN", "PAR", ahora.plusHours(2)));
                    assertTrue(flights.vueloDirecto("MAD", "BCN"));
                    assertFalse(flights.vueloDirecto("MAD", "PAR"));
                    assertTrue(flights.conexionConMaxEscalas("MAD", "PAR", 1));
                    assertEquals(2, toList(flights.vuelosEntre(ahora.minusMinutes(1), ahora.plusHours(3))).size());
                }
            """),
        ),
        Exercise(
            "06_hospital_triaje_limpio",
            "Hospital limpio: triaje y especialidades",
            "PriorityQueue, indices por SIP, especialidad y llegada.",
            [
                "HashMap<String, Paciente> para pacientes",
                "HashMap<String, HashSet<String>> para especialidades",
                "TreeMap<LocalDateTime, HashSet<String>> para llegadas",
                "PriorityQueue<Paciente> para triaje",
            ],
            {
                "Paciente.java": domain("""
                    import java.time.LocalDateTime;

                    public record Paciente(String sip, String nombre, String especialidad, int gravedad, LocalDateTime llegada) {
                    }
                """),
            },
            service("HospitalTriajeLimpio", """
                public boolean registrarPaciente(Paciente paciente) {
                    // TODO: registrar paciente e indices.
                    throw new UnsupportedOperationException("TODO: registrarPaciente");
                }

                public Paciente siguientePaciente() {
                    // TODO: devolver y eliminar el paciente mas grave; desempate por llegada.
                    throw new UnsupportedOperationException("TODO: siguientePaciente");
                }

                public boolean cambiarGravedad(String sip, int nuevaGravedad) {
                    // TODO: actualizar prioridad y reinsertar en la cola si procede.
                    throw new UnsupportedOperationException("TODO: cambiarGravedad");
                }

                public Iterable<Paciente> pacientesEspecialidad(String especialidad) {
                    // TODO: devolver pacientes de una especialidad.
                    throw new UnsupportedOperationException("TODO: pacientesEspecialidad");
                }

                public Iterable<Paciente> pacientesAntesDe(LocalDateTime fecha) {
                    // TODO: devolver pacientes con llegada anterior o igual.
                    throw new UnsupportedOperationException("TODO: pacientesAntesDe");
                }

                public boolean altaPaciente(String sip) {
                    // TODO: eliminar paciente de todos los indices.
                    throw new UnsupportedOperationException("TODO: altaPaciente");
                }
            """, [
                "HashMap<String, Paciente>",
                "HashMap<String, HashSet<String>>",
                "TreeMap<LocalDateTime, HashSet<String>>",
                "PriorityQueue<Paciente>",
            ]),
            test("HospitalTriajeLimpio", """
                @Test
                void prioridadEspecialidadYAltas() {
                    HospitalTriajeLimpio hospital = new HospitalTriajeLimpio();
                    LocalDateTime t = LocalDateTime.of(2026, 1, 1, 10, 0);
                    Paciente ana = new Paciente("S1", "Ana", "TRAUMA", 3, t);
                    Paciente bob = new Paciente("S2", "Bob", "TRAUMA", 5, t.plusMinutes(1));
                    assertTrue(hospital.registrarPaciente(ana));
                    assertTrue(hospital.registrarPaciente(bob));
                    assertEquals(2, toList(hospital.pacientesEspecialidad("TRAUMA")).size());
                    assertEquals(ana, toList(hospital.pacientesAntesDe(t)).get(0));
                    assertEquals(bob, hospital.siguientePaciente());
                    assertTrue(hospital.cambiarGravedad("S1", 7));
                    assertEquals(ana, hospital.siguientePaciente());
                    assertFalse(hospital.altaPaciente("S1"));
                }
            """),
        ),
    ]


def write_exercise(ex: Exercise) -> None:
    project = BASE / ex.folder
    if project.exists():
        shutil.rmtree(project)
    main = project / "src/main/java" / PKG_PATH
    tests = project / "src/test/java" / PKG_PATH
    write(project / "pom.xml", pom())
    for file_name, source in ex.classes.items():
        write(main / file_name, source)
    write(main / f"{ex.service.split('class ')[-1].split()[0] if 'class ' in ex.service else 'Service'}.java", ex.service)
    class_name = ex.service.split("class ")[1].split()[0]
    write(tests / f"{class_name}Test.java", ex.tests)
    write(project / "README.md", f"""
        # {ex.title}

        ## Objetivo

        {ex.focus}

        ## Que esta ya dado

        - Clases de dominio completas en `src/main/java/{str(PKG_PATH)}`.
        - Clase gestora con constructor vacio, comentario de atributos recomendados y metodos `TODO`.
        - Tests completos en `src/test/java`.

        ## Que debes hacer tu

        1. Declarar los atributos privados que necesites.
        2. Inicializarlos en el constructor.
        3. Implementar los metodos publicos sin cambiar firmas.

        ## Estructuras recomendadas

        {chr(10).join("- `" + item + "`" for item in ex.recommended)}

        ## Ejecutar

        ```bash
        mvn test
        ```

        No hay soluciones incluidas.
    """)


def main() -> None:
    BASE.mkdir(parents=True, exist_ok=True)
    for ex in exercises():
        write_exercise(ex)
    write(BASE / "README.md", f"""
        # Casos de uso limpios nuevos

        Estos ejercicios estan pensados para evitar el problema de esqueletos raros:

        - Las clases de dominio si estan dadas y completas.
        - La clase gestora no trae estructuras ya creadas.
        - Tu decides los atributos privados e inicializas tus estructuras.
        - Los tests estan completos y fallan inicialmente por los `TODO`.

        ## Orden recomendado

        1. `01_urjcnetservices_routers_limpio`
        2. `02_registro_cnp_limpio`
        3. `03_cni_contactos_limpio`
        4. `04_red_p2p_limpia`
        5. `05_urjc_flights_limpio`
        6. `06_hospital_triaje_limpio`

        ## Ejecutar

        Entra en cualquier carpeta y ejecuta:

        ```bash
        mvn test
        ```
    """)


if __name__ == "__main__":
    main()
