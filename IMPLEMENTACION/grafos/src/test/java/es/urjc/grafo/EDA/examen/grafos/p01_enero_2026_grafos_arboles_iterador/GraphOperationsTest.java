package es.urjc.grafo.EDA.examen.grafos.p01_enero_2026_grafos_arboles_iterador;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GraphOperationsTest {

    @Test
    void ejercicioDebeImplementarse() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        graph.insertEdge(a, b, "AB");

        assertNotNull(GraphOperations.kPower(graph, 1));
    }
}
