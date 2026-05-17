package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DetectorInteraccionesCNITest {

    @Test
    void ejercicioDebeImplementarse() {
        DetectorInteraccionesCNI servicio = new DetectorInteraccionesCNI();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
