package es.urjc.grafo.EDA.examen;

public record Voter(String dni, String street, String fullName) implements Comparable<Voter> {

    @Override
    public int compareTo(Voter other) {
        return this.dni.compareTo(other.dni);
    }
}
