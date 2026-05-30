package es.urjc.grafo.EDA.examen;



public record ModeloIA(String id, String empresa, double precision) implements Comparable<ModeloIA> {
    @Override
    public int compareTo(ModeloIA other) {

        int cmp = Double.compare(other.precision(), this.precision());
        if (cmp != 0) {
            return cmp;
        }
        return this.id().compareTo(other.id());

    }
}
