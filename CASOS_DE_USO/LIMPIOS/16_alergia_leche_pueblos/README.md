# Alergia a la leche y pueblos

Caso de uso inspirado en el examen donde se modelan pueblos, carreteras bidireccionales y centros de salud capaces de tratar determinadas marcas de leche.

Debes completar `MilkAllergyMap`.

## Metodos

- `addTown(String name, Collection<String> brands)`: registra un pueblo y las marcas que puede tratar.
- `addRoad(String a, String b)`: crea una carretera bidireccional entre pueblos existentes.
- `milkSafeTown()`: devuelve el pueblo que minimiza el peor numero de saltos necesarios para llegar al centro mas cercano capaz de tratar cada marca conocida.
- `survive(String town, String milkBrand, int maxVisitedTowns)`: devuelve `true` si desde el pueblo indicado se llega a un centro que trate la marca en menos pueblos visitados que el limite.

Tambien se incluye `survive(String town, int maxVisitedTowns)` para practicar la variante del enunciado original si decides almacenar la marca peligrosa dentro de la clase.

```bash
mvn test
```
