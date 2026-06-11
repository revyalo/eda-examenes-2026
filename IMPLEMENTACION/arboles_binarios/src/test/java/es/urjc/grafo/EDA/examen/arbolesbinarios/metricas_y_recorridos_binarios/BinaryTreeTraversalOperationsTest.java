package es.urjc.grafo.EDA.examen.arbolesbinarios.metricas_y_recorridos_binarios;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTraversalOperationsTest {

    private static LinkedBinaryTree<String> sampleTree() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.insertLeft(a, "B");
        Position<String> c = tree.insertRight(a, "C");
        tree.insertLeft(b, "D");
        tree.insertRight(b, "E");
        tree.insertRight(c, "F");
        return tree;
    }

    private static <E> List<E> elements(Iterable<E> iterable) {
        List<E> result = new ArrayList<>();
        for (E element : iterable) {
            result.add(element);
        }
        return result;
    }

    private static <E> List<E> positionElements(Iterable<Position<E>> positions) {
        List<E> result = new ArrayList<>();
        for (Position<E> position : positions) {
            result.add(position.getElement());
        }
        return result;
    }

    @Test
    void heightAndLeavesUseBinaryStructure() {
        LinkedBinaryTree<String> tree = sampleTree();

        assertEquals(2, BinaryTreeTraversalOperations.height(tree));
        assertEquals(3, BinaryTreeTraversalOperations.countLeaves(tree));
    }

    @Test
    void sameShapeIgnoresValues() {
        LinkedBinaryTree<String> first = sampleTree();
        LinkedBinaryTree<Integer> second = new LinkedBinaryTree<>();
        Position<Integer> a = second.addRoot(1);
        Position<Integer> b = second.insertLeft(a, 2);
        Position<Integer> c = second.insertRight(a, 3);
        second.insertLeft(b, 4);
        second.insertRight(b, 5);
        second.insertRight(c, 6);

        assertTrue(BinaryTreeTraversalOperations.hasSameShape(first, second));
    }

    @Test
    void balanceDiameterAndWidthAreComputedFromAllNodes() {
        LinkedBinaryTree<String> tree = sampleTree();

        assertTrue(BinaryTreeTraversalOperations.isBalanced(tree));
        assertEquals(4, BinaryTreeTraversalOperations.diameter(tree));
        assertEquals(3, BinaryTreeTraversalOperations.width(tree));
    }

    @Test
    void nodesAtLevelReturnsRequestedLevel() {
        assertEquals(List.of("D", "E", "F"), positionElements(BinaryTreeTraversalOperations.nodesAtLevel(sampleTree(), 2)));
    }

    @Test
    void nodesAtDistanceKCanMoveThroughParentAndChildren() {
        LinkedBinaryTree<String> tree = sampleTree();
        Position<String> root = tree.root();
        Position<String> left = tree.left(root);

        assertEquals(List.of("C", "D", "E"),
                positionElements(BinaryTreeTraversalOperations.nodesAtDistanceK(tree, left, 1)));
    }

    @Test
    void zigZagAlternatesDirectionByLevel() {
        assertEquals(List.of("A", "C", "B", "D", "E", "F"), elements(BinaryTreeTraversalOperations.zigZagTraversal(sampleTree())));
    }

    @Test
    void verticalOrderGroupsByHorizontalCoordinate() {
        Map<Integer, List<String>> order = BinaryTreeTraversalOperations.verticalOrder(sampleTree());

        assertEquals(List.of("D"), order.get(-2));
        assertEquals(List.of("A", "E"), order.get(0));
    }

    @Test
    void pathToNodeAndLcaUseAncestors() {
        LinkedBinaryTree<String> tree = sampleTree();
        Position<String> root = tree.root();
        Position<String> left = tree.left(root);
        Position<String> d = tree.left(left);
        Position<String> e = tree.right(left);

        assertEquals(List.of("A", "B", "E"), elements(BinaryTreeTraversalOperations.pathToNode(tree, "E")));
        assertEquals(left, BinaryTreeTraversalOperations.lowestCommonAncestor(tree, d, e));
    }
}
