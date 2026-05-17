package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class URJCInvestCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        URJCInvestCasoUso servicio = new URJCInvestCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
