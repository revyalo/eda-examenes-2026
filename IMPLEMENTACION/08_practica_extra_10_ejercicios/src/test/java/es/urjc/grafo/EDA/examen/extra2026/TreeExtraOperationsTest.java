package es.urjc.grafo.EDA.examen.extra2026;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeExtraOperationsTest {

    private static <E> List<E> elements(Iterable<Position<E>> positions) {
        List<E> result = new ArrayList<>();
        for (Position<E> position : positions) {
            result.add(position.getElement());
        }
        return result;
    }

    @Test
    void almostCompleteAcceptsLeftPackedLastLevel() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> r = tree.addRoot(1);
        Position<Integer> l = tree.insertLeft(r, 2);
        tree.insertRight(r, 3);
        tree.insertLeft(l, 4);

        assertTrue(TreeExtraOperations.isAlmostComplete(tree));
    }

    @Test
    void lowestCommonAncestorFindsDeepestCommonNode() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.insertLeft(a, "B");
        tree.insertRight(a, "C");
        Position<String> d = tree.insertLeft(b, "D");
        Position<String> e = tree.insertRight(b, "E");

        assertEquals(b, TreeExtraOperations.lowestCommonAncestor(tree, d, e));
    }

    @Test
    void widthReturnsLargestLevelSize() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        tree.add("B", a);
        tree.add("C", a);
        tree.add("D", a);

        assertEquals(3, TreeExtraOperations.width(tree));
    }

    @Test
    void descendantsAtDistanceKReturnsOnlyRequestedLevel() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        tree.add("D", b);
        tree.add("E", c);

        assertEquals(List.of("D", "E"), elements(TreeExtraOperations.descendantsAtDistanceK(tree, a, 2)));
    }
}
