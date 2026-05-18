package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeOperationsExam03Test {
    @Test
    void hasSameShapeDebeImplementarse() {
        LinkedBinaryTree<Integer> a = new LinkedBinaryTree<>();
        Position<Integer> ar = a.addRoot(1);
        a.insertLeft(ar, 2);
        LinkedBinaryTree<String> b = new LinkedBinaryTree<>();
        Position<String> br = b.addRoot("A");
        b.insertLeft(br, "B");
        assertTrue(TreeOperationsExam03.hasSameShape(a, b));
    }

    @Test
    void diameterDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        tree.insertLeft(root, 2);
        tree.insertRight(root, 3);
        assertEquals(2, TreeOperationsExam03.diameter(tree));
    }
}
