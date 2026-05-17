import es.urjc.grafo.EDA.examen.TreeOperations;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeOperationsTest {

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
    void areIdentical() {
        assertThrows(IllegalArgumentException.class, () -> TreeOperations.areIdentical(null, null));
        assertTrue(TreeOperations.areIdentical(new LinkedBinaryTree<>(), new LinkedBinaryTree<>()));
        LinkedBinaryTree<Integer> t1 = new LinkedBinaryTree<>();
        Position<Integer> r = t1.addRoot(1);
        Position<Integer> p2_1 = t1.insertLeft(r, 2);
        Position<Integer> p2_2 = t1.insertRight(r, 2);
        Position<Integer> p7_1 = t1.insertLeft(p2_1, 7);
        Position<Integer> p7_2 = t1.insertRight(p2_2, 7);
        t1.insertLeft(p7_1, 8);
        t1.insertLeft(p7_2, 9);
        t1.insertRight(p7_1, 9);
        t1.insertRight(p7_2, 8);
        assertTrue(TreeOperations.areIdentical(t1, t));
    }

    @Test
    void treeDegree() {
        assertThrows(IllegalArgumentException.class, () -> TreeOperations.treeDegree(null));
        assertEquals(0, TreeOperations.treeDegree(new LinkedTree<>()));
        assertEquals(4, TreeOperations.treeDegree(tree));
    }

}