package es.urjc.grafo.EDA.examen;

import java.util.Collection;
import java.util.Date;

public class BasketballLeague {

    // TODO: define aqui los atributos privados necesarios.

    public boolean insertTeam(Team team) {
        // TODO: insertar un equipo en la liga.
        throw new UnsupportedOperationException("TODO: insertTeam");
    }

    public boolean insertGame(Team homeTeam, Team awayTeam, Date time, String result) {
        // TODO: insertar partido local-visitante.
        throw new UnsupportedOperationException("TODO: insertGame");
    }

    public Collection<Team> listTeams() {
        // TODO: devolver todos los equipos.
        throw new UnsupportedOperationException("TODO: listTeams");
    }

    public Collection<Game> listGames() {
        // TODO: devolver todos los partidos.
        throw new UnsupportedOperationException("TODO: listGames");
    }

    public Player getPlayer(Team t, Integer number) {
        // TODO: devolver jugador de un equipo por dorsal en O(1).
        throw new UnsupportedOperationException("TODO: getPlayer");
    }

    public Collection<Game> listGamesBetween(Team t1, Team t2) {
        // TODO: devolver partidos entre t1 y t2.
        throw new UnsupportedOperationException("TODO: listGamesBetween");
    }

    public Collection<Game> listHomeGames(Team t) {
        // TODO: devolver partidos donde t fue local.
        throw new UnsupportedOperationException("TODO: listHomeGames");
    }

    public boolean transferPlayer(Team t1, Player p1, Team t2, Player p2) {
        // TODO: intercambiar jugadores entre equipos respetando dorsales.
        throw new UnsupportedOperationException("TODO: transferPlayer");
    }
}
