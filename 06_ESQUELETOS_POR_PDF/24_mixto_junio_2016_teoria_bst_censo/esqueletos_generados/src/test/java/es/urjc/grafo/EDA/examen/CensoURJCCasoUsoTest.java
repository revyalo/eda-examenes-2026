package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CensoURJCCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        CensoURJCCasoUso servicio = new CensoURJCCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
