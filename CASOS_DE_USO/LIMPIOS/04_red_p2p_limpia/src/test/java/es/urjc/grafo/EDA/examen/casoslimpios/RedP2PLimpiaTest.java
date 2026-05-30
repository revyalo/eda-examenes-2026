package es.urjc.grafo.EDA.examen.casoslimpios;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RedP2PLimpiaTest {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    private static <E> Set<E> toSet(Iterable<E> values) {
        return new HashSet<>(toList(values));
    }


        @Test
        void busquedaArchivoConTTL() {
            RedP2PLimpia red = new RedP2PLimpia();
            red.addNode(new Nodo("A", "1.1.1.1", 10));
            red.addNode(new Nodo("B", "2.2.2.2", 10));
            red.addNode(new Nodo("C", "3.3.3.3", 10));
            red.connect("A", "B");
            red.connect("B", "C");
            red.addFile("C", "eda.pdf");
            assertEquals(0, toList(red.buscarArchivo("A", "eda.pdf", 1)).size());
            assertEquals(1, toList(red.buscarArchivo("A", "eda.pdf", 2)).size());
            assertTrue(red.shutdownNode("B"));
            assertEquals(0, toList(red.buscarArchivo("A", "eda.pdf", 3)).size());
        }

}
