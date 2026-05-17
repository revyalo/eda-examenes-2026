package es.urjc.grafo.EDA.examen;

public record Incidencia(String id, String servicio, int prioridad, String descripcion) {
    public Incidencia {
        if (id == null || id.isBlank() || servicio == null || servicio.isBlank() || descripcion == null) {
            throw new IllegalArgumentException();
        }
        if (prioridad < 1 || prioridad > 5) {
            throw new IllegalArgumentException();
        }
    }
}
