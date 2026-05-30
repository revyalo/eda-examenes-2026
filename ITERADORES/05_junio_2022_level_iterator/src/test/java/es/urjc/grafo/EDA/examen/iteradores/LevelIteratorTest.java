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

class LevelIteratorTest {

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
        void arbolVacioNoTieneSiguiente() {
            assertFalse(new LevelIterator<>(new LinkedBinaryTree<Integer>()).hasNext());
        }

        @Test
        void recorrePorNiveles() {
            LinkedBinaryTree<Integer> tree = sampleBinaryTree();
            assertEquals(List.of(1, 2, 3, 4, 5, 6), values(new LevelIterator<>(tree)));
        }

        @Test
        void removeEliminaUltimoNodoHojaDevuelto() {
            LinkedBinaryTree<Integer> tree = sampleBinaryTree();
            LevelIterator<Integer> it = new LevelIterator<>(tree);
            assertEquals(1, it.next().getElement());
            assertEquals(2, it.next().getElement());
            assertEquals(3, it.next().getElement());
            assertEquals(4, it.next().getElement());
            it.remove();
            assertEquals(5, tree.size());
            assertEquals(List.of(1, 2, 3, 5, 6), values(new LevelIterator<>(tree)));
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
