package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SyntheticIntelCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        SyntheticIntelCasoUso servicio = new SyntheticIntelCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
