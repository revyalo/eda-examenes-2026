import es.urjc.grafo.EDA.examen.ExtendedBreadthFirstTreeIterator;
import es.urjc.grafo.EDA.examen.TreeOperations;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedBreadthFirstTreeIteratorTest {

    private LinkedBinaryTree<Integer> t;
    private LinkedTree<Character> tree;
    Position<Integer> p8R, p9I;
    Position<Character> pa, pb, pc;

    @BeforeEach
    void setUp() {
        t = new LinkedBinaryTree<>();
        Position<Integer> p1 = t.addRoot(1);
        Position<Integer> p2I = t.insertLeft(p1, 2);
        Position<Integer> p2R = t.insertRight(p1, 2);
        Position<Integer> p7I = t.insertLeft(p2I, 7);
        Position<Integer> p7R = t.insertRight(p2R, 7);
        t.insertLeft(p7I, 8);
        p9I = t.insertRight(p7I, 9);
        t.insertLeft(p7R, 9);
        p8R = t.insertRight(p7R, 8);

        tree = new LinkedTree<>();
        pa = tree.addRoot('a');
        pb = tree.add('e', pa);
        tree.add('i', pa);
        tree.add('o', pa);
        pc = tree.add('u', pa);
        tree.add('b', pb);
        tree.add('c', pb);
        tree.add('d', pb);
    }

    @Test
    void recorridoEnAmplitud_sinBorrados() {
        LinkedTree<Integer> hTree = buildSampleTree();
        ExtendedBreadthFirstTreeIterator<Integer> it = new ExtendedBreadthFirstTreeIterator<>(hTree);
        List<Integer> expectedOrder = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer expected : expectedOrder) {
            assertTrue(it.hasNext());
            Position<Integer> pos = it.next();
            assertEquals(expected, pos.getElement());
        }
        assertFalse(it.hasNext());
    }

    @Test
    void recorridoEnAmplitud_eliminarNodoHojaYSubarbol() {
        LinkedTree<Integer> hTree = buildSampleTree();
        ExtendedBreadthFirstTreeIterator<Integer> it = new ExtendedBreadthFirstTreeIterator<>(hTree);
        List<Integer> expectedOrder = Arrays.asList(1, 2, 3, 4);
        for (Integer expected : expectedOrder) {
            assertTrue(it.hasNext());
            Position<Integer> pos = it.next();
            assertEquals(expected, pos.getElement());
            if (expected == 4) {
                it.remove();
            }
        }
        assertFalse(it.hasNext());

        ExtendedBreadthFirstTreeIterator<Integer> it2 = new ExtendedBreadthFirstTreeIterator<>(hTree);
        List<Integer> expectedOrderAfterRemoval = Arrays.asList(1, 2, 3);
        for (Integer expected : expectedOrderAfterRemoval) {
            assertTrue(it2.hasNext());
            Position<Integer> pos = it2.next();
            assertEquals(expected, pos.getElement());
        }
        assertFalse(it2.hasNext());
    }

    @Test
    void recorridoEnAmplitud_eliminarNodoIntermedioConSubarbol() {
        LinkedTree<Integer> hTree = buildSampleTree();
        ExtendedBreadthFirstTreeIterator<Integer> it = new ExtendedBreadthFirstTreeIterator<>(hTree);
        List<Integer> expectedOrder = Arrays.asList(1, 2, 3);
        for (Integer expected : expectedOrder) {
            assertTrue(it.hasNext());
            Position<Integer> pos = it.next();
            assertEquals(expected, pos.getElement());
            if (expected == 2) {
                it.remove();
            }
        }
        assertFalse(it.hasNext());
    }

    private LinkedTree<Integer> buildSampleTree() {
        LinkedTree<Integer> hTree = new LinkedTree<>();
        Position<Integer> r = hTree.addRoot(1);
        Position<Integer> c1 = hTree.add(2, r);
        Position<Integer> c2 = hTree.add(3, r);
        Position<Integer> c3 = hTree.add(4, c1);
        hTree.add(5, c3);
        return hTree;
    }



}