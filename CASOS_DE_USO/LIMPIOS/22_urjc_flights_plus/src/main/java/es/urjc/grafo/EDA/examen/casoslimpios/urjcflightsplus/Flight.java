package es.urjc.grafo.EDA.examen.casoslimpios.urjcflightsplus;

import java.time.LocalDateTime;

public record Flight(String code,
                     String origin,
                     String destination,
                     LocalDateTime departure,
                     double price,
                     int durationMinutes) {
}
