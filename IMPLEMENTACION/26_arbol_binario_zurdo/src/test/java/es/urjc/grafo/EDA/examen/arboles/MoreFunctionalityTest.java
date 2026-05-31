package es.urjc.grafo.EDA.examen.arboles;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoreFunctionalityTest {

    @Test
    void arbolVacioYRaizSonZurdos() {
        assertTrue(MoreFunctionality.isOdd(new LinkedBinaryTree<Integer>()));

        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.addRoot(1);
        assertTrue(MoreFunctionality.isOdd(tree));
    }

    @Test
    void comparaDescendientesDeLosSubarbolesDeLaRaiz() {
        LinkedBinaryTree<Integer> leftHeavy = new LinkedBinaryTree<>();
        Position<Integer> root = leftHeavy.addRoot(1);
        Position<Integer> left = leftHeavy.insertLeft(root, 2);
        leftHeavy.insertRight(root, 3);
        leftHeavy.insertLeft(left, 4);
        leftHeavy.insertRight(left, 5);
        assertTrue(MoreFunctionality.isOdd(leftHeavy));

        LinkedBinaryTree<Integer> rightHeavy = new LinkedBinaryTree<>();
        Position<Integer> r = rightHeavy.addRoot(1);
        rightHeavy.insertLeft(r, 2);
        Position<Integer> right = rightHeavy.insertRight(r, 3);
        rightHeavy.insertLeft(right, 4);
        rightHeavy.insertRight(right, 5);
        assertFalse(MoreFunctionality.isOdd(rightHeavy));
    }
}
