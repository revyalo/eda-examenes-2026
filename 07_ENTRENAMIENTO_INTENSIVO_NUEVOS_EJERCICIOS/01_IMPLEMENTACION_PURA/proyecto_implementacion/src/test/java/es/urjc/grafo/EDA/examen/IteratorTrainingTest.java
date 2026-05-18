package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class IteratorTrainingTest {
    @Test
    void leafIteratorDebeImplementarse() {
        LeafIterator<Integer> it = new LeafIterator<>(new LinkedBinaryTree<>());
        assertFalse(it.hasNext());
    }
}
