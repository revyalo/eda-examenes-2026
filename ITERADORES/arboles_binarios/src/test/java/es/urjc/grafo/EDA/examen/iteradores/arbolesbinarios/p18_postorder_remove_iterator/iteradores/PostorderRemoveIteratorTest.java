package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p18_postorder_remove_iterator.iteradores;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PostorderRemoveIteratorTest {

    private static <E> List<E> values(Iterator<Position<E>> iterator) {
        List<E> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next().getElement());
        }
        return result;
    }

    @Test
    void recorreEnPostorden() {
        LinkedBinaryTree<Integer> tree = sampleTree();
        assertEquals(List.of(4, 5, 2, 6, 3, 1), values(new PostorderRemoveIterator<>(tree)));
    }

    @Test
    void removeEliminaUltimaHojaDevuelta() {
        LinkedBinaryTree<Integer> tree = sampleTree();
        PostorderRemoveIterator<Integer> iterator = new PostorderRemoveIterator<>(tree);
        assertEquals(4, iterator.next().getElement());
        iterator.remove();
        assertEquals(5, tree.size());
    }

    private LinkedBinaryTree<Integer> sampleTree() {
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
