package es.urjc.grafo.EDA.examen.arboles.numero_descendientes;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumeroDescendientesTest {

    @Test
    void ejercicioDebeImplementarse() {
        LinkedTree<Integer> tree = new LinkedTree<>();
        Position<Integer> root = tree.addRoot(1);
        assertEquals(0, TreeOperations.descendantsNumber(tree, root));
    }
}
