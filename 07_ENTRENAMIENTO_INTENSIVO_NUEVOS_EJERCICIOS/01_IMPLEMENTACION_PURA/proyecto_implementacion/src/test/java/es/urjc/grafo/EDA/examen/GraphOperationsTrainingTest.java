package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphOperationsTrainingTest {
    @Test
    void shortestDistanceLessOrEqualDebeImplementarse() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        graph.insertEdge(a, b, "AB");
        assertEquals(1, GraphOperationsTraining.shortestDistanceLessOrEqual(graph, a, b, 2));
    }
}
