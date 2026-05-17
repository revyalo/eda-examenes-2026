import es.urjc.grafo.EDA.examen.ElementoDominio;
import es.urjc.grafo.EDA.examen.ServicioDominio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDominioPublicTest {
    @Test
    void registraYBuscaElemento() {
        ServicioDominio servicio = new ServicioDominio();
        ElementoDominio elemento = new ElementoDominio("1", "Uno");
        assertTrue(servicio.registrar(elemento));
        assertEquals(elemento, servicio.buscar("1"));
    }
}
