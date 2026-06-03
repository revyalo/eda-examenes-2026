package es.urjc.grafo.EDA.examen.arbolesbinarios.arbol_simetrico;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArbolSimetricoTest {

    @Test
    void symmetricTreeReturnsTrue() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.insertLeft(root, 2);
        Position<Integer> right = tree.insertRight(root, 2);
        tree.insertLeft(left, 3);
        tree.insertRight(right, 3);

        assertTrue(TreeOperations.isSymmetric(tree));
    }

    @Test
    void nonSymmetricShapeReturnsFalse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.insertLeft(root, 2);
        Position<Integer> right = tree.insertRight(root, 2);
        tree.insertLeft(left, 3);
        tree.insertLeft(right, 3);

        assertFalse(TreeOperations.isSymmetric(tree));
    }
}
