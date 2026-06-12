# Refuerzo arboles binarios y ABB

Estos ejercicios refuerzan dos zonas: recorridos/vecindad en arbol binario y operaciones clasicas de arbol binario de busqueda.

## `metricas_y_recorridos_binarios/BinaryTreeTraversalOperations.java`

- `nodesAtDistanceK(tree, target, k)`: devuelve todos los nodos que estan exactamente a distancia `k` de `target`. La distancia puede subir al padre y bajar por hijos.
- `isSubtree(tree, candidate)`: comprueba si `candidate` aparece dentro de `tree` con la misma forma y los mismos valores.
- `pruneBelowDepth(tree, maxDepth)`: elimina todos los nodos situados a profundidad mayor que `maxDepth` y devuelve cuantos se han borrado.

## `abb_avl_serializacion_sumas/BinarySearchTreeValidationOperations.java`

- `floor(tree, key, comparator)`: mayor clave menor o igual que `key`.
- `ceiling(tree, key, comparator)`: menor clave mayor o igual que `key`.
- `predecessor(tree, key, comparator)`: mayor clave estrictamente menor que `key`.
- `successor(tree, key, comparator)`: menor clave estrictamente mayor que `key`.
- `removeRange(tree, min, max, comparator)`: elimina las claves en el rango `[min, max]` y las devuelve en orden creciente.
- `kthSmallest(tree, k)`: devuelve la posicion del k-esimo menor elemento del ABB, considerando `k = 1` como el minimo.
- `trimBST(tree, min, max, comparator)`: poda el ABB eliminando las claves fuera del rango `[min, max]` y devuelve el arbol resultante.

## Pistas

- `floor`, `ceiling`, `predecessor` y `successor` se pueden hacer bajando desde la raiz y guardando el mejor candidato visto.
- `removeRange` conviene plantearlo en dos fases: localizar/ordenar las claves a borrar y despues modificar el arbol sin romper la propiedad ABB.
- `nodesAtDistanceK` suele resolverse mejor si puedes moverte en tres direcciones: izquierda, derecha y padre, controlando visitados.
- `isSubtree` mezcla busqueda de una posible raiz con comparacion recursiva de dos arboles.
- `pruneBelowDepth` es mas seguro si primero localizas las posiciones a eliminar y despues podas.
- `kthSmallest` se apoya en el recorrido inorden del ABB.
