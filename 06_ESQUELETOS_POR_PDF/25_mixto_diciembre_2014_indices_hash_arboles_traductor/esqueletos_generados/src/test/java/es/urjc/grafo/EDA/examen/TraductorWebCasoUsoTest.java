package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TraductorWebCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        TraductorWebCasoUso servicio = new TraductorWebCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
