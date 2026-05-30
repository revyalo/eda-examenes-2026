package es.urjc.grafo.EDA.examen;



public record Player(String nick, String name, int score) implements Comparable<Player> {
    @Override
    public int compareTo(Player other) {

        int cmp = Integer.compare(other.score(), this.score());
        if (cmp != 0) {
            return cmp;
        }
        return this.nick().compareTo(other.nick());

    }
}
