# Índice de iteradores por PDF y práctica extra

        Esta carpeta separa los ejercicios de iteradores de árboles para que puedas practicarlos sin mezclar
        casos de uso, grafos u otros bloques de implementación.

        ## Ejercicios

        | # | Carpeta | Ejercicio | Dificultad | Origen |
        |---:|---|---|---|---|
        | 01 | `01_enero_2026_extended_breadth_first_remove` | ExtendedBreadthFirstTreeIterator.remove | Alta | PDF/esqueleto real: implementación enero 2026, iterador en anchura sobre LinkedTree. |
| 02 | `02_junio_2025_reverse_inorden` | ReverseInordenBTIterator | Alta | PDF mixto junio 2025: parte de implementación de iteradores, separada del caso de uso de red eléctrica. |
| 03 | `03_internal_node_iterator_real` | InternalNodeIterator | Media-alta | PDF/esqueleto real: funcionalidades de árboles e iterador de nodos internos. |
| 04 | `04_junio_2023_without_sibling_iterator` | WithoutSiblingIterator | Alta | PDF mixto junio 2023: parte de implementación con iterador de nodos sin hermano, separada del caso de uso. |
| 05 | `05_junio_2022_level_iterator` | LevelIterator | Media-alta | PDF mixto junio 2022: parte de implementación LevelIterator, separada del caso de uso de luces. |
| 06 | `06_extra_inorden_iterator_with_remove` | InordenIteratorWithRemove | Alta | Ejercicio nuevo inspirado en iteradores de examen: remove sobre recorrido inorden. |
| 07 | `07_extra_reverse_inorden_with_remove` | ReverseInordenBTIteratorWithRemove | Muy alta | Ejercicio nuevo: variante más difícil del ReverseInordenBTIterator real. |
| 08 | `08_extra_leaf_iterator` | LeafIterator | Media-alta | Ejercicio nuevo de práctica: iterador de hojas en árbol general. |
| 09 | `09_extra_skip_leaves_iterator` | SkipLeavesIterator | Media-alta | Ejercicio nuevo de práctica: recorrer solo nodos internos de árbol general. |
| 10 | `10_extra_between_levels_iterator` | BetweenLevelsIterator | Alta | Ejercicio nuevo de práctica: iterador por niveles acotados. |
| 11 | `11_extra_breadth_first_even_level_iterator` | BreadthFirstEvenLevelIterator | Alta | Ejercicio nuevo de práctica: BFS filtrando niveles pares. |
| 12 | `12_extra_path_iterator_to_root` | PathIteratorToRoot | Muy alta | Ejercicio nuevo de práctica: iterador de camino desde un nodo hasta la raíz. |
| 13 | `18_postorder_remove_iterator` | PostorderRemoveIterator | Muy alta | Simulacro nuevo: iterador postorden con remove. |
| 14 | `20_general_tree_zigzag_iterator` | GeneralTreeZigZagIterator | Muy alta | Simulacro nuevo: zigzag sobre arbol general. |

        ## Orden recomendado

        1. `03_internal_node_iterator_real`
        2. `08_extra_leaf_iterator`
        3. `09_extra_skip_leaves_iterator`
        4. `05_junio_2022_level_iterator`
        5. `02_junio_2025_reverse_inorden`
        6. `04_junio_2023_without_sibling_iterator`
        7. `01_enero_2026_extended_breadth_first_remove`
        8. `06_extra_inorden_iterator_with_remove`
        9. `07_extra_reverse_inorden_with_remove`
        10. `10_extra_between_levels_iterator`
        11. `11_extra_breadth_first_even_level_iterator`
        12. `12_extra_path_iterator_to_root`
        13. `18_postorder_remove_iterator`
        14. `20_general_tree_zigzag_iterator`

        Primero domina `hasNext`/`next` sin borrar; después pasa a `remove`, que es donde suelen romperse
        los invariantes del iterador.
