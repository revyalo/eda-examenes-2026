package es.urjc.grafo.EDA.examen.arbolesbinarios.p08_practica_extra_10_ejercicios.extra2026;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeExtraOperationsTest {

    @Test
    void almostCompleteAcceptsLeftPackedLastLevel() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.insertLeft(root, 2);
        tree.insertRight(root, 3);
        tree.insertLeft(left, 4);

        assertTrue(TreeExtraOperations.isAlmostComplete(tree));
    }

    @Test
    void almostCompleteRejectsRightGapBeforeNode() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.insertLeft(root, 2);
        tree.insertRight(root, 3);
        tree.insertRight(left, 4);

        assertFalse(TreeExtraOperations.isAlmostComplete(tree));
    }

    @Test
    void lowestCommonAncestorFindsDeepestCommonNode() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> root = tree.addRoot("A");
        Position<String> left = tree.insertLeft(root, "B");
        tree.insertRight(root, "C");
        Position<String> d = tree.insertLeft(left, "D");
        Position<String> e = tree.insertRight(left, "E");

        assertEquals(left, TreeExtraOperations.lowestCommonAncestor(tree, d, e));
    }
}
