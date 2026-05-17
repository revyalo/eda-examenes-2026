package es.urjc.grafo.EDA.examen;

public record ElementoDominio(String id, String nombre) {
    public ElementoDominio {
        if (id == null || nombre == null) {
            throw new IllegalArgumentException();
        }
    }
}
