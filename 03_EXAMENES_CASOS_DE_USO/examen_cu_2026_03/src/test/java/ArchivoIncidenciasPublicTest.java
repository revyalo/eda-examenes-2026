import es.urjc.grafo.EDA.examen.ArchivoIncidencias;
import es.urjc.grafo.EDA.examen.Incidencia;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ArchivoIncidenciasPublicTest {

    @Test
    void registraYBuscaPorId() {
        ArchivoIncidencias archivo = new ArchivoIncidencias();
        Incidencia i1 = new Incidencia("INC-1", "red", 4, "Caida de enlace");
        assertTrue(archivo.registrarIncidencia(i1));
        assertFalse(archivo.registrarIncidencia(i1));
        assertEquals(i1, archivo.buscarPorId("INC-1"));
        assertNull(archivo.buscarPorId("INC-X"));
    }

    @Test
    void consultaPorServicio() {
        ArchivoIncidencias archivo = new ArchivoIncidencias();
        Incidencia i1 = new Incidencia("INC-1", "red", 4, "Caida");
        Incidencia i2 = new Incidencia("INC-2", "red", 2, "Latencia");
        Incidencia i3 = new Incidencia("INC-3", "sistemas", 3, "Disco");
        archivo.registrarIncidencia(i1);
        archivo.registrarIncidencia(i2);
        archivo.registrarIncidencia(i3);
        Collection<Incidencia> red = archivo.incidenciasDeServicio("red");
        assertEquals(2, red.size());
        assertTrue(red.contains(i1));
        assertTrue(red.contains(i2));
    }
}
