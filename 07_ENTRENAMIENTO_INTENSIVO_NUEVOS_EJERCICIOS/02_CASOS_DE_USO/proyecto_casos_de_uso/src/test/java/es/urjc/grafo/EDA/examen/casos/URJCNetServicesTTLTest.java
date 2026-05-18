package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class URJCNetServicesTTLTest {

    @Test
    void primerMetodoDebeImplementarse() {
        URJCNetServicesTTL servicio = new URJCNetServicesTTL();
        assertDoesNotThrow(() -> servicio.addRouter("A"));
    }
}
