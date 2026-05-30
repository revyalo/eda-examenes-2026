package es.urjc.grafo.EDA.graphs;

import java.util.Collection;

public interface UndirectedHyperGraph<V, E> {

    boolean isEmpty();

    int size();

    /**
     * @return all vertices of the graph.
     */
    Iterable<Vertex<V>> vertices();

    /**
     * @return all the edges of the graph.
     */
    Iterable<Edge<E>> edges();

    /**
     * @param v
     * @return an iterable collection of the edges incident upon vertex v.
     */
    Iterable<Edge<E>> incidentEdges(Vertex<V> v);

    /**
     * @param v
     * @param e
     * @return
     * @returns a Collection containing all the vertices of the edge e without the Vertex v
     */
    Iterable<Vertex<V>> others(Vertex<V> v, Edge<E> e);

    /**
     * @param edge
     * @return a Collection storing all the vertices of edge.
     */
    Iterable<Vertex<V>> endVertices(Edge<E> edge);

    /**
     * Test whether vertices v1 and v2 are adjacent.
     *
     * @param v1
     * @param v2
     * @return the Collection of edges if are adjacent, or null if not.
     */
    Iterable<Edge<E>> getEdges(Vertex<V> v1, Vertex<V> v2);

    /**
     * Insert and return a new vertex storing element value.
     *
     * @param value
     * @return a new vertex
     */
    Vertex<V> insertVertex(V value);

    /**
     * Insert and return a new undirected edge with all vertices
     * in c.
     * If already exists an edge with this vertices the edge is replaced.
     *
     * @param vertices
     * @param edgeValue
     * @return a new undirected edge
     */
    Edge<E> insertEdge(Collection<Vertex<V>> vertices, E edgeValue);


    /**
     * Remove vertex v and all its incident edges.
     *
     * @param vertex
     * @return the element stored at vertex
     */
    V removeVertex(Vertex<V> vertex);

    /**
     * Remove edge
     *
     * @param edge
     * @return the element stored at e.
     */
    E removeEdge(Edge<E> edge);

    Iterable<Vertex<V>> reachableVertices(Vertex<V> vertex);

}
