import es.urjc.grafo.EDA.examen.TreeOperations;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TreeOperationsTest {

    private LinkedBinaryTree<Integer> tree;
    private final Comparator<Integer> comparator = Integer::compare;

    @BeforeEach
    void setUp() {
        tree = new LinkedBinaryTree<>();
    }

    @Test
    void cumplePropiedadesMonticulo_arbolNull_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> TreeOperations.cumplePropiedadesMonticulo(null, comparator));
    }

    @Test
    void cumplePropiedadesMonticulo_arbolVacio_devuelveTrue() {
        assertTrue(TreeOperations.cumplePropiedadesMonticulo(tree, comparator));
    }

    @Test
    void cumplePropiedadesMonticulo_heapValido_devuelveTrue() {
        var r = tree.addRoot(1);
        var l = tree.insertLeft(r, 2);
        var rr = tree.insertRight(r, 3);
        tree.insertLeft(l, 4);
        tree.insertRight(l, 5);
        tree.insertLeft(rr, 6);
        tree.insertRight(rr, 7);

        assertTrue(TreeOperations.cumplePropiedadesMonticulo(tree, comparator));
    }

    @Test
    void cumplePropiedadesMonticulo_violaOrden_devuelveFalse() {
        var r = tree.addRoot(10);
        tree.insertLeft(r, 5); // Hijo con mayor prioridad que el padre

        assertFalse(TreeOperations.cumplePropiedadesMonticulo(tree, comparator));
    }

    @Test
    void cumplePropiedadesMonticulo_violaEstructura_devuelveFalse() {
        var r = tree.addRoot(1);
        tree.insertRight(r, 2); // Falta hijo izquierdo en el primer nivel

        assertFalse(TreeOperations.cumplePropiedadesMonticulo(tree, comparator));
    }

    @Test
    void cumplePropiedadesMonticulo_heapGrandeCompleto_devuelveTrue() {
        var r = tree.addRoot(1);
        var l = tree.insertLeft(r, 2);
        var rr = tree.insertRight(r, 3);
        var l1 = tree.insertLeft(l, 4);
        var l2 = tree.insertRight(l, 5);
        var r1 = tree.insertLeft(rr, 6);
        var r2 = tree.insertRight(rr, 7);
        tree.insertLeft(l1, 8);
        tree.insertRight(l1, 9);
        tree.insertLeft(l2, 10);
        tree.insertRight(l2, 11);
        tree.insertLeft(r1, 12);
        tree.insertRight(r1, 13);
        tree.insertLeft(r2, 14);
        tree.insertRight(r2, 15);

        assertTrue(TreeOperations.cumplePropiedadesMonticulo(tree, comparator));
    }

    @Test
    void cumplePropiedadesMonticulo_valoresIguales_devuelveTrue() {
        var r = tree.addRoot(5);
        var l = tree.insertLeft(r, 5);
        var rr = tree.insertRight(r, 5);
        tree.insertLeft(l, 5);
        tree.insertRight(l, 5);
        tree.insertLeft(rr, 5);

        assertTrue(TreeOperations.cumplePropiedadesMonticulo(tree, comparator));
    }

    @Test
    void cumplePropiedadesMonticulo_huecoIntermedio_devuelveFalse() {
        var r = tree.addRoot(1);
        var l = tree.insertLeft(r, 2);
        var rr = tree.insertRight(r, 3);
        tree.insertLeft(l, 4);
        // Falta hijo derecho de l
        tree.insertLeft(rr, 5); // Aparece un hijo en nivel siguiente tras un hueco

        assertFalse(TreeOperations.cumplePropiedadesMonticulo(tree, comparator));
    }
}