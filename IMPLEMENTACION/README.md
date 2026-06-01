# Implementacion

La carpeta de implementacion queda unificada en tres proyectos Maven, para que no haya un proyecto distinto por cada PDF o simulacro:

- `grafos`: grafos, hipergrafos, conectividad, ciclos, complementario, potencia y operaciones similares.
- `arboles`: arboles generales y operaciones n-arias.
- `arboles_binarios`: arboles binarios, ABB, monticulos, simetria, prefijo, completitud y operaciones de borrado.

Para practicar, entra en uno de los proyectos y ejecuta:

```bash
mvn test
```

Si solo quieres comprobar que todo compila sin ejecutar los tests pendientes de TODO:

```bash
mvn test -DskipTests
```

Los esqueletos no incluyen soluciones. Los tests estan preparados para fallar hasta que implementes la logica.
