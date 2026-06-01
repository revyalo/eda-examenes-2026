package es.urjc.grafo.EDA.examen.arbolesbinarios.p27_levels_complete.arboles;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelsCompleteTest {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    @Test
    void devuelveNivelesCompletosDelEjemplo() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.insertLeft(a, "B");
        Position<String> c = tree.insertRight(a, "C");
        tree.insertLeft(b, "D");
        Position<String> e = tree.insertRight(b, "E");
        tree.insertRight(c, "F");
        tree.insertLeft(e, "G");
        tree.insertRight(e, "H");

        assertEquals(List.of(1, 3, 4), toList(LevelsComplete.levelsComplete(tree)));
    }

    @Test
    void arbolConSoloRaizTieneNivelUnoCompleto() {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        tree.addRoot("A");

        assertEquals(List.of(1), toList(LevelsComplete.levelsComplete(tree)));
    }
}
