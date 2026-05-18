package es.urjc.grafo.EDA.examen.ruta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ManualGraphWarmupTest {
    @Test
    void existsPathLessOrEqualDebeImplementarse() {
        ManualGraphWarmup graph = new ManualGraphWarmup();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        assertTrue(graph.existsPathLessOrEqual("A", "B", 1));
    }
}
