package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class JuegoLucesAvanzadoTest {

    @Test
    void primerMetodoDebeImplementarse() {
        JuegoLucesAvanzado servicio = new JuegoLucesAvanzado();
        assertDoesNotThrow(() -> servicio.addBombilla("A"));
    }
}
