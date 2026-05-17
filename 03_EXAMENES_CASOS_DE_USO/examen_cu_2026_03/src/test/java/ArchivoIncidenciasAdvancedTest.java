import es.urjc.grafo.EDA.examen.ArchivoIncidencias;
import es.urjc.grafo.EDA.examen.Incidencia;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ArchivoIncidenciasAdvancedTest {

    @Test
    void parametrosInvalidos() {
        ArchivoIncidencias archivo = new ArchivoIncidencias();
        assertThrows(IllegalArgumentException.class, () -> archivo.registrarIncidencia(null));
        assertThrows(IllegalArgumentException.class, () -> archivo.buscarPorId(null));
        assertThrows(IllegalArgumentException.class, () -> archivo.incidenciasDeServicio(null));
        assertThrows(IllegalArgumentException.class, () -> archivo.incidenciasConPrioridadEntre(5, 1));
    }

    @Test
    void consultaPorRangoDePrioridad() {
        ArchivoIncidencias archivo = new ArchivoIncidencias();
        Incidencia baja = new Incidencia("INC-1", "red", 1, "Baja");
        Incidencia media = new Incidencia("INC-2", "red", 3, "Media");
        Incidencia alta = new Incidencia("INC-3", "sistemas", 5, "Alta");
        archivo.registrarIncidencia(baja);
        archivo.registrarIncidencia(media);
        archivo.registrarIncidencia(alta);
        Collection<Incidencia> rango = archivo.incidenciasConPrioridadEntre(2, 5);
        assertFalse(rango.contains(baja));
        assertTrue(rango.contains(media));
        assertTrue(rango.contains(alta));
    }

    @Test
    void cerrarEliminaDeTodosLosIndices() {
        ArchivoIncidencias archivo = new ArchivoIncidencias();
        Incidencia incidencia = new Incidencia("INC-1", "red", 4, "Caida");
        archivo.registrarIncidencia(incidencia);
        assertTrue(archivo.cerrarIncidencia("INC-1"));
        assertFalse(archivo.cerrarIncidencia("INC-1"));
        assertNull(archivo.buscarPorId("INC-1"));
        assertTrue(archivo.incidenciasDeServicio("red").isEmpty());
        assertTrue(archivo.incidenciasConPrioridadEntre(1, 5).isEmpty());
    }
}
