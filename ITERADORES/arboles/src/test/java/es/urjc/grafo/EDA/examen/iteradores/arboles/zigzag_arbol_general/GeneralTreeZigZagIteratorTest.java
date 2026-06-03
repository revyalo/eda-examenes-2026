package es.urjc.grafo.EDA.examen.iteradores.arboles.zigzag_arbol_general;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralTreeZigZagIteratorTest {

    private static <E> List<E> values(Iterator<Position<E>> iterator) {
        List<E> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next().getElement());
        }
        return result;
    }

    @Test
    void recorreNivelesAlternandoDireccion() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        Position<String> d = tree.add("D", a);
        tree.add("E", b);
        tree.add("F", c);
        tree.add("G", d);

        assertEquals(List.of("A", "D", "C", "B", "E", "F", "G"), values(new GeneralTreeZigZagIterator<>(tree)));
    }
}
