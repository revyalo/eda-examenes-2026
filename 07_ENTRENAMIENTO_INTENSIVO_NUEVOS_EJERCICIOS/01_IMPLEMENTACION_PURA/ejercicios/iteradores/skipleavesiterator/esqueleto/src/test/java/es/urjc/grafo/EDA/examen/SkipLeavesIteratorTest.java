package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkipLeavesIteratorTest {

    @Test
    void SkipLeavesIteratorDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        SkipLeavesIterator<Integer> iterator = new SkipLeavesIterator<>(tree);
        assertFalse(iterator.hasNext());
    }
}
