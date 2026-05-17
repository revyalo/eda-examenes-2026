package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Parcial1Test {

    @Test
    void ejercicioDebeImplementarse() {
        LinkedTree<Integer> tree = new LinkedTree<>();
        Position<Integer> root = tree.addRoot(1);
        assertNotNull(Parcial1.antecesors(tree, root));
    }
}
