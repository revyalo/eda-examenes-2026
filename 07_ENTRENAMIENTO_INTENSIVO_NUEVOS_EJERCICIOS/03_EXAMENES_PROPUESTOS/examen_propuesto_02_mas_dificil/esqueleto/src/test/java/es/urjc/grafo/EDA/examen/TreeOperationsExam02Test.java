package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeOperationsExam02Test {
    @Test
    void isHeapDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        tree.insertLeft(root, 2);
        tree.insertRight(root, 3);
        assertTrue(TreeOperationsExam02.isHeap(tree, Comparator.naturalOrder()));
    }
}
