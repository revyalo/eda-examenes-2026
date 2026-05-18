package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstEvenLevelIteratorTest {

    @Test
    void BreadthFirstEvenLevelIteratorDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        BreadthFirstEvenLevelIterator<Integer> iterator = new BreadthFirstEvenLevelIterator<>(tree);
        assertFalse(iterator.hasNext());
    }
}
