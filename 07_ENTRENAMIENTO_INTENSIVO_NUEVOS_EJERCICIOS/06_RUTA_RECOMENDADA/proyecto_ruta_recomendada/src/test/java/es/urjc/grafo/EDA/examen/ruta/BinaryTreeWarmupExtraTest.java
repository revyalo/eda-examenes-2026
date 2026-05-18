package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeWarmupExtraTest {
    private LinkedBinaryTree<Integer> sampleTree() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        tree.insertLeft(root, 2);
        tree.insertRight(root, 2);
        return tree;
    }

    @Test void heightDebeImplementarse() {
        assertEquals(1, BinaryTreeWarmup.height(sampleTree()));
    }

    @Test void countNodesDebeImplementarse() {
        assertEquals(3, BinaryTreeWarmup.countNodes(sampleTree()));
    }

    @Test void recorridosDebenImplementarse() {
        assertNotNull(BinaryTreeWarmup.inorder(sampleTree()));
        assertNotNull(BinaryTreeWarmup.preorder(sampleTree()));
        assertNotNull(BinaryTreeWarmup.postorder(sampleTree()));
    }

    @Test void propiedadesEstructuralesDebenImplementarse() {
        LinkedBinaryTree<Integer> tree = sampleTree();
        assertTrue(BinaryTreeWarmup.isSymmetric(tree));
        assertTrue(BinaryTreeWarmup.isPerfect(tree));
        assertEquals(2, BinaryTreeWarmup.width(tree));
        assertTrue(BinaryTreeWarmup.isAlmostComplete(tree));
    }

    @Test void monticuloYDiametroDebenImplementarse() {
        LinkedBinaryTree<Integer> tree = sampleTree();
        assertTrue(BinaryTreeWarmup.isHeap(tree, Integer::compareTo));
        assertTrue(BinaryTreeWarmup.cumplePropiedadesMonticulo(tree, Integer::compareTo));
        assertEquals(2, BinaryTreeWarmup.diameter(tree));
    }
}
