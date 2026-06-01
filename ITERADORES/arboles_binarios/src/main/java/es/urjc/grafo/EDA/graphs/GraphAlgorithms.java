package es.urjc.grafo.EDA.graphs;

import es.urjc.grafo.EDA.utils.Pair;

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
     * La salida de este método es el conjunto de vértices descubiertos y una lista de las aristas
     *          utilizadas durante la exploración en el orden en que fueron encontradas.
     *          Si la arista, al ser explorada, llevó a un vértice que aún no había sido visto, el valor booleano
     *          asociado a dicha arista es True. De lo contrario, si la arista era una arista de retroceso
     *          a un vértice ya conocido, se marca como False.
     */
    public static <V,E> Pair<Set<Vertex<V>>, List<Pair<Edge<E>, Boolean>>> DFS(AdjacencyMapGraph<V,E> g, Vertex<V> u) {
        Set<Vertex<V>> known = new HashSet<>();
        List<Pair<Edge<E>, Boolean>> exploratoryEdges = new LinkedList<>();
        Set<Edge<E>> visitedEdges = new HashSet<>(); // To avoid traversing edges twice in undirected graphs
        DFS(g, u, known, exploratoryEdges, visitedEdges);
        return new Pair<>(known, exploratoryEdges);
    }

    public static <V,E> void DFS(AdjacencyMapGraph<V,E> g, Vertex<V> u, Set<Vertex<V>> known,
                                 List<Pair<Edge<E>, Boolean>> exploratoryEdges,
                                 Set<Edge<E>> visitedEdges) {
        known.add(u);
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
     * La salida de este método es el conjunto de vértices descubiertos y una lista de las aristas
     *          utilizadas durante la exploración en el orden en que fueron encontradas.
     *          Si la arista, al ser explorada, llevó a un vértice que aún no había sido visto, el valor booleano
     *          asociado a dicha arista es True. De lo contrario, si la arista era una arista de retroceso
     *          a un vértice ya conocido, se marca como False.
     */
    public static <V,E> Pair<Set<Vertex<V>>, List<Pair<Edge<E>, Boolean>>> BFS(AdjacencyMapGraph<V,E> g, Vertex<V> u) {
        Set<Vertex<V>> known = new HashSet<>();
        List<Pair<Edge<E>, Boolean>> exploratoryEdges = new LinkedList<>();
        BFS(g, u, known, exploratoryEdges);
        return new Pair<>(known, exploratoryEdges);
    }

    public static <V,E> void BFS(AdjacencyMapGraph<V,E> g, Vertex<V> s, Set<Vertex<V>> known,
                                 List<Pair<Edge<E>, Boolean>> exploratoryEdges) {
        List<Vertex<V>> currentLevel = new LinkedList<>();
        Set<Edge<E>> visitedEdges = new HashSet<>();
        known.add(s);
        currentLevel.addLast(s);
        while (!currentLevel.isEmpty()) {
            List<Vertex<V>> nextLevel = new LinkedList<>();
            for (Vertex<V> u : currentLevel)
                for (Vertex<V> v : g.reachableVertices(u)) {
                    Edge<E> e = g.getEdge(u, v);
                    if (!visitedEdges.contains(e)) {
                        if (!known.contains(v)) {
                            known.add(v);
                            exploratoryEdges.add(new Pair<>(e, true));
                            nextLevel.addLast(v);
                        } else {
                            exploratoryEdges.add(new Pair<>(e, false));
                        }
                        visitedEdges.add(e);
                    }
                }
            currentLevel = nextLevel;
        }
    }

    private record PathInfo<V>(Integer distance, Boolean visited, Vertex<V> previousVertex) {}

    /**
     * Calcula las distancias de los caminos más cortos desde el vértice src a todos los vértices alcanzables en g.
     * Esta implementación utiliza el algoritmo de Dijkstra.
     * Se asume que el elemento de la arista es un número entero que indica el peso de recorrer ese camino.
     */
    public static <V> Map<Vertex<V>, Pair<Integer, List<Vertex<V>>>> shortestPaths(AdjacencyMapGraph<V, Integer> g, Vertex<V> src) {
        // Inicializamos las estructuras necesarias
        // Tabla con la distancia mínima desde el vértice src a cada vértice, si ha sido visitado
        // y el vértice previo en el camino más corto
        Map<Vertex<V>, PathInfo<V>> distanceToVertex = new HashMap<>();
        // Inicialmente, todos los vértices tienen distancia infinita y no han sido visitados
        for (Vertex<V> v : g.vertices()) {
            distanceToVertex.put(v, new PathInfo<>(Integer.MAX_VALUE, false, null));
        }

        // Cola de prioridad para seleccionar el siguiente vértice con la distancia mínima
        PriorityQueue<Pair<Vertex<V>, Integer>> priorityQueueVertices = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Pair<Vertex<V>, Integer>) o1).getSecond().compareTo(((Pair<Vertex<V>, Integer>) o2).getSecond());
            }
        });
        // La distancia al vértice fuente es 0
        priorityQueueVertices.add(new Pair<>(src, 0));

        // Algoritmo de Dijkstra
        while (!priorityQueueVertices.isEmpty()) {
            Pair<Vertex<V>, Integer> caminoMasCorto = priorityQueueVertices.poll();
            Vertex<V> verticeActual = caminoMasCorto.getFirst();
            int distanciaAlVerticeActual = caminoMasCorto.getSecond();
            // Marcamos el vértice como visitado
            distanceToVertex.put(verticeActual, new PathInfo<>(
                    distanciaAlVerticeActual, true, distanceToVertex.get(verticeActual).previousVertex()));

            // Recorremos los vértices alcanzables desde el vértice actual
            for (Vertex<V> verticesAlcanzables : g.reachableVertices(verticeActual)) {
                // Si ya lo hemos visitado anteriormente, es imposible que encontremos un camino más corto,
                // así que lo ignoramos para no hacer cálculos innecesarios
                if (!distanceToVertex.get(verticesAlcanzables).visited()) {
                    Edge<Integer> arista = g.getEdge(verticeActual, verticesAlcanzables);
                    int distanciaArista = arista.getElement();
                    // Si encontramos un camino más corto, actualizamos la distancia y el vértice previo
                    if (distanceToVertex.get(verticesAlcanzables).distance() > distanciaAlVerticeActual + distanciaArista) {
                        // Si el vértice ya estaba en la cola de prioridad, lo eliminamos para actualizar su distancia.
                        // Si el vértice está en la cola de prioridad, su distancia en el mapa tiene que ser
                        // diferente al infinito. Preguntamos al mapa porque es más rápido que buscar si el
                        // vértice está en la cola de prioridad.
                        if (distanceToVertex.get(verticesAlcanzables).distance() != Integer.MAX_VALUE) {
                            priorityQueueVertices.remove(new Pair<>(verticesAlcanzables, distanceToVertex.get(verticesAlcanzables).distance()));
                        }
                        // Actualizamos la distancia y el vértice previo
                        distanceToVertex.put(verticesAlcanzables, new PathInfo<>(
                                distanciaAlVerticeActual + distanciaArista, false, verticeActual));
                        // Añadimos el vértice a la cola de prioridad con la nueva distancia
                        priorityQueueVertices.add(new Pair<>(verticesAlcanzables, distanciaAlVerticeActual + distanciaArista));
                    }
                }
            }
        }

        // Reconstruimos los caminos más cortos
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

        return shortestPaths;
    }

    /**
     * Realiza el cierre transitivo del grafo g.
     * Utiliza el algoritmo de Floyd-Warshall.
     * El grafo g se modifica en este método.
     */
    public static <V> void transitiveClosure(AdjacencyMapGraph<V,Integer> g) {
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
                                g.insertEdge(i, j, 1);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Realiza el cierre transitivo del grafo g.
     * Utiliza el algoritmo de Floyd-Warshall.
     * Las nuevas aristas creadas tienen como peso la suma de los pesos de las aristas que componen el camino.
     * El grafo g se modifica en este método.
     */
    public static <V> void transitiveClosureWithWeights(AdjacencyMapGraph<V,Integer> g) {
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
