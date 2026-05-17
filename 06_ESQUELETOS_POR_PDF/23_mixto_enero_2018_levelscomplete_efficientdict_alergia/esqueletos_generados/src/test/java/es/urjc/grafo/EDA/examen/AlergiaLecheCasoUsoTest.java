package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AlergiaLecheCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        AlergiaLecheCasoUso servicio = new AlergiaLecheCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
