package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.Tree;
import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;

public class TreeOperations {

    /**
     * Calcula el grado del árbol.
     * El grado de un árbol es el máximo grado entre todos los nodos del árbol.
     * <p>
     * Si el árbol es nulo, lanza IllegalArgumentException.
     * Si el árbol está vacío, devuelve 0.
     *
     * @param t el árbol
     * @return el máximo grado entre todos los nodos del árbol
     */
    public static <E> int treeDegree(Tree<E> t) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Comprueba si dos árboles binarios son idénticos.
     * Dos árboles son idénticos si contienen los mismos elementos en las mismas posiciones.
     * <p>
     * Si alguno de los dos árboles es nulo, lanza IllegalArgumentException.
     *
     * @param t1 primer árbol
     * @param t2 segundo árbol
     * @return true si t1 y t2 son idénticos
     */
    public static <E> boolean areIdentical(BinaryTree<E> t1, BinaryTree<E> t2) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
