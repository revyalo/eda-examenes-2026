package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentGraphWarmupExtraTest {
    private AdjacencyMapGraph<String, Integer> sampleGraph() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        return graph;
    }

    @Test void operacionesBaseDebenImplementarse() {
        AdjacencyMapGraph<String, Integer> graph = sampleGraph();
        assertEquals(1, AssignmentGraphWarmup.connectedComponents(graph));
        assertNotNull(AssignmentGraphWarmup.complementary(graph));
    }

    @Test void operacionesAvanzadasDebenImplementarse() {
        AdjacencyMapGraph<String, Integer> graph = sampleGraph();
        assertNotNull(AssignmentGraphWarmup.kPower(graph, 2));
        assertEquals(2, AssignmentGraphWarmup.diameter(graph));
        assertNotNull(AssignmentGraphWarmup.centralVertex(graph));
    }
}
