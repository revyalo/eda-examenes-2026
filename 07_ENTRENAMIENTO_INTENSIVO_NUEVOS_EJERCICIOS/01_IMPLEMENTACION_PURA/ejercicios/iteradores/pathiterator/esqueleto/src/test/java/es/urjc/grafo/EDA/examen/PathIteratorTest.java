package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathIteratorTest {

    @Test
    void PathIteratorDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        PathIterator<Integer> iterator = new PathIterator<>(tree);
        assertFalse(iterator.hasNext());
    }
}
