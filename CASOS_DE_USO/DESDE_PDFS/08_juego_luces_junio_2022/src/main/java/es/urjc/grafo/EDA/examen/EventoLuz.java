package es.urjc.grafo.EDA.examen;

import java.time.LocalDateTime;

public record EventoLuz(String id, int prioridad, LocalDateTime fecha) implements Comparable<EventoLuz> {
    @Override
    public int compareTo(EventoLuz other) {

        int cmp = this.fecha().compareTo(other.fecha());
        if (cmp != 0) {
            return cmp;
        }
        cmp = Integer.compare(other.prioridad(), this.prioridad());
        if (cmp != 0) {
            return cmp;
        }
        return this.id().compareTo(other.id());

    }
}
