package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDateTime;

public record ReservaLibro(String codigo, String isbn, String usuario, LocalDateTime fecha, int prioridad) {
}
