# PostorderRemoveIterator

## Enunciado

Implementa un iterador en postorden para arbol binario con `remove()`.

El recorrido postorden visita primero hijo izquierdo, despues hijo derecho y por ultimo el nodo. El metodo `remove()` debe eliminar el ultimo nodo devuelto por `next()` cuando sea legal segun `LinkedBinaryTree.remove`: el nodo debe tener cero o un hijo. Despues de eliminar, el iterador debe conservar un estado coherente.

## Reglas

- `next()` debe lanzar `NoSuchElementException` si no quedan elementos.
- `remove()` debe lanzar `IllegalStateException` si se llama antes de `next()` o dos veces seguidas sobre el mismo elemento.
- No cambies firmas publicas.
- Puedes anadir atributos y metodos privados.

## Ejecutar

```bash
mvn test
```
