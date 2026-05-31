package es.urjc.grafo.EDA.examen.simulacro;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphCriticalVerticesOperationsTest {

    @Test
    void cadenaTieneVerticesInternosCriticos() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        Vertex<String> d = graph.insertVertex("D");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, d, 1);

        Collection<Vertex<String>> critical = GraphCriticalVerticesOperations.verticesQueDesconectan(graph);
        assertEquals(Set.of("B", "C"), critical.stream().map(Vertex::getElement).collect(Collectors.toSet()));
    }

    @Test
    void cicloNoTieneVerticesCriticos() {
        AdjacencyMapGraph<String, Integer> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        Vertex<String> c = graph.insertVertex("C");
        graph.insertEdge(a, b, 1);
        graph.insertEdge(b, c, 1);
        graph.insertEdge(c, a, 1);

        assertEquals(0, GraphCriticalVerticesOperations.verticesQueDesconectan(graph).size());
    }
}
