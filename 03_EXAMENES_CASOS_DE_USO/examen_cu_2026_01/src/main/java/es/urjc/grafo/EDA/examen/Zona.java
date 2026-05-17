package es.urjc.grafo.EDA.examen;

public record Zona(String id, boolean segura) {
    public Zona {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
