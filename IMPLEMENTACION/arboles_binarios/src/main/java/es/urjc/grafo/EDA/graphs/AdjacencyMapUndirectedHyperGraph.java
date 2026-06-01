package es.urjc.grafo.EDA.graphs;

import java.util.*;

/**
 * Implementación de un hipergrafo no dirigido usando mapas de adyacencia.
 *
 * @param <V> tipo de los elementos almacenados en los vértices
 * @param <E> tipo de los elementos almacenados en las aristas (hiperaristas)
 */
public class AdjacencyMapUndirectedHyperGraph<V,E> implements UndirectedHyperGraph<V,E> {

    private final Map<V, Vertex<V>> vertices = new HashMap<>();
    private final Map<Edge<E>, InnerEdge<E>> edges = new HashMap<>();

    /**
     * Crea un nuevo hipergrafo no dirigido vacío.
     */
    public AdjacencyMapUndirectedHyperGraph() {}

    //---------------- nested Vertex class ----------------
    /** A vertex of an adjacency map graph representation. */
    private class InnerVertex<V> implements Vertex<V> {
        private V element;
        private Map<Vertex<V>, Collection<Edge<E>>> outgoing;

        /** Constructs a new InnerVertex instance storing the given element. */
        public InnerVertex(V elem) {
            element = elem;
            outgoing = new HashMap<>();
        }

        /** Returns the element associated with the vertex. */
        public V getElement() { return element; }

        /** Returns reference to the underlying map of outgoing edges. */
        public Map<Vertex<V>, Collection<Edge<E>>> getOutgoingMap() { return outgoing; }

        public Iterable<Edge<E>> getOutgoingEdges() {
            return new OutgoingEdgesIterable();
        }

        private class OutgoingEdgesIterable implements Iterable<Edge<E>>{
            @Override
            public Iterator<Edge<E>> iterator() {
                return new OutgoingEdgesIterator();
            }
        }

        private class OutgoingEdgesIterator implements Iterator<Edge<E>>{
            private final Iterator<Collection<Edge<E>>> iter;
            private Iterator<Edge<E>> edgeIter;
            private Set<Edge<E>> visitedEdges = new HashSet<>();
            private Queue<Edge<E>> edgesToVisit = new LinkedList<>();

            public OutgoingEdgesIterator() {
                iter = outgoing.values().iterator();
                while (iter.hasNext() && edgesToVisit.isEmpty()) {
                    edgeIter = iter.next().iterator();
                    if (edgeIter.hasNext()) {
                        edgesToVisit.add(edgeIter.next());
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return !edgesToVisit.isEmpty();
            }

            @Override
            public Edge<E> next() {
                // TODO
                throw new UnsupportedOperationException("Not supported yet.");
            }
        }

        /** Validates that this vertex instance belongs to the given graph. */
        public boolean validate(AdjacencyMapUndirectedHyperGraph<V,E> graph) {
            return (AdjacencyMapUndirectedHyperGraph.this == graph && vertices.containsKey(this.element));
        }

        public String toString() {
            return "Vertex: " + element;
        }

        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            final InnerVertex<V> other = (InnerVertex<V>) obj;
            return this.element.equals(other.element);
        }

        public int hashCode() {
            return element.hashCode();
        }
    } //------------ end of InnerVertex class ------------

    //---------------- nested InnerEdge class ----------------
    /** An edge between two vertices. */
    private class InnerEdge<E> implements Edge<E> {
        private E element;
        private Collection<Vertex<V>> endpoints;

        /** Constructs InnerEdge instance from u to v, storing the given element. */
        public InnerEdge(Collection<Vertex<V>> vertices, E elem) {
            element = elem;
            endpoints = new HashSet<>(vertices);
        }

        /** Returns the element associated with the edge. */
        public E getElement() { return element; }

        /** Returns reference to the endpoint array. */
        public Iterable<Vertex<V>> getEndpoints() {
            return this.endpoints;
        }

        /** Validates that this edge instance belongs to the given graph. */
        public boolean validate(AdjacencyMapUndirectedHyperGraph<V, E> graph) {
            return AdjacencyMapUndirectedHyperGraph.this == graph && edges.containsKey(this);
        }

        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            final InnerEdge<E> other = (InnerEdge<E>) obj;
            return this.endpoints.equals(other.endpoints);
        }

        public int hashCode() {
            return this.endpoints.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Edge: ").append(element).append(" between ");
            for (Vertex<V> vertex : endpoints) {
                sb.append(vertex.getElement()).append(" ");
            }
            return sb.toString();
        }

    } //------------ end of InnerEdge class ------------

    private InnerVertex<V> validate(Vertex<V> v) {
        if (!(v instanceof AdjacencyMapUndirectedHyperGraph.InnerVertex vertex)) throw new IllegalArgumentException("Invalid vertex");
        if (!vertex.validate(this)) throw new IllegalArgumentException("Invalid vertex");
        return vertex;
    }

    private InnerEdge<E> validate(Edge<E> e) {
        if (!(e instanceof AdjacencyMapUndirectedHyperGraph.InnerEdge edge)) throw new IllegalArgumentException("Invalid edge");
        if (!edge.validate(this)) throw new IllegalArgumentException("Invalid edge");
        return edge;
    }

    /**
     * Devuelve un iterable con todos los vértices del grafo.
     *
     * @return iterable sobre los vértices
     */
    @Override
    public Iterable<Vertex<V>> vertices() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve un iterable con todas las aristas (hiperaristas) del grafo.
     *
     * @return iterable sobre las aristas
     */
    @Override
    public Iterable<Edge<E>> edges() {
        return this.edges.keySet();
    }

