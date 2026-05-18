package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseInordenBTIteratorWithRemoveTest {

    @Test
    void ReverseInordenBTIteratorWithRemoveDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        ReverseInordenBTIteratorWithRemove<Integer> iterator = new ReverseInordenBTIteratorWithRemove<>(tree);
        assertFalse(iterator.hasNext());
    }
}
