# Indice de iteradores

Los iteradores ya no estan en carpetas sueltas. Ahora se practican desde:

- `ITERADORES/arboles`
- `ITERADORES/arboles_binarios`
- `ITERADORES/grafos`

## Orden recomendado

1. `ITERADORES/arboles`: `LeafIterator`, `SkipLeavesIterator`, `GeneralTreeZigZagIterator`.
2. `ITERADORES/arboles_binarios`: `ReverseInordenBTIterator`, `LevelIterator`, `InordenIteratorWithRemove`.
3. `ITERADORES/arboles_binarios`: variantes mas duras con `remove()`, como `ReverseInordenBTIteratorWithRemove` y `PostorderRemoveIterator`.

Usa el `README.md` de cada proyecto para ver las clases y tests incluidos.
