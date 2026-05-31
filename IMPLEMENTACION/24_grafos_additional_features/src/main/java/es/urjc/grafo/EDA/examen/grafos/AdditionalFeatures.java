package es.urjc.grafo.EDA.examen.grafos;

import es.urjc.grafo.EDA.graphs.AdjacencyMapGraph;
import es.urjc.grafo.EDA.graphs.DirectedGraph;
import es.urjc.grafo.EDA.graphs.Vertex;

import java.util.Collection;

public class AdditionalFeatures {

    public static <V, E> boolean isTree(AdjacencyMapGraph<V, E> graph) {
        // TODO: comprobar nulidad/vacio, numero de aristas y conectividad.
        throw new UnsupportedOperationException("TODO: isTree");
    }

    public static <V, E> Collection<Vertex<V>> sourceVertex(DirectedGraph<V, E> graph) {
        // TODO: devolver vertices con grado de entrada 0 y grado de salida mayor que 0.
        throw new UnsupportedOperationException("TODO: sourceVertex");
    }

    public static <V, E> boolean isComplete(AdjacencyMapGraph<V, E> graph) {
        // TODO: comprobar que cada par de vertices distintos esta conectado por una arista.
        throw new UnsupportedOperationException("TODO: isComplete");
    }
}
