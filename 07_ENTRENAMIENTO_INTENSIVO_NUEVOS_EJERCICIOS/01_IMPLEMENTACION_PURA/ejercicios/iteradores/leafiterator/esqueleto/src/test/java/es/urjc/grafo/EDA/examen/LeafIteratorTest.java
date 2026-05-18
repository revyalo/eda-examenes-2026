package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeafIteratorTest {

    @Test
    void LeafIteratorDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        LeafIterator<Integer> iterator = new LeafIterator<>(tree);
        assertFalse(iterator.hasNext());
    }
}
