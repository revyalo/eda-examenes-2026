package es.urjc.grafo.EDA.examen.grafos.grafos_ponderados_dijkstra;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeightedGraphDijkstraOperationsTest {

    private static class WeightedGraphFixture {
        final AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        final Vertex<String> a = graph.insertVertex("A");
        final Vertex<String> b = graph.insertVertex("B");
        final Vertex<String> c = graph.insertVertex("C");
        final Vertex<String> d = graph.insertVertex("D");
        final Vertex<String> e = graph.insertVertex("E");

        WeightedGraphFixture() {
            graph.insertEdge(a, b, 2);
            graph.insertEdge(a, c, 5);
            graph.insertEdge(b, c, 1);
            graph.insertEdge(b, d, 4);
            graph.insertEdge(c, d, 1);
            graph.insertEdge(c, e, 2);
            graph.insertEdge(d, e, 3);
        }
    }

    private static <V> List<V> elements(Iterable<Vertex<V>> vertices) {
        List<V> result = new ArrayList<>();
        for (Vertex<V> vertex : vertices) {
            result.add(vertex.getElement());
        }
        return result;
    }

    @Test
    void shortestWeightedDistanceUsesCheapestAccumulatedCost() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        int distance = WeightedGraphDijkstraOperations.shortestWeightedDistance(
                fixture.graph, fixture.a, fixture.d);

        assertEquals(4, distance);
    }

    @Test
    void shortestWeightedDistanceReturnsMinusOneWhenTargetIsUnreachable() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");

        assertEquals(-1, WeightedGraphDijkstraOperations.shortestWeightedDistance(graph, a, b));
    }

    @Test
    void shortestWeightedPathReturnsVerticesInOrder() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        List<Vertex<String>> path = WeightedGraphDijkstraOperations.shortestWeightedPath(
                fixture.graph, fixture.a, fixture.d);

        assertEquals(List.of("A", "B", "C", "D"), elements(path));
    }

    @Test
    void reachableWithCostAtMostIncludesSourceAndCheapVerticesOnly() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        Collection<Vertex<String>> reachable = WeightedGraphDijkstraOperations.reachableWithCostAtMost(
                fixture.graph, fixture.a, 3);

        assertEquals(Set.of("A", "B", "C"), new HashSet<>(elements(reachable)));
    }

    @Test
    void kClosestVerticesExcludesSourceAndReturnsTheNearestOnes() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        List<Vertex<String>> closest = WeightedGraphDijkstraOperations.kClosestVertices(
                fixture.graph, fixture.a, 3);

        assertEquals(List.of("B", "C", "D"), elements(closest));
    }

    @Test
    void nearestTargetReturnsCheapestTargetAmongCandidates() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        Vertex<String> nearest = WeightedGraphDijkstraOperations.nearestTarget(
                fixture.graph, fixture.a, List.of(fixture.d, fixture.e));

        assertEquals("D", nearest.getElement());
    }

    @Test
    void multiSourceShortestDistanceStartsFromAllSourcesAtCostZero() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        int distance = WeightedGraphDijkstraOperations.multiSourceShortestDistance(
                fixture.graph, List.of(fixture.a, fixture.d), fixture.e);

        assertEquals(3, distance);
    }

    @Test
    void weightedEccentricityIsTheWorstShortestDistanceFromVertex() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        assertEquals(5, WeightedGraphDijkstraOperations.weightedEccentricity(fixture.graph, fixture.a));
    }

    @Test
    void weightedCenterMinimizesWeightedEccentricity() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        Vertex<String> center = WeightedGraphDijkstraOperations.weightedCenter(fixture.graph);

        assertEquals("C", center.getElement());
    }

    @Test
    void cheapestPathWithMaxEdgesUsesEdgeLimitAsPartOfTheState() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(true);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        Vertex<String> e = graph.insertVertex("E");
        Vertex<String> f = graph.insertVertex("F");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, d, 10);
        graph.insertEdge(a, c, 5);
        graph.insertEdge(c, d, 1);
        graph.insertEdge(a, e, 1);
        graph.insertEdge(e, f, 1);
        graph.insertEdge(f, d, 1);

        List<Vertex<String>> path = WeightedGraphDijkstraOperations.cheapestPathWithMaxEdges(graph, a, d, 2);

        assertEquals(List.of("A", "C", "D"), elements(path));
    }

    @Test
    void shortestPathAvoidingVertexCannotUseTheForbiddenVertex() {
        WeightedGraphFixture fixture = new WeightedGraphFixture();

        List<Vertex<String>> path = WeightedGraphDijkstraOperations.shortestPathAvoidingVertex(
                fixture.graph, fixture.a, fixture.e, fixture.c);

        assertEquals(List.of("A", "B", "D", "E"), elements(path));
    }

    @Test
    void negativeWeightsAreRejectedBecauseDijkstraDoesNotSupportThem() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        graph.insertEdge(a, b, -1);

        assertThrows(IllegalArgumentException.class,
                () -> WeightedGraphDijkstraOperations.shortestWeightedDistance(graph, a, b));
    }

    @Test
    void nullGraphIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> WeightedGraphDijkstraOperations.weightedCenter(null));
    }

    @Test
    void directedGraphsRespectEdgeDirection() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(true);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        graph.insertEdge(a, b, 4);

        assertEquals(-1, WeightedGraphDijkstraOperations.shortestWeightedDistance(graph, b, a));
    }
}
