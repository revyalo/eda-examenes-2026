package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RedElectricaSinGraphTest {

    @Test
    void primerMetodoDebeImplementarse() {
        RedElectricaSinGraph servicio = new RedElectricaSinGraph();
        assertDoesNotThrow(() -> servicio.addEstacion("A"));
    }
}
