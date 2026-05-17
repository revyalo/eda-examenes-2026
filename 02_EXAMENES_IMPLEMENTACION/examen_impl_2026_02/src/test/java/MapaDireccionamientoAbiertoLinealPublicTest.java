import es.urjc.grafo.EDA.mapas.MapaDireccionamientoAbiertoLineal2026;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapaDireccionamientoAbiertoLinealPublicTest {

    @Test
    void putGetYActualizacionBasica() {
        MapaDireccionamientoAbiertoLineal2026<String, Integer> mapa = new MapaDireccionamientoAbiertoLineal2026<>(7, 0.75);
        assertNull(mapa.put("A", 1));
        assertNull(mapa.put("B", 2));
        assertEquals(2, mapa.size());
        assertEquals(1, mapa.get("A"));
        assertEquals(2, mapa.get("B"));
        assertEquals(1, mapa.put("A", 10));
        assertEquals(2, mapa.size());
        assertEquals(10, mapa.get("A"));
    }

    @Test
    void removeUsaCentinelaYPermiteBuscarDespues() {
        MapaDireccionamientoAbiertoLineal2026<ClaveColision, String> mapa = new MapaDireccionamientoAbiertoLineal2026<>(5, 0.95);
        ClaveColision a = new ClaveColision("A");
        ClaveColision b = new ClaveColision("B");
        mapa.put(a, "uno");
        mapa.put(b, "dos");
        assertEquals("uno", mapa.remove(a));
        assertNull(mapa.get(a));
        assertEquals("dos", mapa.get(b));
    }

    private record ClaveColision(String id) {
        @Override
        public int hashCode() {
            return 1;
        }
    }
}
