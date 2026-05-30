package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RedElectricaEspanolaTest {

    @Test
    void ejercicioDebeImplementarse() {
        RedElectricaEspanola servicio = new RedElectricaEspanola();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
