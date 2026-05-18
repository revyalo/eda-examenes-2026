package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphOperationsExam02Test {
    @Test
    void graphDiameterDebeImplementarse() {

AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
Vertex<String> a = graph.insertVertex("A");
Vertex<String> b = graph.insertVertex("B");
Vertex<String> c = graph.insertVertex("C");
graph.insertEdge(a, b, 1);
graph.insertEdge(b, c, 1);

        assertEquals(2, GraphOperationsExam02.graphDiameter(graph));
    }

    @Test
    void centralVertexDebeImplementarse() {

AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
Vertex<String> a = graph.insertVertex("A");
Vertex<String> b = graph.insertVertex("B");
Vertex<String> c = graph.insertVertex("C");
graph.insertEdge(a, b, 1);
graph.insertEdge(b, c, 1);

        assertNotNull(GraphOperationsExam02.centralVertex(graph));
    }
}
