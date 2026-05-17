package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class URJCFlightsCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        URJCFlightsCasoUso servicio = new URJCFlightsCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
