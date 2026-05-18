package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelLimitedIteratorTest {

    @Test
    void LevelLimitedIteratorDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        LevelLimitedIterator<Integer> iterator = new LevelLimitedIterator<>(tree, 2);
        assertFalse(iterator.hasNext());
    }
}
