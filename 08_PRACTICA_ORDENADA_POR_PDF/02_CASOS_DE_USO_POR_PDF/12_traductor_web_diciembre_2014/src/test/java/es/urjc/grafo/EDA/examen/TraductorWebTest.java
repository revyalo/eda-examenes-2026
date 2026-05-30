package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TraductorWebTest {

        @Test
        void traductorBasico() {
            TraductorWeb traductor = new TraductorWeb();
            assertTrue(traductor.addTraduccion("en", "hola", "hello"));
            assertEquals("hello", traductor.traducir("en", "hola"));
            assertNotNull(traductor.palabrasDeIdioma("en"));
            assertNotNull(traductor.palabrasEntre("a", "z"));
        }

}
