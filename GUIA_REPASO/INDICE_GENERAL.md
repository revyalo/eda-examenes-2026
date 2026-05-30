# Índice General

Esta es la ruta recomendada para estudiar con el repositorio ya limpio.

## 1. Casos De Uso Limpios

Empieza aquí si quieres practicar cómo elegir estructuras.

1. `CASOS_DE_USO/LIMPIOS/01_urjcnetservices_routers_limpio`
2. `CASOS_DE_USO/LIMPIOS/02_registro_cnp_limpio`
3. `CASOS_DE_USO/LIMPIOS/03_cni_contactos_limpio`
4. `CASOS_DE_USO/LIMPIOS/04_red_p2p_limpia`
5. `CASOS_DE_USO/LIMPIOS/05_urjc_flights_limpio`
6. `CASOS_DE_USO/LIMPIOS/06_hospital_triaje_limpio`
7. `CASOS_DE_USO/LIMPIOS/07_practica_extra_10_casos`

## 2. Implementación

1. `IMPLEMENTACION/01_enero_2026_grafos_arboles_iterador`
2. `IMPLEMENTACION/02_diciembre_2025_complementario_grado_identicos`
3. `IMPLEMENTACION/03_diciembre_2025_euler_descendants_symmetric`
4. `IMPLEMENTACION/05_arboles_perfecto_iterador`
5. `IMPLEMENTACION/04_hipergrafo`
6. `IMPLEMENTACION/08_practica_extra_10_ejercicios`

## 3. Iteradores

1. `ITERADORES/03_internal_node_iterator_real`
2. `ITERADORES/08_extra_leaf_iterator`
3. `ITERADORES/09_extra_skip_leaves_iterator`
4. `ITERADORES/05_junio_2022_level_iterator`
5. `ITERADORES/02_junio_2025_reverse_inorden`
6. `ITERADORES/04_junio_2023_without_sibling_iterator`
7. `ITERADORES/01_enero_2026_extended_breadth_first_remove`

## 4. Casos Desde PDFs

Cuando ya tengas soltura, usa estos para acercarte más al formato real.

1. `CASOS_DE_USO/DESDE_PDFS/01_urjcnetservices_routers_2026`
2. `CASOS_DE_USO/DESDE_PDFS/02_oposiciones_cnp`
3. `CASOS_DE_USO/DESDE_PDFS/03_cni_interacciones`
4. `CASOS_DE_USO/DESDE_PDFS/13_red_p2p_septiembre_2024`
5. `CASOS_DE_USO/DESDE_PDFS/04_red_electrica_junio_2025`
6. `CASOS_DE_USO/DESDE_PDFS/05_ranking_jugadores_enero_2025`
7. `CASOS_DE_USO/DESDE_PDFS/06_synthetic_intel_junio_2024`
8. `CASOS_DE_USO/DESDE_PDFS/10_urjc_flights_enero_2022`

## Cómo Ejecutar

Cada ejercicio es un proyecto Maven independiente:

```bash
cd RUTA_DEL_EJERCICIO
mvn test
```

Si el test falla por `UnsupportedOperationException`, es normal: falta tu implementación.
