package es.urjc.grafo.EDA.examen.grafos.p03_diciembre_2025_euler_descendants_symmetric;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GraphOperationsTest {

    @Test
    void ejercicioDebeImplementarse() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        graph.insertEdge(a, b, "AB");

        assertTrue(GraphOperations.isEulerianGraph(graph));
    }
}
