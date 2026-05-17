package graphs;

import utils.Pair;

import java.util.*;

public class AdjacencyMapGraph<V,E> implements UndirectedGraph<V,E>, DirectedGraph<V,E> {

    private boolean isDirected;
    private Set<Vertex<V>> vertices = new HashSet<>();
    private Set<Edge<E>> edges = new HashSet<>();

    public AdjacencyMapGraph(boolean directed) { isDirected = directed; }

    /**
     * Constructs a graph from an array of array strings.
     */
    public static AdjacencyMapGraph<String,Integer> graphFromEdgelist(String[][] receivedEdges, boolean directed) {
        AdjacencyMapGraph<String,Integer> g = new AdjacencyMapGraph<>(directed);

        // first pass to get sorted set of vertex labels
        TreeSet<String> labels = new TreeSet<>();
        for (String[] receivedEdge : receivedEdges) {
            labels.add(receivedEdge[0]);
            labels.add(receivedEdge[1]);
        }

        // now create vertices (in alphabetical order)
        HashMap<String, Vertex<String>> verts = new HashMap<>();
        for (String label : labels)
            verts.put(label, g.insertVertex(label));

        // now add edges to the graph
        for (String[] receivedEdge : receivedEdges) {
            Integer cost = (receivedEdge.length == 2 ? 1 : Integer.parseInt(receivedEdge[2]));
            g.insertEdge(verts.get(receivedEdge[0]), verts.get(receivedEdge[1]), cost);
        }
        return g;
    }

    //---------------- nested Vertex class ----------------
    /** A vertex of an adjacency map graph representation. */
    private class InnerVertex<U> implements Vertex<U> {
        private U element;
        private Map<Vertex<U>, Edge<E>> outgoing, incoming;

        /** Constructs a new InnerVertex instance storing the given element. */
        public InnerVertex(U elem, boolean graphIsDirected) {
            element = elem;
            outgoing = new HashMap<>();
            if (graphIsDirected)
                incoming = new HashMap<>();
            else
                // if undirected, alias outgoing map as incoming
                // De esta manera, solo tenemos un mapa de adyacencia donde se encuentran las aristas de las que
                // este vertice forma parte, independientemente de la direccion de la arista
                incoming = outgoing;
        }

        /** Returns the element associated with the vertex. */
        public U getElement() { return element; }

        /** Returns reference to the underlying map of outgoing edges. */
        public Map<Vertex<U>, Edge<E>> getOutgoing() { return outgoing; }

        /** Returns reference to the underlying map of incoming edges. */
        public Map<Vertex<U>, Edge<E>> getIncoming() { return incoming; }

        /** Validates that this vertex instance belongs to the given graph. */
        public boolean validate(AdjacencyMapGraph<U,E> graph) {
            return (AdjacencyMapGraph.this == graph && graph.vertices().contains(this));
        }

        public String toString() {
            return "Vertex: " + element;
        }

        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            final InnerVertex<U> other = (InnerVertex<U>) obj;
            return this.element.equals(other.element);
        }