    /**
     * Devuelve un iterable con las aristas incidentes en el vértice dado.
     *
     * @param v vértice cuyo conjunto de aristas incidentes se desea obtener
     * @return iterable sobre las aristas incidentes en v
     * @throws IllegalArgumentException si el vértice no pertenece a este grafo
     */
    @Override
    public Iterable<Edge<E>> incidentEdges(Vertex<V> v) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class OtherVerticesIterable implements Iterable<Vertex<V>>{

        private Vertex<V> vertex;
        private Edge<E> edge;

        public OtherVerticesIterable(Vertex<V> v, Edge<E> e) {
            this.vertex = validate(v);
            this.edge = validate(e);
        }

        @Override
        public Iterator<Vertex<V>> iterator() {
            return new OtherVerticesIterator(vertex, edge);
        }
    }

    private class OtherVerticesIterator implements Iterator<Vertex<V>> {

        public OtherVerticesIterator(Vertex<V> v, Edge<E> e) {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean hasNext() {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Vertex<V> next() {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    /**
     * Devuelve un iterable con los otros vértices conectados por la arista dada,
     * excluyendo el vértice especificado.
     *
     * @param v vértice origen que se debe excluir del resultado
     * @param e arista que conecta a los vértices
     * @return iterable sobre los vértices distintos de v que son extremos de e
     * @throws IllegalArgumentException si v o e no pertenecen a este grafo
     */
    @Override
    public Iterable<Vertex<V>> others(Vertex<V> v, Edge<E> e) {
        return new OtherVerticesIterable(v, e);
    }

    /**
     * Devuelve los vértices extremos de la arista dada.
     *
     * @param edge arista de la que se obtienen los extremos
     * @return iterable sobre los vértices extremos de edge
     * @throws IllegalArgumentException si edge no pertenece a este grafo
     */
    @Override
    public Iterable<Vertex<V>> endVertices(Edge<E> edge) {
        InnerEdge<E> innerEdge = validate(edge);
        return innerEdge.getEndpoints();
    }

    /**
     * Indica si el grafo no contiene vértices.
     *
     * @return true si el grafo está vacío (sin vértices), false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return this.vertices.isEmpty();
    }

    /**
     * Devuelve el número de vértices del grafo.
     *
     * @return número de vértices
     */
    @Override
    public int size() {
        return this.vertices.size();
    }

    /**
     * Devuelve las aristas que conectan dos vértices concretos.
     *
     * @param v1 primer vértice
     * @param v2 segundo vértice
     * @return iterable sobre las aristas que conectan v1 y v2; si no existe ninguna,
     *         devuelve una colección vacía
     * @throws IllegalArgumentException si alguno de los vértices no pertenece a este grafo
     */
    @Override
    public Iterable<Edge<E>> getEdges(Vertex<V> v1, Vertex<V> v2) {
        InnerVertex<V> vertex1 = validate(v1);
        InnerVertex<V> vertex2 = validate(v2);
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Inserta (o actualiza si ya existe) una arista que conecta la colección de vértices
     * proporcionada.
     *
     * Si ya existe una arista con los mismos extremos, se actualiza su elemento y se devuelve
     * la arista existente. En caso contrario se crea una nueva arista y se añaden las entradas
     * necesarias en las estructuras de adyacencia.
     *
     * @param vertices colección de vértices que forman el extremo de la arista (hiperarista)
     * @param edgeValue valor/elemento que almacena la arista
     * @return la arista insertada o la arista existente si ya había una con esos extremos
     * @throws IllegalArgumentException si algún vértice no pertenece a este grafo
     */
    @Override
    public Edge<E> insertEdge(Collection<Vertex<V>> vertices, E edgeValue) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Obtiene un vértice por su valor almacenado.
     *
     * @param value valor asociado al vértice buscado
     * @return el vértice si existe, o null si no está presente en el grafo
     */
    public Vertex<V> getVertex(V value) {
        return this.vertices.get(value);
    }

    /**
     * Inserta un nuevo vértice con el valor dado en el grafo si no existe.
     *
     * @param value valor a almacenar en el vértice
     * @return el vértice existente con ese valor o el nuevo vértice recién creado
     */
    @Override
    public Vertex<V> insertVertex(V value) {
        Vertex<V> vertex = this.getVertex(value);
        if (vertex != null) {
            return vertex;
        }
        else {
            vertex = new InnerVertex<>(value);
            this.vertices.put(value, vertex);
            return vertex;
        }
    }

    /**
     * Elimina un vértice del grafo.
     *
     * Si una arista solo conecta al vértice eliminado con otro vértice, se elimina también la arista.
     * Es decir, no pueden quedar aristas con un solo extremo.
     *
     * @param vertex vértice a eliminar
     * @return el valor almacenado en el vértice eliminado
     * @throws IllegalArgumentException si el vértice no pertenece a este grafo
     */
    @Override
    public V removeVertex(Vertex<V> vertex) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Elimina una arista del grafo.
     *
     * El método elimina la arista de las estructuras de adyacencia de todos sus extremos
     * y la elimina del mapa interno de aristas.
     *
     * @param edge arista a eliminar
     * @return el elemento almacenado en la arista eliminada
     * @throws IllegalArgumentException si la arista no pertenece a este grafo
     */
    @Override
    public E removeEdge(Edge<E> edge) {
        InnerEdge<E> innerEdge = validate(edge);
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve los vértices alcanzables desde el vértice dado (adyacentes directos).
     *
     * @param vertex vértice origen
     * @return iterable sobre los vértices alcanzables desde vertex
     * @throws IllegalArgumentException si el vértice no pertenece a este grafo
     */
    @Override
    public Iterable<Vertex<V>> reachableVertices(Vertex<V> vertex) {
        InnerVertex<V> innerVertex = validate(vertex);
        return innerVertex.getOutgoingMap().keySet();
    }

}
