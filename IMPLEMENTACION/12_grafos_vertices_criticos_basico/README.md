# Grafos: vertices que desconectan

## Enunciado

Implementa `verticesQueDesconectan` en `GraphCriticalVerticesOperations`.

Un vertice es critico si al eliminarlo virtualmente aumenta el numero de componentes conexas del grafo. No es necesario borrar realmente el vertice: puedes ignorarlo durante los recorridos.

## Reglas

- Si el grafo es `null`, lanza `IllegalArgumentException`.
- Si tiene 0, 1 o 2 vertices, devuelve una coleccion vacia.
- El orden de salida no es relevante.
- Se permite la version sencilla de examen: repetir BFS/DFS por cada vertice candidato.

## Ejecutar

```bash
mvn test
```
