package es.urjc.grafo.EDA.examen.arboles;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunHandlingTest {

    @Test
    void detectaPrefijoConMismaFormaYContenidoInicial() {
        LinkedBinaryTree<Integer> prefix = new LinkedBinaryTree<>();
        Position<Integer> p3 = prefix.addRoot(3);
        Position<Integer> p10 = prefix.insertLeft(p3, 10);
        prefix.insertRight(p3, 9);
        prefix.insertRight(p10, 5);

        LinkedBinaryTree<Integer> full = new LinkedBinaryTree<>();
        Position<Integer> r3 = full.addRoot(3);
        Position<Integer> r10 = full.insertLeft(r3, 10);
        Position<Integer> r9 = full.insertRight(r3, 9);
        full.insertLeft(r10, 7);
        full.insertRight(r10, 5);
        Position<Integer> r11 = full.insertRight(r9, 11);
        full.insertLeft(r11, 2);
        full.insertRight(r11, 6);

        assertTrue(FunHandling.esPrefijo(prefix, full));
    }

    @Test
    void rechazaSiFallaLaFormaOElContenido() {
        LinkedBinaryTree<Integer> prefix = new LinkedBinaryTree<>();
        Position<Integer> a = prefix.addRoot(3);
        prefix.insertLeft(a, 10);
        prefix.insertRight(a, 9);

        LinkedBinaryTree<Integer> differentValue = new LinkedBinaryTree<>();
        Position<Integer> b = differentValue.addRoot(3);
        differentValue.insertLeft(b, 10);
        differentValue.insertRight(b, 8);

        assertFalse(FunHandling.esPrefijo(prefix, differentValue));

        LinkedBinaryTree<Integer> differentShape = new LinkedBinaryTree<>();
        Position<Integer> c = differentShape.addRoot(3);
        differentShape.insertLeft(c, 10);

        assertFalse(FunHandling.esPrefijo(prefix, differentShape));
    }
}
