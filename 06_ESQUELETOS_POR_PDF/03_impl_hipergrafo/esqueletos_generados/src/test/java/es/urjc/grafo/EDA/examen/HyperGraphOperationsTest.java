package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class HyperGraphOperationsTest {

    @Test
    void ejercicioDebeImplementarse() {
        HyperGraphOperations<String, String> hyperGraph = new HyperGraphOperations<>();
        assertDoesNotThrow(() -> hyperGraph.insertHyperedge(java.util.List.of(), "H"));
    }
}
