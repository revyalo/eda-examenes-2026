package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AssignmentGraphWarmupTest {
    @Test
    void existeCaminoDebeImplementarse() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        graph.insertEdge(a, b, 1);
        assertTrue(AssignmentGraphWarmup.existeCaminoDeLongitudMenorOIgualAN(graph, a, b, 1));
    }
}
