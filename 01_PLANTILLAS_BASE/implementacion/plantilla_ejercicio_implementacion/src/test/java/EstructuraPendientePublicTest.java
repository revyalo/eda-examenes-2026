import es.urjc.grafo.EDA.examen.EstructuraPendiente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstructuraPendientePublicTest {
    @Test
    void addIncrementaSize() {
        EstructuraPendiente<Integer> estructura = new EstructuraPendiente<>();
        assertTrue(estructura.add(1));
        assertEquals(1, estructura.size());
    }
}
