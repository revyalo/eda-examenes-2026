# Synthetic_Intel

Caso de uso inspirado en el enunciado de Synthetic_Intel.

Debes elegir las estructuras internas para representar un organigrama a partir de pares empleado-jefe.

## Objetivos

- `NewBasicED.team(managerId)` debe devolver en coste O(1) los empleados directamente asignados a un jefe.
- `Synthetic_Intel.levelManagers(level)` devuelve todos los managers situados en ese nivel del organigrama.
- `Synthetic_Intel.allMyManagers(employeeId)` devuelve todos los jefes del empleado hasta llegar al CEO. Si el empleado es el CEO, devuelve un iterable vacio.

No modifiques cabeceras publicas. Puedes anadir metodos privados.

```bash
mvn test
```
