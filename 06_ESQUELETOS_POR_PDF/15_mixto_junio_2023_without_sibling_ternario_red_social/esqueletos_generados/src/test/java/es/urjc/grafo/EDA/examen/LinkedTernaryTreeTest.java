package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LinkedTernaryTreeTest {

    @Test
    void ejercicioDebeImplementarse() {
        LinkedTernaryTree<Integer> tree = new LinkedTernaryTree<>();
        assertNotNull(tree.addRoot(1));
    }
}
