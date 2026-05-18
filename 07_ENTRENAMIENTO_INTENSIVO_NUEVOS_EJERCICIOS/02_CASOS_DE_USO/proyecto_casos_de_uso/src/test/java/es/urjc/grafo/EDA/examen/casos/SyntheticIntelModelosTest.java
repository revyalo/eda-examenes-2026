package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SyntheticIntelModelosTest {

    @Test
    void primerMetodoDebeImplementarse() {
        SyntheticIntelModelos servicio = new SyntheticIntelModelos();
        assertDoesNotThrow(() -> servicio.addModelo("A"));
    }
}
