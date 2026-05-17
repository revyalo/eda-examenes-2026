import es.urjc.grafo.EDA.mapas.MapaDireccionamientoAbiertoLineal2026;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapaDireccionamientoAbiertoLinealAdvancedTest {

    @Test
    void rehashConservaEntradasActivas() {
        MapaDireccionamientoAbiertoLineal2026<Integer, String> mapa = new MapaDireccionamientoAbiertoLineal2026<>(3, 0.50);
        for (int i = 0; i < 20; i++) {
            mapa.put(i, "V" + i);
        }
        assertEquals(20, mapa.size());
        for (int i = 0; i < 20; i++) {
            assertEquals("V" + i, mapa.get(i));
        }
    }

    @Test
    void soportaClaveNulaYEntries() {
        MapaDireccionamientoAbiertoLineal2026<String, Integer> mapa = new MapaDireccionamientoAbiertoLineal2026<>(7, 0.75);
        mapa.put(null, 99);
        mapa.put("A", 1);
        assertEquals(99, mapa.get(null));
        Set<Integer> valores = new HashSet<>();
        for (Map.Entry<String, Integer> entry : mapa.entries()) {
            valores.add(entry.getValue());
        }
        assertTrue(valores.contains(99));
        assertTrue(valores.contains(1));
    }

    @Test
    void reutilizaHuecoDeEntradaBorrada() {
        MapaDireccionamientoAbiertoLineal2026<ClaveColision, Integer> mapa = new MapaDireccionamientoAbiertoLineal2026<>(7, 0.95);
        ClaveColision a = new ClaveColision("A");
        ClaveColision b = new ClaveColision("B");
        ClaveColision c = new ClaveColision("C");
        mapa.put(a, 1);
        mapa.put(b, 2);
        assertEquals(1, mapa.remove(a));
        mapa.put(c, 3);
        assertEquals(2, mapa.get(b));
        assertEquals(3, mapa.get(c));
        assertEquals(2, mapa.size());
    }

    private record ClaveColision(String id) {
        @Override
        public int hashCode() {
            return 2;
        }
    }
}
