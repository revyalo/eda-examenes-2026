package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Comparator;

public class BinaryTreeWarmup {

    public static <E> int height(BinaryTree<E> tree) {
        // TODO: calcular altura con hijos izquierdo/derecho.
        throw new UnsupportedOperationException("TODO: height");
    }

    public static <E> int countNodes(BinaryTree<E> tree) {
        // TODO: contar nodos del árbol binario.
        throw new UnsupportedOperationException("TODO: countNodes");
    }

    public static <E> Iterable<E> inorder(BinaryTree<E> tree) {
        // TODO: recorrido inorden.
        throw new UnsupportedOperationException("TODO: inorder");
    }

    public static <E> Iterable<E> preorder(BinaryTree<E> tree) {
        // TODO: recorrido preorden.
        throw new UnsupportedOperationException("TODO: preorder");
    }

    public static <E> Iterable<E> postorder(BinaryTree<E> tree) {
        // TODO: recorrido postorden.
        throw new UnsupportedOperationException("TODO: postorder");
    }

    public static <E> boolean areIdentical(BinaryTree<E> t1, BinaryTree<E> t2) {
        // TODO: comparar estructura y elementos.
        throw new UnsupportedOperationException("TODO: areIdentical");
    }

    public static <E> boolean isSymmetric(BinaryTree<E> tree) {
        // TODO: comparar subárbol izquierdo y derecho en espejo.
        throw new UnsupportedOperationException("TODO: isSymmetric");
    }

    public static <E> boolean isPerfect(BinaryTree<E> tree) {
        // TODO: comprobar que todos los niveles están completos.
        throw new UnsupportedOperationException("TODO: isPerfect");
    }

    public static <E> int width(BinaryTree<E> tree) {
        // TODO: devolver máximo número de nodos en un nivel.
        throw new UnsupportedOperationException("TODO: width");
    }

    public static <E> boolean isAlmostComplete(BinaryTree<E> tree) {
        // TODO: comprobar casi completitud con recorrido por niveles.
        throw new UnsupportedOperationException("TODO: isAlmostComplete");
    }

    public static <E> boolean isHeap(BinaryTree<E> tree, Comparator<E> comparator) {
        // TODO: casi completo + propiedad de prioridad.
        throw new UnsupportedOperationException("TODO: isHeap");
    }

    public static <E> boolean cumplePropiedadesMonticulo(BinaryTree<E> tree, Comparator<E> comparator) {
        // TODO: variante estilo examen enero.
        throw new UnsupportedOperationException("TODO: cumplePropiedadesMonticulo");
    }

    public static <E> int diameter(BinaryTree<E> tree) {
        // TODO: longitud del camino más largo entre dos nodos.
        throw new UnsupportedOperationException("TODO: diameter");
    }
}
