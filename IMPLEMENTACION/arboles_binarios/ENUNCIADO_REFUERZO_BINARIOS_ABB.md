# Refuerzo arboles binarios y ABB

Estos ejercicios refuerzan dos zonas: recorridos/vecindad en arbol binario y operaciones clasicas de arbol binario de busqueda.

## `metricas_y_recorridos_binarios/BinaryTreeTraversalOperations.java`

- `nodesAtDistanceK(tree, target, k)`: devuelve todos los nodos que estan exactamente a distancia `k` de `target`. La distancia puede subir al padre y bajar por hijos.

## `abb_avl_serializacion_sumas/BinarySearchTreeValidationOperations.java`

- `floor(tree, key, comparator)`: mayor clave menor o igual que `key`.
- `ceiling(tree, key, comparator)`: menor clave mayor o igual que `key`.
- `predecessor(tree, key, comparator)`: mayor clave estrictamente menor que `key`.
- `successor(tree, key, comparator)`: menor clave estrictamente mayor que `key`.
- `removeRange(tree, min, max, comparator)`: elimina las claves en el rango `[min, max]` y las devuelve en orden creciente.

## Pistas

- `floor`, `ceiling`, `predecessor` y `successor` se pueden hacer bajando desde la raiz y guardando el mejor candidato visto.
- `removeRange` conviene plantearlo en dos fases: localizar/ordenar las claves a borrar y despues modificar el arbol sin romper la propiedad ABB.
- `nodesAtDistanceK` suele resolverse mejor si puedes moverte en tres direcciones: izquierda, derecha y padre, controlando visitados.
