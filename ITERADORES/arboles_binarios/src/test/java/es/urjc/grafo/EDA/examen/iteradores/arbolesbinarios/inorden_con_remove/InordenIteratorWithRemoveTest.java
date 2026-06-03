package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.inorden_con_remove;

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

class InordenIteratorWithRemoveTest {

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
        void recorreEnInorden() {
            LinkedBinaryTree<Integer> tree = sampleBinaryTree();
            assertEquals(List.of(4, 2, 5, 1, 3, 6), values(new InordenIteratorWithRemove<>(tree)));
        }

        @Test
        void removeEliminaHojaVisitada() {
            LinkedBinaryTree<Integer> tree = sampleBinaryTree();
            InordenIteratorWithRemove<Integer> it = new InordenIteratorWithRemove<>(tree);
            assertEquals(4, it.next().getElement());
            it.remove();
            assertEquals(5, tree.size());
            assertEquals(List.of(2, 5, 1, 3, 6), values(new InordenIteratorWithRemove<>(tree)));
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
