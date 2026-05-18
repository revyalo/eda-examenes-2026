# EDA Exámenes 2026

Este directorio contiene material nuevo de práctica para EDA, separado en dos bloques:

- `02_EXAMENES_IMPLEMENTACION`: ejercicios para completar métodos internos o algoritmos sobre estructuras.
- `03_EXAMENES_CASOS_DE_USO`: ejercicios para resolver problemas de dominio usando estructuras ya disponibles.

También incluye:

- `00_ANALISIS`: informe del material original y descomposición de exámenes mixtos antiguos.
- `01_PLANTILLAS_BASE`: plantillas reutilizables.
- `04_TESTS_COMUNES`: criterios y utilidades documentadas para tests.
- `05_GUIAS_CORRECCION`: rúbricas generales.
- `06_ESQUELETOS_POR_PDF`: una carpeta por cada PDF de examen, con el nombre explícito de cada ejercicio y copia del esqueleto original cuando existía.
- `07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS`: ejercicios nuevos de implementación y casos de uso, más una guía de repaso en Markdown y PDF.

## Cómo usar

Abra un proyecto de examen, lea su `README.md`, complete los `TODO` y ejecute:

```bash
mvn test
```

Los métodos principales están incompletos a propósito. No hay soluciones incluidas y no se ha creado ningún examen mixto nuevo. Los exámenes mixtos antiguos aparecen solo documentados en el análisis.

Para localizar un ejercicio antiguo concreto por PDF, empieza por:

```bash
EDA_Examenes_2026/06_ESQUELETOS_POR_PDF/INDICE_GENERAL_PDFS.md
```

## Ejercicios incluidos

Implementación:

- `examen_impl_2026_01`: árboles binarios.
- `examen_impl_2026_02`: mapas hash.
- `examen_impl_2026_03`: grafos.

Casos de uso:

- `examen_cu_2026_01`: plan de evacuación.
- `examen_cu_2026_02`: organigrama.
- `examen_cu_2026_03`: archivo de incidencias.

## Próximos pasos recomendados

1. Revisar primero `00_ANALISIS/INFORME_ANALISIS.md`.
2. Resolver un ejercicio de implementación y ejecutar tests.
3. Resolver un caso de uso y comparar el estilo de diseño con las rúbricas.
