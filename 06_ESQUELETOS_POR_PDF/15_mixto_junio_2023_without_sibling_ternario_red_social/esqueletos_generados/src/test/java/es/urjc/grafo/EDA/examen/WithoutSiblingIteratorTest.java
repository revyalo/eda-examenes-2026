package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class WithoutSiblingIteratorTest {

    @Test
    void ejercicioDebeImplementarse() {
        WithoutSiblingIterator<Integer> iterator = new WithoutSiblingIterator<>(new LinkedBinaryTree<>());
        assertFalse(iterator.hasNext());
    }
}
