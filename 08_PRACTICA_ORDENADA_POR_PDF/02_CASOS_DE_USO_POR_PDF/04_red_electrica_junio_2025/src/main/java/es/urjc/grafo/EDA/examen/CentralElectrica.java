package es.urjc.grafo.EDA.examen;



public record CentralElectrica(String id, String areaId, int potencia) implements Comparable<CentralElectrica> {
    @Override
    public int compareTo(CentralElectrica other) {

        int cmp = Integer.compare(other.potencia(), this.potencia());
        if (cmp != 0) {
            return cmp;
        }
        return this.id().compareTo(other.id());

    }
}
