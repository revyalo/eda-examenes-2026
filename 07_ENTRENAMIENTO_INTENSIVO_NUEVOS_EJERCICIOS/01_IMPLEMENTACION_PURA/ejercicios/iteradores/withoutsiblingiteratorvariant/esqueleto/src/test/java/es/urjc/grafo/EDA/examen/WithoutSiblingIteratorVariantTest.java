package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithoutSiblingIteratorVariantTest {

    @Test
    void WithoutSiblingIteratorVariantDebeImplementarse() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        WithoutSiblingIteratorVariant<Integer> iterator = new WithoutSiblingIteratorVariant<>(tree);
        assertFalse(iterator.hasNext());
    }
}
