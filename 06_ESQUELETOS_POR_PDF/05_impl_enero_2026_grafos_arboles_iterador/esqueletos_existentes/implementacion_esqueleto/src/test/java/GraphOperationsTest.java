import es.urjc.grafo.EDA.examen.GraphOperations;
import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphOperationsTest {

    private AdjacencyMapGraph<String, Void> graph;
    private Vertex<String> a, b, c, d, e;

    @BeforeEach
    void setUp() {
        graph = new AdjacencyMapGraph<>(false);
        a = graph.insertVertex("A");
        b = graph.insertVertex("B");
        c = graph.insertVertex("C");
        d = graph.insertVertex("D");
        e = graph.insertVertex("E");
        graph.insertEdge(a, b, null);
        graph.insertEdge(b, c, null);
        graph.insertEdge(c, d, null);
        graph.insertEdge(a, e, null);
    }

    @Test
    void existeCamino_nuloOLimiteInvalido_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.existeCaminoDeLongitudMenorOIgualAN(null, a, b, 1));
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.existeCaminoDeLongitudMenorOIgualAN(graph, null, b, 1));
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.existeCaminoDeLongitudMenorOIgualAN(graph, a, null, 1));
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.existeCaminoDeLongitudMenorOIgualAN(graph, a, b, -1));
    }

    @Test
    void existeCamino_caminoDentroDeLimite_devuelveTrue() {
        assertTrue(GraphOperations.existeCaminoDeLongitudMenorOIgualAN(graph, a, c, 2));
        assertTrue(GraphOperations.existeCaminoDeLongitudMenorOIgualAN(graph, a, d, 3));
    }

    @Test
    void existeCamino_caminoFueraDeLimite_devuelveFalse() {
        assertFalse(GraphOperations.existeCaminoDeLongitudMenorOIgualAN(graph, a, d, 2));
    }

    @Test
    void existeCamino_sinCamino_devuelveFalse() {
        AdjacencyMapGraph<String, Void> disconGraph = new AdjacencyMapGraph<>(false);
        Vertex<String> x = disconGraph.insertVertex("X");
        Vertex<String> y = disconGraph.insertVertex("Y");
        assertFalse(GraphOperations.existeCaminoDeLongitudMenorOIgualAN(disconGraph, x, y, 1));
    }

    @Test
    void kPower_kInvalidoONulo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.kPower(null, 2));
        assertThrows(IllegalArgumentException.class, () -> GraphOperations.kPower(graph, 0));
    }

    @Test
    void kPower_kIgualUno_reproduceAdyacenciasOriginales() {
        var k1 = GraphOperations.kPower(graph, 1);
        Vertex<String> ka = k1.getVertex("A");
        Vertex<String> kb = k1.getVertex("B");
        Vertex<String> kc = k1.getVertex("C");
        Vertex<String> kd = k1.getVertex("D");
        Vertex<String> ke = k1.getVertex("E");

        assertTrue(k1.areAdjacent(ka, kb));
        assertTrue(k1.areAdjacent(kb, kc));
        assertTrue(k1.areAdjacent(kc, kd));
        assertTrue(k1.areAdjacent(ka, ke));
        assertFalse(k1.areAdjacent(ka, kc));
        assertFalse(k1.areAdjacent(kb, kd));
    }

    @Test
    void kPower_kIgualDos_conectaVerticesADistancia2() {
        var k2 = GraphOperations.kPower(graph, 2);
        Vertex<String> ka = k2.getVertex("A");
        Vertex<String> kb = k2.getVertex("B");
        Vertex<String> kc = k2.getVertex("C");
        Vertex<String> kd = k2.getVertex("D");

        assertTrue(k2.areAdjacent(ka, kc)); // A-C distancia 2 en original
        assertTrue(k2.areAdjacent(kb, kd)); // B-D distancia 2 en original
        assertFalse(k2.areAdjacent(ka, kd)); // A-D distancia 3 aún no conectada
    }

    @Test
    void kPower_kIgualTres_conectaVerticesADistancia3() {
        var k3 = GraphOperations.kPower(graph, 3);
        Vertex<String> ka = k3.getVertex("A");
        Vertex<String> kd = k3.getVertex("D");
        assertTrue(k3.areAdjacent(ka, kd)); // A-D distancia 3 en original
    }
}