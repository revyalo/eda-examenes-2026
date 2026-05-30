package es.urjc.grafo.EDA.examen.casoslimpios;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RegistroCNPLimpioTest {

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
        void altaBusquedaYDuplicados() {
            RegistroCNPLimpio registro = new RegistroCNPLimpio();
            Opositor ana = new Opositor("111A", "Ana", "Madrid", new Notas(8, 7, 9));
            assertTrue(registro.addOpositor(ana));
            assertFalse(registro.addOpositor(ana));
            assertEquals(ana, registro.getOpositor("111A"));
            assertNull(registro.getOpositor("000Z"));
        }

        @Test
        void rankingRangosYProvincia() {
            RegistroCNPLimpio registro = new RegistroCNPLimpio();
            registro.addOpositor(new Opositor("111A", "Ana", "Madrid", new Notas(8, 7, 9)));
            registro.addOpositor(new Opositor("222B", "Luis", "Madrid", new Notas(4, 5, 6)));
            registro.addOpositor(new Opositor("333C", "Eva", "Toledo", new Notas(9, 9, 9)));
            assertEquals(1, toList(registro.aptosPorProvincia("Madrid", 7.0)).size());
            assertEquals(2, toList(registro.opositoresEntreNotas(7.0, 10.0)).size());
            assertEquals("333C", toList(registro.top(1)).get(0).dni());
            assertTrue(registro.actualizarNotas("222B", new Notas(10, 10, 10)));
            assertEquals("222B", toList(registro.top(1)).get(0).dni());
        }

}
