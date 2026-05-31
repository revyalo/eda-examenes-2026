package es.urjc.grafo.EDA.examen;

import java.util.Objects;

public class Player {

    private final String name;
    private final Integer number;

    public Player(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player other)) {
            return false;
        }
        return Objects.equals(name, other.name) && Objects.equals(number, other.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
