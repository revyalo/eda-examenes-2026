package es.urjc.grafo.EDA.examen.casoslimpios.sensores;

import java.time.LocalDateTime;

public record Alerta(String id, String sensor, LocalDateTime fecha, int severidad, String zona) {
}
