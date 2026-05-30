# Resultados de verificación de iteradores

Fecha: 2026-05-30.

## Alcance

- Proyectos Maven de iteradores: 12.
- Ejercicios reales separados desde PDFs/esqueletos antiguos: 5.
- Variantes nuevas de práctica: 7.

## Compilación

Se ha ejecutado en cada proyecto:

```bash
mvn -q -DskipTests test
```

Resultado:

- Proyectos compilados: 12/12.
- Errores de compilación: 0.
- Clases de entorno de árboles copiadas: sí.
- Clases o dependencias faltantes: 0.

## Tests

Se ha ejecutado en cada proyecto:

```bash
mvn -q test
```

Resultado inicial esperado:

- Tests ejecutados: 27.
- Tests que ya pasan por código dado en el esqueleto original: 1.
- Fallos por TODO esperado: 26.
- Fallos por estructura Maven, imports o clases faltantes: 0.

El único test que pasa inicialmente está en `01_enero_2026_extended_breadth_first_remove`, porque el esqueleto real ya traía implementado el recorrido en anchura y solo dejaba pendiente `remove`.

## Interpretación

La carpeta está preparada para resolver. Los tests fallan porque los iteradores están incompletos a propósito, no porque falten clases de dominio, paquetes o dependencias.

Cuando termines un ejercicio, el proyecto correspondiente debería pasar `mvn test` sin tocar los tests ni cambiar firmas públicas.
