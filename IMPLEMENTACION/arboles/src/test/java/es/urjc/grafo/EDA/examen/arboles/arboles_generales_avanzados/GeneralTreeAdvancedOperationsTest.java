package es.urjc.grafo.EDA.examen.arboles.arboles_generales_avanzados;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneralTreeAdvancedOperationsTest {

    private static <E> List<E> elements(Iterable<Position<E>> positions) {
        List<E> result = new ArrayList<>();
        for (Position<E> position : positions) {
            result.add(position.getElement());
        }
        return result;
    }

    private static <E> List<List<E>> pathElements(Iterable<Iterable<Position<E>>> paths) {
        List<List<E>> result = new ArrayList<>();
        for (Iterable<Position<E>> path : paths) {
            result.add(elements(path));
        }
        return result;
    }

    @Test
    void heightCountsLongestRootToLeafPath() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", b);
        tree.add("D", c);

        assertEquals(3, GeneralTreeAdvancedOperations.height(tree));
    }

    @Test
    void nodesAtDepthReturnsOnlyRequestedLevel() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        tree.add("B", a);
        tree.add("C", a);

        assertEquals(List.of("B", "C"), elements(GeneralTreeAdvancedOperations.nodesAtDepth(tree, 1)));
    }

    @Test
    void pathToRootMovesThroughParents() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", b);

        assertEquals(List.of("C", "B", "A"), elements(GeneralTreeAdvancedOperations.pathToRoot(tree, c)));
    }

    @Test
    void lowestCommonAncestorFindsDeepestSharedAncestor() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        Position<String> d = tree.add("D", b);
        Position<String> e = tree.add("E", b);

        assertEquals(b, GeneralTreeAdvancedOperations.lowestCommonAncestor(tree, d, e));
        assertEquals(a, GeneralTreeAdvancedOperations.lowestCommonAncestor(tree, d, c));
    }

    @Test
    void cousinsHaveSameDepthAndDifferentParent() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        Position<String> d = tree.add("D", b);
        Position<String> e = tree.add("E", c);

        assertTrue(GeneralTreeAdvancedOperations.areCousins(tree, d, e));
    }

    @Test
    void perfectRequiresUniformLeafDepthAndInternalDegree() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        tree.add("B", a);
        tree.add("C", a);

        assertTrue(GeneralTreeAdvancedOperations.isPerfect(tree));
    }

    @Test
    void levelWithMostNodesReturnsSmallestWinningLevel() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        tree.add("B", a);
        tree.add("C", a);
        tree.add("D", a);

        assertEquals(1, GeneralTreeAdvancedOperations.levelWithMostNodes(tree));
    }

    @Test
    void subtreeSizeIncludesRootOfSubtree() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        tree.add("C", b);
        tree.add("D", b);

        assertEquals(3, GeneralTreeAdvancedOperations.subtreeSize(tree, b));
    }

    @Test
    void distanceUsesEdgesBetweenPositions() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        Position<String> d = tree.add("D", b);

        assertEquals(3, GeneralTreeAdvancedOperations.distance(tree, d, c));
    }

    @Test
    void pathBetweenReturnsFullPathFromFirstToSecond() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        Position<String> d = tree.add("D", b);

        assertEquals(List.of("D", "B", "A", "C"), elements(GeneralTreeAdvancedOperations.pathBetween(tree, d, c)));
    }

    @Test
    void removeLeavesDeletesOnlyCurrentLeaves() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        tree.add("C", a);
        tree.add("D", b);

        assertEquals(2, GeneralTreeAdvancedOperations.removeLeaves(tree));
        assertEquals(2, tree.size());
        assertEquals(List.of("A", "B"), elements(tree));
    }

    @Test
    void copySubtreeCreatesIndependentTreeWithSameShapeAndElements() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        tree.add("C", b);
        tree.add("D", b);

        LinkedTree<String> copy = GeneralTreeAdvancedOperations.copySubtree(tree, b);

        assertEquals(List.of("B", "C", "D"), elements(copy));
        tree.replace(b, "X");
        assertEquals("B", copy.root().getElement());
    }

    @Test
    void rootToLeafPathsReturnsEveryLeafPath() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        tree.add("C", a);
        tree.add("D", b);

        assertEquals(List.of(List.of("A", "B", "D"), List.of("A", "C")),
                pathElements(GeneralTreeAdvancedOperations.rootToLeafPaths(tree)));
    }

    @Test
    void removeSubtreeDeletesCompleteBranchAndReportsSize() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        tree.add("C", a);
        tree.add("D", b);
        tree.add("E", b);

        assertEquals(3, GeneralTreeAdvancedOperations.removeSubtree(tree, b));
        assertEquals(List.of("A", "C"), elements(tree));
    }

    @Test
    void subtreeWithMostNodesIgnoresTheRootParameterItself() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        tree.add("D", b);
        tree.add("E", b);
        tree.add("F", c);

        assertEquals(b, GeneralTreeAdvancedOperations.subtreeWithMostNodes(tree, a));
    }

    @Test
    void sameShapeIgnoringChildrenOrderAllowsPermutedChildren() {
        LinkedTree<String> first = new LinkedTree<>();
        Position<String> a = first.addRoot("A");
        Position<String> b = first.add("B", a);
        first.add("C", a);
        first.add("D", b);

        LinkedTree<Integer> second = new LinkedTree<>();
        Position<Integer> one = second.addRoot(1);
        second.add(2, one);
        Position<Integer> three = second.add(3, one);
        second.add(4, three);

        assertTrue(GeneralTreeAdvancedOperations.sameShapeIgnoringChildrenOrder(first, second));
    }

    @Test
    void isomorphicIgnoresElementsButChecksShape() {
        LinkedTree<String> first = new LinkedTree<>();
        Position<String> a = first.addRoot("A");
        first.add("B", a);
        first.add("C", a);
        LinkedTree<Integer> second = new LinkedTree<>();
        Position<Integer> one = second.addRoot(1);
        second.add(2, one);
        second.add(3, one);

        assertTrue(GeneralTreeAdvancedOperations.isIsomorphic(first, second));
    }
}
