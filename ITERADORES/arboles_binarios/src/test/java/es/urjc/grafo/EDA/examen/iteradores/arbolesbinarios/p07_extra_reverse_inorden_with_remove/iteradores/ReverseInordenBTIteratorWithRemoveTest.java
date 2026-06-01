package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p07_extra_reverse_inorden_with_remove.iteradores;

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

class ReverseInordenBTIteratorWithRemoveTest {

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
        void recorreEnInordenInverso() {
            LinkedBinaryTree<Integer> tree = sampleBinaryTree();
            assertEquals(List.of(6, 3, 1, 5, 2, 4), values(new ReverseInordenBTIteratorWithRemove<>(tree)));
        }

        @Test
        void removeEliminaHojaDerechaVisitada() {
            LinkedBinaryTree<Integer> tree = sampleBinaryTree();
            ReverseInordenBTIteratorWithRemove<Integer> it = new ReverseInordenBTIteratorWithRemove<>(tree);
            assertEquals(6, it.next().getElement());
            it.remove();
            assertEquals(5, tree.size());
            assertEquals(List.of(3, 1, 5, 2, 4), values(new ReverseInordenBTIteratorWithRemove<>(tree)));
        }

        private LinkedBinaryTree<Integer> sampleBinaryTree() {
            LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
            Position<Integer> root = tree.addRoot(1);
            Position<Integer> left = tree.insertLeft(root, 2);
            Position<Integer> right = tree.insertRight(root, 3);
            tree.insertLeft(left, 4);
            tree.insertRight(left, 5);
            tree.insertRight(right, 6);
            return tree;
        }

}
