package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RedP2PConnectionManagerTest {

    @Test
    void ejercicioDebeImplementarse() {
        RedP2PConnectionManager servicio = new RedP2PConnectionManager();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
