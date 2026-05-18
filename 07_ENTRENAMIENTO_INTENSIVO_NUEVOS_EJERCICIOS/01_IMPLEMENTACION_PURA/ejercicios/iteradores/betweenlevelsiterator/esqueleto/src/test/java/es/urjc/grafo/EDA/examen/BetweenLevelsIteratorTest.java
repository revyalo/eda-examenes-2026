package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BetweenLevelsIteratorTest {

    @Test
    void BetweenLevelsIteratorDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        BetweenLevelsIterator<Integer> iterator = new BetweenLevelsIterator<>(tree, 0, 2);
        assertFalse(iterator.hasNext());
    }
}
