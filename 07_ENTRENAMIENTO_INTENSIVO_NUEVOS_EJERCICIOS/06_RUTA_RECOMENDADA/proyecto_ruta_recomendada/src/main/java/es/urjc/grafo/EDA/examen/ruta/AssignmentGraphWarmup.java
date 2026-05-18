package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;

public class AssignmentGraphWarmup {

    public static <V, E> boolean existeCaminoDeLongitudMenorOIgualAN(AdjacencyMapGraph<V, E> graph, Vertex<V> origin, Vertex<V> destination, int n) {
        // TODO: BFS limitado usando incidentEdges/opposite.
        throw new UnsupportedOperationException("TODO: existeCaminoDeLongitudMenorOIgualAN");
    }

    public static <V, E> int connectedComponents(AdjacencyMapGraph<V, E> graph) {
        // TODO: repetir BFS/DFS desde no visitados.
        throw new UnsupportedOperationException("TODO: connectedComponents");
    }

    public static <V, E> AdjacencyMapGraph<V, E> complementary(AdjacencyMapGraph<V, E> graph) {
        // TODO: crear grafo complementario.
        throw new UnsupportedOperationException("TODO: complementary");
    }

    public static <V, E> AdjacencyMapGraph<V, E> kPower(AdjacencyMapGraph<V, E> graph, int k) {
        // TODO: grafo potencia mediante BFS por vértice.
        throw new UnsupportedOperationException("TODO: kPower");
    }

    public static <V, E> int diameter(AdjacencyMapGraph<V, E> graph) {
        // TODO: BFS desde cada vértice.
        throw new UnsupportedOperationException("TODO: diameter");
    }

    public static <V, E> Vertex<V> centralVertex(AdjacencyMapGraph<V, E> graph) {
        // TODO: vértice con menor excentricidad.
        throw new UnsupportedOperationException("TODO: centralVertex");
    }
}
