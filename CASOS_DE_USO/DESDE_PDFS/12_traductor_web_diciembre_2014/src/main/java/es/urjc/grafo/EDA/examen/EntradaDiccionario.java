package es.urjc.grafo.EDA.examen;



public record EntradaDiccionario(String idioma, String palabra, String traduccion) implements Comparable<EntradaDiccionario> {
    @Override
    public int compareTo(EntradaDiccionario other) {

        int cmp = this.idioma().compareTo(other.idioma());
        if (cmp != 0) {
            return cmp;
        }
        return this.palabra().compareTo(other.palabra());

    }
}
