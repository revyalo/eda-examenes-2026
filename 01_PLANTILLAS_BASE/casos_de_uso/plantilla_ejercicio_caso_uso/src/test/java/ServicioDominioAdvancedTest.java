import es.urjc.grafo.EDA.examen.ElementoDominio;
import es.urjc.grafo.EDA.examen.ServicioDominio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDominioAdvancedTest {
    @Test
    void noDuplicaIdentificador() {
        ServicioDominio servicio = new ServicioDominio();
        assertTrue(servicio.registrar(new ElementoDominio("1", "Uno")));
        assertFalse(servicio.registrar(new ElementoDominio("1", "Repetido")));
    }
}
