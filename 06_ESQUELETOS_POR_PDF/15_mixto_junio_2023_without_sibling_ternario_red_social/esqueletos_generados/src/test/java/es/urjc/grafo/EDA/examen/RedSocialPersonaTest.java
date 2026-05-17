package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RedSocialPersonaTest {

    @Test
    void ejercicioDebeImplementarse() {
        RedSocialPersona servicio = new RedSocialPersona();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
