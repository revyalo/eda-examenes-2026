# Examen propuesto 04 - casos de uso

## Enunciado

Implementa un sistema de mensajes/eventos sobre una red manual de nodos.
Debes usar las estructuras indicadas en el esqueleto:

- `HashMap` para busqueda por codigo.
- `HashSet` para evitar repetidos y representar vecinos.
- `TreeMap` para consultas por fecha.
- `PriorityQueue` para prioridad de eventos.

## Que debe completar el alumno

- `MensajeEventoComparator.compare`.
- `registrarEvento`.
- `cancelarEvento`.
- `buscarEvento`.
- `eventosHasta`.
- `conectar`.
- `hayConexionConDistanciaMenorOIgual`.

## Tests

Ejecuta:

```bash
mvn test
```

Los tests fallan inicialmente por TODO esperado.
