package es.urjc.grafo.EDA.examen.casoslimpios.mensajes;

import java.time.LocalDateTime;

public record MensajePlataforma(String id, String emisor, LocalDateTime fecha, int prioridad, String texto) {
}
