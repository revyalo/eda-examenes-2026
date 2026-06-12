package es.urjc.grafo.EDA.examen.grafos.practica_extra_grafos_2026;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GraphExtraOperationsTest {

    private static <V> Set<V> elements(Iterable<Vertex<V>> vertices) {
        Set<V> result = new HashSet<>();
        for (Vertex<V> vertex : vertices) {
            result.add(vertex.getElement());
        }
        return result;
    }

    private static <V> List<V> orderedElements(Iterable<Vertex<V>> vertices) {
        List<V> result = new ArrayList<>();
        for (Vertex<V> vertex : vertices) {
            result.add(vertex.getElement());
        }
        return result;
    }

    @Test
    void shortestDistanceRespectsLimit() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, d, 1);

        assertEquals(3, GraphExtraOperations.shortestDistanceLessOrEqual(graph, a, d, 3));
        assertEquals(-1, GraphExtraOperations.shortestDistanceLessOrEqual(graph, a, d, 2));
    }

    @Test
    void verticesAtExactDistance() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        Vertex<String> e = graph.insertVertex("E");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(a, c, 1);
        graph.insertEdge(b, d, 1);
        graph.insertEdge(c, e, 1);

        assertEquals(Set.of("D", "E"), elements(GraphExtraOperations.verticesAtDistanceK(graph, a, 2)));
    }

    @Test
    void countsConnectedComponents() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(c, d, 1);

        assertEquals(2, GraphExtraOperations.connectedComponents(graph));
    }

    @Test
    void computesDiameterOnlyIfConnected() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, d, 1);

        assertEquals(3, GraphExtraOperations.graphDiameter(graph));
    }

    @Test
    void detectsBipartiteConflict() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, a, 1);

        assertFalse(GraphExtraOperations.isBipartite(graph));
    }

    @Test
    void countsSeveralShortestPaths() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(a, c, 1);
        graph.insertEdge(b, d, 1);
        graph.insertEdge(c, d, 1);

        assertEquals(2, GraphExtraOperations.countShortestPaths(graph, a, d));
    }

    @Test
    void shortestPathWithForbiddenVerticesAvoidsBlockedNodes() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        Vertex<String> e = graph.insertVertex("E");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, d, 1);
        graph.insertEdge(a, c, 1);
        graph.insertEdge(c, e, 1);
        graph.insertEdge(e, d, 1);

        assertEquals(List.of("A", "C", "E", "D"),
                orderedElements(GraphExtraOperations.shortestPathWithForbiddenVertices(graph, a, d, Set.of(b))));
    }

    @Test
    void uniqueShortestPathDistinguishesTies() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, d, 1);
        graph.insertEdge(a, c, 1);
        graph.insertEdge(c, d, 1);

        assertFalse(GraphExtraOperations.hasUniqueShortestPath(graph, a, d));
    }

    @Test
    void graphRadiusIsMinimumEccentricity() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, d, 1);

        assertEquals(2, GraphExtraOperations.graphRadius(graph));
    }

    @Test
    void minimumStopsPathReturnsEmptyWhenPathExceedsLimit() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);

        assertEquals(List.of("A", "B", "C"),
                orderedElements(GraphExtraOperations.minimumStopsPath(graph, a, c, 2)));
        assertTrue(GraphExtraOperations.minimumStopsPath(graph, a, c, 1).isEmpty());
    }
}
