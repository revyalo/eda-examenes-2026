package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDateTime;

public record SolicitudReserva(String codigo, String asignatura, LocalDateTime inicio, int duracionMinutos, int prioridad, int capacidadNecesaria) {
}
