package es.urjc.grafo.EDA.examen;

import java.util.Collection;
import java.util.Objects;

public class Team {

    private final String name;

    // TODO: define aqui los atributos privados necesarios para los jugadores.

    public Team(String name) {
        this.name = name;
        // TODO: inicializar jugadores del equipo.
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(Player player) {
        // TODO: anadir jugador si no pertenece a otro equipo y no repite dorsal.
        throw new UnsupportedOperationException("TODO: addPlayer");
    }

    public boolean removePlayer(Player player) {
        // TODO: eliminar jugador del equipo.
        throw new UnsupportedOperationException("TODO: removePlayer");
    }

    public Player getPlayer(Integer number) {
        // TODO: devolver jugador por dorsal en O(1).
        throw new UnsupportedOperationException("TODO: getPlayer");
    }

    public Collection<Player> players() {
        // TODO: devolver jugadores del equipo.
        throw new UnsupportedOperationException("TODO: players");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Team other)) {
            return false;
        }
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
