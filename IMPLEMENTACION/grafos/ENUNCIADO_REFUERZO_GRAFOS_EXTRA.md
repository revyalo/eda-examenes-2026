# Refuerzo grafos no ponderados

Estos ejercicios estan en `grafos/practica_extra_grafos_2026/GraphExtraOperations.java`.

## Metodos nuevos

- `shortestPathWithForbiddenVertices(graph, start, end, forbidden)`: devuelve un camino minimo desde `start` hasta `end` sin visitar ningun vertice de la coleccion `forbidden`. Si no existe camino valido, devuelve una lista vacia.
- `hasUniqueShortestPath(graph, start, end)`: devuelve `true` si existe exactamente un camino minimo entre `start` y `end`. Si no hay camino, devuelve `false`.
- `graphRadius(graph)`: devuelve el radio del grafo, entendido como la minima excentricidad entre todos los vertices. Si el grafo no es conexo, devuelve `-1`.
- `minimumStopsPath(graph, start, end, maxStops)`: devuelve un camino con el menor numero de aristas entre `start` y `end`, siempre que use como maximo `maxStops` aristas. Si supera el limite, devuelve una lista vacia.

## Pistas

- Todos estos ejercicios se resuelven como pequenas adaptaciones de BFS.
- Para devolver caminos, guarda el predecesor de cada vertice descubierto.
- Para contar caminos minimos o detectar unicidad, no basta con marcar visitado: tambien debes saber a que distancia se alcanzo cada vertice.
- Para el radio, calcula la excentricidad de cada vertice con BFS y quedate con la menor.
