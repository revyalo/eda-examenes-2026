package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.trees.Tree;
import es.urjc.grafo.EDA.utils.Position;

public class GeneralTreeWarmup {

    public static <E> int countNodes(Tree<E> tree) {
        // TODO: recorrer todos los nodos del árbol.
        throw new UnsupportedOperationException("TODO: countNodes");
    }

    public static <E> int countLeaves(Tree<E> tree) {
        // TODO: contar posiciones hoja.
        throw new UnsupportedOperationException("TODO: countLeaves");
    }

    public static <E> int height(Tree<E> tree) {
        // TODO: devolver la altura del árbol.
        throw new UnsupportedOperationException("TODO: height");
    }

    public static <E> int treeDegree(Tree<E> tree) {
        // TODO: devolver el máximo número de hijos de cualquier nodo.
        throw new UnsupportedOperationException("TODO: treeDegree");
    }

    public static <E> int descendantsNumber(Tree<E> tree, Position<E> node) {
        // TODO: contar descendientes de node, sin contar node salvo que el enunciado indique lo contrario.
        throw new UnsupportedOperationException("TODO: descendantsNumber");
    }

    public static <E> Iterable<Position<E>> nodesAtDepth(Tree<E> tree, int depth) {
        // TODO: devolver nodos exactamente a profundidad depth.
        throw new UnsupportedOperationException("TODO: nodesAtDepth");
    }

    public static <E> boolean isPerfect(Tree<E> tree) {
        // TODO: comprobar que todas las hojas están al mismo nivel y que cada nodo interno tiene grado máximo uniforme.
        throw new UnsupportedOperationException("TODO: isPerfect");
    }
}
