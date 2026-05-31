# AdditionalFeatures de grafos

Ejercicio inspirado en el enunciado de grafos de las capturas.

Debes completar la clase `AdditionalFeatures`, en el paquete `es.urjc.grafo.EDA.examen.grafos`, sin modificar las cabeceras publicas.

## Metodos

- `isTree(AdjacencyMapGraph<V, E> g)`: devuelve `true` si el grafo no dirigido es un arbol. Un grafo es arbol si es conexo y tiene exactamente `n - 1` aristas. Si el grafo es `null` o esta vacio, devuelve `true`.
- `sourceVertex(DirectedGraph<V, E> d)`: devuelve todos los vertices fuente de un grafo dirigido. Un vertice fuente solo tiene aristas de salida y debe tener al menos una.
- `isComplete(AdjacencyMapGraph<V, E> g)`: devuelve `true` si existe una arista entre cada par de vertices. Si el grafo es `null` o esta vacio, devuelve `false`.

## Tests

Ejecuta:

```bash
mvn test
```

Los tests comprueban grafos vacios, arboles, grafos no conexos, vertices fuente y grafos completos.
