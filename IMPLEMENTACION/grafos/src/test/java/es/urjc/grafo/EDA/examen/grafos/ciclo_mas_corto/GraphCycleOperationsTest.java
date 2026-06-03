package es.urjc.grafo.EDA.examen.grafos.ciclo_mas_corto;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphCycleOperationsTest {

    @Test
    void trianguloTieneCicloDeLongitudTres() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, a, 1);

        assertEquals(3, GraphCycleOperations.shortestCycleLength(graph));
    }

    @Test
    void arbolNoTieneCiclo() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);

        assertEquals(-1, GraphCycleOperations.shortestCycleLength(graph));
    }
}
