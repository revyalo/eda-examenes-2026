package es.urjc.grafo.EDA.examen.iteradores.arboles.p01_enero_2026_extended_breadth_first_remove.iteradores;

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

class ExtendedBreadthFirstTreeIteratorTest {

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
        void recorridoInicialEnAnchura() {
            LinkedTree<Integer> tree = sampleGeneralTree();
            assertEquals(List.of(1, 2, 3, 4, 5), values(new ExtendedBreadthFirstTreeIterator<>(tree)));
        }

        @Test
        void removeEliminaHoja() {
            LinkedTree<Integer> tree = sampleGeneralTree();
            ExtendedBreadthFirstTreeIterator<Integer> it = new ExtendedBreadthFirstTreeIterator<>(tree);

            assertEquals(1, it.next().getElement());
            assertEquals(2, it.next().getElement());
            assertEquals(3, it.next().getElement());
            assertEquals(4, it.next().getElement());
            it.remove();

            assertEquals(4, tree.size());
            assertEquals(List.of(1, 2, 3, 5), values(new ExtendedBreadthFirstTreeIterator<>(tree)));
        }

        @Test
        void removeEliminaNodoInternoYNoVisitaSuSubarbolPendiente() {
            LinkedTree<Integer> tree = sampleGeneralTree();
            ExtendedBreadthFirstTreeIterator<Integer> it = new ExtendedBreadthFirstTreeIterator<>(tree);

            assertEquals(1, it.next().getElement());
            assertEquals(2, it.next().getElement());
            it.remove();

            assertEquals(List.of(3), values(it));
            assertEquals(2, tree.size());
            assertEquals(List.of(1, 3), values(new ExtendedBreadthFirstTreeIterator<>(tree)));
        }

        private LinkedTree<Integer> sampleGeneralTree() {
            LinkedTree<Integer> tree = new LinkedTree<>();
            Position<Integer> root = tree.addRoot(1);
            Position<Integer> two = tree.add(2, root);
            tree.add(3, root);
            tree.add(4, two);
            tree.add(5, two);
            return tree;
        }

}
