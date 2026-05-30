package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class BasketballLeagueTest {

        @Test
        void ligaBasica() {
            BasketballLeague league = new BasketballLeague();
            assertTrue(league.addTeam(new Team("MAD", "Madrid", 0)));
            assertTrue(league.addTeam(new Team("BCN", "Barcelona", 0)));
            assertTrue(league.recordResult("MAD", "BCN"));
            assertNotNull(league.topTeams(2));
            assertNotNull(league.teamsBetweenPoints(0, 5));
        }

}
