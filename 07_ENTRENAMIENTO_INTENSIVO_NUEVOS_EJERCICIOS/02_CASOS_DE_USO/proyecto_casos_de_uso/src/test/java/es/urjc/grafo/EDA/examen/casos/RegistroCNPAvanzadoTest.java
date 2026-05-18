package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RegistroCNPAvanzadoTest {

    @Test
    void primerMetodoDebeImplementarse() {
        RegistroCNPAvanzado servicio = new RegistroCNPAvanzado();
        assertDoesNotThrow(() -> servicio.addOpositor("A"));
    }
}
