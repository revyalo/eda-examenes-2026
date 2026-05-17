import es.urjc.grafo.EDA.examen.Empleado;
import es.urjc.grafo.EDA.examen.OrganigramaServicios;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganigramaServiciosAdvancedTest {

    @Test
    void parametrosInvalidos() {
        Empleado directora = new Empleado(1, "Directora");
        OrganigramaServicios org = new OrganigramaServicios(directora);
        assertThrows(IllegalArgumentException.class, () -> new OrganigramaServicios(null));
        assertThrows(IllegalArgumentException.class, () -> org.addEmpleado(null, new Empleado(2, "X")));
        assertThrows(IllegalArgumentException.class, () -> org.addEmpleado(directora, null));
    }

    @Test
    void rutaDeMandoDesdeEmpleadoHastaDirector() {
        Empleado directora = new Empleado(1, "Directora");
        Empleado jefe = new Empleado(2, "Jefe");
        Empleado tecnica = new Empleado(3, "Tecnica");
        OrganigramaServicios org = new OrganigramaServicios(directora);
        org.addEmpleado(directora, jefe);
        org.addEmpleado(jefe, tecnica);
        Collection<Empleado> ruta = org.rutaDeMando(tecnica);
        assertEquals(List.of(tecnica, jefe, directora), List.copyOf(ruta));
    }

    @Test
    void equipoCompletoDevuelveSubarbol() {
        Empleado directora = new Empleado(1, "Directora");
        Empleado jefe = new Empleado(2, "Jefe");
        Empleado tecnica = new Empleado(3, "Tecnica");
        Empleado becario = new Empleado(4, "Becario");
        OrganigramaServicios org = new OrganigramaServicios(directora);
        org.addEmpleado(directora, jefe);
        org.addEmpleado(jefe, tecnica);
        org.addEmpleado(tecnica, becario);
        Collection<Empleado> equipo = org.equipoCompleto(jefe);
        assertEquals(3, equipo.size());
        assertTrue(equipo.containsAll(List.of(jefe, tecnica, becario)));
    }
}
