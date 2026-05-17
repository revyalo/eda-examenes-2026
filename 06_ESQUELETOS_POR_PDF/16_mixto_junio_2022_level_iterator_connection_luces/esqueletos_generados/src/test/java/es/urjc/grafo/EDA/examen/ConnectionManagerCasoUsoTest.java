package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ConnectionManagerCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        ConnectionManagerCasoUso servicio = new ConnectionManagerCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
