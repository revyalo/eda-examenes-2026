package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeOperationsTrainingTest {

    @Test
    void widthDebeImplementarse() {
        LinkedBinaryTree<Integer> binary = new LinkedBinaryTree<>();
        Position<Integer> root = binary.addRoot(1);
        Position<Integer> left = binary.insertLeft(root, 2);
        Position<Integer> right = binary.insertRight(root, 2);

        LinkedTree<Integer> general = new LinkedTree<>();
        Position<Integer> gRoot = general.addRoot(1);
        general.add(2, gRoot);
        general.add(3, gRoot);

        assertEquals(2, TreeOperationsTraining.width(binary));
    }
}
