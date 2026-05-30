package es.urjc.grafo.EDA.examen;



public record Habitante(String dni, String municipio, int edad) implements Comparable<Habitante> {
    @Override
    public int compareTo(Habitante other) {

        int cmp = Integer.compare(this.edad(), other.edad());
        if (cmp != 0) {
            return cmp;
        }
        return this.dni().compareTo(other.dni());

    }
}
