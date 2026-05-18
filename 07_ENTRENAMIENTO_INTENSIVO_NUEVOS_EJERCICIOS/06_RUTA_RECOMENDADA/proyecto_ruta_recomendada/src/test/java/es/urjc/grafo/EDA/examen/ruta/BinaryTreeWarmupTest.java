package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeWarmupTest {
    @Test
    void areIdenticalDebeImplementarse() {
        LinkedBinaryTree<Integer> a = new LinkedBinaryTree<>();
        Position<Integer> rootA = a.addRoot(1);
        a.insertLeft(rootA, 2);

        LinkedBinaryTree<Integer> b = new LinkedBinaryTree<>();
        Position<Integer> rootB = b.addRoot(1);
        b.insertLeft(rootB, 2);

        assertTrue(BinaryTreeWarmup.areIdentical(a, b));
    }
}
