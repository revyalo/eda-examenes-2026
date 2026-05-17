import es.urjc.grafo.EDA.examen.GraphOperations;
import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Edge;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphOperationsAdvancedTest {

    @Test
    void parametrosInvalidosLanzanExcepcion() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.componentesConexas(null));
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.esPuente(graph, null));
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.esPuente(null, null));
    }

    @Test
    void aristaEnCicloNoEsPuente() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Edge<Integer> ab = graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, a, 1);
        assertFalse(GraphOperations.esPuente(graph, ab));
        assertEquals(1, GraphOperations.componentesConexas(graph));
    }

    @Test
    void puenteEntreCicloYHoja() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, a, 1);
        Edge<Integer> cd = graph.insertEdge(c, d, 1);
        assertTrue(GraphOperations.esPuente(graph, cd));
    }
}
