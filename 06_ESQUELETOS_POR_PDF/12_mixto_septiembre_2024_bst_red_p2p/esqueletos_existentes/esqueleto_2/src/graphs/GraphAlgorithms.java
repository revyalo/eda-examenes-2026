package graphs;

import utils.Pair;

import java.util.*;

/**
 * A collection of graph algorithms.
 */
public class GraphAlgorithms {

    /**
     * Performs depth-first search of the unknown portion of Graph g starting at Vertex u.
     *
     * @param g Graph instance
     * @param u Vertex of graph g that will be the source of the search
     *
     * As an outcome, this method returns the set of vertices discovered, and a list of the edges used during the
     *          exploration in the order in which they were encountered.
     *          If the edge was explored, the boolean value is True. Otherwise, if the edge was a back edge
     *          to an already known vertex, it is marked as False.
     */
    public static <V,E> Pair<Set<Vertex<V>>, List<Pair<Edge<E>, Boolean>>> DFS(Graph<V,E> g, Vertex<V> u) {
        Set<Vertex<V>> known = new HashSet<>();
        List<Pair<Edge<E>, Boolean>> exploratoryEdges = new LinkedList<>();
        Set<Edge<E>> visitedEdges = new HashSet<>(); // To avoid traversing edges twice in undirected graphs
        DFS(g, u, known, exploratoryEdges, visitedEdges);
        return new Pair<>(known, exploratoryEdges);
    }

    public static <V,E> void DFS(Graph<V,E> g, Vertex<V> u, Set<Vertex<V>> known,
                                 List<Pair<Edge<E>, Boolean>> exploratoryEdges,
                                 Set<Edge<E>> visitedEdges) {
        known.add(u);                              // u has been discovered
        for (Vertex<V> reachableVertex : g.reachableVertices(u)) {
            Edge<E> edge = g.getEdge(u, reachableVertex);
            if (!visitedEdges.contains(edge)) {
                visitedEdges.add(edge);
                if (!known.contains(reachableVertex)) {
                    exploratoryEdges.add(new Pair<>(edge, true));
                    DFS(g, reachableVertex, known, exploratoryEdges, visitedEdges);
                } else {
                    exploratoryEdges.add(new Pair<>(edge, false));
                }
            }
        }
    }

    /**
     * Performs breadth-first search of the undiscovered portion of Graph g starting at Vertex s.
     *
     * @param g Graph instance
     * @param u Vertex of graph g that will be the source of the search
     *
     * As an outcome, this method returns the set of vertices discovered, and a list of the edges used during the
     *          exploration in the order in which they were encountered.
     *          If the edge was explored, the boolean value is True. Otherwise, if the edge was a back edge
     *          to an already known vertex, it is marked as False.
     */
    public static <V,E> Pair<Set<Vertex<V>>, List<Pair<Edge<E>, Boolean>>> BFS(Graph<V,E> g, Vertex<V> u) {
        Set<Vertex<V>> known = new HashSet<>();
        List<Pair<Edge<E>, Boolean>> exploratoryEdges = new LinkedList<>();
        BFS(g, u, known, exploratoryEdges);
        return new Pair<>(known, exploratoryEdges);
    }

    public static <V,E> void BFS(Graph<V,E> g, Vertex<V> s, Set<Vertex<V>> known,
                                 List<Pair<Edge<E>, Boolean>> exploratoryEdges) {
        List<Vertex<V>> currentLevel = new LinkedList<>();
        Set<Edge<E>> visitedEdges = new HashSet<>(); // To avoid traversing edges twice in undirected graphs
        known.add(s);
        currentLevel.addLast(s);                          // first level includes only s
        while (!currentLevel.isEmpty()) {
            List<Vertex<V>> nextLevel = new LinkedList<>();
            for (Vertex<V> u : currentLevel)
                for (Vertex<V> v : g.reachableVertices(u)) {
                    Edge<E> e = g.getEdge(u, v);
                    if (!visitedEdges.contains(e)) {
                        if (!known.contains(v)) {
                            known.add(v);
                            exploratoryEdges.add(new Pair<>(e, true));
                            nextLevel.addLast(v);      // v will be further considered in next pass
                        } else {
                            exploratoryEdges.add(new Pair<>(e, false));
                        }
                        visitedEdges.add(e);
                    }
                }
            currentLevel = nextLevel;                     // relabel 'next' level to become the current
        }
    }

    private record PathInfo<V>(Integer distance, Boolean visited, Vertex<V> previousVertex) {}

