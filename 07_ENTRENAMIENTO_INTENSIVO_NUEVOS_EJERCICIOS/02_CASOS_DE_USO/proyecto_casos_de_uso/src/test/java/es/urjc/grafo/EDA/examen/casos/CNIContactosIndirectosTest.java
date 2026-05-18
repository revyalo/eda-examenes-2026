package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CNIContactosIndirectosTest {

    @Test
    void primerMetodoDebeImplementarse() {
        CNIContactosIndirectos servicio = new CNIContactosIndirectos();
        assertDoesNotThrow(() -> servicio.addAgente("A"));
    }
}
