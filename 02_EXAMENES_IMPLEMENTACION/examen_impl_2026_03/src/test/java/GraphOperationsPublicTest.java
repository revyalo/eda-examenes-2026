import es.urjc.grafo.EDA.examen.GraphOperations;
import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Edge;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphOperationsPublicTest {

    @Test
    void componentesEnGrafoVacioYAislados() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        assertEquals(0, GraphOperations.componentesConexas(graph));
        graph.insertVertex("A");
        graph.insertVertex("B");
        assertEquals(2, GraphOperations.componentesConexas(graph));
    }

    @Test
    void componentesEnGrafoConDosBloques() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(c, d, 1);
        assertEquals(2, GraphOperations.componentesConexas(graph));
    }

    @Test
    void detectaPuenteEnCadena() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Edge<Integer> ab = graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        assertTrue(GraphOperations.esPuente(graph, ab));
    }
}
