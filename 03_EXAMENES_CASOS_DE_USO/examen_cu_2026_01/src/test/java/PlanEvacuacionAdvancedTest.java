import es.urjc.grafo.EDA.examen.PlanEvacuacion;
import es.urjc.grafo.EDA.examen.Zona;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanEvacuacionAdvancedTest {

    @Test
    void parametrosInvalidosLanzanExcepcion() {
        PlanEvacuacion plan = new PlanEvacuacion();
        Zona a = new Zona("A", false);
        assertThrows(IllegalArgumentException.class, () -> plan.addZona(null));
        assertThrows(IllegalArgumentException.class, () -> plan.addPasillo(a, null, 1));
        assertThrows(IllegalArgumentException.class, () -> plan.addPasillo(a, a, 0));
        assertThrows(IllegalArgumentException.class, () -> plan.zonasAlcanzables(null, 1));
        assertThrows(IllegalArgumentException.class, () -> plan.zonasAlcanzables(a, -1));
    }

    @Test
    void zonaSeguraMasCercanaUsaDistanciaAcumulada() {
        PlanEvacuacion plan = new PlanEvacuacion();
        Zona a = new Zona("A", false);
        Zona b = new Zona("B", false);
        Zona c = new Zona("C", true);
        Zona d = new Zona("D", true);
        plan.addZona(a);
        plan.addZona(b);
        plan.addZona(c);
        plan.addZona(d);
        plan.addPasillo(a, b, 2);
        plan.addPasillo(b, c, 2);
        plan.addPasillo(a, d, 8);
        assertEquals(c, plan.zonaSeguraMasCercana(a));
    }

    @Test
    void sinZonaSeguraAlcanzableDevuelveNull() {
        PlanEvacuacion plan = new PlanEvacuacion();
        Zona a = new Zona("A", false);
        Zona b = new Zona("B", false);
        Zona c = new Zona("C", true);
        plan.addZona(a);
        plan.addZona(b);
        plan.addZona(c);
        plan.addPasillo(a, b, 2);
        assertNull(plan.zonaSeguraMasCercana(a));
    }
}
