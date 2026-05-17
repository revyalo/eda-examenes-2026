# Exámenes mixtos antiguos

| Examen | Parte implementación | Parte casos de uso | Tests/esqueletos asociados | Patrón reutilizado |
|---|---|---|---|---|
| Junio 2025, convocatoria extraordinaria | `ReverseInordenBTIterator`, `FunHandling.esPrefijo` | `Area`, `RedElectrica` | `ReverseInorderBTIteratorTest`, `FunHandlingTest`, `AreaTest`, `RedElectricaTest` | Separar iteradores/árboles de aplicación con grafos/áreas |
| Enero 2025 ordinaria | `graphs.AdditionalFeatures` | `PlayersRanking`, `NameComparator` | Carpeta `Solucion/Solucion` y enunciado | Métodos de grafo + ranking con mapas |
| Septiembre 2024 | `merge` en BST, `removeHalfNodes` en árbol binario | `ConnectionManager`, `netP2P` | `Esqueleto 2/test` | Implementación de árbol + aplicación de red |
| Junio 2024 | `ELHyperGraph`/hipergrafo | `Synthetic_Intel` | `Hipergrafo` y enunciados duplicados | Implementación de estructura compleja separada de dominio |
| Junio 2023 | Iterador sin hermanos, árbol ternario | `RedSocial` | enunciado antiguo | Iteradores + aplicación con relaciones |
| Junio 2022 modelo A | `LevelIterator` | `ConnectionManager`, juego de luces | enunciado Wuolah | Árbol por niveles + grafo de luces |
| Enero 2022 | `MinimumSuccesorTree` | Liga de baloncesto | enunciado Wuolah | ABB + mapas/ranking |
| Parciales 2021 | Árbol perfecto e iterador de internos | Gestión de estudiantes/routers | `Funcionalidades-arboles`, `Esqueleto 6`, `Uso - Esqueleto` | Árboles como bloque independiente, dominio como bloque independiente |
| Enero 2018 opción A | `LevelsComplete`, `EfficientDict` | Caso alergias/leche/pueblos | PDF 2018 | Diccionario/hash + grafo de dominio |
| Enero 2016 | `isPerfect`, `isOdd`, `InternalNodeIterator` | `URJCInvest` | PDF 2016 | Funcionalidad de árbol + aplicación de búsquedas |

## Cómo estaban combinados

Los exámenes mixtos solían entregar un único ZIP con una carpeta `src` y otra `test`. En el mismo proyecto aparecían paquetes de material (`tree`, `graphs`, `utils`) y un paquete de dominio (`examen`, `CNP`, `RedP2P`, etc.). La puntuación se repartía normalmente entre 30-40% de implementación y 60-70% de caso de uso.

## Separación aplicada en 2026

- Las partes de implementación se han transformado en proyectos bajo `02_EXAMENES_IMPLEMENTACION`.
- Las partes de dominio se han transformado en proyectos bajo `03_EXAMENES_CASOS_DE_USO`.
- No se ha creado ningún examen mixto nuevo.
- Los tests de cada bloque son independientes y no comparten clases de dominio con los otros bloques.

## Localización por PDF

Además de esta descomposición conceptual, la carpeta `06_ESQUELETOS_POR_PDF` contiene una carpeta por cada PDF mixto antiguo.
Dentro de cada una aparece el nombre concreto de cada ejercicio y su carpeta separada en `ejercicios/implementacion` o `ejercicios/casos_de_uso`.
