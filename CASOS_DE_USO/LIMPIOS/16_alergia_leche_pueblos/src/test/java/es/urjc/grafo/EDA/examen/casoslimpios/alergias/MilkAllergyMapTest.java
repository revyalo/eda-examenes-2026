package es.urjc.grafo.EDA.examen.casoslimpios.alergias;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MilkAllergyMapTest {

    private MilkAllergyMap sample() {
        MilkAllergyMap map = new MilkAllergyMap();
        map.addTown("1", List.of("A", "E"));
        map.addTown("2", List.of("C"));
        map.addTown("3", List.of("D", "E"));
        map.addTown("4", List.of("B"));
        map.addTown("5", List.of("B"));
        map.addTown("6", List.of("C"));
        map.addTown("7", List.of("A"));
        map.addRoad("1", "2");
        map.addRoad("1", "4");
        map.addRoad("1", "6");
        map.addRoad("2", "3");
        map.addRoad("2", "4");
        map.addRoad("3", "5");
        map.addRoad("4", "7");
        map.addRoad("5", "7");
        map.addRoad("6", "7");
        return map;
    }

    @Test
    void milkSafeTownDevuelveElPuebloMasSeguroDelEjemplo() {
        assertEquals("2", sample().milkSafeTown());
    }

    @Test
    void surviveUsaElCentroMasCercanoParaLaMarca() {
        MilkAllergyMap map = sample();

        assertTrue(map.survive("4", "A", 2));
        assertFalse(map.survive("4", "D", 2));
    }
}
