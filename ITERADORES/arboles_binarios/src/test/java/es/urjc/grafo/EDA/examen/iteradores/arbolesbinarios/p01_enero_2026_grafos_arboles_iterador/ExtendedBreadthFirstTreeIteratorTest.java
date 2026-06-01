package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p01_enero_2026_grafos_arboles_iterador;

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
