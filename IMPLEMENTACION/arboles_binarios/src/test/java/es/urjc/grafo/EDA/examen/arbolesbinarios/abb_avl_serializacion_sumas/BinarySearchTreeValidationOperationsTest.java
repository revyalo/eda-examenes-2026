package es.urjc.grafo.EDA.examen.arbolesbinarios.abb_avl_serializacion_sumas;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeValidationOperationsTest {

    private static LinkedBinaryTree<Integer> bst() {
        LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
        Position<Integer> root = tree.addRoot(8);
        Position<Integer> left = tree.insertLeft(root, 4);
        Position<Integer> right = tree.insertRight(root, 12);
        tree.insertLeft(left, 2);
        tree.insertRight(left, 6);
        tree.insertLeft(right, 10);
        tree.insertRight(right, 14);
        return tree;
    }

    private static List<List<Integer>> normalize(Iterable<Iterable<Integer>> paths) {
        List<List<Integer>> result = new ArrayList<>();
        for (Iterable<Integer> path : paths) {
            List<Integer> one = new ArrayList<>();
            for (Integer value : path) {
                one.add(value);
            }
            result.add(one);
        }
        return result;
    }

    @Test
    void isBSTUsesComparatorBounds() {
        assertTrue(BinarySearchTreeValidationOperations.isBST(bst(), Integer::compareTo));
    }

    @Test
    void isAVLRequiresBSTAndBalance() {
        assertTrue(BinarySearchTreeValidationOperations.isAVL(bst()));
    }

    @Test
    void floorAndCeilingReturnClosestBounds() {
        LinkedBinaryTree<Integer> tree = bst();

        assertEquals(6, BinarySearchTreeValidationOperations.floor(tree, 7, Integer::compareTo).getElement());
        assertEquals(8, BinarySearchTreeValidationOperations.ceiling(tree, 7, Integer::compareTo).getElement());
    }

    @Test
    void predecessorAndSuccessorAreStrict() {
        LinkedBinaryTree<Integer> tree = bst();

        assertEquals(6, BinarySearchTreeValidationOperations.predecessor(tree, 8, Integer::compareTo).getElement());
        assertEquals(10, BinarySearchTreeValidationOperations.successor(tree, 8, Integer::compareTo).getElement());
    }

    @Test
    void removeRangeDeletesIncludedKeysAndReturnsThemInOrder() {
        LinkedBinaryTree<Integer> tree = bst();

        List<Integer> removed = new ArrayList<>();
        for (Integer value : BinarySearchTreeValidationOperations.removeRange(tree, 4, 12, Integer::compareTo)) {
            removed.add(value);
        }

        assertEquals(List.of(4, 6, 8, 10, 12), removed);
        assertTrue(BinarySearchTreeValidationOperations.isBST(tree, Integer::compareTo));
        assertEquals(List.of(2, 14), inorderElements(tree));
    }

    @Test
    void kthSmallestUsesInorderPosition() {
        LinkedBinaryTree<Integer> tree = bst();

        assertEquals(6, BinarySearchTreeValidationOperations.kthSmallest(tree, 3).getElement());
    }

    @Test
    void trimBstKeepsOnlyValuesInsideRange() {
        LinkedBinaryTree<Integer> tree = bst();

        LinkedBinaryTree<Integer> trimmed = BinarySearchTreeValidationOperations.trimBST(tree, 5, 12, Integer::compareTo);

        assertTrue(BinarySearchTreeValidationOperations.isBST(trimmed, Integer::compareTo));
        assertEquals(List.of(6, 8, 10, 12), inorderElements(trimmed));
    }

    @Test
    void serializeDeserializePreservesShapeAndValues() {
        String serialized = BinarySearchTreeValidationOperations.serialize(bst());
        LinkedBinaryTree<Integer> rebuilt = BinarySearchTreeValidationOperations.deserialize(serialized);

        assertTrue(BinarySearchTreeValidationOperations.isBST(rebuilt, Integer::compareTo));
        assertEquals(serialized, BinarySearchTreeValidationOperations.serialize(rebuilt));
    }

    @Test
    void pathSumChecksRootToLeafPaths() {
        assertTrue(BinarySearchTreeValidationOperations.pathSum(bst(), 14));
        assertFalse(BinarySearchTreeValidationOperations.pathSum(bst(), 999));
    }

    @Test
    void pathsWithSumReturnsAllMatchingPaths() {
        assertEquals(List.of(List.of(8, 4, 2)), normalize(BinarySearchTreeValidationOperations.pathsWithSum(bst(), 14)));
    }

    private static List<Integer> inorderElements(LinkedBinaryTree<Integer> tree) {
        List<Integer> result = new ArrayList<>();
        for (Position<Integer> position : tree) {
            result.add(position.getElement());
        }
        return result;
    }
}
