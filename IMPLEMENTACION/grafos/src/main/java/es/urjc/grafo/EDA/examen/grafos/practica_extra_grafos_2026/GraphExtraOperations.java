package es.urjc.grafo.EDA.examen.grafos.practica_extra_grafos_2026;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;

import java.util.Collection;
import java.util.List;

public class GraphExtraOperations {

    public static <V, E> int shortestDistanceLessOrEqual(AdjacencyMapGraph<V, E> graph,
                                                         Vertex<V> start,
                                                         Vertex<V> end,
                                                         int limit) {
        // TODO: calcula la distancia minima si es menor o igual que limit.
        throw new UnsupportedOperationException("TODO: shortestDistanceLessOrEqual");
    }

    public static <V, E> Iterable<Vertex<V>> verticesAtDistanceK(AdjacencyMapGraph<V, E> graph,
                                                                 Vertex<V> start,
                                                                 int k) {
        // TODO: devuelve los vertices que estan exactamente a distancia k.
        throw new UnsupportedOperationException("TODO: verticesAtDistanceK");
    }

    public static <V, E> int connectedComponents(AdjacencyMapGraph<V, E> graph) {
        // TODO: cuenta las componentes conexas del grafo.
        throw new UnsupportedOperationException("TODO: connectedComponents");
    }

    public static <V, E> int graphDiameter(AdjacencyMapGraph<V, E> graph) {
        // TODO: calcula el diametro; devuelve -1 si el grafo no es conexo.
        throw new UnsupportedOperationException("TODO: graphDiameter");
    }

    public static <V, E> boolean isBipartite(AdjacencyMapGraph<V, E> graph) {
        // TODO: colorea por niveles y detecta conflictos.
        throw new UnsupportedOperationException("TODO: isBipartite");
    }

    public static <V, E> int countShortestPaths(AdjacencyMapGraph<V, E> graph,
                                                Vertex<V> start,
                                                Vertex<V> end) {
        // TODO: cuenta caminos minimos con BFS.
        throw new UnsupportedOperationException("TODO: countShortestPaths");
    }

    public static <V, E> List<Vertex<V>> shortestPathWithForbiddenVertices(AdjacencyMapGraph<V, E> graph,
                                                                           Vertex<V> start,
                                                                           Vertex<V> end,
                                                                           Collection<Vertex<V>> forbidden) {
        // TODO: devolver un camino minimo evitando todos los vertices prohibidos.
        throw new UnsupportedOperationException("TODO: shortestPathWithForbiddenVertices");
    }

    public static <V, E> boolean hasUniqueShortestPath(AdjacencyMapGraph<V, E> graph,
                                                       Vertex<V> start,
                                                       Vertex<V> end) {
        // TODO: comprobar si existe exactamente un camino minimo entre start y end.
        throw new UnsupportedOperationException("TODO: hasUniqueShortestPath");
    }

    public static <V, E> int graphRadius(AdjacencyMapGraph<V, E> graph) {
        // TODO: devolver la minima excentricidad del grafo; si no es conexo, devolver -1.
        throw new UnsupportedOperationException("TODO: graphRadius");
    }

    public static <V, E> List<Vertex<V>> minimumStopsPath(AdjacencyMapGraph<V, E> graph,
                                                          Vertex<V> start,
                                                          Vertex<V> end,
                                                          int maxStops) {
        // TODO: devolver un camino con el menor numero de aristas si no supera maxStops.
        throw new UnsupportedOperationException("TODO: minimumStopsPath");
    }
}
