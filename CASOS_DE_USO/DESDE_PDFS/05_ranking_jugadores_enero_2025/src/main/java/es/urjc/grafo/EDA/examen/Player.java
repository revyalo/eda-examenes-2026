package es.urjc.grafo.EDA.examen;

import java.util.Objects;

public class Player implements Comparable<Player> {

    private final String name;
    private final String surname;
    private int ranking;

    public Player(String name, String surname, int ranking) {
        this.name = name;
        this.surname = surname;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public int compareTo(Player other) {
        int byRanking = Integer.compare(other.ranking, this.ranking);
        if (byRanking != 0) {
            return byRanking;
        }
        return new NameComparator().compare(this, other);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player other)) {
            return false;
        }
        return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
