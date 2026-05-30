# Practica ordenada por PDFs

Esta es la carpeta limpia para estudiar. Lo anterior queda como material de apoyo, pero esta carpeta es la que deberias abrir primero.

## Bloques

- `01_IMPLEMENTACION_POR_PDF`: ejercicios de implementacion extraidos de PDFs reales o partes de implementacion de examenes mixtos.
- `02_CASOS_DE_USO_POR_PDF`: casos de uso con proyecto completo: clases de dominio, gestor/servicio, tests y PDF fuente cuando se conoce.
- `03_CASOS_DE_USO_LIMPIOS_NUEVOS`: casos de uso nuevos con dominio completo, gestor vacio y metodos TODO para que tu elijas las estructuras.
- `04_ITERADORES_POR_PDF`: iteradores de arboles separados por ejercicio, con tests propios.
- `INDICE_LIMPIO.md`: orden recomendado y estado de cada proyecto.

## Regla de uso

Entra en un proyecto concreto y ejecuta:

```bash
mvn test
```

El fallo inicial correcto es `UnsupportedOperationException` por TODO. Si falla porque falta una clase o no compila, eso es un problema real.

<!-- iteradores-por-pdf:start -->
## Iteradores añadidos

Se ha añadido `04_ITERADORES_POR_PDF`, una carpeta separada con ejercicios de iteradores de árboles.
Incluye patrones reales de enero 2026, junio 2025, junio 2023 y junio 2022, además de variantes nuevas
para entrenar `remove`, inorden inverso, hojas, nodos internos y recorridos por niveles.
<!-- iteradores-por-pdf:end -->
