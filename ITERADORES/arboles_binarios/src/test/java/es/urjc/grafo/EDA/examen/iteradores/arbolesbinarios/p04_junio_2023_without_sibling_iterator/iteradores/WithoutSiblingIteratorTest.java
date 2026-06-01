package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p04_junio_2023_without_sibling_iterator.iteradores;

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

class WithoutSiblingIteratorTest {

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
        void raizSolaNoCuenta() {
            LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
            tree.addRoot(1);
            assertFalse(new WithoutSiblingIterator<>(tree).hasNext());
        }

        @Test
        void devuelveNodosSinHermano() {
            LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
            Position<Integer> root = tree.addRoot(1);
            Position<Integer> left = tree.insertLeft(root, 2);
            Position<Integer> right = tree.insertRight(root, 3);
            Position<Integer> four = tree.insertLeft(left, 4);
            tree.insertRight(right, 5);
            tree.insertRight(four, 7);

            assertEquals(Set.of(4, 5, 7), valueSet(new WithoutSiblingIterator<>(tree)));
        }

}
