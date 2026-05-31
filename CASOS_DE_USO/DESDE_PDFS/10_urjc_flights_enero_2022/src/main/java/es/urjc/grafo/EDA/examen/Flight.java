package es.urjc.grafo.EDA.examen;

import java.time.LocalDateTime;

public record Flight(Airport origin, Airport destination, LocalDateTime departureTime) {
}
