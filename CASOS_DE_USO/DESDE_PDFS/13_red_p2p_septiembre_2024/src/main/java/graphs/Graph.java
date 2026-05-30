package graphs;

import utils.Pair;

import java.util.Collection;

public interface Graph<V,E> {

    Collection<Vertex<V>> vertices();

    Collection<Edge<E>> edges();

    Collection<Edge<E>> incidentEdges(Vertex<V> v);

    Vertex<V> opposite(Vertex<V> v, Edge<E> e);

    Pair<Vertex<V>, Vertex<V>> endVertices(Edge<E> edge);

    boolean areAdjacent(Vertex<V> v1, Vertex<V> v2);

    Edge<E> getEdge(Vertex<V> v1, Vertex<V> v2);

    Vertex<V> getVertex(V v);

    Vertex<V> insertVertex(V value);

    Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue);

    V removeVertex(Vertex<V> vertex);

    E removeEdge(Edge<E> edge);

    Collection<Vertex<V>> reachableVertices(Vertex<V> vertex);
}
