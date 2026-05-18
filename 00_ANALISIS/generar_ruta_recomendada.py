from __future__ import annotations

import shutil
import textwrap
from pathlib import Path


ROOT = Path("/Users/arevalo/Documents/Codex/EDA")
BASE = ROOT / "Esqueletos" / "Implementación - Esqueleto"
OUT = ROOT / "EDA_Examenes_2026" / "07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS" / "06_RUTA_RECOMENDADA"


def write(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(textwrap.dedent(content).lstrip(), encoding="utf-8")


def copy_professor_base(project: Path) -> None:
    project.mkdir(parents=True, exist_ok=True)
    shutil.copy2(BASE / "pom.xml", project / "pom.xml")
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


GUIDE = """
# Guía de orden recomendado para empezar

La idea es ir de menos a más: primero recuperar Java, recursividad y recorridos; después subir a grafos, montículos, iteradores y casos de uso.

## 1. Árboles generales

Empieza aquí porque entrenas recursividad sin tener que pensar todavía en dos hijos fijos.

| Orden | Ejercicio | Objetivo | Clase |
|---:|---|---|---|
| 1 | `countNodes(tree)` | Recorrer todos los nodos | `GeneralTreeWarmup` |
| 2 | `countLeaves(tree)` | Detectar hojas | `GeneralTreeWarmup` |
| 3 | `height(tree)` | Recursividad con máximo | `GeneralTreeWarmup` |
| 4 | `treeDegree(tree)` | Máximo número de hijos | `GeneralTreeWarmup` |
| 5 | `descendantsNumber(tree, node)` | Contar descendientes de un nodo | `GeneralTreeWarmup` |
| 6 | `nodesAtDepth(tree, depth)` | Controlar profundidad | `GeneralTreeWarmup` |
| 7 | `isPerfect(tree)` | Mezclar altura + hojas | `GeneralTreeWarmup` |
| 8 | `InternalNodeIterator` | Iterador de nodos internos | `InternalNodeIterator` |

Plantilla mental:

```java
private int count(Position<E> p) {
    int total = 1;
    for (Position<E> child : tree.children(p)) {
        total += count(child);
    }
    return total;
}
```

## 2. Árboles binarios

Cuando lo anterior salga fluido, pasa a binarios.

| Orden | Ejercicio | Objetivo | Clase |
|---:|---|---|---|
| 1 | `height(binaryTree)` | Caso base + hijos izquierdo/derecho | `BinaryTreeWarmup` |
| 2 | `countNodes(binaryTree)` | Recorrido binario básico | `BinaryTreeWarmup` |
| 3 | `inorder / preorder / postorder` | Recorridos clásicos | `BinaryTreeWarmup` |
| 4 | `areIdentical(t1, t2)` | Comparar dos árboles | `BinaryTreeWarmup` |
| 5 | `isSymmetric(tree)` | Comparar espejo | `BinaryTreeWarmup` |
| 6 | `isPerfect(tree)` | Todos los niveles completos | `BinaryTreeWarmup` |
| 7 | `width(tree)` | Recorrido por niveles | `BinaryTreeWarmup` |
| 8 | `isAlmostComplete(tree)` | Cola/BFS de árbol | `BinaryTreeWarmup` |
| 9 | `isHeap(tree)` | Casi completo + prioridad | `BinaryTreeWarmup` |
| 10 | `cumplePropiedadesMonticulo(tree)` | Ejercicio tipo enero | `BinaryTreeWarmup` |
| 11 | `diameter(tree)` | Subida de nivel | `BinaryTreeWarmup` |

## 3. Grafos

No empieces por `kPower`. Primero domina BFS con distancias.

| Orden | Ejercicio | Objetivo | Clase |
|---:|---|---|---|
| 1 | `addVertex / addEdge` con `HashMap<V, HashSet<V>>` | Entender grafo simple | `ManualGraphWarmup` |
| 2 | `dfsReachable(origen)` | DFS recursivo | `ManualGraphWarmup` |
| 3 | `existsPathDFS(origen, destino)` | Camino cualquiera | `ManualGraphWarmup` |
| 4 | `bfs(origen)` | Cola + visitados | `ManualGraphWarmup` |
| 5 | `distance(origen, destino)` | BFS con distancias | `ManualGraphWarmup` |
| 6 | `existsPathLessOrEqual(origen, destino, n)` | Ejercicio tipo enero | `ManualGraphWarmup` |
| 7 | `connectedComponents()` | Repetir DFS/BFS | `ManualGraphWarmup` |
| 8 | `isConnected()` | Componente única | `ManualGraphWarmup` |
| 9 | `complementary()` | Crear grafo nuevo | `ManualGraphWarmup` |
| 10 | `kPower(g, k)` | Grafo potencia | `AssignmentGraphWarmup` |
| 11 | `diameter(g)` | BFS desde cada vértice | `AssignmentGraphWarmup` |
| 12 | `centralVertex(g)` | Centro del grafo | `AssignmentGraphWarmup` |

Representación manual:

```java
HashMap<String, HashSet<String>> adj = new HashMap<>();
```

Traducción al entorno:

```java
for (Edge<E> edge : graph.incidentEdges(vertex)) {
    Vertex<V> neighbor = graph.opposite(vertex, edge);
}
```

## 4. Casos de uso

Empieza con CNP antes que routers o CNI.

| Orden | Caso | Estructuras | Clase |
|---:|---|---|---|
| 1 | Registro CNP simple | `HashMap`, `HashSet` | `CNPWarmup` |
| 2 | Registro CNP con ranking | `HashMap`, `TreeSet` | `CNPWarmup` |
| 3 | Registro CNP con notas por rango | `TreeMap`, `TreeSet` | `CNPWarmup` |
| 4 | URJCNetServices 2 | `HashMap`, `HashSet`, grafo manual | `RouterWarmup` |
| 5 | CNI contactos indirectos | BFS con mapas | `CNIWarmup` |
| 6 | Red P2P | Grafo + TTL | `P2PWarmup` |
| 7 | URJCFlights | Grafo dirigido + escalas | `FlightsWarmup` |
| 8 | Ranking jugadores/equipos | `TreeSet`, comparadores | `RankingWarmup` |
| 9 | Hospital/triaje | `PriorityQueue` | `HospitalWarmup` |
| 10 | Hipergrafo de proyectos | Dos índices cruzados | `HypergraphMapsWarmup` |

## Ruta ideal

### Semana 1

| Día | Bloque |
|---:|---|
| 1 | Java básico + `HashMap`, `HashSet`, `Queue` |
| 2 | Árboles generales: contar, altura, grado |
| 3 | Árboles binarios: altura, idénticos, simétricos |
| 4 | Grafos: DFS, BFS, camino |
| 5 | Grafos: distancia ≤ n, componentes |
| 6 | Caso CNP con ranking |
| 7 | Simulacro pequeño |

### Semana 2

| Día | Bloque |
|---:|---|
| 1 | `kPower` + complementario |
| 2 | `isAlmostComplete` + `isHeap` |
| 3 | Iteradores: BFS/InternalNode/remove |
| 4 | URJCNetServices con routers |
| 5 | CNI/P2P con TTL |
| 6 | Simulacro implementación |
| 7 | Repaso de errores |

## 12 imprescindibles

1. `treeDegree`
2. `descendantsNumber`
3. `areIdentical`
4. `isSymmetric`
5. `isPerfect`
6. `isAlmostComplete`
7. `cumplePropiedadesMonticulo`
8. `bfs`
9. `existeCaminoDeLongitudMenorOIgualAN`
10. `connectedComponents`
11. `complementary`
12. `kPower`
"""


def build_docs() -> None:
    write(OUT / "README.md", """
        # Ruta recomendada de ejercicios

        Esta carpeta contiene los ejercicios de arranque que conviene hacer antes de los ejercicios avanzados.

        - `GUIA_ORDEN_RECOMENDADO.md`: orden de estudio y prioridad.
        - `proyecto_ruta_recomendada`: proyecto Maven con estructura del profesor, esqueletos y tests.

        Para usar:

        ```bash
        cd proyecto_ruta_recomendada
        mvn test
        ```

        Los tests fallan al principio porque los métodos están incompletos.
    """)
    write(OUT / "GUIA_ORDEN_RECOMENDADO.md", GUIDE)


def build_project() -> None:
    project = OUT / "proyecto_ruta_recomendada"
    if project.exists():
        shutil.rmtree(project)
    copy_professor_base(project)
    main = project / "src/main/java/es/urjc/grafo/EDA/examen/ruta"
    test = project / "src/test/java/es/urjc/grafo/EDA/examen/ruta"

    write(main / "GeneralTreeWarmup.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.trees.Tree;
        import es.urjc.grafo.EDA.utils.Position;

        public class GeneralTreeWarmup {

            public static <E> int countNodes(Tree<E> tree) {
                // TODO: recorrer todos los nodos del árbol.
                throw new UnsupportedOperationException("TODO: countNodes");
            }

            public static <E> int countLeaves(Tree<E> tree) {
                // TODO: contar posiciones hoja.
                throw new UnsupportedOperationException("TODO: countLeaves");
            }

            public static <E> int height(Tree<E> tree) {
                // TODO: devolver la altura del árbol.
                throw new UnsupportedOperationException("TODO: height");
            }

            public static <E> int treeDegree(Tree<E> tree) {
                // TODO: devolver el máximo número de hijos de cualquier nodo.
                throw new UnsupportedOperationException("TODO: treeDegree");
            }

            public static <E> int descendantsNumber(Tree<E> tree, Position<E> node) {
                // TODO: contar descendientes de node, sin contar node salvo que el enunciado indique lo contrario.
                throw new UnsupportedOperationException("TODO: descendantsNumber");
            }

            public static <E> Iterable<Position<E>> nodesAtDepth(Tree<E> tree, int depth) {
                // TODO: devolver nodos exactamente a profundidad depth.
                throw new UnsupportedOperationException("TODO: nodesAtDepth");
            }

            public static <E> boolean isPerfect(Tree<E> tree) {
                // TODO: comprobar que todas las hojas están al mismo nivel y que cada nodo interno tiene grado máximo uniforme.
                throw new UnsupportedOperationException("TODO: isPerfect");
            }
        }
    """)

    write(main / "InternalNodeIterator.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.trees.Tree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Iterator;

        public class InternalNodeIterator<E> implements Iterator<Position<E>> {

            private final Tree<E> tree;

            public InternalNodeIterator(Tree<E> tree) {
                this.tree = tree;
            }

            @Override
            public boolean hasNext() {
                // TODO: indicar si queda algún nodo interno por visitar.
                throw new UnsupportedOperationException("TODO: hasNext");
            }

            @Override
            public Position<E> next() {
                // TODO: devolver el siguiente nodo interno.
                throw new UnsupportedOperationException("TODO: next");
            }

            @Override
            public void remove() {
                // TODO: si procede, eliminar el último nodo devuelto manteniendo el iterador consistente.
                throw new UnsupportedOperationException("TODO: remove");
            }
        }
    """)

    write(main / "BinaryTreeWarmup.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Comparator;

        public class BinaryTreeWarmup {

            public static <E> int height(BinaryTree<E> tree) {
                // TODO: calcular altura con hijos izquierdo/derecho.
                throw new UnsupportedOperationException("TODO: height");
            }

            public static <E> int countNodes(BinaryTree<E> tree) {
                // TODO: contar nodos del árbol binario.
                throw new UnsupportedOperationException("TODO: countNodes");
            }

            public static <E> Iterable<E> inorder(BinaryTree<E> tree) {
                // TODO: recorrido inorden.
                throw new UnsupportedOperationException("TODO: inorder");
            }

            public static <E> Iterable<E> preorder(BinaryTree<E> tree) {
                // TODO: recorrido preorden.
                throw new UnsupportedOperationException("TODO: preorder");
            }

            public static <E> Iterable<E> postorder(BinaryTree<E> tree) {
                // TODO: recorrido postorden.
                throw new UnsupportedOperationException("TODO: postorder");
            }

            public static <E> boolean areIdentical(BinaryTree<E> t1, BinaryTree<E> t2) {
                // TODO: comparar estructura y elementos.
                throw new UnsupportedOperationException("TODO: areIdentical");
            }

            public static <E> boolean isSymmetric(BinaryTree<E> tree) {
                // TODO: comparar subárbol izquierdo y derecho en espejo.
                throw new UnsupportedOperationException("TODO: isSymmetric");
            }

            public static <E> boolean isPerfect(BinaryTree<E> tree) {
                // TODO: comprobar que todos los niveles están completos.
                throw new UnsupportedOperationException("TODO: isPerfect");
            }

            public static <E> int width(BinaryTree<E> tree) {
                // TODO: devolver máximo número de nodos en un nivel.
                throw new UnsupportedOperationException("TODO: width");
            }

            public static <E> boolean isAlmostComplete(BinaryTree<E> tree) {
                // TODO: comprobar casi completitud con recorrido por niveles.
                throw new UnsupportedOperationException("TODO: isAlmostComplete");
            }

            public static <E> boolean isHeap(BinaryTree<E> tree, Comparator<E> comparator) {
                // TODO: casi completo + propiedad de prioridad.
                throw new UnsupportedOperationException("TODO: isHeap");
            }

            public static <E> boolean cumplePropiedadesMonticulo(BinaryTree<E> tree, Comparator<E> comparator) {
                // TODO: variante estilo examen enero.
                throw new UnsupportedOperationException("TODO: cumplePropiedadesMonticulo");
            }

            public static <E> int diameter(BinaryTree<E> tree) {
                // TODO: longitud del camino más largo entre dos nodos.
                throw new UnsupportedOperationException("TODO: diameter");
            }
        }
    """)

    write(main / "ManualGraphWarmup.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import java.util.HashMap;
        import java.util.HashSet;

        public class ManualGraphWarmup {

            private final HashMap<String, HashSet<String>> adj = new HashMap<>();

            public void addVertex(String id) {
                // TODO: añadir vértice si no existe.
                throw new UnsupportedOperationException("TODO: addVertex");
            }

            public void addEdge(String a, String b) {
                // TODO: crear arista no dirigida usando HashMap + HashSet.
                throw new UnsupportedOperationException("TODO: addEdge");
            }

            public HashSet<String> dfsReachable(String origin) {
                // TODO: devolver alcanzables con DFS.
                throw new UnsupportedOperationException("TODO: dfsReachable");
            }

            public boolean existsPathDFS(String origin, String destination) {
                // TODO: comprobar camino cualquiera.
                throw new UnsupportedOperationException("TODO: existsPathDFS");
            }

            public HashSet<String> bfs(String origin) {
                // TODO: recorrido BFS.
                throw new UnsupportedOperationException("TODO: bfs");
            }

            public int distance(String origin, String destination) {
                // TODO: distancia mínima con BFS; -1 si no hay camino.
                throw new UnsupportedOperationException("TODO: distance");
            }

            public boolean existsPathLessOrEqual(String origin, String destination, int n) {
                // TODO: camino de longitud <= n.
                throw new UnsupportedOperationException("TODO: existsPathLessOrEqual");
            }

            public int connectedComponents() {
                // TODO: contar componentes conexas.
                throw new UnsupportedOperationException("TODO: connectedComponents");
            }

            public boolean isConnected() {
                // TODO: comprobar si hay una sola componente.
                throw new UnsupportedOperationException("TODO: isConnected");
            }

            public ManualGraphWarmup complementary() {
                // TODO: construir complementario.
                throw new UnsupportedOperationException("TODO: complementary");
            }
        }
    """)

    write(main / "AssignmentGraphWarmup.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;

        public class AssignmentGraphWarmup {

            public static <V, E> boolean existeCaminoDeLongitudMenorOIgualAN(AdjacencyMapGraph<V, E> graph, Vertex<V> origin, Vertex<V> destination, int n) {
                // TODO: BFS limitado usando incidentEdges/opposite.
                throw new UnsupportedOperationException("TODO: existeCaminoDeLongitudMenorOIgualAN");
            }

            public static <V, E> int connectedComponents(AdjacencyMapGraph<V, E> graph) {
                // TODO: repetir BFS/DFS desde no visitados.
                throw new UnsupportedOperationException("TODO: connectedComponents");
            }

            public static <V, E> AdjacencyMapGraph<V, E> complementary(AdjacencyMapGraph<V, E> graph) {
                // TODO: crear grafo complementario.
                throw new UnsupportedOperationException("TODO: complementary");
            }

            public static <V, E> AdjacencyMapGraph<V, E> kPower(AdjacencyMapGraph<V, E> graph, int k) {
                // TODO: grafo potencia mediante BFS por vértice.
                throw new UnsupportedOperationException("TODO: kPower");
            }

            public static <V, E> int diameter(AdjacencyMapGraph<V, E> graph) {
                // TODO: BFS desde cada vértice.
                throw new UnsupportedOperationException("TODO: diameter");
            }

            public static <V, E> Vertex<V> centralVertex(AdjacencyMapGraph<V, E> graph) {
                // TODO: vértice con menor excentricidad.
                throw new UnsupportedOperationException("TODO: centralVertex");
            }
        }
    """)

    write(main / "CNPWarmup.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import java.time.LocalDate;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class CNPWarmup {

            private final HashMap<String, Opositor> opositoresPorDni = new HashMap<>();
            private final HashMap<String, HashSet<String>> opositoresPorProvincia = new HashMap<>();
            private final TreeSet<Opositor> rankingPorNota = new TreeSet<>();
            private final TreeMap<Double, HashSet<String>> opositoresPorNota = new TreeMap<>();

            public record Opositor(String dni, String nombre, String provincia, double nota, LocalDate fecha) implements Comparable<Opositor> {
                @Override
                public int compareTo(Opositor other) {
                    int cmp = Double.compare(other.nota, this.nota);
                    if (cmp != 0) {
                        return cmp;
                    }
                    return this.dni.compareTo(other.dni);
                }
            }

            public void addOpositor(Opositor opositor) {
                // TODO: alta sin duplicados y actualización de índices.
                throw new UnsupportedOperationException("TODO: addOpositor");
            }

            public void removeOpositor(String dni) {
                // TODO: borrar de todos los índices.
                throw new UnsupportedOperationException("TODO: removeOpositor");
            }

            public void actualizarNota(String dni, double nota) {
                // TODO: quitar y reinsertar en TreeSet/TreeMap.
                throw new UnsupportedOperationException("TODO: actualizarNota");
            }

            public Iterable<Opositor> topN(int n) {
                // TODO: devolver mejores n opositores.
                throw new UnsupportedOperationException("TODO: topN");
            }

            public Iterable<Opositor> opositoresEntreNotas(double min, double max) {
                // TODO: consulta por rango usando TreeMap.
                throw new UnsupportedOperationException("TODO: opositoresEntreNotas");
            }

            public Iterable<Opositor> aptosPorProvincia(String provincia) {
                // TODO: filtrar por provincia y nota de aprobado.
                throw new UnsupportedOperationException("TODO: aptosPorProvincia");
            }
        }
    """)

    case_classes = {
        "RouterWarmup": "URJCNetServices con routers y TTL",
        "CNIWarmup": "CNI contactos indirectos con BFS limitado",
        "P2PWarmup": "Red P2P con búsqueda por TTL",
        "FlightsWarmup": "URJCFlights con grafo dirigido y escalas",
        "RankingWarmup": "Ranking con TreeSet y comparadores",
        "HospitalWarmup": "Hospital/triaje con PriorityQueue",
        "HypergraphMapsWarmup": "Hipergrafo con dos índices cruzados",
    }
    for class_name, title in case_classes.items():
        write(main / f"{class_name}.java", f"""
            package es.urjc.grafo.EDA.examen.ruta;

            import java.time.LocalDateTime;
            import java.util.HashMap;
            import java.util.HashSet;
            import java.util.PriorityQueue;
            import java.util.TreeMap;
            import java.util.TreeSet;

            public class {class_name} {{

                private final HashMap<String, Elemento> elementos = new HashMap<>();
                private final HashMap<String, HashSet<String>> relaciones = new HashMap<>();
                private final HashMap<String, HashSet<String>> indiceSecundario = new HashMap<>();
                private final TreeMap<LocalDateTime, HashSet<String>> porFecha = new TreeMap<>();
                private final TreeSet<Elemento> ranking = new TreeSet<>();
                private final PriorityQueue<Elemento> prioridad = new PriorityQueue<>();

                public record Elemento(String id, String nombre, int prioridad, LocalDateTime fecha) implements Comparable<Elemento> {{
                    @Override
                    public int compareTo(Elemento other) {{
                        int cmp = Integer.compare(other.prioridad, this.prioridad);
                        if (cmp != 0) {{
                            return cmp;
                        }}
                        return this.id.compareTo(other.id);
                    }}
                }}

                public void addElemento(Elemento elemento) {{
                    // TODO: alta sin duplicados y actualización de índices necesarios.
                    throw new UnsupportedOperationException("TODO: addElemento - {title}");
                }}

                public void addRelacion(String a, String b) {{
                    // TODO: añadir relación dirigida/no dirigida según el caso.
                    throw new UnsupportedOperationException("TODO: addRelacion - {title}");
                }}

                public boolean conectadoConLimite(String origen, String destino, int limite) {{
                    // TODO: BFS manual sobre HashMap<String, HashSet<String>>.
                    throw new UnsupportedOperationException("TODO: conectadoConLimite - {title}");
                }}

                public Iterable<Elemento> topN(int n) {{
                    // TODO: devolver ranking usando TreeSet/PriorityQueue según proceda.
                    throw new UnsupportedOperationException("TODO: topN - {title}");
                }}
            }}
        """)

    write_tests(test)
    write(project / "README.md", """
        # Proyecto ruta recomendada

        Proyecto Maven con la estructura del profesor:

        - `src/main/java/es/urjc/grafo/EDA`
        - clases del ejercicio en `src/main/java/es/urjc/grafo/EDA/examen/ruta`
        - tests en `src/test/java/es/urjc/grafo/EDA/examen/ruta`

        No contiene soluciones. Los tests están preparados para fallar hasta que completes los TODO.
    """)


def write_tests(test: Path) -> None:
    write(test / "GeneralTreeWarmupTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertEquals;

        class GeneralTreeWarmupTest {
            @Test
            void countNodesYLeavesDebenImplementarse() {
                LinkedTree<String> tree = new LinkedTree<>();
                Position<String> root = tree.addRoot("A");
                tree.add("B", root);
                tree.add("C", root);
                assertEquals(3, GeneralTreeWarmup.countNodes(tree));
                assertEquals(2, GeneralTreeWarmup.countLeaves(tree));
            }
        }
    """)
    write(test / "BinaryTreeWarmupTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertTrue;

        class BinaryTreeWarmupTest {
            @Test
            void areIdenticalDebeImplementarse() {
                LinkedBinaryTree<Integer> a = new LinkedBinaryTree<>();
                Position<Integer> rootA = a.addRoot(1);
                a.insertLeft(rootA, 2);

                LinkedBinaryTree<Integer> b = new LinkedBinaryTree<>();
                Position<Integer> rootB = b.addRoot(1);
                b.insertLeft(rootB, 2);

                assertTrue(BinaryTreeWarmup.areIdentical(a, b));
            }
        }
    """)
    write(test / "ManualGraphWarmupTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertTrue;

        class ManualGraphWarmupTest {
            @Test
            void existsPathLessOrEqualDebeImplementarse() {
                ManualGraphWarmup graph = new ManualGraphWarmup();
                graph.addVertex("A");
                graph.addVertex("B");
                graph.addEdge("A", "B");
                assertTrue(graph.existsPathLessOrEqual("A", "B", 1));
            }
        }
    """)
    write(test / "AssignmentGraphWarmupTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.assertTrue;

        class AssignmentGraphWarmupTest {
            @Test
            void existeCaminoDebeImplementarse() {
                AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
                Vertex<String> a = graph.insertVertex("A");
                Vertex<String> b = graph.insertVertex("B");
                graph.insertEdge(a, b, 1);
                assertTrue(AssignmentGraphWarmup.existeCaminoDeLongitudMenorOIgualAN(graph, a, b, 1));
            }
        }
    """)
    write(test / "CNPWarmupTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import org.junit.jupiter.api.Test;

        import java.time.LocalDate;

        import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

        class CNPWarmupTest {
            @Test
            void addOpositorDebeImplementarse() {
                CNPWarmup cnp = new CNPWarmup();
                CNPWarmup.Opositor opositor = new CNPWarmup.Opositor("123", "Ana", "Madrid", 7.5, LocalDate.now());
                assertDoesNotThrow(() -> cnp.addOpositor(opositor));
            }
        }
    """)
    write(test / "CasesWarmupTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import org.junit.jupiter.api.Test;

        import java.time.LocalDateTime;

        import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

        class CasesWarmupTest {
            @Test
            void routerWarmupDebeImplementarse() {
                RouterWarmup routers = new RouterWarmup();
                RouterWarmup.Elemento elemento = new RouterWarmup.Elemento("R1", "Router 1", 1, LocalDateTime.now());
                assertDoesNotThrow(() -> routers.addElemento(elemento));
            }
        }
    """)
    write(test / "GeneralTreeWarmupExtraTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class GeneralTreeWarmupExtraTest {
            private LinkedTree<String> sampleTree() {
                LinkedTree<String> tree = new LinkedTree<>();
                Position<String> root = tree.addRoot("A");
                Position<String> b = tree.add("B", root);
                tree.add("C", root);
                tree.add("D", b);
                return tree;
            }

            @Test void heightDebeImplementarse() {
                assertEquals(2, GeneralTreeWarmup.height(sampleTree()));
            }

            @Test void treeDegreeDebeImplementarse() {
                assertEquals(2, GeneralTreeWarmup.treeDegree(sampleTree()));
            }

            @Test void descendantsNumberDebeImplementarse() {
                LinkedTree<String> tree = sampleTree();
                assertEquals(3, GeneralTreeWarmup.descendantsNumber(tree, tree.root()));
            }

            @Test void nodesAtDepthDebeImplementarse() {
                assertNotNull(GeneralTreeWarmup.nodesAtDepth(sampleTree(), 1));
            }

            @Test void isPerfectDebeImplementarse() {
                assertFalse(GeneralTreeWarmup.isPerfect(sampleTree()));
            }

            @Test void internalNodeIteratorDebeImplementarse() {
                InternalNodeIterator<String> iterator = new InternalNodeIterator<>(sampleTree());
                assertTrue(iterator.hasNext());
            }
        }
    """)
    write(test / "BinaryTreeWarmupExtraTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
        import es.urjc.grafo.EDA.utils.Position;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class BinaryTreeWarmupExtraTest {
            private LinkedBinaryTree<Integer> sampleTree() {
                LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
                Position<Integer> root = tree.addRoot(1);
                tree.insertLeft(root, 2);
                tree.insertRight(root, 2);
                return tree;
            }

            @Test void heightDebeImplementarse() {
                assertEquals(1, BinaryTreeWarmup.height(sampleTree()));
            }

            @Test void countNodesDebeImplementarse() {
                assertEquals(3, BinaryTreeWarmup.countNodes(sampleTree()));
            }

            @Test void recorridosDebenImplementarse() {
                assertNotNull(BinaryTreeWarmup.inorder(sampleTree()));
                assertNotNull(BinaryTreeWarmup.preorder(sampleTree()));
                assertNotNull(BinaryTreeWarmup.postorder(sampleTree()));
            }

            @Test void propiedadesEstructuralesDebenImplementarse() {
                LinkedBinaryTree<Integer> tree = sampleTree();
                assertTrue(BinaryTreeWarmup.isSymmetric(tree));
                assertTrue(BinaryTreeWarmup.isPerfect(tree));
                assertEquals(2, BinaryTreeWarmup.width(tree));
                assertTrue(BinaryTreeWarmup.isAlmostComplete(tree));
            }

            @Test void monticuloYDiametroDebenImplementarse() {
                LinkedBinaryTree<Integer> tree = sampleTree();
                assertTrue(BinaryTreeWarmup.isHeap(tree, Integer::compareTo));
                assertTrue(BinaryTreeWarmup.cumplePropiedadesMonticulo(tree, Integer::compareTo));
                assertEquals(2, BinaryTreeWarmup.diameter(tree));
            }
        }
    """)
    write(test / "ManualGraphWarmupExtraTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class ManualGraphWarmupExtraTest {
            private ManualGraphWarmup sampleGraph() {
                ManualGraphWarmup graph = new ManualGraphWarmup();
                graph.addVertex("A");
                graph.addVertex("B");
                graph.addVertex("C");
                graph.addEdge("A", "B");
                graph.addEdge("B", "C");
                return graph;
            }

            @Test void dfsYBfsDebenImplementarse() {
                ManualGraphWarmup graph = sampleGraph();
                assertTrue(graph.dfsReachable("A").contains("C"));
                assertTrue(graph.bfs("A").contains("C"));
            }

            @Test void distanciasDebenImplementarse() {
                ManualGraphWarmup graph = sampleGraph();
                assertTrue(graph.existsPathDFS("A", "C"));
                assertEquals(2, graph.distance("A", "C"));
            }

            @Test void componentesYComplementarioDebenImplementarse() {
                ManualGraphWarmup graph = sampleGraph();
                assertEquals(1, graph.connectedComponents());
                assertTrue(graph.isConnected());
                assertNotNull(graph.complementary());
            }
        }
    """)
    write(test / "AssignmentGraphWarmupExtraTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
        import es.urjc.grafo.EDA.graphs.Vertex;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

        class AssignmentGraphWarmupExtraTest {
            private AdjacencyMapGraph<String, Integer> sampleGraph() {
                AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
                Vertex<String> a = graph.insertVertex("A");
                Vertex<String> b = graph.insertVertex("B");
                Vertex<String> c = graph.insertVertex("C");
                graph.insertEdge(a, b, 1);
                graph.insertEdge(b, c, 1);
                return graph;
            }

            @Test void operacionesBaseDebenImplementarse() {
                AdjacencyMapGraph<String, Integer> graph = sampleGraph();
                assertEquals(1, AssignmentGraphWarmup.connectedComponents(graph));
                assertNotNull(AssignmentGraphWarmup.complementary(graph));
            }

            @Test void operacionesAvanzadasDebenImplementarse() {
                AdjacencyMapGraph<String, Integer> graph = sampleGraph();
                assertNotNull(AssignmentGraphWarmup.kPower(graph, 2));
                assertEquals(2, AssignmentGraphWarmup.diameter(graph));
                assertNotNull(AssignmentGraphWarmup.centralVertex(graph));
            }
        }
    """)
    write(test / "CNPWarmupExtraTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import org.junit.jupiter.api.Test;

        import java.time.LocalDate;

        import static org.junit.jupiter.api.Assertions.*;

        class CNPWarmupExtraTest {
            private CNPWarmup.Opositor opositor() {
                return new CNPWarmup.Opositor("123", "Ana", "Madrid", 7.5, LocalDate.now());
            }

            @Test void rankingYRangosDebenImplementarse() {
                CNPWarmup cnp = new CNPWarmup();
                cnp.addOpositor(opositor());
                cnp.actualizarNota("123", 8.0);
                assertNotNull(cnp.topN(1));
                assertNotNull(cnp.opositoresEntreNotas(5.0, 10.0));
                assertNotNull(cnp.aptosPorProvincia("Madrid"));
            }

            @Test void removeDebeImplementarse() {
                CNPWarmup cnp = new CNPWarmup();
                cnp.addOpositor(opositor());
                assertDoesNotThrow(() -> cnp.removeOpositor("123"));
            }
        }
    """)
    write(test / "CasesWarmupExtraTest.java", """
        package es.urjc.grafo.EDA.examen.ruta;

        import org.junit.jupiter.api.Test;

        import java.time.LocalDateTime;

        import static org.junit.jupiter.api.Assertions.*;

        class CasesWarmupExtraTest {
            @Test void routerCniP2PDebenImplementarse() {
                RouterWarmup.Elemento r = new RouterWarmup.Elemento("A", "A", 1, LocalDateTime.now());
                RouterWarmup router = new RouterWarmup();
                router.addElemento(r);
                router.addRelacion("A", "B");
                assertTrue(router.conectadoConLimite("A", "B", 1));

                CNIWarmup cni = new CNIWarmup();
                cni.addElemento(new CNIWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
                assertNotNull(cni.topN(1));

                P2PWarmup p2p = new P2PWarmup();
                p2p.addElemento(new P2PWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
                assertNotNull(p2p.topN(1));
            }

            @Test void flightsRankingHospitalHipergrafoDebenImplementarse() {
                FlightsWarmup flights = new FlightsWarmup();
                flights.addElemento(new FlightsWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
                assertNotNull(flights.topN(1));

                RankingWarmup ranking = new RankingWarmup();
                ranking.addElemento(new RankingWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
                assertNotNull(ranking.topN(1));

                HospitalWarmup hospital = new HospitalWarmup();
                hospital.addElemento(new HospitalWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
                assertNotNull(hospital.topN(1));

                HypergraphMapsWarmup hyper = new HypergraphMapsWarmup();
                hyper.addElemento(new HypergraphMapsWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
                assertNotNull(hyper.topN(1));
            }
        }
    """)


def main() -> None:
    if OUT.exists():
        shutil.rmtree(OUT)
    OUT.mkdir(parents=True)
    build_docs()
    build_project()


if __name__ == "__main__":
    main()
