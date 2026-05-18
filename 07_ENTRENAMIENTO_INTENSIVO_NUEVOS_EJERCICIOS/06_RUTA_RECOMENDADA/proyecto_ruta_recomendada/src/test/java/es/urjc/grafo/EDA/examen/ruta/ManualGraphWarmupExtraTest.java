package es.urjc.grafo.EDA.examen.ruta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManualGraphWarmupExtraTest {
    private ManualGraphWarmup sampleGraph() {
        ManualGraphWarmup graph = new ManualGraphWarmup();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        return graph;
    }

    @Test void dfsYBfsDebenImplementarse() {
        ManualGraphWarmup graph = sampleGraph();
        assertTrue(graph.dfsReachable("A").contains("C"));
        assertTrue(graph.bfs("A").contains("C"));
    }

    @Test void distanciasDebenImplementarse() {
        ManualGraphWarmup graph = sampleGraph();
        assertTrue(graph.existsPathDFS("A", "C"));
        assertEquals(2, graph.distance("A", "C"));
    }

    @Test void componentesYComplementarioDebenImplementarse() {
        ManualGraphWarmup graph = sampleGraph();
        assertEquals(1, graph.connectedComponents());
        assertTrue(graph.isConnected());
        assertNotNull(graph.complementary());
    }
}
