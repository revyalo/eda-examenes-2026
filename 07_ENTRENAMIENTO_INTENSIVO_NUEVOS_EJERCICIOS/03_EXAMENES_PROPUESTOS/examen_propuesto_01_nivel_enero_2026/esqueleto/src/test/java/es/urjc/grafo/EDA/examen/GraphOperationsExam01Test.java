package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphOperationsExam01Test {
    @Test
    void verticesWithinDistanceKDebeImplementarse() {

AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
Vertex<String> a = graph.insertVertex("A");
Vertex<String> b = graph.insertVertex("B");
Vertex<String> c = graph.insertVertex("C");
graph.insertEdge(a, b, 1);
graph.insertEdge(b, c, 1);

        assertNotNull(GraphOperationsExam01.verticesWithinDistanceK(graph, a, 2));
    }

    @Test
    void kPowerOptimizedDebeImplementarse() {

AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
Vertex<String> a = graph.insertVertex("A");
Vertex<String> b = graph.insertVertex("B");
Vertex<String> c = graph.insertVertex("C");
graph.insertEdge(a, b, 1);
graph.insertEdge(b, c, 1);

        assertNotNull(GraphOperationsExam01.kPowerOptimized(graph, 2));
    }
}
