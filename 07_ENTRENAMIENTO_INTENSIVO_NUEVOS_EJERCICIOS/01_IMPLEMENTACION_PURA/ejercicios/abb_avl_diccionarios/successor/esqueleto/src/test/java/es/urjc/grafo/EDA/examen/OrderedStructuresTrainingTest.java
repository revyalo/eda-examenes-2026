package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedStructuresTrainingTest {

    @Test
    void successorDebeImplementarse() {
        OrderedStructuresTraining<Integer, String> training = new OrderedStructuresTraining<>();
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.addRoot(1);

        assertNull(training.successor(5));
    }
}
