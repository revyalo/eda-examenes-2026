package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BasketballLeagueCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        BasketballLeagueCasoUso servicio = new BasketballLeagueCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
