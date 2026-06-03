package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.anchura_niveles_pares;

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

class BreadthFirstEvenLevelIteratorTest {

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
        void incluyeRaizYNodosDeNivelDos() {
            LinkedBinaryTree<Integer> tree = sampleBinaryTree();
            assertEquals(List.of(1, 4, 5, 6), values(new BreadthFirstEvenLevelIterator<>(tree)));
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
