package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class RedSocialTest {

        @Test
        void relacionesBasicas() {
            RedSocial red = new RedSocial();
            assertTrue(red.addPersona(new Persona("ana", "Madrid", 0)));
            assertTrue(red.addPersona(new Persona("bob", "Madrid", 0)));
            assertTrue(red.seguir("ana", "bob"));
            assertFalse(red.sonAmigos("ana", "bob"));
            assertTrue(red.seguir("bob", "ana"));
            assertTrue(red.sonAmigos("ana", "bob"));
            assertNotNull(red.sugerencias("ana"));
        }

}
