# Esqueletos por PDF

Esta seccion corrige la organizacion anterior: aqui hay una carpeta por cada PDF de examen detectado.
Cada carpeta indica el nombre de cada ejercicio, su tipo y la estructura evaluada.

Convenciones:

- `esqueletos_existentes`: copia limpia del esqueleto original cuando ya existia en `Esqueletos/`.
- `esqueletos_generados`: proyecto Maven con la estructura real de los esqueletos del profesor (`src/main/java`, `src/test/java`, paquete `es.urjc.grafo.EDA`, entorno base y clases `examen`).
- `ejercicios/implementacion`: apartados de implementacion extraidos del PDF.
- `ejercicios/casos_de_uso`: apartados de caso de uso extraidos del PDF.
- `respuestas_teoricas`: PDFs o apartados teoricos sin esqueleto Java directo.

No se copian carpetas de soluciones ni zips cuyo contenido identificado sea una solucion.
