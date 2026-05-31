# Resultados de verificación

Fecha: 2026-05-31.

## Alcance

- Proyectos de implementación por PDF/práctica extra: 20.
- Proyectos de casos de uso por PDF: 13.
- Proyectos de casos de uso limpios nuevos: 15.
- Proyectos de iteradores por PDF/práctica extra: 14.
- Total: 62 proyectos Maven.

## Compilación

Se ha ejecutado:

```bash
mvn -q -DskipTests test
```

Resultado:

- Proyectos compilados: 62.
- Errores de compilación: 0.

## Tests

Se ha ejecutado:

```bash
mvn -q -Dmaven.test.failure.ignore=true test
```

Resultado:

- Tests ejecutados: 189.
- Failures: 5.
- Errors: 183.
- Skipped: 0.
- Tests que ya pasan por codigo dado en esqueletos originales: 1.
- Fallos por TODO esperado: 188.
- Fallos por dependencias, imports, clases faltantes o estructura Maven: 0.

Casos limpios nuevos:

- Tests ejecutados: 31.
- Failures: 0.
- Errors: 31.
- Fallos por TODO esperado: 31.
- Fallos por dependencias, imports, clases faltantes o estructura Maven: 0.

Iteradores:

- Tests ejecutados: 30.
- Tests que ya pasan por código dado en el esqueleto original: 1.
- Fallos por TODO esperado: 29.
- Fallos por dependencias, imports, clases faltantes o estructura Maven: 0.

## Interpretación

La carpeta está preparada para estudiar. Los tests fallan inicialmente porque los métodos del alumno siguen incompletos a propósito.

Si al resolver un ejercicio un test sigue fallando, ya no debería ser porque falte una clase de dominio o porque el proyecto esté mal montado.
