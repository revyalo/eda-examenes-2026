package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p02_junio_2025_reverse_inorden.iteradores;

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

class ReverseInordenBTIteratorTest {

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
            assertFalse(new ReverseInordenBTIterator<>(new LinkedBinaryTree<Integer>()).hasNext());
        }

        @Test
        void recorreEnInordenInverso() {
            LinkedBinaryTree<Integer> tree = new LinkedBinaryTree<>();
            Position<Integer> p3 = tree.addRoot(3);
            Position<Integer> p10 = tree.insertLeft(p3, 10);
            Position<Integer> p9 = tree.insertRight(p3, 9);
            tree.insertLeft(p10, 7);
            tree.insertRight(p10, 5);
            Position<Integer> p11 = tree.insertRight(p9, 11);
            tree.insertLeft(p11, 2);
            tree.insertRight(p11, 6);

            assertEquals(List.of(6, 11, 2, 9, 3, 5, 10, 7), values(new ReverseInordenBTIterator<>(tree)));
        }

        @Test
        void arbolConUnSoloNodo() {
            LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
            tree.addRoot("raiz");
            assertEquals(List.of("raiz"), values(new ReverseInordenBTIterator<>(tree)));
        }

}
