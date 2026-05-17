import es.urjc.grafo.EDA.examen.TreeOperations;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeOperationsAdvancedTest {

    @Test
    void parametrosInvalidosLanzanExcepcion() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        assertThrows(IllegalArgumentException.class, () -> TreeOperations.esCompleto(null));
        assertThrows(IllegalArgumentException.class, () -> TreeOperations.contarNodosEnNivel(null, 0));
        assertThrows(IllegalArgumentException.class, () -> TreeOperations.contarNodosEnNivel(tree, -1));
    }

    @Test
    void completoConUltimoNivelParcialALaIzquierda() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.insertLeft(root, 2);
        Position<Integer> right = tree.insertRight(root, 3);
        tree.insertLeft(left, 4);
        tree.insertRight(left, 5);
        tree.insertLeft(right, 6);
        assertTrue(TreeOperations.esCompleto(tree));
    }

    @Test
    void incompletoPorHuecoIntermedio() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.insertLeft(root, 2);
        Position<Integer> right = tree.insertRight(root, 3);
        tree.insertLeft(left, 4);
        tree.insertLeft(right, 6);
        assertFalse(TreeOperations.esCompleto(tree));
    }
}
