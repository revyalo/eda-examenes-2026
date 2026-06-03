package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.nodos_internos_arbol_perfecto;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class InternalNodeIteratorTest {

    @Test
    void ejercicioDebeImplementarse() {
        InternalNodeIterator<Integer> iterator = new InternalNodeIterator<>(new LinkedBinaryTree<>());
        assertFalse(iterator.hasNext());
    }
}
