package es.urjc.grafo.EDA.graphs;

import es.urjc.grafo.EDA.utils.Pair;

import java.util.Collection;

public interface DirectedGraph<V, E> {
    /**
     * @return all vertices of the graph.
     */
    Collection<Vertex<V>> vertices();

    /**
     * @return all the edges of the graph.
     */
    Collection<Edge<E>> edges();

    /**
     * Returns a Collection of edges where the vertex v is the end vertex.
     *
     * @return an iterable collection of the edges incident upon vertex v.
     */
    Collection<Edge<E>> incidentEdges(Vertex<V> v);

    /**
     * @return the end vertex of the edge e distinct of e.
     */
    Vertex<V> opposite(Vertex<V> v, Edge<E> e);

    /**
     * @return the end vertex of the edge.
     */
    Vertex<V> endVertex(Edge<E> edge);

    /**
     * Returns a Pair of vertices. The first vertex is the start vertex of the edge, and the second vertex is
     * the end vertex.
     *
     * @param edge an edge of the graph
     * @return a pair of vertices
     */
    Pair<Vertex<V>, Vertex<V>> endVertices(Edge<E> edge);

    /**
     * @return the start vertex of the edge.
     */
    Vertex<V> startVertex(Edge<E> edge);

    /**
     * Test whether vertices v1 and v2 are adjacent. That is, if there exists an edge where v1 is the start vertex
     * and v2 is the end vertex. If the graph is directed, this is not the same as the adjacency of v2 and v1.
     *
     * @return true if are adjacent
     */
    boolean areAdjacent(Vertex<V> v1, Vertex<V> v2);

    /**
     * Test whether vertices v1 and v2 are adjacent.
     *
     * @return the edge if are adjacent, or null if not.
     */
    Edge<E> getEdge(Vertex<V> v1, Vertex<V> v2);

    /**
     * Returns the edge from v1 to v2, or null if they are not adjacent,
     * and the edge from v2 to v1, or null if they are not adjacent.
     *
     * @param v1 vertex
     * @param v2 vertex
     * @return edges from v1 to v2 and from v2 to v1, if they are not null.
     */
    Pair<Edge<E>, Edge<E>> getEdges(Vertex<V> v1, Vertex<V> v2);

    /**
     * Insert and return a new vertex storing element value.
     * If the vertex already exists, then nothing is done.
     */
    Vertex<V> insertVertex(V value);

    /**
     * Insert and return a new undirected edge with end vertices
     * v1 and v2 and storing element vertexValue.
     * If there already exists an edge with these vertices, then the value of the edge is replaced.
     */
    Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue);

    /**
     * Returns a Collection of edges where vertex v is the origin vertex.
     *
     * @param v a vertex
     * @return the output edges of a vertex
     */
    Collection<Edge<E>> outputEdges(Vertex<V> v);

    /**
     * Remove vertex v and all its incident edges.
     *
     * @return the element stored at vertex
     */
    V removeVertex(Vertex<V> vertex);

    /**
     * Remove edge
     *
     * @return the element stored at e.
     */
    E removeEdge(Edge<E> edge);

    /**
     * Returns a collection of vertices that can be reached from vertex following a single edge.
     * That is, all vertices that are the end vertex of edges where the specified vertex is the origin.
     *
     * @param vertex a vertex
     * @return the reachable vertices from vertex
     */
    Collection<Vertex<V>> reachableVertices(Vertex<V> vertex);
}
