# Practica extra 2026: 10 ejercicios de implementacion

Proyecto nuevo dentro de `IMPLEMENTACION`, inspirado en el formato del examen practico de enero/diciembre: firmas cerradas, metodos estaticos, estructuras de grafos/arboles del entorno y tests JUnit.

No hay soluciones incluidas. Los metodos principales lanzan `UnsupportedOperationException` hasta que los completes.

## Normas

- No cambies las firmas publicas.
- No anadas metodos o atributos publicos.
- Puedes anadir metodos privados auxiliares.
- Si necesitas estructuras auxiliares, usalas solo como apoyo del algoritmo.
- Respeta `Position`, `Vertex`, `Edge`, `AdjacencyMapGraph`, `LinkedBinaryTree` y `LinkedTree`.

## Ejercicios

### 1. `shortestDistanceLessOrEqual`

Dado un grafo no dirigido no ponderado, un vertice origen, un vertice destino y un limite `n`, devuelve la distancia minima entre ambos vertices si dicha distancia es menor o igual que `n`. Si no hay camino o el camino minimo supera `n`, devuelve `-1`. Debe resolverse con un recorrido por niveles.

### 2. `verticesAtDistanceK`

Devuelve todos los vertices que estan exactamente a distancia `k` desde un vertice inicial. El origen esta a distancia `0`. No deben aparecer vertices repetidos.

### 3. `connectedComponents`

Devuelve el numero de componentes conexas de un grafo no dirigido. Un grafo vacio tiene `0` componentes.

### 4. `graphDiameter`

Calcula el diametro de un grafo no dirigido conexo: la mayor distancia minima entre dos vertices. Si el grafo no es conexo, devuelve `-1`.

### 5. `isBipartite`

Comprueba si un grafo no dirigido es bipartito usando un coloreado por niveles. Un grafo vacio se considera bipartito.

### 6. `countShortestPaths`

Cuenta cuantos caminos minimos distintos existen entre dos vertices. Si no hay camino, devuelve `0`. El conteo debe basarse en BFS y no en enumerar todos los caminos posibles.

### 7. `isAlmostComplete`

Comprueba si un arbol binario es casi completo: todos los niveles salvo quizas el ultimo estan completos, y los nodos del ultimo nivel aparecen lo mas a la izquierda posible.

### 8. `lowestCommonAncestor`

Dado un arbol binario y dos posiciones del arbol, devuelve la posicion del ancestro comun mas bajo.

### 9. `width`

Devuelve la anchura maxima de un arbol general: el mayor numero de nodos que aparecen en un mismo nivel.

### 10. `descendantsAtDistanceK`

Desde una posicion de un arbol general, devuelve todos sus descendientes que estan exactamente a distancia `k`. Para `k = 0`, debe devolverse la propia posicion.

## Ejecutar

```bash
mvn test
```

Al principio los tests fallan por los TODO. Eso es lo esperado.
