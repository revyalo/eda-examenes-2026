# Grafos: ciclo mas corto

## Enunciado

Implementa `shortestCycleLength` en `GraphCycleOperations`.

Dado un grafo no dirigido, simple y sin bucles, devuelve la longitud del ciclo simple mas corto. La longitud de un ciclo es el numero de aristas que contiene. Si el grafo no tiene ciclos, devuelve `-1`.

## Reglas

- Si el grafo es `null`, lanza `IllegalArgumentException`.
- Si el grafo esta vacio o es aciclico, devuelve `-1`.
- No debes enumerar todos los caminos simples.
- La estrategia esperada es adaptar BFS desde cada vertice, evitando confundir la arista por la que se llega con un ciclo.

## Ejecutar

```bash
mvn test
```
