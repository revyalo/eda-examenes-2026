package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ISPRIPRouterAlgorithmTest {

    @Test
    void ejercicioDebeImplementarse() {
        ISPRIPRouterAlgorithm servicio = new ISPRIPRouterAlgorithm();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
