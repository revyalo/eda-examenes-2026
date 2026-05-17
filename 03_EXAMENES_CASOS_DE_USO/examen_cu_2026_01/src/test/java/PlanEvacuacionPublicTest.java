import es.urjc.grafo.EDA.examen.PlanEvacuacion;
import es.urjc.grafo.EDA.examen.Zona;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class PlanEvacuacionPublicTest {

    @Test
    void registraZonasYEvitaDuplicados() {
        PlanEvacuacion plan = new PlanEvacuacion();
        Zona a = new Zona("A", false);
        assertTrue(plan.addZona(a));
        assertFalse(plan.addZona(a));
    }

    @Test
    void pasilloRequiereZonasRegistradas() {
        PlanEvacuacion plan = new PlanEvacuacion();
        Zona a = new Zona("A", false);
        Zona b = new Zona("B", true);
        assertFalse(plan.addPasillo(a, b, 5));
        plan.addZona(a);
        plan.addZona(b);
        assertTrue(plan.addPasillo(a, b, 5));
        assertFalse(plan.addPasillo(a, b, 5));
    }

    @Test
    void zonasAlcanzablesConTiempoMaximo() {
        PlanEvacuacion plan = escenarioBasico();
        Collection<Zona> zonas = plan.zonasAlcanzables(new Zona("A", false), 7);
        assertTrue(zonas.contains(new Zona("B", false)));
        assertTrue(zonas.contains(new Zona("C", true)));
        assertFalse(zonas.contains(new Zona("D", true)));
    }

    private PlanEvacuacion escenarioBasico() {
        PlanEvacuacion plan = new PlanEvacuacion();
        Zona a = new Zona("A", false);
        Zona b = new Zona("B", false);
        Zona c = new Zona("C", true);
        Zona d = new Zona("D", true);
        plan.addZona(a);
        plan.addZona(b);
        plan.addZona(c);
        plan.addZona(d);
        plan.addPasillo(a, b, 3);
        plan.addPasillo(b, c, 4);
        plan.addPasillo(c, d, 10);
        return plan;
    }
}
