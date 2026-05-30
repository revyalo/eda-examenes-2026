# Informe de análisis del material EDA

## 1. Mapa resumido del directorio de entrada

- `PDFS/Presentaciones`: teoría de TAD, genéricos, iteradores, `Position`, Collections, árboles generales, mapas, diccionarios, mapas ordenados, AVL/RB, grafos y memoria secundaria.
- `PDFS/Implementacion`: enunciados recientes de implementación, especialmente diciembre de 2025 y enero de 2026.
- `PDFS/Casos de uso`: enunciados de caso de uso como CNP, CNI/interacciones, routers y un hipergrafo clasificado en esa carpeta aunque por contenido es implementación.
- `PDFS/Implementacion y casos de uso`: exámenes antiguos y recientes con ejercicios mezclados o con partes de teoría, implementación y aplicación.
- `Esqueletos`: proyectos entregados al alumno, algunos Maven y otros con estructura clásica `src`/`test`.
- `Entorno_y_funciones_totales_que_usamos`: proyectos del entorno y prácticas del profesor: listas posicionales, heap, diccionario, RB/AVL y cierre transitivo.

## 2. Clasificación de exámenes encontrados

- Implementación pura: `PDFS/Implementacion/Implementación - Enunciado.pdf`, `Enunciado_practico_enero.pdf`, `examen-practico-de-estructuras-de-datos-avanzadas-grado-en-ingenieria.pdf`, `Enunciado (3).pdf`.
- Casos de uso puro: `PDFS/Casos de uso/Enunciado.pdf` (CNP), `Casos de uso - Enunciado.pdf` (routers/URJCNetServices), `Enunciado (2).pdf` (CNI/interacciones).
- Mixtos: `PDFS/Implementacion y casos de uso/Enunciado.pdf` (junio 2025), `4c79148b-e28c-42e4-b222-a9c1a8d5a431.pdf` (enero 2025), `3fca766b-255d-44fe-b8c5-572372d17b0c.pdf` y `estructuras-de-datos-avanzadas-examen-septiembre-2024-convocatoria.pdf` (septiembre 2024), `4d1b6b48-d8b9-49dd-84c2-ccd32de869d3.pdf` (junio 2023), `wuolah-free-EnunciadoJunioUltimaV2-A.pdf` (junio 2022), `wuolah-free-Examen-1.pdf`, `wuolah-free-Examen-2.pdf`, `wuolah-free-Examen-3.pdf`, `wuolah-free-Examen-8.pdf`, `d25bf4e1-84a6-4178-a75b-cbd65c3e0058.pdf`, `examen-ordinario-eda-enero-2018-opcion-a-2h-30m-ejercicios.pdf`, `3540d1fd-f0f4-4198-bfcc-adfc51ad30a4.pdf`, `f4955113-a3a7-443c-8a04-6f30b9de991e.pdf`.
- Desconocidos o poco inferibles por extracción parcial/scan: `examen-practico-eda-24-convocatoria-de-septiembre-2024.pdf`, `wuolah-free-Examen-7.pdf` y PDFs de test marcados como no tener en cuenta.

## 3. Exámenes mixtos antiguos

Los mixtos combinan uno o dos ejercicios de implementación de estructuras con un ejercicio largo de aplicación. El patrón más repetido es: ejercicios 1-2 sobre árboles, mapas, iteradores, hipergrafos o grafos; ejercicio final sobre una aplicación de dominio como red social, P2P, ranking, vuelos, CNP, red eléctrica o traducción web.

## 4. Descomposición de exámenes mixtos

- Junio 2025: implementación en `ReverseInordenBTIterator` y `FunHandling.esPrefijo`; caso de uso en `Area` y `RedElectrica`. Los tests de solución detectados corresponden a `ReverseInorderBTIteratorTest`, `FunHandlingTest`, `AreaTest` y `RedElectricaTest`.
- Enero 2025: implementación en `graphs.AdditionalFeatures`; caso de uso en `PlayersRanking` y `NameComparator`.
- Septiembre 2024: implementación en `merge` de BST y `removeHalfNodes`; caso de uso en `ConnectionManager` y `netP2P`.
- Junio 2024: implementación de hipergrafo `ELHyperGraph`; caso de uso `Synthetic_Intel`, inferido por el enunciado posterior.
- Junio 2023: implementación de iterador sin hermanos y árbol ternario; caso de uso en `RedSocial`.
- Junio 2022: implementación de `LevelIterator`; casos de uso en `ConnectionManager` y juego de luces.
- Enero 2016/2018 y 2014/2016: primera parte de implementación/razonamiento de estructuras y segunda parte de aplicación con índices, diccionarios, censos, traducción web o alergias.

