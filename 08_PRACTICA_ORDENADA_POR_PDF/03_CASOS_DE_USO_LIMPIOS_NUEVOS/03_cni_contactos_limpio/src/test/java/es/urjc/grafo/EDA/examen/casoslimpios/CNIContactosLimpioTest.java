package es.urjc.grafo.EDA.examen.casoslimpios;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CNIContactosLimpioTest {

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
        void contactosYCadena() {
            CNIContactosLimpio cni = new CNIContactosLimpio();
            cni.addAgente(new Agente(1, "A", "N"));
            cni.addAgente(new Agente(2, "B", "N"));
            cni.addAgente(new Agente(3, "C", "S"));
            LocalDate dia = LocalDate.of(2026, 1, 1);
            assertTrue(cni.registrarContacto(new Contacto(1, 2, dia, 15)));
            assertTrue(cni.registrarContacto(new Contacto(2, 3, dia, 15)));
            assertTrue(cni.contactoDirecto(1, 2));
            assertTrue(cni.posibleCadena(1, 3, 2));
            assertEquals(3, toList(cni.grupoDeRiesgo(1, dia, 10)).size());
        }

}
