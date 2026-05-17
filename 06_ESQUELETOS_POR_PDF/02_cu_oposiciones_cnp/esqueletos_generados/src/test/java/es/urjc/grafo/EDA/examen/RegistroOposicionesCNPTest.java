package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RegistroOposicionesCNPTest {

    @Test
    void ejercicioDebeImplementarse() {
        RegistroOposicionesCNP servicio = new RegistroOposicionesCNP();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
