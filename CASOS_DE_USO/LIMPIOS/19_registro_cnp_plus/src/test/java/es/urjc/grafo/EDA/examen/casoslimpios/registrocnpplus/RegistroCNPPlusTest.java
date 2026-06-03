package es.urjc.grafo.EDA.examen.casoslimpios.registrocnpplus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RegistroCNPPlusTest {

    private static List<Opositor> list(Iterable<Opositor> iterable) {
        List<Opositor> result = new ArrayList<>();
        for (Opositor opositor : iterable) {
            result.add(opositor);
        }
        return result;
    }

    @Test
    void constructorAvoidsDuplicatedDniAndSupportsLookup() {
        Opositor ana = new Opositor(10, "Ana", 9, 9, 9);
        Opositor repeated = new Opositor(10, "Otra", 1, 1, 1);
        RegistroCNPPlus registro = new RegistroCNPPlus(List.of(ana, repeated));

        assertEquals(1, registro.size());
        assertEquals(ana, registro.getOpositor(10));
    }

    @Test
    void minMaxRangeAndTopUseAverageGrade() {
        Opositor a = new Opositor(3, "A", 5, 5, 5);
        Opositor b = new Opositor(1, "B", 9, 9, 9);
        Opositor c = new Opositor(2, "C", 7, 7, 7);
        RegistroCNPPlus registro = new RegistroCNPPlus(List.of(a, b, c));

        assertEquals(5.0, registro.getMinNotaMedia(), 0.001);
        assertEquals(9.0, registro.getMaxNotaMedia(), 0.001);
        assertEquals(List.of(c, b), list(registro.getOpositoresConNotaMediaSuperiorA(6.0)));
        assertEquals(List.of(c), list(registro.getOpositoresConNotaMediaEnElRango(6.0, 8.0)));
        assertEquals(List.of(b, c), list(registro.getTopK(2)));
    }

    @Test
    void removeUpdatesAllIndexes() {
        Opositor a = new Opositor(1, "A", 8, 8, 8);
        RegistroCNPPlus registro = new RegistroCNPPlus(List.of(a));

        assertTrue(registro.removeOpositor(1));
        assertNull(registro.getOpositor(1));
        assertEquals(0, registro.size());
    }
}
