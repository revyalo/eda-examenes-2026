package es.urjc.grafo.EDA.examen.arbolesbinarios.abb_avl_serializacion_sumas;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;

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

    public static <E> Position<E> floor(BinaryTree<E> tree, E key, Comparator<E> comparator) {
        // TODO: devolver la posicion con mayor clave <= key, o null si no existe.
        throw new UnsupportedOperationException("TODO: floor");
    }

    public static <E> Position<E> ceiling(BinaryTree<E> tree, E key, Comparator<E> comparator) {
        // TODO: devolver la posicion con menor clave >= key, o null si no existe.
        throw new UnsupportedOperationException("TODO: ceiling");
    }

    public static <E> Position<E> predecessor(BinaryTree<E> tree, E key, Comparator<E> comparator) {
        // TODO: devolver la posicion con mayor clave estrictamente menor que key.
        throw new UnsupportedOperationException("TODO: predecessor");
    }

    public static <E> Position<E> successor(BinaryTree<E> tree, E key, Comparator<E> comparator) {
        // TODO: devolver la posicion con menor clave estrictamente mayor que key.
        throw new UnsupportedOperationException("TODO: successor");
    }

    public static <E> Iterable<E> removeRange(LinkedBinaryTree<E> tree,
                                             E min,
                                             E max,
                                             Comparator<E> comparator) {
        // TODO: eliminar del ABB los valores en [min, max] y devolverlos en orden creciente.
        throw new UnsupportedOperationException("TODO: removeRange");
    }

    public static <E> Position<E> kthSmallest(BinaryTree<E> tree, int k) {
        // TODO: devolver la posicion del k-esimo menor elemento del ABB usando inorden.
        throw new UnsupportedOperationException("TODO: kthSmallest");
    }

    public static <E> LinkedBinaryTree<E> trimBST(LinkedBinaryTree<E> tree,
                                                 E min,
                                                 E max,
                                                 Comparator<E> comparator) {
        // TODO: podar el ABB eliminando las claves fuera del rango [min, max].
        throw new UnsupportedOperationException("TODO: trimBST");
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
