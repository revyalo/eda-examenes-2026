package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ReverseInordenBTIteratorTest {

    @Test
    void ejercicioDebeImplementarse() {
        ReverseInordenBTIterator<Integer> iterator = new ReverseInordenBTIterator<>(new LinkedBinaryTree<>());
        assertFalse(iterator.hasNext());
    }
}
