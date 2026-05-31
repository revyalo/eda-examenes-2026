package es.urjc.grafo.EDA.examen;

public class PlayersRanking {

    // TODO: define aqui los atributos privados necesarios.

    public boolean addNewPlayer(Player p) {
        // TODO: anadir jugador al ranking en O(log n).
        throw new UnsupportedOperationException("TODO: addNewPlayer");
    }

    public boolean removePlayer(Player p) {
        // TODO: eliminar jugador del ranking.
        throw new UnsupportedOperationException("TODO: removePlayer");
    }

    public Iterable<Player> playersWithRanking(Integer r) {
        // TODO: devolver jugadores con esa puntuacion ordenados por NameComparator.
        throw new UnsupportedOperationException("TODO: playersWithRanking");
    }

    public boolean modificationRankingPlayer(Player p, Integer diferencia) {
        // TODO: modificar los puntos del jugador y mantener indices coherentes.
        throw new UnsupportedOperationException("TODO: modificationRankingPlayer");
    }

    public Iterable<Player> allPlayers() {
        // TODO: devolver todos los jugadores de mayor a menor puntuacion.
        throw new UnsupportedOperationException("TODO: allPlayers");
    }
}
