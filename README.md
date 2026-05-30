# EDA Exámenes 2026

Repositorio ordenado para estudiar EDA con esqueletos, enunciados y tests.

## Por dónde empezar

1. Abre `GUIA_REPASO/INDICE_GENERAL.md`.
2. Elige un bloque: `CASOS_DE_USO`, `IMPLEMENTACION` o `ITERADORES`.
3. Entra en un ejercicio concreto.
4. Lee su `README.md`.
5. Completa los TODO.
6. Ejecuta `mvn test`.

Los tests fallan al principio porque los métodos del alumno están sin implementar a propósito.

## Estructura limpia

```text
EDA_Examenes_2026/
├── ANALISIS/
├── CASOS_DE_USO/
│   ├── LIMPIOS/
│   └── DESDE_PDFS/
├── GUIA_REPASO/
├── IMPLEMENTACION/
├── ITERADORES/
├── .gitignore
└── README.md
```

## Qué hay en cada carpeta

- `CASOS_DE_USO/LIMPIOS`: casos nuevos con clases de dominio dadas y clase gestora vacía, para que tú elijas las estructuras.
- `CASOS_DE_USO/DESDE_PDFS`: casos reconstruidos desde PDFs reales, con dominio, servicio/gestor y tests.
- `IMPLEMENTACION`: ejercicios de implementación pura extraídos de PDFs reales o de partes de implementación de exámenes mixtos.
- `ITERADORES`: ejercicios de iteradores de árboles, incluyendo `remove`, inorden inverso, hojas, nodos internos y niveles.
- `GUIA_REPASO`: orden recomendado, guía de Java/EDA y resultados de verificación.
- `ANALISIS`: informe del material original y exámenes mixtos antiguos documentados.

## Verificación

Proyectos Maven actuales:

- Implementación: 7.
- Casos de uso: 19.
- Iteradores: 12.
- Total: 38.

Compilación verificada:

- 38/38 proyectos compilan con `mvn -q -DskipTests test`.
- Los fallos de `mvn test` son fallos esperados por TODO, no por clases faltantes.

## Reglas

- No hay soluciones incluidas.
- No hay carpetas antiguas de plantillas ni primeros intentos.
- No hay exámenes mixtos nuevos.
- Los exámenes mixtos antiguos solo aparecen documentados o separados en ejercicios actuales.
