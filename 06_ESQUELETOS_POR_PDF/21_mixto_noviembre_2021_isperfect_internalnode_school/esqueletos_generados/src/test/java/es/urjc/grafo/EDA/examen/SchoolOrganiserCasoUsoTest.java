package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SchoolOrganiserCasoUsoTest {

    @Test
    void ejercicioDebeImplementarse() {
        SchoolOrganiserCasoUso servicio = new SchoolOrganiserCasoUso();
        assertDoesNotThrow(servicio::resolverCaso);
    }
}
