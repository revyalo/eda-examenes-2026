# Arbol general: podar subarboles pequenos

## Enunciado

Implementa `removeSubtreesSmallerThan` en `GeneralTreePruneOperations`.

El metodo elimina todos los subarboles propios cuyo tamano sea menor que `k`. El tamano de un subarbol es su numero de nodos. Si se elimina un subarbol, no se evaluan sus descendientes por separado.

## Reglas

- Si el arbol es `null` o `k < 1`, lanza `IllegalArgumentException`.
- La raiz nunca se elimina, aunque su subarbol tenga tamano menor que `k`.
- Devuelve el numero total de nodos eliminados.
- Usa `NAryTree.remove` cuando toque borrar.

## Ejecutar

```bash
mvn test
```
