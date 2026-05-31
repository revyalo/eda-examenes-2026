# Arbol general: diametro

## Enunciado

Implementa `diameter` en `GeneralTreeDiameterOperations`.

El diametro de un arbol general es la mayor distancia entre dos nodos del arbol, medida en numero de aristas.

## Reglas

- Si el arbol es `null`, lanza `IllegalArgumentException`.
- Si el arbol esta vacio o tiene un unico nodo, devuelve `0`.
- Debe funcionar con nodos de cualquier grado.
- La solucion esperada combina alturas y las dos ramas mas profundas de cada nodo.

## Ejecutar

```bash
mvn test
```
