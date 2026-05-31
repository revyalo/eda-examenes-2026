package es.urjc.grafo.EDA.examen.bst;

import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSuccessorTreeTest {

    private static MinimumSuccessorTree<Integer> sampleTree() {
        MinimumSuccessorTree<Integer> tree = new MinimumSuccessorTree<>();
        tree.insert(8);
        Position<Integer> four = tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);
        assertEquals(4, four.getElement());
        return tree;
    }

    @Test
    void minimumDevuelveMenorDelArbolYDelSubarbol() {
        MinimumSuccessorTree<Integer> tree = sampleTree();

        assertEquals(2, tree.minimum().getElement());
        assertEquals(10, tree.minimum(tree.right(tree.root())).getElement());
    }

    @Test
    void iteratorRecorreEnOrdenCreciente() {
        MinimumSuccessorTree<Integer> tree = sampleTree();
        List<Integer> values = new ArrayList<>();
        for (Position<Integer> position : tree) {
            values.add(position.getElement());
        }

        assertEquals(List.of(2, 4, 6, 8, 10, 12, 14), values);
    }

    @Test
    void maximumPredecessorDevuelveMayorEnArbolInverso() {
        MaximumPredecessorTree<Integer> tree = new MaximumPredecessorTree<>();
        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(2);
        tree.insert(6);
        tree.insert(10);
        tree.insert(14);

        assertEquals(14, tree.maximum().getElement());
        assertEquals(6, tree.maximum(tree.right(tree.root())).getElement());
    }
}
