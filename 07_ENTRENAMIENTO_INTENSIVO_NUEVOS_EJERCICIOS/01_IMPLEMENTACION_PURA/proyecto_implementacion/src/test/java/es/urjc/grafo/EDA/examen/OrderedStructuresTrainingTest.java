package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderedStructuresTrainingTest {
    @Test
    void rangeCountDebeImplementarse() {
        OrderedStructuresTraining<Integer, String> dict = new OrderedStructuresTraining<>();
        assertEquals(0, dict.rangeCount(1, 5));
    }
}
