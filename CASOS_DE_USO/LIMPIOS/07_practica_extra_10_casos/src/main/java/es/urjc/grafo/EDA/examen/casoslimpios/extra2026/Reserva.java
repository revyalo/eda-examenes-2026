package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDateTime;

public record Reserva(String codigo, String aula, String asignatura, LocalDateTime inicio, int duracionMinutos) {
}