    /**
     * Computes shortest-path distances from src vertex to all reachable vertices of g.
     *
     * This implementation uses Dijkstra's algorithm.
     *
     * The edge's element is assumed to be its integral weight.
     */
    public static <V> Map<Vertex<V>, Pair<Integer, List<Vertex<V>>>> shortestPaths(Graph<V, Integer> g, Vertex<V> src) {
        Map<Vertex<V>, PathInfo<V>> distanceToVertex = new HashMap<>();

        PriorityQueue<Pair<Vertex<V>, Integer>> priorityQueueVertices = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Pair<Vertex<V>, Integer>) o1).getSecond().compareTo(((Pair<Vertex<V>, Integer>) o2).getSecond());
            }
        });

        // for each vertex v of the graph, add an entry to the priority queue, with
        // the source having distance 0 and all others having infinite distance
        for (Vertex<V> v : g.vertices()) {
                distanceToVertex.put(v, new PathInfo<>(Integer.MAX_VALUE, false, null));
        }

        priorityQueueVertices.add(new Pair(src, 0));  // distance from source to source is 0

        while (!priorityQueueVertices.isEmpty()) {
            Pair<Vertex<V>, Integer> entry = priorityQueueVertices.poll();
            Vertex<V> currentVertex = entry.getFirst();
            int distanceToSource = entry.getSecond();
            distanceToVertex.put(currentVertex, new PathInfo<>(distanceToSource, true, distanceToVertex.get(currentVertex).previousVertex()));
            for (Vertex<V> reachableVertex : g.reachableVertices(currentVertex)) {
                if (!distanceToVertex.get(reachableVertex).visited()) {
                    Edge<Integer> e = g.getEdge(currentVertex, reachableVertex);
                    int edgeWeight = e.getElement();
                    if (distanceToVertex.get(reachableVertex).distance() > distanceToSource + edgeWeight) {
                        if (distanceToVertex.get(reachableVertex).distance() != Integer.MAX_VALUE) {
                            priorityQueueVertices.remove(new Pair(reachableVertex, distanceToVertex.get(reachableVertex).distance()));
                        }
                        distanceToVertex.put(reachableVertex, new PathInfo<>(distanceToSource + edgeWeight, false, currentVertex));
                        priorityQueueVertices.add(new Pair(reachableVertex, distanceToSource + edgeWeight));
                    }
                }
            }
        }

        Map<Vertex<V>, Pair<Integer, List<Vertex<V>>>> shortestPaths = new HashMap<>();
        for (Vertex<V> vertex : distanceToVertex.keySet()) {
            List<Vertex<V>> path = new LinkedList<>();
            Vertex<V> currentVertex = vertex;
            while (currentVertex != null) {
                path.addFirst(currentVertex);
                currentVertex = distanceToVertex.get(currentVertex).previousVertex();
            }
            shortestPaths.put(vertex, new Pair<>(distanceToVertex.get(vertex).distance(), path));
        }

        return shortestPaths;         // this only includes reachable vertices
    }

    /**
     * Converts graph g into its transitive closure.
     * This uses the Floyd-Warshall algorithm.
     */
    public static <V> void transitiveClosure(Graph<V,Integer> g) {
        for (Vertex<V> k : g.vertices()) {
            for (Vertex<V> i : g.vertices()) {
                Edge<Integer> edgeIK = g.getEdge(i, k);
                if (i != k && edgeIK != null) { // Si existe la arista (i,k)
                    for (Vertex<V> j : g.vertices()) {
                        Edge<Integer> edgeKJ = g.getEdge(k, j);
                        if (i != j && j != k && edgeKJ != null) { // Y existe la arista (k,j)
                            Edge<Integer> edgeIJ = g.getEdge(i, j);
                            if (edgeIJ == null) { // Pero no existe la arista (i,j)
                                // Entonces creamos una nueva arista (i,j), ya que se puede ir de i a j pasando por k
                                g.insertEdge(i, j, edgeIK.getElement() + edgeKJ.getElement());
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Converts graph g into its transitive closure.
     * This uses the Floyd-Warshall algorithm.
     * Weights of new edges represent the cost of the shortest path between the vertices.
     */
    public static <V> void transitiveClosureWithWeights(Graph<V,Integer> g) {
        for (Vertex<V> k : g.vertices()) {
            for (Vertex<V> i : g.vertices()) {
                Edge<Integer> edgeIK = g.getEdge(i, k);
                if (i != k && edgeIK != null) { // Si existe la arista (i,k)
                    for (Vertex<V> j : g.vertices()) {
                        Edge<Integer> edgeKJ = g.getEdge(k, j);
                        if (i != j && j != k && edgeKJ != null) { // Y existe la arista (k,j)
                            Edge<Integer> edgeIJ = g.getEdge(i, j);
                            if (edgeIJ == null) { // Pero no existe la arista (i,j)
                                // Entonces creamos una nueva arista (i,j), ya que se puede ir de i a j pasando por k
                                g.insertEdge(i, j, edgeIK.getElement() + edgeKJ.getElement());
                            }
                            else{
                                // Si existe la arista, comprobamos si el camino que estamos considerando es más corto
                                if(edgeIJ.getElement() > edgeIK.getElement() + edgeKJ.getElement()){
                                    // Si es asi, actualizamos el peso de la arista
                                    g.removeEdge(edgeIJ);
                                    g.insertEdge(i, j, edgeIK.getElement() + edgeKJ.getElement());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
