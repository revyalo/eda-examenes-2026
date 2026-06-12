# Refuerzo Tree general

Estos ejercicios estan en `arboles/arboles_generales_avanzados/GeneralTreeAdvancedOperations.java`.

## Metodos nuevos

- `pathBetween(tree, first, second)`: devuelve el camino completo desde `first` hasta `second`, incluyendo ambos extremos y pasando por el ancestro comun mas bajo.
- `removeLeaves(tree)`: elimina todas las hojas actuales del arbol general y devuelve cuantas se han eliminado. Solo se eliminan las hojas que lo eran al empezar la operacion.
- `copySubtree(tree, root)`: crea una copia independiente del subarbol cuya raiz es `root`, manteniendo forma y elementos.
- `rootToLeafPaths(tree)`: devuelve todos los caminos desde la raiz hasta cada hoja.
- `removeSubtree(tree, root)`: elimina el subarbol completo cuya raiz es `root` y devuelve cuantos nodos se han eliminado.
- `subtreeWithMostNodes(tree, root)`: devuelve la raiz del mayor subarbol propio contenido bajo `root`; si `root` no tiene descendientes, devuelve `null`.
- `sameShapeIgnoringChildrenOrder(first, second)`: comprueba si dos arboles tienen la misma forma aunque los hijos equivalentes aparezcan en distinto orden.

## Pistas

- `pathBetween` se puede resolver combinando caminos a la raiz o usando `lowestCommonAncestor`.
- Para `removeLeaves`, primero localiza las hojas y despues borralas; si borras mientras recorres, puedes convertir nodos internos en hojas antes de tiempo.
- Para `copySubtree`, crea un arbol nuevo y copia hijos de forma recursiva.
- `rootToLeafPaths` es un ejercicio de backtracking: anade al bajar y retira al volver.
- `sameShapeIgnoringChildrenOrder` es mas dificil que `isIsomorphic`, porque tienes que emparejar hijos por forma, no por posicion.
