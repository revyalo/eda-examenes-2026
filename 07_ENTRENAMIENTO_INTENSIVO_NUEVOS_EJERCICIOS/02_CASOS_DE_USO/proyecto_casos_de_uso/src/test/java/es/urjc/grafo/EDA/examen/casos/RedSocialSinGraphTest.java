package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RedSocialSinGraphTest {

    @Test
    void primerMetodoDebeImplementarse() {
        RedSocialSinGraph servicio = new RedSocialSinGraph();
        assertDoesNotThrow(() -> servicio.addPersona("A"));
    }
}
