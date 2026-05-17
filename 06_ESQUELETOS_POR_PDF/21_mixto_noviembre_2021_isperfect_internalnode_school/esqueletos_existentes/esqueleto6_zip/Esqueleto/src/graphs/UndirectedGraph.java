package graphs;

import utils.Pair;

import java.util.Collection;

public interface UndirectedGraph<V,E> extends Graph<V, E> {
    /**
     * @return all vertices of the graph.
     */
    Collection<Vertex<V>> vertices();
        
    /**
     * @return all the edges of the graph.
     */
    Collection<Edge<E>> edges();

    /**
     * @return an iterable collection of the edges incident upon vertex v.
     */
    Collection<Edge<E>> incidentEdges(Vertex<V> v);
    
    /**
     * @return the end vertex of the edge e distinct of e.
     */
    Vertex<V> opposite(Vertex<V> v, Edge<E> e);

    /**
     * Returns the pair of vertices that are connected by the given edge.
     * Order does not matter, since the graph is not directed.
     * @return an array storing the end vertices of edge.
     */
    Pair<Vertex<V>, Vertex<V>> endVertices(Edge<E> edge);

    /**
     * Test whether vertices v1 and v2 are adjacent.
     * @return true if are adjacent
     */
    boolean areAdjacent(Vertex<V> v1, Vertex<V> v2);

    /**
     * Test whether vertices v1 and v2 are adjacent.
     * @return the edge if are adjacent, or null if not.
     */
    Edge<E> getEdge(Vertex<V> v1, Vertex<V> v2);
            
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
     * Remove vertex v and all its incident edges.
     * @return the element stored at vertex
     */
    V removeVertex(Vertex<V> vertex);

    /**
     * Remove edge
     * @return the element stored at e.
     */
    E removeEdge(Edge<E> edge);

    /**
     * Returns a collection of the vertices adjacent to vertex.
     * That is, vertices that are connected to vertex by an edge.
     * @param vertex a vertex
     * @return a collection of the vertices adjacent to vertex
     */
    Collection<Vertex<V>> adjacentVertices(Vertex<V> vertex);
}
