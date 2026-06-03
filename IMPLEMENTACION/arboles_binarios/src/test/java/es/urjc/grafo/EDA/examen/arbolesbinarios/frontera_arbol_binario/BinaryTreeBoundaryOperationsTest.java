package es.urjc.grafo.EDA.examen.arbolesbinarios.frontera_arbol_binario;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeBoundaryOperationsTest {

    @Test
    void fronteraDeArbolCompletoSinRepetidos() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.insertLeft(a, "B");
        Position<String> c = tree.insertRight(a, "C");
        tree.insertLeft(b, "D");
        tree.insertRight(b, "E");
        tree.insertLeft(c, "F");
        tree.insertRight(c, "G");

        assertEquals(List.of("A", "B", "D", "E", "F", "G", "C"), BinaryTreeBoundaryOperations.boundaryTraversal(tree));
    }

    @Test
    void raizUnicaSoloApareceUnaVez() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        tree.addRoot(1);

        assertEquals(List.of(1), BinaryTreeBoundaryOperations.boundaryTraversal(tree));
    }
}
