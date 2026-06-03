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
}
