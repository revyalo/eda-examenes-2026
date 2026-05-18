package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class TraductorWebPrioridadesTest {

    @Test
    void primerMetodoDebeImplementarse() {
        TraductorWebPrioridades servicio = new TraductorWebPrioridades();
        assertDoesNotThrow(() -> servicio.addTraduccion("es", "hola", "hello"));
    }
}
