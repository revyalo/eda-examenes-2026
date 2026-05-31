package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketballLeagueTest {

    @Test
    void equiposPartidosYTraspasos() {
        BasketballLeague league = new BasketballLeague();
        Team madrid = new Team("Madrid");
        Team barcelona = new Team("Barcelona");
        Player p7 = new Player("Base", 7);
        Player p9 = new Player("Pivot", 9);
        Player p11 = new Player("Alero", 11);
        Player p12 = new Player("Escolta", 12);
        madrid.addPlayer(p7);
        madrid.addPlayer(p9);
        barcelona.addPlayer(p11);
        barcelona.addPlayer(p12);

        assertTrue(league.insertTeam(madrid));
        assertTrue(league.insertTeam(barcelona));
        assertTrue(league.insertGame(madrid, barcelona, new java.util.Date(1000), "80-75"));
        assertEquals(java.util.Set.of(madrid, barcelona), java.util.Set.copyOf(league.listTeams()));
        assertEquals(1, league.listGamesBetween(madrid, barcelona).size());
        assertEquals(1, league.listHomeGames(madrid).size());
        assertEquals(p7, league.getPlayer(madrid, 7));
        assertTrue(league.transferPlayer(madrid, p7, barcelona, p11));
        assertEquals(p11, league.getPlayer(madrid, 11));
    }
}
