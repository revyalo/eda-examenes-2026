package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class RedElectricaEspanolaTest {

        @Test
        void redElectricaBasica() {
            RedElectricaEspanola red = new RedElectricaEspanola();
            Area norte = new Area("N", "Norte");
            CentralElectrica c1 = new CentralElectrica("C1", "N", 100);
            CentralElectrica c2 = new CentralElectrica("C2", "N", 80);
            assertTrue(red.addArea(norte));
            assertTrue(red.addCentral(c1));
            assertTrue(red.addCentral(c2));
            assertTrue(red.conectar("C1", "C2"));
            assertTrue(red.estanConectadas("C1", "C2"));
            assertNotNull(red.centralesDeArea("N"));
            assertEquals(c1, red.centralMasConectada());
        }

}
