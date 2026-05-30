# Red P2P limpia: nodos, conexiones y archivos

## Objetivo

Gestionar nodos P2P, conexiones y busqueda de archivos con TTL.

## Que esta ya dado

- `Nodo`: clase entidad simple.
- `RedP2PLimpia`: clase gestora vacia, con constructor y metodos `TODO`.
- Tests completos en `src/test/java`.

## Que debes hacer tu

1. Declarar los atributos privados que necesites.
2. Inicializarlos en el constructor.
3. Implementar los metodos publicos sin cambiar firmas.
4. Mantener consistencia al apagar un nodo.

## Pistas

- Necesitas buscar nodos por id.
- Necesitas representar conexiones no dirigidas.
- Necesitas saber que archivos tiene cada nodo.
- `buscarArchivo` se resuelve con una busqueda limitada por TTL.
- El esqueleto no trae estructuras internas ya declaradas.

## Ejecutar

```bash
mvn test
```

No hay soluciones incluidas.
