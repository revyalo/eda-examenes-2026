package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class InternalNodeIteratorWithRemoveTest {
    @Test
    void hasNextDebeImplementarse() {
        InternalNodeIteratorWithRemove<Integer> it = new InternalNodeIteratorWithRemove<>(new LinkedBinaryTree<>());
        assertFalse(it.hasNext());
    }
}
