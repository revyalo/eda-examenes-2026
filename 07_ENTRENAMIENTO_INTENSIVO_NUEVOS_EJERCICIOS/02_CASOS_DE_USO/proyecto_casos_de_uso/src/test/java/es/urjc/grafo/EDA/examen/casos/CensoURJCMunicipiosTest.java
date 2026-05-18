package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CensoURJCMunicipiosTest {

    @Test
    void primerMetodoDebeImplementarse() {
        CensoURJCMunicipios servicio = new CensoURJCMunicipios();
        assertDoesNotThrow(() -> servicio.addHabitante("A"));
    }
}
