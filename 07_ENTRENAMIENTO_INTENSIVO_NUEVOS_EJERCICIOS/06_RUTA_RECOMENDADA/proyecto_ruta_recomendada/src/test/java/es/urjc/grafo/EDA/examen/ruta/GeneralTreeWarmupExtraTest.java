package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTreeWarmupExtraTest {
    private LinkedTree<String> sampleTree() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> root = tree.addRoot("A");
        Position<String> b = tree.add("B", root);
        tree.add("C", root);
        tree.add("D", b);
        return tree;
    }

    @Test void heightDebeImplementarse() {
        assertEquals(2, GeneralTreeWarmup.height(sampleTree()));
    }

    @Test void treeDegreeDebeImplementarse() {
        assertEquals(2, GeneralTreeWarmup.treeDegree(sampleTree()));
    }

    @Test void descendantsNumberDebeImplementarse() {
        LinkedTree<String> tree = sampleTree();
        assertEquals(3, GeneralTreeWarmup.descendantsNumber(tree, tree.root()));
    }

    @Test void nodesAtDepthDebeImplementarse() {
        assertNotNull(GeneralTreeWarmup.nodesAtDepth(sampleTree(), 1));
    }

    @Test void isPerfectDebeImplementarse() {
        assertFalse(GeneralTreeWarmup.isPerfect(sampleTree()));
    }

    @Test void internalNodeIteratorDebeImplementarse() {
        InternalNodeIterator<String> iterator = new InternalNodeIterator<>(sampleTree());
        assertTrue(iterator.hasNext());
    }
}
