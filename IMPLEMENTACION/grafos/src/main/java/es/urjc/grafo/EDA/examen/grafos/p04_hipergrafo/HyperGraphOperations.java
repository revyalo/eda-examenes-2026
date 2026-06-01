package es.urjc.grafo.EDA.examen.grafos.p04_hipergrafo;

import es.urjc.grafo.EDA.graphs.AdjacencyMapUndirectedHyperGraph;
import es.urjc.grafo.EDA.graphs.Vertex;

public class HyperGraphOperations<V, E> {

    private final AdjacencyMapUndirectedHyperGraph<V, E> hyperGraph = new AdjacencyMapUndirectedHyperGraph<>();

    public Vertex<V> insertVertex(V value) {
        return hyperGraph.insertVertex(value);
    }

    public void insertHyperedge(Iterable<Vertex<V>> vertices, E value) {
        // TODO: completar o delegar segun el enunciado del PDF.
        throw new UnsupportedOperationException("TODO: insertHyperedge");
    }
}
