package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayersRankingTest {

    @Test
    void comparadorOrdenaPorApellidoYNombre() {
        NameComparator comparator = new NameComparator();
        assertTrue(comparator.compare(
                new Player("Ana", "Lopez", 100),
                new Player("Luis", "Ruiz", 50)) > 0);
        assertTrue(comparator.compare(
                new Player("Luis", "Ruiz", 50),
                new Player("Ana", "Lopez", 100)) < 0);
        assertEquals(0, comparator.compare(
                new Player("Ana", "Lopez", 100),
                new Player("Ana", "Lopez", 200)));
    }

    @Test
    void rankingPermiteAltasConsultasYModificaciones() {
        PlayersRanking ranking = new PlayersRanking();
        Player ana = new Player("Ana", "Lopez", 10);
        Player luis = new Player("Luis", "Ruiz", 20);

        assertTrue(ranking.addNewPlayer(ana));
        assertTrue(ranking.addNewPlayer(luis));
        assertFalse(ranking.addNewPlayer(new Player("Ana", "Lopez", 30)));
        assertIterableEquals(java.util.List.of(luis, ana), ranking.allPlayers());
        assertIterableEquals(java.util.List.of(ana), ranking.playersWithRanking(10));
        assertTrue(ranking.modificationRankingPlayer(ana, 15));
        assertIterableEquals(java.util.List.of(ana, luis), ranking.allPlayers());
        assertTrue(ranking.removePlayer(luis));
    }
}
