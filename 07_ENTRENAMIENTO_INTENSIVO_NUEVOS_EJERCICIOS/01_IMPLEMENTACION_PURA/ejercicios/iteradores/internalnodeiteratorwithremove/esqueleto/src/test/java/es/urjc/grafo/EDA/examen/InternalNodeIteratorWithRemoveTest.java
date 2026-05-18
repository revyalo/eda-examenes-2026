package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalNodeIteratorWithRemoveTest {

    @Test
    void InternalNodeIteratorWithRemoveDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        InternalNodeIteratorWithRemove<Integer> iterator = new InternalNodeIteratorWithRemove<>(tree);
        assertFalse(iterator.hasNext());
    }
}
