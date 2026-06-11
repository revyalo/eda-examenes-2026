# Refuerzo Tree general

Estos ejercicios estan en `arboles/arboles_generales_avanzados/GeneralTreeAdvancedOperations.java`.

## Metodos nuevos

- `pathBetween(tree, first, second)`: devuelve el camino completo desde `first` hasta `second`, incluyendo ambos extremos y pasando por el ancestro comun mas bajo.
- `removeLeaves(tree)`: elimina todas las hojas actuales del arbol general y devuelve cuantas se han eliminado. Solo se eliminan las hojas que lo eran al empezar la operacion.
- `copySubtree(tree, root)`: crea una copia independiente del subarbol cuya raiz es `root`, manteniendo forma y elementos.

## Pistas

- `pathBetween` se puede resolver combinando caminos a la raiz o usando `lowestCommonAncestor`.
- Para `removeLeaves`, primero localiza las hojas y despues borralas; si borras mientras recorres, puedes convertir nodos internos en hojas antes de tiempo.
- Para `copySubtree`, crea un arbol nuevo y copia hijos de forma recursiva.
