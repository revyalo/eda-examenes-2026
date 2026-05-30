package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class SyntheticIntelTest {

        @Test
        void dependenciasBasicas() {
            SyntheticIntel intel = new SyntheticIntel();
            ModeloIA a = new ModeloIA("A", "URJC", 0.90);
            ModeloIA b = new ModeloIA("B", "URJC", 0.80);
            assertTrue(intel.addModelo(a));
            assertTrue(intel.addModelo(b));
            assertTrue(intel.addDependencia("A", "B"));
            assertTrue(intel.dependeDirectamente("A", "B"));
            assertTrue(intel.dependeIndirectamente("A", "B"));
            assertNotNull(intel.modelosEntrePrecision(0.75, 1.0));
        }

}
