package es.urjc.grafo.EDA.examen.grafos.grafos_ponderados_dijkstra;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.Vertex;

import java.util.Collection;
import java.util.List;

public class WeightedGraphDijkstraOperations {

    public static <V> int shortestWeightedDistance(AdjacencyMapGraph<V, Integer> graph,
                                                   Vertex<V> source,
                                                   Vertex<V> target) {
        // TODO: adaptar Dijkstra para devolver el coste minimo entre source y target.
        throw new UnsupportedOperationException("TODO: shortestWeightedDistance");
    }

    public static <V> List<Vertex<V>> shortestWeightedPath(AdjacencyMapGraph<V, Integer> graph,
                                                           Vertex<V> source,
                                                           Vertex<V> target) {
        // TODO: adaptar Dijkstra guardando predecesores para reconstruir el camino minimo.
        throw new UnsupportedOperationException("TODO: shortestWeightedPath");
    }

    public static <V> Collection<Vertex<V>> reachableWithCostAtMost(AdjacencyMapGraph<V, Integer> graph,
                                                                    Vertex<V> source,
                                                                    int maxCost) {
        // TODO: devolver los vertices alcanzables desde source con coste acumulado <= maxCost.
        throw new UnsupportedOperationException("TODO: reachableWithCostAtMost");
    }

    public static <V> List<Vertex<V>> kClosestVertices(AdjacencyMapGraph<V, Integer> graph,
                                                       Vertex<V> source,
                                                       int k) {
        // TODO: devolver los k vertices distintos de source con menor distancia ponderada.
        throw new UnsupportedOperationException("TODO: kClosestVertices");
    }

    public static <V> Vertex<V> nearestTarget(AdjacencyMapGraph<V, Integer> graph,
                                              Vertex<V> source,
                                              Collection<Vertex<V>> targets) {
        // TODO: devolver el destino de targets mas cercano a source usando Dijkstra.
        throw new UnsupportedOperationException("TODO: nearestTarget");
    }

    public static <V> int multiSourceShortestDistance(AdjacencyMapGraph<V, Integer> graph,
                                                      Collection<Vertex<V>> sources,
                                                      Vertex<V> target) {
        // TODO: calcular la distancia minima desde cualquiera de los origenes hasta target.
        throw new UnsupportedOperationException("TODO: multiSourceShortestDistance");
    }

    public static <V> int weightedEccentricity(AdjacencyMapGraph<V, Integer> graph,
                                               Vertex<V> vertex) {
        // TODO: devolver la mayor distancia minima ponderada desde vertex al resto de vertices.
        throw new UnsupportedOperationException("TODO: weightedEccentricity");
    }

    public static <V> Vertex<V> weightedCenter(AdjacencyMapGraph<V, Integer> graph) {
        // TODO: devolver el vertice con menor excentricidad ponderada.
        throw new UnsupportedOperationException("TODO: weightedCenter");
    }

    public static <V> List<Vertex<V>> cheapestPathWithMaxEdges(AdjacencyMapGraph<V, Integer> graph,
                                                               Vertex<V> source,
                                                               Vertex<V> target,
                                                               int maxEdges) {
        // TODO: buscar el camino mas barato usando como maximo maxEdges aristas.
        throw new UnsupportedOperationException("TODO: cheapestPathWithMaxEdges");
    }

    public static <V> List<Vertex<V>> shortestPathAvoidingVertex(AdjacencyMapGraph<V, Integer> graph,
                                                                 Vertex<V> source,
                                                                 Vertex<V> target,
                                                                 Vertex<V> forbidden) {
        // TODO: buscar el camino minimo sin visitar el vertice forbidden.
        throw new UnsupportedOperationException("TODO: shortestPathAvoidingVertex");
    }
}
