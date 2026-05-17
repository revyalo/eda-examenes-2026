package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MinimumSuccesorTreeTest {

    @Test
    void ejercicioDebeImplementarse() {
        MinimumSuccesorTree<Integer> tree = new MinimumSuccesorTree<>();
        assertNotNull(tree.minimum());
    }
}
