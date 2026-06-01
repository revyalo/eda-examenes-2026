package es.urjc.grafo.EDA.examen.arboles.p28_parcial1_antecesors_degree.arboles;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Parcial1Test {

    private static <E> List<E> elements(Iterable<Position<E>> positions) {
        List<E> result = new ArrayList<>();
        for (Position<E> position : positions) {
            result.add(position.getElement());
        }
        return result;
    }

    @Test
    void antecesorsDevuelveCaminoDesdePadreHastaRaiz() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        Position<String> c = tree.add("C", a);
        Position<String> d = tree.add("D", b);
        Position<String> e = tree.add("E", c);
        Position<String> f = tree.add("F", e);
        Position<String> g = tree.add("G", f);

        assertEquals(List.of("F", "E", "C", "A"), elements(Parcial1.antecesors(tree, g)));
        assertEquals(List.of(), elements(Parcial1.antecesors(tree, a)));
        assertNotNull(d);
    }

    @Test
    void degreeDevuelveMaximoNumeroDeHijos() {
        LinkedTree<String> tree = new LinkedTree<>();
        Position<String> a = tree.addRoot("A");
        Position<String> b = tree.add("B", a);
        tree.add("C", a);
        tree.add("D", a);
        tree.add("E", b);
        tree.add("F", b);

        assertEquals(3, Parcial1.degree(tree));
    }
}
