package es.urjc.grafo.EDA.examen.grafos.p24_grafos_additional_features.grafos;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalFeaturesTest {

    @Test
    void isTreeAceptaNuloVacioYArbolConexo() {
        assertTrue(AdditionalFeatures.<String, Integer>isTree(null));

        AdjacencyMapGraph<String, Integer> empty = new AdjacencyMapGraph<>(false);
        assertTrue(AdditionalFeatures.isTree(empty));

        AdjacencyMapGraph<String, Integer> tree = new AdjacencyMapGraph<>(false);
        Vertex<String> a = tree.insertVertex("A");
        Vertex<String> b = tree.insertVertex("B");
        Vertex<String> c = tree.insertVertex("C");
        Vertex<String> d = tree.insertVertex("D");
        tree.insertEdge(a, b, 1);
        tree.insertEdge(a, c, 1);
        tree.insertEdge(c, d, 1);

        assertTrue(AdditionalFeatures.isTree(tree));
    }

    @Test
    void isTreeDetectaCiclosYNoConectividad() {
        AdjacencyMapGraph<String, Integer> cycle = new AdjacencyMapGraph<>(false);
        Vertex<String> a = cycle.insertVertex("A");
        Vertex<String> b = cycle.insertVertex("B");
        Vertex<String> c = cycle.insertVertex("C");
        cycle.insertEdge(a, b, 1);
        cycle.insertEdge(b, c, 1);
        cycle.insertEdge(c, a, 1);
        assertFalse(AdditionalFeatures.isTree(cycle));

        AdjacencyMapGraph<String, Integer> disconnected = new AdjacencyMapGraph<>(false);
        Vertex<String> x = disconnected.insertVertex("X");
        Vertex<String> y = disconnected.insertVertex("Y");
        disconnected.insertVertex("Z");
        disconnected.insertEdge(x, y, 1);
        assertFalse(AdditionalFeatures.isTree(disconnected));
    }

    @Test
    void sourceVertexDevuelveSoloVerticesFuenteConSalida() {
        AdjacencyMapGraph<String, Integer> directed = new AdjacencyMapGraph<>(true);
        Vertex<String> a = directed.insertVertex("A");
        Vertex<String> b = directed.insertVertex("B");
        Vertex<String> c = directed.insertVertex("C");
        Vertex<String> d = directed.insertVertex("D");
        directed.insertEdge(a, b, 1);
        directed.insertEdge(a, c, 1);
        directed.insertEdge(b, c, 1);
        directed.insertEdge(c, d, 1);

        Collection<Vertex<String>> result = AdditionalFeatures.sourceVertex(directed);
        Set<String> values = result.stream().map(Vertex::getElement).collect(Collectors.toSet());

        assertEquals(Set.of("A"), values);
    }

    @Test
    void isCompleteDistingueGrafoCompletoDeCamino() {
        assertFalse(AdditionalFeatures.<String, Integer>isComplete(null));

        AdjacencyMapGraph<String, Integer> complete = new AdjacencyMapGraph<>(false);
        Vertex<String> a = complete.insertVertex("A");
        Vertex<String> b = complete.insertVertex("B");
        Vertex<String> c = complete.insertVertex("C");
        complete.insertEdge(a, b, 1);
        complete.insertEdge(a, c, 1);
        complete.insertEdge(b, c, 1);
        assertTrue(AdditionalFeatures.isComplete(complete));

        AdjacencyMapGraph<String, Integer> path = new AdjacencyMapGraph<>(false);
        Vertex<String> x = path.insertVertex("X");
        Vertex<String> y = path.insertVertex("Y");
        Vertex<String> z = path.insertVertex("Z");
        path.insertEdge(x, y, 1);
        path.insertEdge(y, z, 1);
        assertFalse(AdditionalFeatures.isComplete(path));
    }
}