## 5. Arquitectura del entorno del profesor

- Paquete principal reciente: `es.urjc.grafo.EDA`.
- Paquetes frecuentes: `graphs`, `trees`, `trees.binaryTrees`, `trees.nAryTrees`, `lists`, `mapas`, `diccionarios`, `map`, `searchtree`, `utils`, `util`, `examen`.
- Interfaces: `Position`, `Vertex`, `Edge`, `Tree`, `BinaryTree`, `NAryTree`, `Graph`, `UndirectedGraph`, `DirectedGraph`, `Mapa`, `Dictionary`, `SortedMap`.
- Clases base: `LinkedBinaryTree`, `LinkedTree`, `ArrayBinaryTree`, `LinkedPositionalList`, `AdjacencyMapGraph`, `GraphAlgorithms`, `MapaEncadenamientoSeparado`, `AbstractMapaDireccionamientoAbierto`, `TreeMap`, `AVLTreeMap`, `RBTreeMap`, `Heap`.
- Excepciones: predominan `IllegalArgumentException`, `RuntimeException`, `NoSuchElementException` y `UnsupportedOperationException` en esqueletos.

## 6. Convenciones de código detectadas

- Java 21 o superior en POM, `groupId` `es.urjc.grafo.EDA`.
- Métodos incompletos con comentario `// TODO` y `throw new UnsupportedOperationException("Not implemented yet")` o `"Not supported yet."`.
- Se mantienen firmas públicas y se permiten auxiliares privados.
- Uso intenso de genéricos: `<E>`, `<V,E>`, `<K,V>`.
- Se aceptan estructuras auxiliares de `java.util` en algoritmos y tests, pero no como sustituto de la estructura pedida.

## 7. Convenciones de tests

- Framework: JUnit Jupiter 5.8.1 en los proyectos Maven recientes; algunos enunciados antiguos mencionan JUnit 4/Hamcrest.
- Tests en `src/test/java`, normalmente en paquete por defecto importando las clases del paquete principal.
- Nombres descriptivos en español, `assertThrows`, `assertEquals`, `assertTrue`, `assertFalse`, `assertNull`.
- Se prueban vacíos, un elemento, varios, duplicados, nulos y errores de contrato.

## 8. Implementación frente a casos de uso

- Implementación: completar una estructura o algoritmo interno: iteradores, hash, árbol, hipergrafo, recorridos, cierre o potencia de grafo.
- Caso de uso: elegir y usar estructuras ya dadas para modelar un dominio. La dificultad está en los índices, las relaciones y las consultas, no en reimplementar la ED.

## 9. Patrones repetidos en esqueletos

- Clases pequeñas en paquete `examen` o dentro del paquete de la estructura.
- Atributos marcados con `TODO`.
- Métodos con Javadoc que explican comportamiento y casos de error.
- Restricción explícita de no modificar cabeceras ni añadir públicos.

## 10. Patrones repetidos en tests

- Construcción manual de árboles y grafos dentro del test.
- Uso de colecciones esperadas para comparar iterables.
- Casos de frontera antes de casos grandes.
- Verificación indirecta de invariantes: tamaño, ausencia de duplicados, orden de recorrido y persistencia tras borrado.

## 11. Recomendaciones 2026 aplicadas

- Mantener dos bloques separados: implementación y casos de uso.
- Usar Maven con la misma estructura reciente.
- Incluir tests públicos y avanzados en cada proyecto.
- Usar esqueletos con TODOs y excepciones, sin soluciones.
- Reutilizar interfaces y clases base del profesor copiadas como entorno local del examen.

## 12. Elementos dudosos

- Algunos PDFs están escaneados o tienen texto parcial; su clasificación se basa en lo extraíble y en los esqueletos asociados.
- La carpeta `PDFS/Casos de uso/Enunciado (1).pdf` contiene un hipergrafo, que por contenido es implementación aunque esté en la carpeta de casos.
- Algunos ZIP contienen soluciones propuestas; se han usado solo para identificar patrones y no se han copiado soluciones de ejercicios nuevos.

## 13. Esqueletos consolidados

La primera organización por PDF se consolidó para evitar duplicados y carpetas históricas.
El material practicable queda en `IMPLEMENTACION`, `CASOS_DE_USO` e `ITERADORES`.
Los nombres de los proyectos conservan la convocatoria o el origen del PDF cuando se pudo inferir con seguridad.
