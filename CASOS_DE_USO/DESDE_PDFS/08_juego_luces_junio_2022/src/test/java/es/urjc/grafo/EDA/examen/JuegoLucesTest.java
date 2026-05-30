package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class JuegoLucesTest {

        @Test
        void lucesBasicas() {
            JuegoLuces juego = new JuegoLuces();
            assertTrue(juego.addBombilla(new Bombilla("A", "Z1")));
            assertTrue(juego.addBombilla(new Bombilla("B", "Z1")));
            assertTrue(juego.connect("A", "B"));
            assertTrue(juego.toggle("A"));
            assertEquals(2, juego.propagar("A", 1));
            assertEquals(1, juego.encendidasEnComponente("A"));
        }

}
