package es.urjc.grafo.EDA.examen.arbolesbinarios.abb_avl_serializacion_sumas;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;

import java.util.Comparator;

public class BinarySearchTreeValidationOperations {

    public static <E> boolean isBST(BinaryTree<E> tree, Comparator<E> comparator) {
        // TODO: validar propiedad de arbol binario de busqueda usando comparator.
        throw new UnsupportedOperationException("TODO: isBST");
    }

    public static <E extends Comparable<E>> boolean isAVL(BinaryTree<E> tree) {
        // TODO: validar que es ABB y que cumple balance AVL en todos los nodos.
        throw new UnsupportedOperationException("TODO: isAVL");
    }

    public static String serialize(BinaryTree<Integer> tree) {
        // TODO: serializar con recorrido que conserve nulos para poder reconstruir.
        throw new UnsupportedOperationException("TODO: serialize");
    }

    public static LinkedBinaryTree<Integer> deserialize(String data) {
        // TODO: reconstruir el arbol de enteros desde la cadena producida por serialize.
        throw new UnsupportedOperationException("TODO: deserialize");
    }

    public static boolean pathSum(BinaryTree<Integer> tree, int target) {
        // TODO: devolver true si existe un camino raiz-hoja con suma target.
        throw new UnsupportedOperationException("TODO: pathSum");
    }

    public static Iterable<Iterable<Integer>> pathsWithSum(BinaryTree<Integer> tree, int target) {
        // TODO: devolver todos los caminos raiz-hoja cuya suma sea target.
        throw new UnsupportedOperationException("TODO: pathsWithSum");
    }
}
