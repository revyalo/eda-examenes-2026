package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class CensoURJCTest {

        @Test
        void censoBasico() {
            CensoURJC censo = new CensoURJC();
            assertTrue(censo.addHabitante(new Habitante("1", "Madrid", 20)));
            assertTrue(censo.moverHabitante("1", "Mostoles"));
            assertNotNull(censo.habitantesMunicipio("Mostoles"));
            assertNotNull(censo.habitantesEntreEdades(18, 30));
            assertTrue(censo.removeHabitante("1"));
        }

}
