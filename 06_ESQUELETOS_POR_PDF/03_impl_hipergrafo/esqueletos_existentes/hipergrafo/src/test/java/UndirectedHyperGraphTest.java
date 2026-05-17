import es.urjc.grafo.EDA.graphs.AdjacencyMapUndirectedHyperGraph;
import es.urjc.grafo.EDA.graphs.Edge;
import es.urjc.grafo.EDA.graphs.UndirectedHyperGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class UndirectedHyperGraphTest {

    private UndirectedHyperGraph<String, String> graph;
    private Vertex<String> v1, v2, v3, v4, v5, v6, v7, v8;

    public UndirectedHyperGraphTest() {
    }

    @BeforeEach
    public void setUp() {
        this.graph = new AdjacencyMapUndirectedHyperGraph<>();
    }


    @Test
    public void testVertices() {
        assertTrue(graph.isEmpty());
        v1 = graph.insertVertex("Madrid");
        v2 = graph.insertVertex("Barcelona");
        assertFalse(graph.isEmpty());
        List<Vertex<String>> asList = Arrays.asList(v1, v2);
        Iterable<Vertex<String>> vertices = graph.vertices();
        assertEquals(asList.size(), graph.size());
        Set<Vertex<String>> set = new HashSet<>();
        for (Vertex<String> vertex : vertices) {
            assertTrue(asList.contains(vertex));
            set.add(vertex);
        }
        assertEquals(asList.size(), set.size());
    }

    @Test
    public void testEdges() {
        assertTrue(graph.isEmpty());
        v1 = graph.insertVertex("Madrid");
        v2 = graph.insertVertex("Barcelona");
        v3 = graph.insertVertex("San Sebastian");
        v4 = graph.insertVertex("Sevilla");
        v5 = graph.insertVertex("Zaragoza");
        v6 = graph.insertVertex("Burgos");
        assertFalse(graph.isEmpty());
        Edge<String> e1 = graph.insertEdge(Arrays.asList(v1, v2, v5), "A2");
        Edge<String> e2 = graph.insertEdge(Arrays.asList(v1, v6, v3), "A1");
        List<Edge<String>> l = Arrays.asList(e1, e2);
        Iterable<Edge<String>> edges = graph.edges();
        Set<Edge<String>> set = new HashSet<>();
        for (Edge<String> edge : edges) {
            assertTrue(l.contains(edge));
            set.add(edge);
        }
        assertEquals(l.size(), set.size());
        assertTrue(set.containsAll(l));
    }


    @Test
    public void testIncidentEdges() {
        assertTrue(graph.isEmpty());
        v1 = graph.insertVertex("Madrid");
        v2 = graph.insertVertex("Barcelona");
        v3 = graph.insertVertex("San Sebastian");
        v4 = graph.insertVertex("Sevilla");
        v5 = graph.insertVertex("Zaragoza");
        v6 = graph.insertVertex("Burgos");
        assertFalse(graph.isEmpty());
        Edge<String> e1 = graph.insertEdge(Arrays.asList(v1, v2, v5), "A2");
        Edge<String> e2 = graph.insertEdge(Arrays.asList(v1, v6, v3), "A1");
        List<Edge<String>> l = Arrays.asList(e1, e2);
        Iterable<Edge<String>> edges = graph.incidentEdges(v1);
        Set<Edge<String>> set = new HashSet<>();
        for (Edge<String> edge : edges) {
            assertTrue(l.contains(edge));
            set.add(edge);
        }
        assertEquals(l.size(), set.size());

        l = Arrays.asList(e1);
        Iterable<Edge<String>> incidentV2 = graph.incidentEdges(v2);
        Iterable<Edge<String>> incidentV5 = graph.incidentEdges(v5);

        set.clear();
        for (Edge<String> edge : incidentV2) {
            assertTrue(l.contains(edge));
            set.add(edge);
        }
        assertEquals(l.size(), set.size());

        set.clear();
        for (Edge<String> edge : incidentV5) {
            assertTrue(l.contains(edge));
            set.add(edge);
        }
        assertEquals(l.size(), set.size());
    }


    @Test
    public void testOthers() {
        assertTrue(graph.isEmpty());
        v1 = graph.insertVertex("Madrid");
        v2 = graph.insertVertex("Barcelona");
        v3 = graph.insertVertex("San Sebastian");
        v4 = graph.insertVertex("Sevilla");
        v5 = graph.insertVertex("Zaragoza");
        v6 = graph.insertVertex("Burgos");
        assertFalse(graph.isEmpty());
        Edge<String> e1 = graph.insertEdge(Arrays.asList(v1, v2, v5), "A2");
        Edge<String> e2 = graph.insertEdge(Arrays.asList(v1, v6, v3), "A1");
        List<Vertex<String>> l = Arrays.asList(v2, v5);
        Iterable<Vertex<String>> others = graph.others(v1, e1);
        Set<Vertex<String>> set = new HashSet<>();
        for (Vertex<String> vertex : others) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        l = Arrays.asList(v1, v5);
        others = graph.others(v2, e1);

        set.clear();
        for (Vertex<String> vertex : others) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        l = Arrays.asList(v1, v6);
        others = graph.others(v3, e2);
        set.clear();
        for (Vertex<String> vertex : others) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

    }


    @Test
    public void testEndVertices() {
        assertTrue(graph.isEmpty());
        v1 = graph.insertVertex("Madrid");
        v2 = graph.insertVertex("Barcelona");
        v3 = graph.insertVertex("San Sebastian");
        v4 = graph.insertVertex("Sevilla");
        v5 = graph.insertVertex("Zaragoza");
        v6 = graph.insertVertex("Burgos");
        v7 = graph.insertVertex("Cordoba");
        assertFalse(graph.isEmpty());
        Edge<String> e1 = graph.insertEdge(Arrays.asList(v1, v2, v5), "A2");
        Edge<String> e2 = graph.insertEdge(Arrays.asList(v1, v6, v3), "A1");
        Edge<String> e3 = graph.insertEdge(Arrays.asList(v1, v7, v4), "A4");
        List<Vertex<String>> l = Arrays.asList(v2, v5, v1);
        Iterable<Vertex<String>> endVertices = graph.endVertices(e1);
        Set<Vertex<String>> set = new HashSet<>();
        for (Vertex<String> vertex : endVertices) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        l = Arrays.asList(v3, v6, v1);
        endVertices = graph.endVertices(e2);
        set.clear();
        for (Vertex<String> vertex : endVertices) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        l = Arrays.asList(v4, v7, v1);
        endVertices = graph.endVertices(e3);
        set.clear();
        for (Vertex<String> vertex : endVertices) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
    }

    @Test
    public void testGetAdjacent() {
        assertTrue(graph.isEmpty());
        v1 = graph.insertVertex("Madrid");
        v2 = graph.insertVertex("Barcelona");
        v3 = graph.insertVertex("San Sebastian");
        v4 = graph.insertVertex("Sevilla");
        v5 = graph.insertVertex("Zaragoza");
        v6 = graph.insertVertex("Burgos");
        v7 = graph.insertVertex("Cordoba");
        v8 = graph.insertVertex("Cáceres");
        assertFalse(graph.isEmpty());
        Edge<String> e1 = graph.insertEdge(Arrays.asList(v8, v2, v5), "A2");
        Edge<String> e2 = graph.insertEdge(Arrays.asList(v1, v6, v3), "A1");
        Edge<String> e3 = graph.insertEdge(Arrays.asList(v2, v8, v4), "A4");

        Iterable<Edge<String>> areAdjacent = graph.getEdges(v1, v2);
        Set<Edge<String>> set = new HashSet<>();
        for (Edge<String> edge : areAdjacent) {
            set.add(edge);
        }
        assertTrue(set.isEmpty());

        areAdjacent = graph.getEdges(v2, v8);
        List<Edge<String>> l = Arrays.asList(e1, e3);
        for (Edge<String> edge : areAdjacent) {
            assertTrue(l.contains(edge));
            set.add(edge);
        }
        assertEquals(l.size(), set.size());
    }


    @Test
    public void testRemoveVertex() {
        assertTrue(graph.isEmpty());
        v1 = graph.insertVertex("Madrid");
        v2 = graph.insertVertex("Barcelona");
        v3 = graph.insertVertex("San Sebastian");
        v4 = graph.insertVertex("Sevilla");
        v5 = graph.insertVertex("Zaragoza");
        v6 = graph.insertVertex("Burgos");
        v7 = graph.insertVertex("Cordoba");
        v8 = graph.insertVertex("Cáceres");
        assertFalse(graph.isEmpty());
        Edge<String> e1 = graph.insertEdge(Arrays.asList(v8, v2, v5), "A2");
        Edge<String> e2 = graph.insertEdge(Arrays.asList(v1, v6, v3), "A1");
        Edge<String> e3 = graph.insertEdge(Arrays.asList(v2, v8, v4), "A4");

        List<Vertex<String>> l = Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8);
        Iterable<Vertex<String>> vertices = graph.vertices();
        Set<Vertex<String>> set = new HashSet<>();
        for (Vertex<String> vertex : vertices) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        List<Edge<String>> l2 = Arrays.asList(e1, e2, e3);
        Iterable<Edge<String>> edges = graph.edges();
        Set<Edge<String>> set2 = new HashSet<>();
        for (Edge<String> edge : edges) {
            assertTrue(l2.contains(edge));
            set2.add(edge);
        }
        assertEquals(l2.size(), set2.size());

        graph.removeVertex(v2);
        l = Arrays.asList(v1, v3, v4, v5, v6, v7, v8);
        vertices = graph.vertices();
        set.clear();
        for (Vertex<String> vertex : vertices) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        l2 = Arrays.asList(e1, e2, e3);
        edges = graph.edges();
        set2.clear();
        for (Edge<String> edge : edges) {
            assertTrue(l2.contains(edge));
            set2.add(edge);
        }
        assertEquals(l2.size(), set2.size());

        graph.removeVertex(v4);
        l = Arrays.asList(v1, v3, v5, v6, v7, v8);
        vertices = graph.vertices();
        set.clear();
        for (Vertex<String> vertex : vertices) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        l2 = Arrays.asList(e1, e2);
        edges = graph.edges();
        set2.clear();
        for (Edge<String> edge : edges) {
            assertTrue(l2.contains(edge));
            set2.add(edge);
        }
        assertEquals(l2.size(), set2.size());
    }

    @Test
    public void testRemoveEdge() {
        assertTrue(graph.isEmpty());
        v1 = graph.insertVertex("Madrid");
        v2 = graph.insertVertex("Barcelona");
        v3 = graph.insertVertex("San Sebastian");
        v4 = graph.insertVertex("Sevilla");
        v5 = graph.insertVertex("Zaragoza");
        v6 = graph.insertVertex("Burgos");
        v7 = graph.insertVertex("Cordoba");
        v8 = graph.insertVertex("Cáceres");
        assertFalse(graph.isEmpty());
        Edge<String> e1 = graph.insertEdge(Arrays.asList(v8, v2, v5), "A2");
        Edge<String> e2 = graph.insertEdge(Arrays.asList(v1, v6, v3), "A1");
        Edge<String> e3 = graph.insertEdge(Arrays.asList(v2, v8, v4), "A4");

        List<Vertex<String>> l = Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8);
        Iterable<Vertex<String>> vertices = graph.vertices();

        Set<Vertex<String>> set = new HashSet<>();
        for (Vertex<String> vertex : vertices) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        List<Edge<String>> l2 = Arrays.asList(e1, e2, e3);
        Iterable<Edge<String>> edges = graph.edges();
        Set<Edge<String>> set2 = new HashSet<>();
        for (Edge<String> edge : edges) {
            assertTrue(l2.contains(edge));
            set2.add(edge);
        }
        assertEquals(l2.size(), set2.size());

        graph.removeEdge(e3);
        l = Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8);
        vertices = graph.vertices();
        set.clear();
        for (Vertex<String> vertex : vertices) {
            assertTrue(l.contains(vertex));
            set.add(vertex);
        }
        assertEquals(l.size(), set.size());

        l2 = Arrays.asList(e1, e2);
        edges = graph.edges();
        set2.clear();
        for (Edge<String> edge : edges) {
            assertTrue(l2.contains(edge));
            set2.add(edge);
        }
        assertEquals(l2.size(), set2.size());
    }

}
