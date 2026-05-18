package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InordenIteratorWithRemoveTest {

    @Test
    void InordenIteratorWithRemoveDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        InordenIteratorWithRemove<Integer> iterator = new InordenIteratorWithRemove<>(tree);
        assertFalse(iterator.hasNext());
    }
}
