package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RedP2PBusquedaArchivosTest {

    @Test
    void primerMetodoDebeImplementarse() {
        RedP2PBusquedaArchivos servicio = new RedP2PBusquedaArchivos();
        assertDoesNotThrow(() -> servicio.addNode("A"));
    }
}
