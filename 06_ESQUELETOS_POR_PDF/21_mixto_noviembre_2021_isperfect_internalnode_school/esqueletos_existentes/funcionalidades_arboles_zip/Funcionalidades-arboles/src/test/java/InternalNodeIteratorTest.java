import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.trees.binaryTrees.InternalNodeIterator;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for InternalNodeIterator of a BinaryTree
 */
public class InternalNodeIteratorTest {

    private Position<Integer> p5;
    private Position<Integer> p6, p7, p9;

    private BinaryTree<Integer> initializeTree() {
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        p5 = t.addRoot(5);
        p6 = t.insertLeft(p5, 6);
        p7 = t.insertRight(p5, 7);
        t.insertLeft(p6, 8);
        p9 = t.insertRight(p6, 9);
        t.insertLeft(p7, 10);
        t.insertRight(p7, 11);
        return t;
    }

    /**
     * Test the hasNext and next methods of the InternalNodeIterator.
     */
    @Test
    public void testHasNextAndNext() {
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> new InternalNodeIterator<>(null), "Iterator should throw exception for null tree");
        BinaryTree<Integer> finalT = t;
        Assertions.assertThrows(IllegalArgumentException.class, () -> new InternalNodeIterator<>(finalT), "Iterator should throw exception for empty tree");

        t.addRoot(25);
        Iterator<Position<Integer>> instance = new InternalNodeIterator<>(t);
        assertFalse(instance.hasNext(), "Single root node is not an internal node");

        t = initializeTree();
        instance = new InternalNodeIterator<>(t);
        assertTrue(instance.hasNext(), "Iterator should have next on a populated tree");

        Set<Position<Integer>> expectedNodes = Set.of(p5, p6, p7);
        Set<Position<Integer>> visitedNodes = new HashSet<>();

        while (instance.hasNext()) {
            Position<Integer> currentNode = instance.next();
            assertTrue(expectedNodes.contains(currentNode), "Iterator returned unexpected node");
            visitedNodes.add(currentNode);
        }

        assertEquals(expectedNodes, visitedNodes, "Iterator did not return all expected internal nodes");
    }

    /**
     * Test with a tree having only a root node.
     */
    @Test
    public void testSingleRootNode() {
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        t.addRoot(10);
        InternalNodeIterator<Integer> instance = new InternalNodeIterator<>(t);

        assertFalse(instance.hasNext(), "Iterator should not have next for a single root node");
    }

    /**
     * Test with a tree where all nodes are internal nodes.
     */
    @Test
    public void testAllInternalNodes() {
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        Position<Integer> root = t.addRoot(1);
        Position<Integer> left = t.insertLeft(root, 2);
        Position<Integer> right = t.insertRight(root, 3);
        t.insertLeft(left, 4);
        t.insertRight(left, 5);
        t.insertLeft(right, 6);
        t.insertRight(right, 7);

        InternalNodeIterator<Integer> instance = new InternalNodeIterator<>(t);

        Set<Position<Integer>> expectedNodes = Set.of(root, left, right);
        Set<Position<Integer>> visitedNodes = new HashSet<>();

        while (instance.hasNext()) {
            Position<Integer> currentNode = instance.next();
            assertTrue(expectedNodes.contains(currentNode), "Iterator returned unexpected node");
            visitedNodes.add(currentNode);
        }

        assertEquals(expectedNodes, visitedNodes, "Iterator did not return all expected internal nodes");
    }

    /**
     * Test edge cases like a completely unbalanced tree.
     */
    @Test
    public void testUnbalancedTree() {
        BinaryTree<Integer> t = new LinkedBinaryTree<>();
        Position<Integer> root = t.addRoot(1);
        Position<Integer> left = t.insertLeft(root, 2);
        t.insertLeft(left, 3);

        InternalNodeIterator<Integer> instance = new InternalNodeIterator<>(t);

        Set<Position<Integer>> expectedNodes = Set.of(root, left);
        Set<Position<Integer>> visitedNodes = new HashSet<>();

        while (instance.hasNext()) {
            Position<Integer> currentNode = instance.next();
            assertTrue(expectedNodes.contains(currentNode), "Iterator returned unexpected node");
            visitedNodes.add(currentNode);
        }

        assertEquals(expectedNodes, visitedNodes, "Iterator did not return all expected internal nodes in unbalanced tree");
    }
}
