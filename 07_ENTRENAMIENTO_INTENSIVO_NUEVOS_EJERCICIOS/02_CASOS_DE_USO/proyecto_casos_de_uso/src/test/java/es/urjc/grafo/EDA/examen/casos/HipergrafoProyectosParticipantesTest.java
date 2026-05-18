package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class HipergrafoProyectosParticipantesTest {

    @Test
    void primerMetodoDebeImplementarse() {
        HipergrafoProyectosParticipantes servicio = new HipergrafoProyectosParticipantes();
        assertDoesNotThrow(() -> servicio.addProyecto("A"));
    }
}
