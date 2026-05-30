package es.urjc.grafo.EDA.examen.casoslimpios;

import java.time.LocalDateTime;

public record Vuelo(String codigo, String origen, String destino, LocalDateTime salida) {
}
