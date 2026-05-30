package es.urjc.grafo.EDA.examen.iteradores;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SkipLeavesIteratorTest {

    private static <E> List<E> values(Iterator<Position<E>> iterator) {
        List<E> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next().getElement());
        }
        return result;
    }

    private static <E> Set<E> valueSet(Iterator<Position<E>> iterator) {
        return new HashSet<>(values(iterator));
    }


        @Test
        void raizSolaNoAparece() {
            LinkedTree<Integer> tree = new LinkedTree<>();
            tree.addRoot(1);
            assertFalse(new SkipLeavesIterator<>(tree).hasNext());
        }

        @Test
        void devuelveInternosPorNiveles() {
            LinkedTree<Integer> tree = sampleGeneralTree();
            assertEquals(List.of(1, 2, 5), values(new SkipLeavesIterator<>(tree)));
        }

        private LinkedTree<Integer> sampleGeneralTree() {
            LinkedTree<Integer> tree = new LinkedTree<>();
            Position<Integer> root = tree.addRoot(1);
            Position<Integer> two = tree.add(2, root);
            tree.add(3, root);
            tree.add(4, two);
            Position<Integer> five = tree.add(5, two);
            tree.add(6, five);
            return tree;
        }

}
