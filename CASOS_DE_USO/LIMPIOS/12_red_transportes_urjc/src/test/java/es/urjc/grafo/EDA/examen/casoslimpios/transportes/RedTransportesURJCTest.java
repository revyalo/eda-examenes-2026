package es.urjc.grafo.EDA.examen.casoslimpios.transportes;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedTransportesURJCTest {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    @Test
    void trayectoLimitadoYParadaMasConectada() {
        RedTransportesURJC red = new RedTransportesURJC();
        red.addParada(new Parada("A", "Aulario", "Mostoles"));
        red.addParada(new Parada("B", "Biblioteca", "Mostoles"));
        red.addParada(new Parada("C", "Rectorado", "Mostoles"));
        red.conectar(new ConexionTransporte("A", "B", "L1"));
        red.conectar(new ConexionTransporte("B", "C", "L1"));

        assertTrue(red.existeTrayecto("A", "C", 2));
        assertFalse(red.existeTrayecto("A", "C", 1));
        assertEquals(2, toList(red.paradasAlcanzables("A", 1)).size());
        assertEquals("B", red.paradaMasConectada().id());
    }
}