        public int hashCode() {
            return element.hashCode();
        }
    } //------------ end of InnerVertex class ------------

    //---------------- nested InnerEdge class ----------------
    /** An edge between two vertices. */
    private class InnerEdge<R> implements Edge<R> {
        private R element;
        private Vertex<V>[] endpoints;

        /** Constructs InnerEdge instance from u to v, storing the given element. */
        public InnerEdge(Vertex<V> u, Vertex<V> v, R elem) {
            element = elem;
            endpoints = (Vertex<V>[]) new Vertex[]{u,v};  // array of length 2
        }

        /** Returns the element associated with the edge. */
        public R getElement() { return element; }

        /** Returns reference to the endpoint array. */
        public Pair<Vertex<V>, Vertex<V>> getEndpoints() {
            return new Pair<>(endpoints[0], endpoints[1]);
        }

        /** Validates that this edge instance belongs to the given graph. */
        public boolean validate(UndirectedGraph<V, R> graph) {
            return AdjacencyMapGraph.this == graph && graph.edges().contains(this);
        }

        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            final InnerEdge<R> other = (InnerEdge<R>) obj;
            if (isDirected){
                // Order matters
                return this.endpoints[0].equals(other.endpoints[0]) && this.endpoints[1].equals(other.endpoints[1]);
            }
            else{
                // Order does not matter
                return (this.endpoints[0].equals(other.endpoints[0]) && this.endpoints[1].equals(other.endpoints[1])) ||
                        (this.endpoints[0].equals(other.endpoints[1]) && this.endpoints[1].equals(other.endpoints[0]));
            }
        }

        public int hashCode() {
            if (isDirected){
                // Order matters
                return Arrays.hashCode(endpoints);
            }
            else{
                // Order does not matter
                return endpoints[0].hashCode() + endpoints[1].hashCode();
            }
        }

        public String toString() {
            return "Edge: " + element + " between (" + endpoints[0] + ") and (" + endpoints[1] + ")";
        }
    } //------------ end of InnerEdge class ------------

    private InnerVertex<V> validate(Vertex<V> v) {
        if (!(v instanceof AdjacencyMapGraph.InnerVertex vertex)) throw new IllegalArgumentException("Invalid vertex");
        if (!vertex.validate(this)) throw new IllegalArgumentException("Invalid vertex");
        return vertex;
    }

    private InnerEdge<E> validate(Edge<E> e) {
        if (!(e instanceof AdjacencyMapGraph.InnerEdge edge)) throw new IllegalArgumentException("Invalid edge");
        if (!edge.validate(this)) throw new IllegalArgumentException("Invalid edge");
        return edge;
    }

    public Vertex<V> startVertex(Edge<E> edge) {
        InnerEdge<E> innerEdge = validate(edge);
        return innerEdge.getEndpoints().getFirst();
    }

    public Vertex<V> getVertex(V value){
        InnerVertex<V> vertex = new InnerVertex<>(value, this.isDirected);
        if (this.vertices.contains(vertex)){
            return this.vertices.stream().filter(v -> v.equals(vertex)).findFirst().get();
        }
        else return null;
    }

    public Edge<E> getEdge(V value1, V value2){
        Vertex<V> v1 = getVertex(value1);
        Vertex<V> v2 = getVertex(value2);
        if (v1 != null && v2 != null){
            return getEdge(v1, v2);
        }
        else return null;
    }

    /**
     * Returns the edge from v1 to v2, or null if they are not adjacent,
     * and the edge from v2 to v1, or null if they are not adjacent.
     * @param v1 vertex
     * @param v2 vertex
     * @return edges from v1 to v2 and from v2 to v1, if they are not null.
     */
    @Override
    public Pair<Edge<E>, Edge<E>> getEdges(Vertex<V> v1, Vertex<V> v2) {
        InnerVertex<V> vertex1 = validate(v1);
        InnerVertex<V> vertex2 = validate(v2);
        Edge<E>[] edges = new Edge[2];
        Edge<E> edge = vertex1.getOutgoing().get(vertex2);
        if (edge != null)
            edges[0] = edge;
        if (this.isDirected) {
            edge = vertex2.getOutgoing().get(vertex1);
            if (edge != null)
                edges[1] = edge;
        }
        return new Pair<>(edges[0], edges[1]);
    }

    @Override
    public Collection<Edge<E>> outputEdges(Vertex<V> v) {
        return validate(v).outgoing.values();
    }

    @Override
    public Collection<Vertex<V>> vertices() {
        return this.vertices;
    }

    @Override
    public Collection<Edge<E>> edges() {
        return this.edges;
    }

    @Override
    public Collection<Edge<E>> incidentEdges(Vertex<V> v) {
        return validate(v).incoming.values();
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException {
        InnerEdge<E> edge = validate(e);
        Pair<Vertex<V>, Vertex<V>> endpoints = edge.getEndpoints();
        if (endpoints.getFirst() == v)
            return endpoints.getSecond();
        else if (endpoints.getSecond() == v)
            return endpoints.getFirst();
        else
            throw new IllegalArgumentException("v is not incident to this edge");
    }

    @Override
    public Vertex<V> endVertex(Edge<E> e) {
        InnerEdge<E> edge = validate(e);
        return edge.getEndpoints().getSecond();
    }

    @Override
    public Pair<Vertex<V>, Vertex<V>> endVertices(Edge<E> edge) {
        return validate(edge).getEndpoints();
    }

    @Override
    public boolean areAdjacent(Vertex<V> v1, Vertex<V> v2) {
        InnerVertex<V> vertex1 = validate(v1);
        InnerVertex<V> vertex2 = validate(v2);
        return vertex1.getOutgoing().containsKey(vertex2);
    }

    @Override
    public Edge<E> getEdge(Vertex<V> v1, Vertex<V> v2) {
        InnerVertex<V> vertex1 = validate(v1);
        InnerVertex<V> vertex2 = validate(v2);
        return vertex1.getOutgoing().getOrDefault(vertex2, null);
    }

    @Override
    public Vertex<V> insertVertex(V value) {
        InnerVertex<V> v = new InnerVertex<>(value, this.isDirected);
        if (this.vertices.contains(v)) return this.vertices.stream().filter(vertex -> vertex.equals(v)).findFirst().get();
        vertices.add(v);
        return v;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) {
        InnerVertex<V> vertex1 = validate(v1);
        InnerVertex<V> vertex2 = validate(v2);
        InnerEdge<E> edge = new InnerEdge<>(vertex1, vertex2, edgeValue);
        if (this.edges.contains(edge)) {
            // In case the edge already exists, we remove it to replace it
            this.edges.remove(edge);
            vertex1.outgoing.remove(vertex2);
            vertex2.incoming.remove(vertex1);
        }
        this.edges.add(edge);
        vertex1.outgoing.put(vertex2, edge);
        vertex2.incoming.put(vertex1, edge);
        return edge;
    }

    @Override
    public V removeVertex(Vertex<V> vertex) {
        InnerVertex<V> v = validate(vertex);
        Iterator<Edge<E>> it = v.outgoing.values().iterator();
        while (it.hasNext()) {
            Edge<E> edge = it.next();
            it.remove();
            this.edges.remove(edge);
        }
        if (this.isDirected) {
            it = v.incoming.values().iterator();
            while (it.hasNext()) {
                Edge<E> edge = it.next();
                it.remove();
                this.edges.remove(edge);
            }
        }
        vertices.remove(v);
        return v.getElement();
    }

    @Override
    public E removeEdge(Edge<E> edge) {
        InnerEdge<E> e = validate(edge);
        Pair<Vertex<V>, Vertex<V>> affectedVertices = e.getEndpoints();
        InnerVertex<V> affectedVertex = validate(affectedVertices.getFirst());
        affectedVertex.outgoing.remove(affectedVertices.getSecond());
        affectedVertex = validate(affectedVertices.getSecond());
        affectedVertex.incoming.remove(affectedVertices.getFirst());
        E temp = e.getElement();
        edges.remove(e);
        return temp;
    }


    /**
     * Returns a collection of vertices that are adjacent to the specified vertex. In the case of directed graphs,
     * direction is not considered. That is, vertex v2 is adjacent to vertex v1 if there exists either
     * an edge from v1 to v2, an edge from v2 to v1, or both.
     * @param vertex a vertex of the graph
     * @return a collection of vertices adjacent to vertex in the graph
     */
    public Collection<Vertex<V>> adjacentVertices(Vertex<V> vertex){
        InnerVertex<V> v = validate(vertex);
        Set<Vertex<V>> adjacentVertices = v.outgoing.keySet();
        if (this.isDirected){
            adjacentVertices.addAll(v.incoming.keySet());
        }
        return adjacentVertices;
    }

    /**
     * Returns a collection of vertices that can be reached from vertex. That is, all vertices
     * that are the end vertex of edges where the specified vertex is the origin.
     * If this graph is undirected, this returns the same collection as adjacentVertices
     * (i.e., direction does not matter).
     * @param vertex a vertex
     * @return the reachable vertices from vertex
     */
    public Collection<Vertex<V>> reachableVertices(Vertex<V> vertex){
        return validate(vertex).outgoing.keySet();
    }
}
