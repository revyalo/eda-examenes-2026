package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralTreeWarmupTest {
    @Test
    void countNodesYLeavesDebenImplementarse() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> root = tree.addRoot("A");
        tree.add("B", root);
        tree.add("C", root);
        assertEquals(3, GeneralTreeWarmup.countNodes(tree));
        assertEquals(2, GeneralTreeWarmup.countLeaves(tree));
    }
}
