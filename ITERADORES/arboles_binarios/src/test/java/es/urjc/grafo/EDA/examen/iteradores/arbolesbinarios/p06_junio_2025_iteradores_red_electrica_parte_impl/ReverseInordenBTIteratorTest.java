package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p06_junio_2025_iteradores_red_electrica_parte_impl;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class ReverseInordenBTIteratorTest {

    @Test
    void ejercicioDebeImplementarse() {
        ReverseInordenBTIterator<Integer> iterator = new ReverseInordenBTIterator<>(new LinkedBinaryTree<>());
        assertFalse(iterator.hasNext());
    }
}
