package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class AlergiasCentrosSanitariosTest {

    @Test
    void primerMetodoDebeImplementarse() {
        AlergiasCentrosSanitarios servicio = new AlergiasCentrosSanitarios();
        assertDoesNotThrow(() -> servicio.addCentro("A"));
    }
}
