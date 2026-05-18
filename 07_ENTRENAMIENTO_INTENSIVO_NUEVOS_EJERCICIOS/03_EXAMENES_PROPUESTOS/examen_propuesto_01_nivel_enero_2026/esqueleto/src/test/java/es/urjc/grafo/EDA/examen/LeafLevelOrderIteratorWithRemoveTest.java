package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LeafLevelOrderIteratorWithRemoveTest {
    @Test
    void hasNextDebeImplementarse() {
        LeafLevelOrderIteratorWithRemove<Integer> it = new LeafLevelOrderIteratorWithRemove<>(new LinkedBinaryTree<>());
        assertFalse(it.hasNext());
    }
}
