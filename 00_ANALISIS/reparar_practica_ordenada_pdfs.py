from __future__ import annotations

import shutil
import textwrap
from dataclasses import dataclass
from pathlib import Path


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
OUT = ROOT / "EDA_Examenes_2026" / "08_PRACTICA_ORDENADA_POR_PDF"
PDFS = ROOT / "PDFS"
ESQ = ROOT / "Esqueletos"
GEN = ROOT / "EDA_Examenes_2026" / "06_ESQUELETOS_POR_PDF"


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).lstrip(), encoding="utf-8")


def clean_copy(src: Path, dst: Path) -> None:
    def ignore(_dir: str, names: list[str]) -> set[str]:
        return {n for n in names if n in {".git", ".idea", ".DS_Store", "target", "out", "__MACOSX"}}

    shutil.copytree(src, dst, ignore=ignore, dirs_exist_ok=True)


def pom() -> str:
    return """
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <groupId>es.urjc.grafo.EDA</groupId>
            <artifactId>examen-eda-practica</artifactId>
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


def copy_pdf(src: Path, dst_dir: Path) -> None:
    if src.exists():
        shutil.copy2(src, dst_dir / "enunciado_original.pdf")


def copy_maven_project(src: Path, dst: Path, title: str, source_pdf: Path | None = None) -> None:
    clean_copy(src, dst)
    if source_pdf:
        copy_pdf(source_pdf, dst)
    write(dst / "README.md", f"""
        # {title}

        Proyecto copiado desde el esqueleto real del profesor, con todas sus clases de dominio, entorno, tests y `pom.xml`.

        ## Como usarlo

        1. Lee `enunciado_original.pdf` si esta disponible.
        2. Completa solo los `TODO`.
        3. Ejecuta `mvn test`.

        No hay soluciones incluidas.
    """)


def copy_legacy_project(src: Path, dst: Path, title: str, source_pdf: Path | None = None) -> None:
    (dst / "src/main/java").mkdir(parents=True, exist_ok=True)
    (dst / "src/test/java").mkdir(parents=True, exist_ok=True)
    clean_copy(src / "src", dst / "src/main/java")
    clean_copy(src / "test", dst / "src/test/java")
    write(dst / "pom.xml", pom())
    if source_pdf:
        copy_pdf(source_pdf, dst)
    write(dst / "README.md", f"""
        # {title}

        Proyecto convertido a Maven desde el esqueleto antiguo `src`/`test`.
        Se han copiado las clases de dominio y las dependencias locales necesarias.

        ## Como usarlo

        1. Completa solo los `TODO`.
        2. Ejecuta `mvn test`.

        No hay soluciones incluidas.
    """)


@dataclass
class Method:
    ret: str
    name: str
    params: str
    comment: str


@dataclass
class GeneratedCase:
    folder: str
    title: str
    source_pdf: Path
    service: str
    domain_sources: dict[str, str]
    fields: list[str]
    methods: list[Method]
    test_body: str
    note: str


def generated_case_source(case: GeneratedCase) -> str:
    fields = "\n".join(f"    {field}" for field in case.fields)
    methods = []
    for m in case.methods:
        methods.append(f"""
            public {m.ret} {m.name}({m.params}) {{
                // TODO: {m.comment}
                throw new UnsupportedOperationException("TODO: {m.name}");
            }}
        """)
    return f"""
        package es.urjc.grafo.EDA.examen;

        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class {case.service} {{

        {fields}

        {''.join(methods)}
        }}
    """


def write_generated_case(case: GeneratedCase) -> None:
    dst = OUT / "02_CASOS_DE_USO_POR_PDF" / case.folder
    main = dst / "src/main/java/es/urjc/grafo/EDA/examen"
    test = dst / "src/test/java/es/urjc/grafo/EDA/examen"
    write(dst / "pom.xml", pom())
    copy_pdf(case.source_pdf, dst)
    for class_name, source in case.domain_sources.items():
        write(main / f"{class_name}.java", source)
    write(main / f"{case.service}.java", generated_case_source(case))
    write(test / f"{case.service}Test.java", f"""
        package es.urjc.grafo.EDA.examen;

        import org.junit.jupiter.api.Test;
        import java.time.LocalDate;
        import java.time.LocalDateTime;
        import static org.junit.jupiter.api.Assertions.*;

        class {case.service}Test {{
        {case.test_body}
        }}
    """)
    write(dst / "README.md", f"""
        # {case.title}

        ## Fuente

        Este proyecto procede de un PDF antiguo de examen. La copia del enunciado esta en `enunciado_original.pdf`.

        ## Estructura

        - Clase principal: `src/main/java/es/urjc/grafo/EDA/examen/{case.service}.java`
        - Clases de dominio: `src/main/java/es/urjc/grafo/EDA/examen`
        - Tests: `src/test/java/es/urjc/grafo/EDA/examen/{case.service}Test.java`

        ## Que debe completar el alumno

        Completa los `TODO` de la clase principal manteniendo sincronizados todos los indices.

        {case.note}

        No hay soluciones incluidas.
    """)


def record(name: str, params: str, comparable: bool = False) -> str:
    imports = []
    if "LocalDateTime" in params:
        imports.append("import java.time.LocalDateTime;")
    if "LocalDate" in params and "LocalDateTime" not in params:
        imports.append("import java.time.LocalDate;")
    import_block = "\n".join(imports)
    if comparable:
        if "int score" in params:
            compare_body = """
                    int cmp = Integer.compare(other.score(), this.score());
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.nick().compareTo(other.nick());
            """
        elif "double precision" in params:
            compare_body = """
                    int cmp = Double.compare(other.precision(), this.precision());
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.id().compareTo(other.id());
            """
        elif "int potencia" in params:
            compare_body = """
                    int cmp = Integer.compare(other.potencia(), this.potencia());
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.id().compareTo(other.id());
            """
        elif "int prioridad" in params and "LocalDateTime fecha" in params:
            compare_body = """
                    int cmp = this.fecha().compareTo(other.fecha());
                    if (cmp != 0) {
                        return cmp;
                    }
                    cmp = Integer.compare(other.prioridad(), this.prioridad());
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.id().compareTo(other.id());
            """
        elif "int points" in params:
            compare_body = """
                    int cmp = Integer.compare(other.points(), this.points());
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.id().compareTo(other.id());
            """
        elif "int edad" in params:
            compare_body = """
                    int cmp = Integer.compare(this.edad(), other.edad());
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.dni().compareTo(other.dni());
            """
        elif "String idioma" in params and "String palabra" in params:
            compare_body = """
                    int cmp = this.idioma().compareTo(other.idioma());
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.palabra().compareTo(other.palabra());
            """
        elif "int popularidad" in params:
            compare_body = """
                    int cmp = Integer.compare(other.popularidad(), this.popularidad());
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.nick().compareTo(other.nick());
            """
        else:
            compare_body = "return this.toString().compareTo(other.toString());"
        return f"""
            package es.urjc.grafo.EDA.examen;

            {import_block}

            public record {name}({params}) implements Comparable<{name}> {{
                @Override
                public int compareTo({name} other) {{
                    {compare_body}
                }}
            }}
        """
    return f"""
        package es.urjc.grafo.EDA.examen;

        {import_block}

        public record {name}({params}) {{
        }}
    """


def generated_cases() -> list[GeneratedCase]:
    mixed = PDFS / "Implementacion y casos de uso"
    return [
        GeneratedCase(
            "04_red_electrica_junio_2025",
            "Red Electrica Espanola",
            mixed / "Enunciado.pdf",
            "RedElectricaEspanola",
            {
                "Area": record("Area", "String id, String nombre"),
                "CentralElectrica": record("CentralElectrica", "String id, String areaId, int potencia", comparable=True),
            },
            [
                "private final HashMap<String, Area> areas = new HashMap<>();",
                "private final HashMap<String, CentralElectrica> centrales = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> red = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> centralesPorArea = new HashMap<>();",
                "private final TreeSet<CentralElectrica> rankingPotencia = new TreeSet<>();",
            ],
            [
                Method("boolean", "addArea", "Area area", "registrar un area sin duplicados."),
                Method("boolean", "addCentral", "CentralElectrica central", "registrar una central y todos los indices."),
                Method("boolean", "conectar", "String origen, String destino", "anadir una conexion no dirigida entre centrales existentes."),
                Method("Iterable<CentralElectrica>", "centralesDeArea", "String areaId", "devolver las centrales de un area."),
                Method("boolean", "estanConectadas", "String origen, String destino", "comprobar si hay camino entre dos centrales."),
                Method("CentralElectrica", "centralMasConectada", "", "devolver la central con mas conexiones."),
            ],
            """
                @Test
                void redElectricaBasica() {
                    RedElectricaEspanola red = new RedElectricaEspanola();
                    Area norte = new Area("N", "Norte");
                    CentralElectrica c1 = new CentralElectrica("C1", "N", 100);
                    CentralElectrica c2 = new CentralElectrica("C2", "N", 80);
                    assertTrue(red.addArea(norte));
                    assertTrue(red.addCentral(c1));
                    assertTrue(red.addCentral(c2));
                    assertTrue(red.conectar("C1", "C2"));
                    assertTrue(red.estanConectadas("C1", "C2"));
                    assertNotNull(red.centralesDeArea("N"));
                    assertEquals(c1, red.centralMasConectada());
                }
            """,
            "Usa `HashMap` para busquedas, `HashSet` para vecinos y `TreeSet` para ranking.",
        ),
        GeneratedCase(
            "05_ranking_jugadores_enero_2025",
            "PlayersRanking y NameComparator",
            mixed / "4c79148b-e28c-42e4-b222-a9c1a8d5a431.pdf",
            "PlayersRanking",
            {
                "Player": record("Player", "String nick, String name, int score", comparable=True),
                "NameComparator": """
                    package es.urjc.grafo.EDA.examen;

                    import java.util.Comparator;

                    public class NameComparator implements Comparator<Player> {
                        @Override
                        public int compare(Player a, Player b) {
                            // TODO: ordenar por nombre y desempatar por nick.
                            throw new UnsupportedOperationException("TODO: NameComparator.compare");
                        }
                    }
                """,
            },
            [
                "private final HashMap<String, Player> playersByNick = new HashMap<>();",
                "private final TreeSet<Player> rankingByScore = new TreeSet<>();",
                "private final TreeSet<Player> rankingByName = new TreeSet<>(new NameComparator());",
                "private final TreeMap<Integer, HashSet<String>> playersByScore = new TreeMap<>();",
            ],
            [
                Method("boolean", "addPlayer", "Player player", "insertar un jugador si no existe su nick."),
                Method("boolean", "updateScore", "String nick, int newScore", "actualizar puntuacion y reindexar rankings."),
                Method("Iterable<Player>", "top", "int n", "devolver los n mejores jugadores."),
                Method("Iterable<Player>", "playersBetweenScores", "int min, int max", "buscar por rango de puntuacion."),
                Method("Player", "findByNick", "String nick", "buscar por identificador."),
            ],
            """
                @Test
                void rankingBasico() {
                    PlayersRanking ranking = new PlayersRanking();
                    Player ana = new Player("ana1", "Ana", 20);
                    Player bob = new Player("bob1", "Bob", 15);
                    assertTrue(ranking.addPlayer(ana));
                    assertTrue(ranking.addPlayer(bob));
                    assertFalse(ranking.addPlayer(ana));
                    assertTrue(ranking.updateScore("bob1", 30));
                    assertEquals(bob, ranking.findByNick("bob1"));
                    assertNotNull(ranking.top(2));
                    assertNotNull(ranking.playersBetweenScores(10, 40));
                }
            """,
            "Cuidado: al cambiar puntos hay que quitar y reinsertar en `TreeSet` y `TreeMap`.",
        ),
        GeneratedCase(
            "06_synthetic_intel_junio_2024",
            "Synthetic Intel",
            mixed / "examen-de-estructuras-de-datos-avanzadas-junio-2024.pdf",
            "SyntheticIntel",
            {
                "ModeloIA": record("ModeloIA", "String id, String empresa, double precision", comparable=True),
            },
            [
                "private final HashMap<String, ModeloIA> modelos = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> dependencias = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> modelosPorEmpresa = new HashMap<>();",
                "private final TreeMap<Double, HashSet<String>> modelosPorPrecision = new TreeMap<>();",
                "private final TreeSet<ModeloIA> rankingPrecision = new TreeSet<>();",
            ],
            [
                Method("boolean", "addModelo", "ModeloIA modelo", "registrar un modelo unico."),
                Method("boolean", "addDependencia", "String modelo, String dependencia", "registrar una dependencia dirigida."),
                Method("boolean", "dependeDirectamente", "String modelo, String dependencia", "comprobar arista directa."),
                Method("boolean", "dependeIndirectamente", "String modelo, String dependencia", "comprobar camino dirigido."),
                Method("Iterable<ModeloIA>", "modelosEntrePrecision", "double min, double max", "consulta por rango."),
            ],
            """
                @Test
                void dependenciasBasicas() {
                    SyntheticIntel intel = new SyntheticIntel();
                    ModeloIA a = new ModeloIA("A", "URJC", 0.90);
                    ModeloIA b = new ModeloIA("B", "URJC", 0.80);
                    assertTrue(intel.addModelo(a));
                    assertTrue(intel.addModelo(b));
                    assertTrue(intel.addDependencia("A", "B"));
                    assertTrue(intel.dependeDirectamente("A", "B"));
                    assertTrue(intel.dependeIndirectamente("A", "B"));
                    assertNotNull(intel.modelosEntrePrecision(0.75, 1.0));
                }
            """,
            "Representa las dependencias como grafo dirigido con mapas y conjuntos.",
        ),
        GeneratedCase(
            "07_red_social_junio_2023",
            "Red social sin Graph",
            mixed / "4d1b6b48-d8b9-49dd-84c2-ccd32de869d3.pdf",
            "RedSocial",
            {
                "Persona": record("Persona", "String nick, String ciudad, int popularidad", comparable=True),
            },
            [
                "private final HashMap<String, Persona> personas = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> seguidos = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> seguidores = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> personasPorCiudad = new HashMap<>();",
                "private final TreeSet<Persona> rankingPopularidad = new TreeSet<>();",
            ],
            [
                Method("boolean", "addPersona", "Persona persona", "registrar persona e indices."),
                Method("boolean", "seguir", "String origen, String destino", "anadir relacion dirigida."),
                Method("boolean", "dejarDeSeguir", "String origen, String destino", "eliminar relacion dirigida."),
                Method("boolean", "sonAmigos", "String a, String b", "comprobar seguimiento mutuo."),
                Method("Iterable<Persona>", "sugerencias", "String nick", "devolver amigos de amigos no seguidos."),
            ],
            """
                @Test
                void relacionesBasicas() {
                    RedSocial red = new RedSocial();
                    assertTrue(red.addPersona(new Persona("ana", "Madrid", 0)));
                    assertTrue(red.addPersona(new Persona("bob", "Madrid", 0)));
                    assertTrue(red.seguir("ana", "bob"));
                    assertFalse(red.sonAmigos("ana", "bob"));
                    assertTrue(red.seguir("bob", "ana"));
                    assertTrue(red.sonAmigos("ana", "bob"));
                    assertNotNull(red.sugerencias("ana"));
                }
            """,
            "Usa dos indices: seguidos y seguidores. No uses una clase `Graph`.",
        ),
        GeneratedCase(
            "08_juego_luces_junio_2022",
            "Juego de las luces",
            mixed / "wuolah-free-EnunciadoJunioUltimaV2-A.pdf",
            "JuegoLuces",
            {
                "Bombilla": record("Bombilla", "String id, String zona"),
                "EventoLuz": record("EventoLuz", "String id, int prioridad, LocalDateTime fecha", comparable=True),
            },
            [
                "private final HashMap<String, Bombilla> bombillas = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> conexiones = new HashMap<>();",
                "private final HashSet<String> encendidas = new HashSet<>();",
                "private final PriorityQueue<EventoLuz> eventos = new PriorityQueue<>();",
            ],
            [
                Method("boolean", "addBombilla", "Bombilla bombilla", "registrar bombilla unica."),
                Method("boolean", "connect", "String a, String b", "conectar bombillas."),
                Method("boolean", "toggle", "String id", "cambiar estado."),
                Method("int", "propagar", "String origen, int distancia", "cambiar estado hasta distancia indicada."),
                Method("int", "encendidasEnComponente", "String id", "contar encendidas en la componente."),
            ],
            """
                @Test
                void lucesBasicas() {
                    JuegoLuces juego = new JuegoLuces();
                    assertTrue(juego.addBombilla(new Bombilla("A", "Z1")));
                    assertTrue(juego.addBombilla(new Bombilla("B", "Z1")));
                    assertTrue(juego.connect("A", "B"));
                    assertTrue(juego.toggle("A"));
                    assertEquals(2, juego.propagar("A", 1));
                    assertEquals(1, juego.encendidasEnComponente("A"));
                }
            """,
            "Entrena grafo manual con `HashMap<String, HashSet<String>>` y estados en `HashSet`.",
        ),
        GeneratedCase(
            "09_basketball_league_enero_2022",
            "BasketballLeague",
            mixed / "wuolah-free-Examen-1.pdf",
            "BasketballLeague",
            {
                "Team": record("Team", "String id, String city, int points", comparable=True),
            },
            [
                "private final HashMap<String, Team> teams = new HashMap<>();",
                "private final TreeSet<Team> ranking = new TreeSet<>();",
                "private final TreeMap<Integer, HashSet<String>> teamsByPoints = new TreeMap<>();",
            ],
            [
                Method("boolean", "addTeam", "Team team", "registrar equipo unico."),
                Method("boolean", "recordResult", "String winner, String loser", "actualizar puntos y ranking."),
                Method("Iterable<Team>", "topTeams", "int n", "devolver mejores equipos."),
                Method("Iterable<Team>", "teamsBetweenPoints", "int min, int max", "consulta por rango."),
            ],
            """
                @Test
                void ligaBasica() {
                    BasketballLeague league = new BasketballLeague();
                    assertTrue(league.addTeam(new Team("MAD", "Madrid", 0)));
                    assertTrue(league.addTeam(new Team("BCN", "Barcelona", 0)));
                    assertTrue(league.recordResult("MAD", "BCN"));
                    assertNotNull(league.topTeams(2));
                    assertNotNull(league.teamsBetweenPoints(0, 5));
                }
            """,
            "Practica `TreeSet` y `TreeMap` con reindexado tras cambios.",
        ),
        GeneratedCase(
            "10_urjc_flights_enero_2022",
            "URJCFlights",
            mixed / "wuolah-free-Examen-2.pdf",
            "URJCFlights",
            {
                "Airport": record("Airport", "String code, String city"),
                "Flight": record("Flight", "String code, String origin, String destination, LocalDateTime time"),
            },
            [
                "private final HashMap<String, Airport> airports = new HashMap<>();",
                "private final HashMap<String, Flight> flights = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> outgoing = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> incoming = new HashMap<>();",
                "private final TreeMap<LocalDateTime, HashSet<String>> flightsByTime = new TreeMap<>();",
            ],
            [
                Method("boolean", "addAirport", "Airport airport", "registrar aeropuerto."),
                Method("boolean", "addFlight", "Flight flight", "registrar vuelo dirigido."),
                Method("boolean", "directFlight", "String origin, String destination", "comprobar arista directa."),
                Method("boolean", "connectionWithMaxStops", "String origin, String destination, int stops", "BFS limitado por escalas."),
                Method("Iterable<Flight>", "flightsUntil", "LocalDateTime time", "consulta temporal."),
            ],
            """
                @Test
                void vuelosBasicos() {
                    URJCFlights flights = new URJCFlights();
                    assertTrue(flights.addAirport(new Airport("MAD", "Madrid")));
                    assertTrue(flights.addAirport(new Airport("BCN", "Barcelona")));
                    assertTrue(flights.addFlight(new Flight("F1", "MAD", "BCN", LocalDateTime.now())));
                    assertTrue(flights.directFlight("MAD", "BCN"));
                    assertTrue(flights.connectionWithMaxStops("MAD", "BCN", 0));
                    assertNotNull(flights.flightsUntil(LocalDateTime.now().plusDays(1)));
                }
            """,
            "Grafo dirigido con dos mapas: salidas y entradas.",
        ),
        GeneratedCase(
            "11_censo_urjc_junio_2016",
            "Censo URJC",
            mixed / "3540d1fd-f0f4-4198-bfcc-adfc51ad30a4.pdf",
            "CensoURJC",
            {
                "Habitante": record("Habitante", "String dni, String municipio, int edad", comparable=True),
            },
            [
                "private final HashMap<String, Habitante> habitantes = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> habitantesPorMunicipio = new HashMap<>();",
                "private final TreeMap<Integer, HashSet<String>> habitantesPorEdad = new TreeMap<>();",
                "private final TreeSet<Habitante> rankingEdad = new TreeSet<>();",
            ],
            [
                Method("boolean", "addHabitante", "Habitante habitante", "insertar habitante sin DNI repetido."),
                Method("boolean", "removeHabitante", "String dni", "borrar de todos los indices."),
                Method("Iterable<Habitante>", "habitantesMunicipio", "String municipio", "consulta por municipio."),
                Method("Iterable<Habitante>", "habitantesEntreEdades", "int min, int max", "consulta de rango."),
                Method("boolean", "moverHabitante", "String dni, String nuevoMunicipio", "actualizar municipio e indices."),
            ],
            """
                @Test
                void censoBasico() {
                    CensoURJC censo = new CensoURJC();
                    assertTrue(censo.addHabitante(new Habitante("1", "Madrid", 20)));
                    assertTrue(censo.moverHabitante("1", "Mostoles"));
                    assertNotNull(censo.habitantesMunicipio("Mostoles"));
                    assertNotNull(censo.habitantesEntreEdades(18, 30));
                    assertTrue(censo.removeHabitante("1"));
                }
            """,
            "Cada alta, baja o cambio debe tocar todos los indices.",
        ),
        GeneratedCase(
            "12_traductor_web_diciembre_2014",
            "Traductor web",
            mixed / "f4955113-a3a7-443c-8a04-6f30b9de991e.pdf",
            "TraductorWeb",
            {
                "EntradaDiccionario": record("EntradaDiccionario", "String idioma, String palabra, String traduccion", comparable=True),
            },
            [
                "private final HashMap<String, HashMap<String, String>> traducciones = new HashMap<>();",
                "private final HashMap<String, HashSet<String>> palabrasPorIdioma = new HashMap<>();",
                "private final TreeSet<EntradaDiccionario> entradasOrdenadas = new TreeSet<>();",
            ],
            [
                Method("boolean", "addTraduccion", "String idioma, String palabra, String traduccion", "registrar traduccion."),
                Method("String", "traducir", "String idioma, String palabra", "buscar traduccion."),
                Method("Iterable<String>", "palabrasDeIdioma", "String idioma", "devolver palabras conocidas."),
                Method("Iterable<EntradaDiccionario>", "palabrasEntre", "String ini, String fin", "consulta alfabetica."),
            ],
            """
                @Test
                void traductorBasico() {
                    TraductorWeb traductor = new TraductorWeb();
                    assertTrue(traductor.addTraduccion("en", "hola", "hello"));
                    assertEquals("hello", traductor.traducir("en", "hola"));
                    assertNotNull(traductor.palabrasDeIdioma("en"));
                    assertNotNull(traductor.palabrasEntre("a", "z"));
                }
            """,
            "Caso clasico de doble `HashMap` e indice ordenado.",
        ),
    ]


def copy_implementation_projects() -> None:
    impl = OUT / "01_IMPLEMENTACION_POR_PDF"
    sources = [
        ("01_enero_2026_grafos_arboles_iterador", "05_impl_enero_2026_grafos_arboles_iterador", "Implementacion enero 2026: grafos, arboles e iterador"),
        ("02_diciembre_2025_complementario_grado_identicos", "06_impl_diciembre_2025_complementario_grado_identicos", "Implementacion diciembre 2025: complementario, grado e identicos"),
        ("03_diciembre_2025_euler_descendants_symmetric", "07_impl_diciembre_2025_euler_descendants_symmetric", "Implementacion diciembre 2025: euleriano, descendientes y simetria"),
        ("04_hipergrafo", "03_impl_hipergrafo", "Implementacion: hipergrafo"),
        ("05_arboles_perfecto_iterador", "08_impl_funcionalidades_arboles_perfecto_iterador", "Implementacion: arbol perfecto e iterador"),
        ("06_junio_2025_iteradores_red_electrica_parte_impl", "09_mixto_junio_2025_iteradores_red_electrica", "Parte de implementacion extraida de junio 2025"),
        ("07_septiembre_2024_bst_remove_half_nodes_parte_impl", "12_mixto_septiembre_2024_bst_red_p2p", "Parte de implementacion extraida de septiembre 2024"),
    ]
    for folder, source, title in sources:
        src = GEN / source / "esqueletos_generados"
        dst = impl / folder
        clean_copy(src, dst)
        indice = GEN / source / "INDICE_EJERCICIOS.md"
        if indice.exists():
            shutil.copy2(indice, dst / "INDICE_EJERCICIOS.md")
        write(dst / "README.md", f"""
            # {title}

            Proyecto de implementacion copiado desde `06_ESQUELETOS_POR_PDF/{source}`.
            Contiene entorno, clases de examen y tests. Completa solo los `TODO`.

            Ejecuta:

            ```bash
            mvn test
            ```
        """)


def copy_real_case_projects() -> None:
    cases = OUT / "02_CASOS_DE_USO_POR_PDF"
    copy_maven_project(
        ESQ / "Uso - Esqueleto",
        cases / "01_urjcnetservices_routers_2026",
        "URJCNetServices / routers 2026",
        PDFS / "Casos de uso" / "Casos de uso - Enunciado.pdf",
    )
    copy_maven_project(
        ESQ / "Oposiciones-CNP - esqueleto",
        cases / "02_oposiciones_cnp",
        "Oposiciones CNP",
        PDFS / "Casos de uso" / "Enunciado.pdf",
    )
    copy_maven_project(
        ESQ / "CNI-Interacciones",
        cases / "03_cni_interacciones",
        "CNI Interacciones",
        PDFS / "Casos de uso" / "Enunciado (2).pdf",
    )
    copy_legacy_project(
        ESQ / "Esqueleto 2",
        cases / "13_red_p2p_septiembre_2024",
        "Red P2P septiembre 2024",
        PDFS / "Implementacion y casos de uso" / "estructuras-de-datos-avanzadas-examen-septiembre-2024-convocatoria.pdf",
    )


def write_root_docs() -> None:
    write(OUT / "README.md", """
        # Practica ordenada por PDFs

        Esta es la carpeta limpia para estudiar. Lo anterior queda como material de apoyo, pero esta carpeta es la que deberias abrir primero.

        ## Bloques

        - `01_IMPLEMENTACION_POR_PDF`: ejercicios de implementacion extraidos de PDFs reales o partes de implementacion de examenes mixtos.
        - `02_CASOS_DE_USO_POR_PDF`: casos de uso con proyecto completo: clases de dominio, gestor/servicio, tests y PDF fuente cuando se conoce.
        - `INDICE_LIMPIO.md`: orden recomendado y estado de cada proyecto.

        ## Regla de uso

        Entra en un proyecto concreto y ejecuta:

        ```bash
        mvn test
        ```

        El fallo inicial correcto es `UnsupportedOperationException` por TODO. Si falla porque falta una clase o no compila, eso es un problema real.
    """)
    write(OUT / "INDICE_LIMPIO.md", """
        # Indice limpio

        ## Casos de uso recomendados primero

        1. `02_CASOS_DE_USO_POR_PDF/01_urjcnetservices_routers_2026`
        2. `02_CASOS_DE_USO_POR_PDF/02_oposiciones_cnp`
        3. `02_CASOS_DE_USO_POR_PDF/03_cni_interacciones`
        4. `02_CASOS_DE_USO_POR_PDF/13_red_p2p_septiembre_2024`
        5. `02_CASOS_DE_USO_POR_PDF/04_red_electrica_junio_2025`
        6. `02_CASOS_DE_USO_POR_PDF/05_ranking_jugadores_enero_2025`
        7. `02_CASOS_DE_USO_POR_PDF/06_synthetic_intel_junio_2024`
        8. `02_CASOS_DE_USO_POR_PDF/10_urjc_flights_enero_2022`

        ## Implementacion recomendada primero

        1. `01_IMPLEMENTACION_POR_PDF/01_enero_2026_grafos_arboles_iterador`
        2. `01_IMPLEMENTACION_POR_PDF/02_diciembre_2025_complementario_grado_identicos`
        3. `01_IMPLEMENTACION_POR_PDF/03_diciembre_2025_euler_descendants_symmetric`
        4. `01_IMPLEMENTACION_POR_PDF/05_arboles_perfecto_iterador`
        5. `01_IMPLEMENTACION_POR_PDF/04_hipergrafo`

        ## Carpetas antiguas que ya no deberian ser tu punto de partida

        - `01_PLANTILLAS_BASE`
        - `04_TESTS_COMUNES`
        - `05_GUIAS_CORRECCION`
        - `03_EXAMENES_CASOS_DE_USO` porque algunos proyectos antiguos estaban incompletos.
        - `07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS` queda como banco extra, no como ruta principal.
    """)


def main() -> None:
    OUT.mkdir(parents=True, exist_ok=True)
    copy_implementation_projects()
    copy_real_case_projects()
    for case in generated_cases():
        write_generated_case(case)
    write_root_docs()


if __name__ == "__main__":
    main()
