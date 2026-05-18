package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphOperationsExam03Test {
    @Test
    void isConnectedDebeImplementarse() {

AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
Vertex<String> a = graph.insertVertex("A");
Vertex<String> b = graph.insertVertex("B");
Vertex<String> c = graph.insertVertex("C");
graph.insertEdge(a, b, 1);
graph.insertEdge(b, c, 1);

        assertTrue(GraphOperationsExam03.isConnected(graph));
    }

    @Test
    void hasCycleUndirectedDebeImplementarse() {

AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
Vertex<String> a = graph.insertVertex("A");
Vertex<String> b = graph.insertVertex("B");
Vertex<String> c = graph.insertVertex("C");
graph.insertEdge(a, b, 1);
graph.insertEdge(b, c, 1);

        assertFalse(GraphOperationsExam03.hasCycleUndirected(graph));
    }
}
