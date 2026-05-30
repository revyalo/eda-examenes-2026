package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PlayersRankingTest {

        @Test
        void rankingBasico() {
            PlayersRanking ranking = new PlayersRanking();
            Player ana = new Player("ana1", "Ana", 20);
            Player bob = new Player("bob1", "Bob", 15);
            assertTrue(ranking.addPlayer(ana));
            assertTrue(ranking.addPlayer(bob));
            assertFalse(ranking.addPlayer(ana));
            assertTrue(ranking.updateScore("bob1", 30));
            assertEquals(bob, ranking.findByNick("bob1"));
            assertNotNull(ranking.top(2));
            assertNotNull(ranking.playersBetweenScores(10, 40));
        }

}
