import es.urjc.grafo.EDA.examen.TreeOperations;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeOperationsPublicTest {

    @Test
    void arbolVacioYRaizSonCompletos() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        assertTrue(TreeOperations.esCompleto(tree));
        tree.addRoot(1);
        assertTrue(TreeOperations.esCompleto(tree));
    }

    @Test
    void detectaHuecoEnHijoIzquierdo() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        tree.insertRight(root, 3);
        assertFalse(TreeOperations.esCompleto(tree));
    }

    @Test
    void cuentaNodosPorNivel() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(1);
        Position<Integer> left = tree.insertLeft(root, 2);
        tree.insertRight(root, 3);
        tree.insertLeft(left, 4);
        assertEquals(1, TreeOperations.contarNodosEnNivel(tree, 0));
        assertEquals(2, TreeOperations.contarNodosEnNivel(tree, 1));
        assertEquals(1, TreeOperations.contarNodosEnNivel(tree, 2));
        assertEquals(0, TreeOperations.contarNodosEnNivel(tree, 3));
    }
}
