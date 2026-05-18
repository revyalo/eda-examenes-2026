package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LigaDeportivaRankingTest {

    @Test
    void primerMetodoDebeImplementarse() {
        LigaDeportivaRanking servicio = new LigaDeportivaRanking();
        assertDoesNotThrow(() -> servicio.addEquipo("A"));
    }
}
