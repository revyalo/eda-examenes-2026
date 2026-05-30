package es.urjc.grafo.EDA.examen;

import java.time.LocalDateTime;

public record Flight(String code, String origin, String destination, LocalDateTime time) {
}
