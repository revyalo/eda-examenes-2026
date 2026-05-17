package es.urjc.grafo.EDA.examen;

public record Empleado(Integer id, String nombre) {
    public Empleado {
        if (id == null || nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
