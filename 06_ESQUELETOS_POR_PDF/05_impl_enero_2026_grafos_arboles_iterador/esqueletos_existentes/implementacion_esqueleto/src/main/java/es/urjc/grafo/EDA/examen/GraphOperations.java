package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;

/**
 * Clase que contiene operaciones sobre grafos.
 * Se asume que todos los grafos recibidos en estas operaciones son no dirigidos y no ponderados.
 */
public class GraphOperations {

    /**
     * Determina si existe un camino de longitud menor o igual a n entre dos vértices.
     *
     * @param graph grafo no dirigido y no ponderado
     * @param start vértice de inicio
     * @param end   vértice de fin
     * @param n     longitud máxima del camino
     * @param <V>
     * @param <E>
     * @return true si existe un camino de longitud menor o igual a n entre start y end
     */
    public static <V, E> boolean existeCaminoDeLongitudMenorOIgualAN(AdjacencyMapGraph<V, E> graph, Vertex<V> start, Vertex<V> end, int n) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Devuelve la potencia k-ésima de un grafo.
     * El grafo k-ésimo potencia de un grafo G es un grafo
     * que contiene una arista entre dos vértices u y v
     * si existe un camino de longitud menor o igual que k entre u y v en G.
     * <p>
     * Si el grafo es nulo, lanza la excepción IllegalArgumentException
     * Si k es menor que 1, lanza la excepción IllegalArgumentException
     *
     * @param graph Un grafo no dirigido y no ponderado
     * @param k
     * @param <V>
     * @param <E>
     * @return
     */
    public static <V, E> AdjacencyMapGraph<V, E> kPower(AdjacencyMapGraph<V, E> graph, int k) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
