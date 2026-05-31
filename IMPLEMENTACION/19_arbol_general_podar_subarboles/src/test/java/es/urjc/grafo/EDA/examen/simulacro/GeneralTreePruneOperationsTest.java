package es.urjc.grafo.EDA.examen.simulacro;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralTreePruneOperationsTest {

    @Test
    void eliminaSubarbolesPropiosPequenos() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        tree.add("C", a);
        tree.add("D", b);
        tree.add("E", b);

        assertEquals(1, GeneralTreePruneOperations.removeSubtreesSmallerThan(tree, 2));
        assertEquals(4, tree.size());
    }
}
