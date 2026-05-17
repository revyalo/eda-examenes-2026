import es.urjc.grafo.EDA.examen.Empleado;
import es.urjc.grafo.EDA.examen.OrganigramaServicios;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrganigramaServiciosPublicTest {

    @Test
    void directorInicial() {
        Empleado directora = new Empleado(1, "Directora");
        OrganigramaServicios org = new OrganigramaServicios(directora);
        assertEquals(directora, org.getDirector());
    }

    @Test
    void addEmpleadoYSubordinadosDirectos() {
        Empleado directora = new Empleado(1, "Directora");
        Empleado jefe = new Empleado(2, "Jefe");
        Empleado tecnica = new Empleado(3, "Tecnica");
        OrganigramaServicios org = new OrganigramaServicios(directora);
        assertTrue(org.addEmpleado(directora, jefe));
        assertTrue(org.addEmpleado(directora, tecnica));
        Collection<Empleado> subordinados = org.subordinadosDirectos(directora);
        assertEquals(2, subordinados.size());
        assertTrue(subordinados.containsAll(List.of(jefe, tecnica)));
    }

    @Test
    void noPermiteEmpleadoDuplicado() {
        Empleado directora = new Empleado(1, "Directora");
        Empleado jefe = new Empleado(2, "Jefe");
        OrganigramaServicios org = new OrganigramaServicios(directora);
        assertTrue(org.addEmpleado(directora, jefe));
        assertFalse(org.addEmpleado(directora, jefe));
    }
}
