# Resumen de compilacion de esqueletos por PDF

Fecha de verificacion: 2026-05-18.

## Cobertura

- PDFs de examenes indexados fuera de `PDFS/Presentaciones`: 31.
- Proyectos `esqueletos_generados` creados con estructura del profesor: 27.
- Ejercicios de implementacion nombrados: 41.
- Ejercicios de casos de uso nombrados: 20.
- PDFs/ejercicios marcados como pendiente de revision por extraccion insuficiente: 2.
- PDFs de test/teoria marcados como no usados para esqueletos de practica: 4.

Los proyectos generados aplican la estructura de los esqueletos reales:

- `pom.xml` con `groupId` `es.urjc.grafo.EDA`, Java 21 y JUnit Jupiter 5.8.1.
- `src/main/java/es/urjc/grafo/EDA`.
- entorno base `graphs`, `trees`, `lists` y `utils`.
- clases del examen en `src/main/java/es/urjc/grafo/EDA/examen`.
- tests en `src/test/java/es/urjc/grafo/EDA/examen`.

## Comandos ejecutados

```bash
python3 EDA_Examenes_2026/00_ANALISIS/generar_esqueletos_por_pdf.py

python3 EDA_Examenes_2026/00_ANALISIS/reestructurar_esqueletos_por_pdf.py

find EDA_Examenes_2026/06_ESQUELETOS_POR_PDF -path '*/esqueletos_generados/pom.xml'

for pom in $(find EDA_Examenes_2026/06_ESQUELETOS_POR_PDF -path '*/esqueletos_generados/pom.xml' | sort); do
  dir=$(dirname "$pom")
  (cd "$dir" && mvn -q -DskipTests test)
done

for pom in $(find EDA_Examenes_2026/06_ESQUELETOS_POR_PDF -path '*/esqueletos_generados/pom.xml' | sort); do
  dir=$(dirname "$pom")
  (cd "$dir" && mvn -q -Dmaven.test.failure.ignore=true test)
done
```

## Resultado

- Compilacion: 27/27 proyectos generados con estructura del profesor compilados correctamente.
- Tests de arranque: 57 ejecutados.
- Fallos esperados por aserciones contra TODO: 25.
- Errores esperados por `UnsupportedOperationException`: 32.
- Tests omitidos: 0.

Los fallos y errores de test son esperados: los esqueletos generados no contienen soluciones y los metodos principales lanzan `UnsupportedOperationException` o no producen todavia el resultado esperado.

## Material no copiado

No se copiaron carpetas ni zips identificados como soluciones:

- `Esqueletos/Solucion`
- `Esqueletos/Solución propuesta`
- `Esqueletos/Ordinaria2025.zip`
- `Esqueletos/Solución propuesta.zip`
