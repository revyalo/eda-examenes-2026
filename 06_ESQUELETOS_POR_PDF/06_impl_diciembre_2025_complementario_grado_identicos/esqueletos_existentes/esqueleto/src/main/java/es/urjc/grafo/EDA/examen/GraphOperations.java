package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;

/**
 * Clase que contiene operaciones sobre grafos.
 * Se asume que todos los grafos recibidos en estas operaciones son no dirigidos.
 */
public class GraphOperations {

    /**
     * Dado un grafo, construye su grafo complementario.
     * Un grafo es complementario de otro si contiene las aristas
     * que no están en el otro.
     * <p>
     * Si el grafo es nulo, lanza la excepción IllegalArgumentException
     * Si el grafo está vacío, el complementario resultante también.
     * El grafo es no dirigido y no tiene bucles (una arista que conecta un vértice consigo mismo).
     *
     * @param graph el grafo
     * @return el grafo complementario de graph
     */
    public static <V, E> AdjacencyMapGraph<V, E> complementary(AdjacencyMapGraph<V, E> graph) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
