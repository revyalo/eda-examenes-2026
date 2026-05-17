import es.urjc.grafo.EDA.examen.EstructuraPendiente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstructuraPendienteAdvancedTest {
    @Test
    void admiteVariosElementos() {
        EstructuraPendiente<String> estructura = new EstructuraPendiente<>();
        estructura.add("A");
        estructura.add("B");
        assertEquals(2, estructura.size());
    }
}
