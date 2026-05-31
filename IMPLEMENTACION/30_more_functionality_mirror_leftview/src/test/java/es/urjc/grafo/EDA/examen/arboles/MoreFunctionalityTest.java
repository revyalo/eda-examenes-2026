package es.urjc.grafo.EDA.examen.arboles;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoreFunctionalityTest {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    @Test
    void checkMirrorComparaDosArbolesReflejados() {
        LinkedBinaryTree<Integer> left = new LinkedBinaryTree<>();
        Position<Integer> a = left.addRoot(5);
        Position<Integer> l9 = left.insertLeft(a, 9);
        Position<Integer> l12 = left.insertRight(a, 12);
        left.insertLeft(l9, 7);
        Position<Integer> l4 = left.insertRight(l9, 4);
        left.insertLeft(l4, 1);
        left.insertRight(l4, 2);
        left.insertLeft(l12, 8);
        Position<Integer> l15 = left.insertRight(l12, 15);
        left.insertRight(l15, 14);

        LinkedBinaryTree<Integer> right = new LinkedBinaryTree<>();
        Position<Integer> b = right.addRoot(5);
        Position<Integer> r12 = right.insertLeft(b, 12);
        Position<Integer> r9 = right.insertRight(b, 9);
        Position<Integer> r15 = right.insertLeft(r12, 15);
        right.insertRight(r12, 8);
        right.insertLeft(r15, 14);
        Position<Integer> r4 = right.insertLeft(r9, 4);
        right.insertRight(r9, 7);
        right.insertLeft(r4, 2);
        right.insertRight(r4, 1);

        assertTrue(MoreFunctionality.checkMirror(left, right));
    }

    @Test
    void leftViewDevuelvePrimerNodoVisiblePorNivel() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        tree.add("C", a);
        Position<String> d = tree.add("D", a);
        Position<String> e = tree.add("E", a);
        Position<String> f = tree.add("F", d);
        Position<String> g = tree.add("G", e);
        Position<String> h = tree.add("H", e);
        tree.add("I", e);
        Position<String> j = tree.add("J", g);
        tree.add("K", h);
        tree.add("L", j);
        assertNotNull(b);
        assertNotNull(f);

        assertEquals(List.of("A", "B", "F", "J", "L"), toList(MoreFunctionality.leftView(tree)));
    }
}
