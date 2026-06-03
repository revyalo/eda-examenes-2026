package es.urjc.grafo.EDA.examen.arbolesbinarios.arboles_identicos;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArbolesIdenticosTest {

    private static LinkedBinaryTree<Integer> sampleTree() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.insertLeft(root, 2);
        tree.insertRight(root, 3);
        tree.insertLeft(left, 4);
        return tree;
    }

    @Test
    void identicalTreesReturnTrue() {
        assertTrue(TreeOperations.areIdentical(sampleTree(), sampleTree()));
    }

    @Test
    void differentElementsReturnFalse() {
        LinkedBinaryTree<Integer> first = sampleTree();
        LinkedBinaryTree<Integer> second = new LinkedBinaryTree<>();
        Position<Integer> root = second.addRoot(1);
        Position<Integer> left = second.insertLeft(root, 2);
        second.insertRight(root, 9);
        second.insertLeft(left, 4);

        assertFalse(TreeOperations.areIdentical(first, second));
    }
}
