package es.urjc.grafo.EDA.examen.casoslimpios;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTriajeLimpioTest {

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
        void prioridadEspecialidadYAltas() {
            HospitalTriajeLimpio hospital = new HospitalTriajeLimpio();
            LocalDateTime t = LocalDateTime.of(2026, 1, 1, 10, 0);
            Paciente ana = new Paciente("S1", "Ana", "TRAUMA", 3, t);
            Paciente bob = new Paciente("S2", "Bob", "TRAUMA", 5, t.plusMinutes(1));
            assertTrue(hospital.registrarPaciente(ana));
            assertTrue(hospital.registrarPaciente(bob));
            assertEquals(2, toList(hospital.pacientesEspecialidad("TRAUMA")).size());
            assertEquals(ana, toList(hospital.pacientesAntesDe(t)).get(0));
            assertEquals(bob, hospital.siguientePaciente());
            assertTrue(hospital.cambiarGravedad("S1", 7));
            assertEquals(ana, hospital.siguientePaciente());
            assertFalse(hospital.altaPaciente("S1"));
        }

}
