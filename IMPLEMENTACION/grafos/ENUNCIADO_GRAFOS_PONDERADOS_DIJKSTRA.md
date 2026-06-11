# Grafos ponderados - Adaptaciones de Dijkstra

En este bloque se practican variantes de BFS cuando las aristas tienen coste. El grafo usa la clase `AdjacencyMapGraph<V, Integer>` y el peso de cada arista es el `Integer` almacenado en la propia arista.

Los pesos deben ser no negativos. Si aparece un peso negativo, el metodo debe lanzar `IllegalArgumentException`, porque Dijkstra no es valido con pesos negativos.

## Metodos a implementar

- `shortestWeightedDistance(graph, source, target)`: devuelve el coste minimo entre dos vertices. Si no existe camino, devuelve `-1`.
- `shortestWeightedPath(graph, source, target)`: devuelve el camino de coste minimo como lista de vertices desde origen hasta destino. Si no existe camino, devuelve una lista vacia.
- `reachableWithCostAtMost(graph, source, maxCost)`: devuelve los vertices alcanzables desde `source` con coste acumulado menor o igual que `maxCost`. El origen cuenta como alcanzable con coste `0`.
- `kClosestVertices(graph, source, k)`: devuelve los `k` vertices distintos de `source` mas cercanos por coste.
- `nearestTarget(graph, source, targets)`: devuelve el vertice de `targets` que esta mas cerca de `source`.
- `multiSourceShortestDistance(graph, sources, target)`: calcula la distancia minima desde cualquiera de los origenes hasta `target`.
- `weightedEccentricity(graph, vertex)`: devuelve la mayor distancia minima ponderada desde `vertex` hasta cualquier otro vertice.
- `weightedCenter(graph)`: devuelve el vertice con menor excentricidad ponderada.
- `cheapestPathWithMaxEdges(graph, source, target, maxEdges)`: devuelve el camino mas barato entre dos vertices usando como maximo `maxEdges` aristas.
- `shortestPathAvoidingVertex(graph, source, target, forbidden)`: devuelve el camino minimo sin pasar por el vertice `forbidden`.

## Pistas

La plantilla mental es casi la misma que BFS:

```text
BFS:
  Queue<Vertex<V>>
  distancia + 1

Dijkstra:
  PriorityQueue por menor coste acumulado
  distancia + peso de la arista
  mapa de distancias minimas
```

Para reconstruir caminos, guarda un mapa de predecesores y recorre desde el destino hacia el origen al terminar.
