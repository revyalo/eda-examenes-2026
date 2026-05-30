# CNI limpio: contactos indirectos

## Objetivo

Gestionar agentes y contactos directos para consultar cadenas indirectas.

## Que esta ya dado

- `Agente`: clase entidad simple.
- `Contacto`: clase entidad simple con las dos personas, fecha y minutos.
- `CNIContactosLimpio`: clase gestora vacia, con constructor y metodos `TODO`.
- Tests completos en `src/test/java`.

## Que debes hacer tu

1. Declarar los atributos privados que necesites.
2. Inicializarlos en el constructor.
3. Implementar los metodos publicos sin cambiar firmas.
4. Usar `Contacto` como dato de entrada del ejercicio; no hace falta inventar otra clase.

## Pistas

- Necesitas saber que agentes existen.
- Necesitas saber si dos agentes han tenido contacto directo.
- Para `grupoDeRiesgo`, solo cuentan contactos con fecha suficiente y minutos suficientes.
- Para `posibleCadena`, piensa en un recorrido por niveles con limite de saltos.
- El esqueleto no impone ningun `TreeMap` ni ningun indice concreto.

## Ejecutar

```bash
mvn test
```

No hay soluciones incluidas.
