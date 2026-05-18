package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class URJCFlightsSinGraphTest {

    @Test
    void primerMetodoDebeImplementarse() {
        URJCFlightsSinGraph servicio = new URJCFlightsSinGraph();
        assertDoesNotThrow(() -> servicio.addAirport("A"));
    }
}
