package es.urjc.grafo.EDA.examen.arbolesbinarios.p03_diciembre_2025_euler_descendants_symmetric;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeOperationsTest {

    @Test
    void ejercicioDebeImplementarse() {
        LinkedTree<Integer> tree = new LinkedTree<>();
        Position<Integer> root = tree.addRoot(1);
        assertEquals(0, TreeOperations.descendantsNumber(tree, root));
    }
}
