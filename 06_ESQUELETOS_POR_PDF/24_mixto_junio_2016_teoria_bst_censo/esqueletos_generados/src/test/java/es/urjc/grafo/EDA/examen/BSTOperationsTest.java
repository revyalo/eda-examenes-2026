package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BSTOperationsTest {

    @Test
    void ejercicioDebeImplementarse() {
        BSTOperations<Integer> tree = new BSTOperations<>();
        assertNotNull(tree.toLinkedTree());
    }
}
