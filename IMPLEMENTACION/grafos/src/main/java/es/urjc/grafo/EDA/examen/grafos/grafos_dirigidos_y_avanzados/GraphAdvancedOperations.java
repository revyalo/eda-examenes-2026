package es.urjc.grafo.EDA.examen.grafos.grafos_dirigidos_y_avanzados;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.DirectedGraph;
import es.urjc.grafo.EDA.graphs.Edge;
import es.urjc.grafo.EDA.graphs.Vertex;

import java.util.Collection;

public class GraphAdvancedOperations {

    public static <V, E> boolean isStronglyConnected(DirectedGraph<V, E> graph) {
        // TODO: comprobar si todo vertice alcanza a todos los demas siguiendo aristas dirigidas.
        throw new UnsupportedOperationException("TODO: isStronglyConnected");
    }

    public static <V, E> Iterable<Vertex<V>> topologicalSort(DirectedGraph<V, E> graph) {
        // TODO: devolver un orden topologico si el grafo dirigido no tiene ciclos.
        throw new UnsupportedOperationException("TODO: topologicalSort");
    }

    public static <V, E> boolean hasCycleDirected(DirectedGraph<V, E> graph) {
        // TODO: detectar ciclos dirigidos usando estados de visita o estrategia equivalente.
        throw new UnsupportedOperationException("TODO: hasCycleDirected");
    }

    public static <V, E> AdjacencyMapGraph<V, Integer> transitiveClosure(DirectedGraph<V, E> graph) {
        // TODO: construir el cierre transitivo dirigido: u -> v si v es alcanzable desde u.
        throw new UnsupportedOperationException("TODO: transitiveClosure");
    }

    public static <V, E> int minimumEdgesToConnect(AdjacencyMapGraph<V, E> graph) {
        // TODO: devolver componentesConexas - 1 en un grafo no dirigido.
        throw new UnsupportedOperationException("TODO: minimumEdgesToConnect");
    }

    public static <V, E> Collection<Edge<E>> bridges(AdjacencyMapGraph<V, E> graph) {
        // TODO: devolver las aristas cuya eliminacion aumenta el numero de componentes.
        throw new UnsupportedOperationException("TODO: bridges");
    }

    public static <V, E> int eccentricity(AdjacencyMapGraph<V, E> graph, Vertex<V> vertex) {
        // TODO: devolver la mayor distancia minima desde vertex a cualquier otro vertice alcanzable.
        throw new UnsupportedOperationException("TODO: eccentricity");
    }

    public static <V, E> Vertex<V> center(AdjacencyMapGraph<V, E> graph) {
        // TODO: devolver el vertice con menor excentricidad. Si hay empate, usar orden de iteracion estable.
        throw new UnsupportedOperationException("TODO: center");
    }

    public static <V, E> Collection<Vertex<V>> reachableWithinKEdgesDirected(DirectedGraph<V, E> graph,
                                                                            Vertex<V> start,
                                                                            int k) {
        // TODO: devolver vertices alcanzables desde start usando como maximo k aristas dirigidas.
        throw new UnsupportedOperationException("TODO: reachableWithinKEdgesDirected");
    }

    public static <V, E> boolean isForest(AdjacencyMapGraph<V, E> graph) {
        // TODO: comprobar que cada componente conexa del grafo no dirigido es un arbol.
        throw new UnsupportedOperationException("TODO: isForest");
    }

    public static <V, E> Collection<Vertex<V>> articulationPointsTarjan(AdjacencyMapGraph<V, E> graph) {
        // TODO: devolver puntos de articulacion con una estrategia eficiente tipo Tarjan.
        throw new UnsupportedOperationException("TODO: articulationPointsTarjan");
    }
}
