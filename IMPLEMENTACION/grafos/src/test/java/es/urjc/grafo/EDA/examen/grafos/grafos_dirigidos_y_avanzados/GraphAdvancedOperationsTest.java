package es.urjc.grafo.EDA.examen.grafos.grafos_dirigidos_y_avanzados;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Edge;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphAdvancedOperationsTest {

    private static <V> List<V> elements(Iterable<Vertex<V>> vertices) {
        List<V> result = new ArrayList<>();
        for (Vertex<V> vertex : vertices) {
            result.add(vertex.getElement());
        }
        return result;
    }

    @Test
    void stronglyConnectedRequiresReachabilityInBothDirections() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(true);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, a, 1);

        assertTrue(GraphAdvancedOperations.isStronglyConnected(graph));
    }

    @Test
    void topologicalSortPlacesPredecessorsBeforeSuccessors() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(true);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);

        List<String> order = elements(GraphAdvancedOperations.topologicalSort(graph));

        assertTrue(order.indexOf("A") < order.indexOf("B"));
        assertTrue(order.indexOf("B") < order.indexOf("C"));
    }

    @Test
    void directedCycleIsDetected() {
        AdjacencyMapGraph<Integer, Integer> graph = new AdjacencyMapGraph<>(true);
        Vertex<Integer> one = graph.insertVertex(1);
        Vertex<Integer> two = graph.insertVertex(2);
        Vertex<Integer> three = graph.insertVertex(3);
        graph.insertEdge(one, two, 1);
        graph.insertEdge(two, three, 1);
        graph.insertEdge(three, one, 1);

        assertTrue(GraphAdvancedOperations.hasCycleDirected(graph));
    }

    @Test
    void transitiveClosureAddsReachabilityEdges() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(true);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);

        AdjacencyMapGraph<String, Integer> closure = GraphAdvancedOperations.transitiveClosure(graph);

        assertNotNull(closure.getEdge("A", "C"));
    }

    @Test
    void minimumEdgesToConnectCountsComponentsMinusOne() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertEdge(a, b, 1);

        assertEquals(1, GraphAdvancedOperations.minimumEdgesToConnect(graph));
    }

    @Test
    void bridgesReturnsCriticalEdges() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, "AB");
        Edge<String> bridge = graph.insertEdge(b, c, "BC");

        assertTrue(GraphAdvancedOperations.bridges(graph).contains(bridge));
    }

    @Test
    void centerMinimizesEccentricity() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);

        assertEquals("B", GraphAdvancedOperations.center(graph).getElement());
        assertEquals(1, GraphAdvancedOperations.eccentricity(graph, b));
    }

    @Test
    void reachableWithinKEdgesUsesDirection() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(true);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);

        Collection<Vertex<String>> reachable = GraphAdvancedOperations.reachableWithinKEdgesDirected(graph, a, 1);

        assertTrue(elements(reachable).contains("B"));
        assertFalse(elements(reachable).contains("C"));
    }

    @Test
    void forestAcceptsSeveralTreeComponents() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertVertex("D");
        assertTrue(GraphAdvancedOperations.isForest(graph));
    }

    @Test
    void articulationPointsTarjanFindsCutVertices() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);

        assertTrue(GraphAdvancedOperations.articulationPointsTarjan(graph).contains(b));
    }
}
