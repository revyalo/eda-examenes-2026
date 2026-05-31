# GeneralTreeZigZagIterator

## Enunciado

Implementa un iterador zigzag sobre arbol general. El recorrido se hace por niveles: el nivel 0 se devuelve de izquierda a derecha, el nivel 1 de derecha a izquierda, el nivel 2 de izquierda a derecha, y asi sucesivamente.

## Reglas

- El constructor recibe un `Tree<E>`.
- Si el arbol esta vacio, el iterador no tiene elementos.
- `next()` debe lanzar `NoSuchElementException` si no quedan elementos.
- No hay `remove()` obligatorio.

## Ejecutar

```bash
mvn test
```
