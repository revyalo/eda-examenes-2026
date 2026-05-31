# Casos de uso limpios nuevos

Estos ejercicios estan pensados para evitar el problema de esqueletos raros:

- Las clases de dominio si estan dadas y completas.
- La clase gestora no trae estructuras ya creadas.
- Tu decides los atributos privados e inicializas tus estructuras.
- Los tests estan completos y fallan inicialmente por los `TODO`.

## Orden recomendado

1. `01_urjcnetservices_routers_limpio`
2. `02_registro_cnp_limpio`
3. `03_cni_contactos_limpio`
4. `04_red_p2p_limpia`
5. `05_urjc_flights_limpio`
6. `06_hospital_triaje_limpio`
7. `07_practica_extra_10_casos`
8. `08_red_sensores_incendios`
9. `12_red_transportes_urjc`
10. `13_plataforma_mensajes`
11. `14_urjc_investment`
12. `15_synthetic_intel_organigrama`
13. `16_alergia_leche_pueblos`
14. `17_urjc_network_rip`
15. `18_organiser_estudiantes`

El proyecto `07_practica_extra_10_casos` contiene 10 casos de uso nuevos en un unico proyecto Maven, para practicar con enunciados mas largos sin crear mas carpetas de categoria.

Los proyectos `08`, `12` y `13` son casos de uso de simulacro: sensores, transportes y plataforma de mensajes.

Los proyectos `14` a `18` son casos limpios reconstruidos desde capturas/PDFs: URJC Investment, Synthetic_Intel, alergia a la leche, RIP de routers y Organiser de estudiantes.

## Ejecutar

Entra en cualquier carpeta y ejecuta:

```bash
mvn test
```
