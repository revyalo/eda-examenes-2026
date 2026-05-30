# Registro CNP limpio: opositores, ranking y rangos

## Objetivo

Gestionar opositores por DNI, provincia, nota media y ranking.

## Que esta ya dado

- `Opositor`: clase entidad simple.
- `Notas`: clase entidad simple con metodo `media()`.
- `RegistroCNPLimpio`: clase gestora vacia, con constructor y metodos `TODO`.
- Tests completos en `src/test/java`.

## Que debes hacer tu

1. Declarar los atributos privados que necesites.
2. Inicializarlos en el constructor.
3. Implementar los metodos publicos sin cambiar firmas.
4. Mantener coherentes tus atributos cuando cambien las notas.

## Pistas

- Necesitas evitar DNIs duplicados.
- Necesitas obtener opositores por provincia.
- Necesitas consultar rangos de nota y un top ordenado.
- El esqueleto no trae estructuras internas ya declaradas.

## Ejecutar

```bash
mvn test
```

No hay soluciones incluidas.
