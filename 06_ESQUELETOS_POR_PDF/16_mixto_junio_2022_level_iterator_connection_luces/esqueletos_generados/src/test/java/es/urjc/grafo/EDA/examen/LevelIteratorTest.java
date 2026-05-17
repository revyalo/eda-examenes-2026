package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LevelIteratorTest {

    @Test
    void ejercicioDebeImplementarse() {
        LevelIterator<Integer> iterator = new LevelIterator<>(new LinkedBinaryTree<>());
        assertFalse(iterator.hasNext());
    }
}
