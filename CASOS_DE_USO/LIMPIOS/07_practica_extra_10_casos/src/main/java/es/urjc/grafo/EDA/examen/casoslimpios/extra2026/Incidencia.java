package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDateTime;

public record Incidencia(String codigo, int gravedad, LocalDateTime hora, String municipio, String descripcion) {
}
