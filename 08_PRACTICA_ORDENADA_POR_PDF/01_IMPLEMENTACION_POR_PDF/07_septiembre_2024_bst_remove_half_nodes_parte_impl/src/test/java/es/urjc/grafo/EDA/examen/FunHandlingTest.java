package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FunHandlingTest {

    @Test
    void ejercicioDebeImplementarse() {
        assertDoesNotThrow(() -> FunHandling.removeHalfNodes(new LinkedBinaryTree<>()));
    }
}
