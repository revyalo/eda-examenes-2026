package es.urjc.grafo.EDA.examen;



public record Team(String id, String city, int points) implements Comparable<Team> {
    @Override
    public int compareTo(Team other) {

        int cmp = Integer.compare(other.points(), this.points());
        if (cmp != 0) {
            return cmp;
        }
        return this.id().compareTo(other.id());

    }
}
