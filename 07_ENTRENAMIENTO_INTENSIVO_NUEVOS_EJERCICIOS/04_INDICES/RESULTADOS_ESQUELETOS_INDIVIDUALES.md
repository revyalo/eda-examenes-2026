# Resultados de esqueletos individuales y simulacros

Fecha de verificación: 2026-05-18.

## Alcance

- Proyectos individuales de implementación: 70.
- Proyectos individuales de casos de uso: 15.
- Proyectos de exámenes propuestos: 4.
- Total de proyectos Maven: 89.

## Compilación

Se ha ejecutado compilación sin tests sobre todos los esqueletos individuales.

Resultado:

- Implementación: 70 proyectos compilados, 0 errores de compilación.
- Casos de uso: 15 proyectos compilados, 0 errores de compilación.
- Exámenes propuestos: 4 proyectos compilados, 0 errores de compilación.
- Total: 89 proyectos compilados, 0 errores de compilación.

## Tests iniciales

Se han ejecutado los tests con `maven.test.failure.ignore=true` para poder medir todos los fallos iniciales.

Resultado:

- Tests ejecutados en ejercicios individuales: 160.
- Tests ejecutados en exámenes propuestos: 16.
- Tests ejecutados en total: 176.
- Fallos: 42.
- Errores: 134.
- Omitidos: 0.
- Fallos/errores por `TODO` esperado: 176.
- Fallos/errores por problemas de estructura: 0.

Interpretación: los tests están conectados y fallan porque los métodos del alumno están incompletos a propósito.

## Comandos usados

Compilación de implementación:

```bash
for pom in $(find EDA_Examenes_2026/07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS/01_IMPLEMENTACION_PURA/ejercicios -path '*/esqueleto/pom.xml' | sort); do
  dir=$(dirname "$pom")
  (cd "$dir" && mvn -q -DskipTests test)
done
```

Compilación de casos de uso:

```bash
for pom in $(find EDA_Examenes_2026/07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS/02_CASOS_DE_USO/ejercicios -path '*/esqueleto/pom.xml' | sort); do
  dir=$(dirname "$pom")
  (cd "$dir" && mvn -q -DskipTests test)
done
```

Ejecución de tests iniciales:

```bash
for pom in $(find EDA_Examenes_2026/07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS/01_IMPLEMENTACION_PURA/ejercicios EDA_Examenes_2026/07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS/02_CASOS_DE_USO/ejercicios -path '*/esqueleto/pom.xml' | sort); do
  dir=$(dirname "$pom")
  (cd "$dir" && mvn -q -Dmaven.test.failure.ignore=true test)
done
```

Compilación y tests de exámenes propuestos:

```bash
for pom in $(find EDA_Examenes_2026/07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS/03_EXAMENES_PROPUESTOS -path '*/esqueleto/pom.xml' | sort); do
  dir=$(dirname "$pom")
  (cd "$dir" && mvn -q -DskipTests test)
  (cd "$dir" && mvn -q -Dmaven.test.failure.ignore=true test)
done
```

## Nota importante

No hay soluciones incluidas. Los métodos principales mantienen `TODO` y lanzan `UnsupportedOperationException` o fallan por aserciones preparadas para que el alumno complete la lógica.
