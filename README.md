# EDA Exámenes 2026

Repositorio ordenado para estudiar EDA con esqueletos, enunciados y tests.

## Por dónde empezar

1. Abre `GUIA_REPASO/INDICE_GENERAL.md`.
2. Elige un bloque: `CASOS_DE_USO`, `IMPLEMENTACION` o `ITERADORES`.
3. En casos de uso, entra en un ejercicio concreto; en implementación e iteradores, entra en el proyecto del bloque que quieras practicar.
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

- `CASOS_DE_USO/LIMPIOS`: casos nuevos con clases de dominio dadas y clase gestora vacia, para que tu elijas las estructuras.
- `CASOS_DE_USO/DESDE_PDFS`: casos reconstruidos desde PDFs reales, con dominio, servicio/gestor y tests.
- `IMPLEMENTACION`: tres proyectos Maven unificados: `grafos`, `arboles` y `arboles_binarios`.
- `ITERADORES`: tres proyectos Maven unificados: `arboles`, `arboles_binarios` y `grafos`.
- `GUIA_REPASO`: orden recomendado, guia de Java/EDA y resultados de verificacion.
- `ANALISIS`: informe del material original y examenes mixtos antiguos documentados.

## Verificación

Proyectos Maven actuales:

- Implementación: 3.
- Casos de uso: 33.
- Iteradores: 3.
- Total: 39.

Compilación esperada:

- Todos los proyectos deben compilar con `mvn -q -DskipTests test`.
- Los fallos de `mvn test` son fallos esperados por TODO, no por clases faltantes.

## Reglas

- No hay soluciones incluidas.
- No hay carpetas antiguas de plantillas ni primeros intentos.
- No hay examenes mixtos nuevos.
- Los examenes mixtos antiguos solo aparecen documentados o separados en ejercicios actuales.
