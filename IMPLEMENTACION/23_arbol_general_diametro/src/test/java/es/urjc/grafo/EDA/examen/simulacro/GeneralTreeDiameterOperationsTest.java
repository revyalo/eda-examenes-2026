package es.urjc.grafo.EDA.examen.simulacro;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralTreeDiameterOperationsTest {

    @Test
    void diametroEntreDosHojasProfundas() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        tree.add("D", b);
        Position<String> e = tree.add("E", c);
        tree.add("F", e);

        assertEquals(5, GeneralTreeDiameterOperations.diameter(tree));
    }
}
