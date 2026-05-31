# FunHandling.esPrefijo

Ejercicio inspirado en el enunciado donde se pregunta si un arbol binario `a1` es prefijo de otro arbol binario `a2`.

Debes completar `FunHandling.esPrefijo(a1, a2)`.

Un arbol `a1` es prefijo de `a2` si la parte inicial de `a2` coincide con `a1` en contenido y forma:

- la raiz coincide,
- cada hijo existente en `a1` existe en la misma posicion en `a2`,
- los elementos son iguales,
- `a2` puede tener mas descendientes a partir de las hojas de `a1`.

No modifiques la cabecera publica.

```bash
mvn test
```
