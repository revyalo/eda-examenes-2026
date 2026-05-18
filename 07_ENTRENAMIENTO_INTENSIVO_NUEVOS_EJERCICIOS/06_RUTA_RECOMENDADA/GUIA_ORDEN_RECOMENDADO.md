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
