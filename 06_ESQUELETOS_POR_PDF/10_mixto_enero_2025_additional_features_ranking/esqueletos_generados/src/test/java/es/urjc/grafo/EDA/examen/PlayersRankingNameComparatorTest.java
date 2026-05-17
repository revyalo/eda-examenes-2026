package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PlayersRankingNameComparatorTest {

    @Test
    void ejercicioDebeImplementarse() {
        PlayersRankingNameComparator servicio = new PlayersRankingNameComparator();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
