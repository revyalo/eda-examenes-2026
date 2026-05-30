# URJCNetServices limpio: routers, mensajes y TTL

## Objetivo

Grafo manual con routers, mensajes por fecha y consultas por distancia.

## Que esta ya dado

- `Router`: clase entidad simple.
- `Mensaje`: clase entidad simple.
- `URJCNetServicesLimpio`: clase gestora vacia, con constructor y metodos `TODO`.
- Tests completos en `src/test/java`.

## Que debes hacer tu

1. Declarar los atributos privados que necesites.
2. Inicializarlos en el constructor.
3. Implementar los metodos publicos sin cambiar firmas.
4. Elegir tus propias estructuras internas, sin que el esqueleto imponga una solucion.

## Pistas

- Necesitas buscar routers por id.
- Necesitas representar conexiones no dirigidas entre routers.
- Necesitas guardar mensajes y filtrar por fecha.
- Puedes usar las estructuras permitidas por la asignatura si te ayudan, pero no hay atributos ya creados.

## Ejecutar

```bash
mvn test
```

No hay soluciones incluidas.
