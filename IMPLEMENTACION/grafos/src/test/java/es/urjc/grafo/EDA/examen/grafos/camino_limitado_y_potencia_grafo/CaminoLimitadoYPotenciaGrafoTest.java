package es.urjc.grafo.EDA.examen.grafos.camino_limitado_y_potencia_grafo;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CaminoLimitadoYPotenciaGrafoTest {

    @Test
    void ejercicioDebeImplementarse() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> a = graph.insertVertex("A");
        Vertex<String> b = graph.insertVertex("B");
        graph.insertEdge(a, b, "AB");

        assertNotNull(GraphOperations.kPower(graph, 1));
    }
}
