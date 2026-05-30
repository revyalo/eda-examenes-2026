package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TreeOperationsTest {

    @Test
    void ejercicioDebeImplementarse() {
        assertTrue(TreeOperations.cumplePropiedadesMonticulo(new LinkedBinaryTree<Integer>(), Integer::compareTo));
    }
}
