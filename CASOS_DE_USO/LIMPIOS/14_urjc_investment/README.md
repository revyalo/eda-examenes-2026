# URJC Investment

Caso de uso inspirado en el examen sobre la Torre Europa.

Debes completar `URJCInvest` y `OrganizationChart`. Las clases de dominio ya existen para que el proyecto compile, pero la eleccion de estructuras internas queda para ti.

## Reglas

- Cada empresa tiene un unico CEO.
- Cada trabajador depende de un unico jefe directo, salvo el CEO.
- Los nombres de trabajadores son unicos.
- Un trabajador no puede estar en mas de una empresa.
- `searchCompany` debe permitir localizar rapido el organigrama de una empresa.
- `getGrantHolders` devuelve los empleados de minima responsabilidad, es decir, los que no son jefes de nadie.

## Metodos principales

- `insertEmployee(String company, String employeeName, String position, String bossName)`
- `searchCompany(String company)`
- `OrganizationChart.getGrantHolders()`

```bash
mvn test
```
