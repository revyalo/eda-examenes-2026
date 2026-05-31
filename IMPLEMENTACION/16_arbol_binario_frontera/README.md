# Arbol binario: frontera exterior

## Enunciado

Implementa `boundaryTraversal` en `BinaryTreeBoundaryOperations`.

Devuelve los elementos de la frontera exterior del arbol binario: raiz, borde izquierdo sin hojas, hojas de izquierda a derecha y borde derecho sin hojas en orden inverso. No debe haber elementos repetidos.

## Reglas

- Si el arbol es `null`, lanza `IllegalArgumentException`.
- Si esta vacio, devuelve una lista vacia.
- Un arbol con solo raiz devuelve solo la raiz.
- No desencapsules nodos internos: usa la interfaz `BinaryTree` y `Position`.

## Ejecutar

```bash
mvn test
```
