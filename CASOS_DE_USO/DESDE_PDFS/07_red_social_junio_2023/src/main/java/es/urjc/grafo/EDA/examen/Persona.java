package es.urjc.grafo.EDA.examen;

import java.util.Objects;

public class Persona {

    private final String username;

    public Persona(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Persona other)) {
            return false;
        }
        return Objects.equals(username, other.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
