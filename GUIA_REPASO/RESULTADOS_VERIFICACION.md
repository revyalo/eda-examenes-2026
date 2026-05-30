# Resultados de verificación

Fecha: 2026-05-30.

## Alcance

- Proyectos de implementación por PDF: 7.
- Proyectos de casos de uso por PDF: 13.
- Proyectos de casos de uso limpios nuevos: 6.
- Proyectos de iteradores por PDF/práctica extra: 12.
- Total: 38 proyectos Maven.

## Compilación

Se ha ejecutado:

```bash
mvn -q -DskipTests test
```

Resultado:

- Proyectos compilados: 38.
- Errores de compilación: 0.

## Tests

Se ha ejecutado:

```bash
mvn -q -Dmaven.test.failure.ignore=true test
```

Resultado:

- Tests ejecutados: 93.
- Failures: 4.
- Errors: 89.
- Skipped: 0.
- Fallos por TODO esperado: 93.
- Fallos por dependencias, imports, clases faltantes o estructura Maven: 0.

Casos limpios nuevos:

- Tests ejecutados: 9.
- Failures: 0.
- Errors: 9.
- Fallos por TODO esperado: 9.
- Fallos por dependencias, imports, clases faltantes o estructura Maven: 0.

Iteradores:

- Tests ejecutados: 27.
- Tests que ya pasan por código dado en el esqueleto original: 1.
- Fallos por TODO esperado: 26.
- Fallos por dependencias, imports, clases faltantes o estructura Maven: 0.

## Interpretación

La carpeta está preparada para estudiar. Los tests fallan inicialmente porque los métodos del alumno siguen incompletos a propósito.

Si al resolver un ejercicio un test sigue fallando, ya no debería ser porque falte una clase de dominio o porque el proyecto esté mal montado.
