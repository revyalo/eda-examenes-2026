# EDA Exámenes 2026

## Empieza aquí

La carpeta principal para estudiar ahora es:

```text
08_PRACTICA_ORDENADA_POR_PDF
```

Esa carpeta corrige la organización anterior y separa lo importante en dos bloques limpios:

- `01_IMPLEMENTACION_POR_PDF`: ejercicios de implementación extraídos de PDFs reales.
- `02_CASOS_DE_USO_POR_PDF`: casos de uso con proyecto completo, clases de dominio, tests y PDF fuente cuando se conoce.
- `03_CASOS_DE_USO_LIMPIOS_NUEVOS`: casos nuevos con clases de dominio dadas y clase gestora vacía para que tú declares las estructuras.
- `04_ITERADORES_POR_PDF`: iteradores de árboles separados desde PDFs y variantes nuevas con tests.

Los casos de uso antiguos de `03_EXAMENES_CASOS_DE_USO` no son la ruta recomendada porque algunos estaban incompletos. Las plantillas, rúbricas y tests comunes quedan como material secundario, no como punto de partida.

## Material de apoyo

- `00_ANALISIS`: informe del material original y descomposición de exámenes mixtos antiguos.
- `06_ESQUELETOS_POR_PDF`: primera organización por PDF, útil como histórico.
- `07_ENTRENAMIENTO_INTENSIVO_NUEVOS_EJERCICIOS`: banco extra de entrenamiento.
- `01_PLANTILLAS_BASE`, `04_TESTS_COMUNES`, `05_GUIAS_CORRECCION`: material interno/secundario.

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

## Verificación

La carpeta `08_PRACTICA_ORDENADA_POR_PDF` contiene 38 proyectos Maven:

- 7 de implementación.
- 13 de casos de uso por PDF.
- 6 casos de uso limpios nuevos.
- 12 ejercicios de iteradores.

Resultado de verificación:

- Compilación: 20/20 proyectos compilan.
- Tests: 93 ejecutados.
- Fallos por TODO esperado: 93.
- Fallos por dependencias, paquetes o clases faltantes: 0.

Además, la carpeta de iteradores compila 12/12 proyectos. Sus tests iniciales ejecutan 27 pruebas: 1 pasa porque el recorrido venía dado en el esqueleto original y 26 fallan por TODO esperado.

Consulta `08_PRACTICA_ORDENADA_POR_PDF/RESULTADOS_VERIFICACION.md`.

<!-- iteradores-por-pdf:start -->
## Carpeta de iteradores

Dentro de `08_PRACTICA_ORDENADA_POR_PDF/04_ITERADORES_POR_PDF` tienes una colección separada de
iteradores de árboles con esqueletos Maven y tests: `ExtendedBreadthFirstTreeIterator.remove`,
`ReverseInordenBTIterator`, `InternalNodeIterator`, `WithoutSiblingIterator`, `LevelIterator` y
variantes nuevas de práctica.
<!-- iteradores-por-pdf:end -->
