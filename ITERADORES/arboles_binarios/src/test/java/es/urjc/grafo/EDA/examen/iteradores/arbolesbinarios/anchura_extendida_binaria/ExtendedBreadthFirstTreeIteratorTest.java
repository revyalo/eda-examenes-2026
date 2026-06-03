package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.anchura_extendida_binaria;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ExtendedBreadthFirstTreeIteratorTest {

    @Test
    void ejercicioDebeImplementarse() {
        ExtendedBreadthFirstTreeIterator<Integer> iterator = new ExtendedBreadthFirstTreeIterator<>(new LinkedBinaryTree<>());
        assertFalse(iterator.hasNext());
    }
}
