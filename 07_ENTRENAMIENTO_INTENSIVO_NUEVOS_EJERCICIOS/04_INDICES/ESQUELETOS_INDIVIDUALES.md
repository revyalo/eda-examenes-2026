# Esqueletos individuales

Se ha generado un proyecto `esqueleto` dentro de cada carpeta de ejercicio grande. Esto significa que cada idea prioritaria tiene enunciado, estructura Maven, código a completar y tests propios.

- Ejercicios de implementación con esqueleto propio: 70
- Casos de uso con esqueleto propio: 15
- Examenes propuestos con esqueleto propio: 4
- Total de proyectos Maven generados: 89

Cada `esqueleto` contiene:

- `pom.xml`
- `src/main/java`
- `src/test/java`
- `README.md`

Los métodos están incompletos a propósito.

## Cómo ejecutar un ejercicio individual

Desde la carpeta `esqueleto/` del ejercicio:

```bash
mvn test
```

El resultado inicial debe fallar por `TODO`. Cuando completes la implementación correctamente, los tests de ese ejercicio deberían pasar.

## Ejemplos de rutas

- Implementación, grafos: `01_IMPLEMENTACION_PURA/ejercicios/grafos_prioritarios/shortestdistancelessorequal/esqueleto`
- Implementación, árboles: `01_IMPLEMENTACION_PURA/ejercicios/arboles_binarios_y_generales/isalmostcomplete/esqueleto`
- Implementación, ABB/AVL: `01_IMPLEMENTACION_PURA/ejercicios/abb_avl_diccionarios/rangecount/esqueleto`
- Casos de uso: `02_CASOS_DE_USO/ejercicios/registrocnpavanzado/esqueleto`
- Simulacro de examen: `03_EXAMENES_PROPUESTOS/examen_propuesto_01_nivel_enero_2026/esqueleto`

## Verificación

La compilación de los 89 proyectos se ha comprobado. El resumen está en `RESULTADOS_ESQUELETOS_INDIVIDUALES.md`.
