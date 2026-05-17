package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class EfficientDictTest {

    @Test
    void ejercicioDebeImplementarse() {
        EfficientDict<String, Integer> dict = new EfficientDict<>();
        assertNull(dict.put("A", 1));
    }
}
