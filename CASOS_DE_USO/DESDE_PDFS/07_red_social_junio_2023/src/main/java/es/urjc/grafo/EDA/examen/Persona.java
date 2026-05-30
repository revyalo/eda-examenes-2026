package es.urjc.grafo.EDA.examen;



public record Persona(String nick, String ciudad, int popularidad) implements Comparable<Persona> {
    @Override
    public int compareTo(Persona other) {

        int cmp = Integer.compare(other.popularidad(), this.popularidad());
        if (cmp != 0) {
            return cmp;
        }
        return this.nick().compareTo(other.nick());

    }
}
