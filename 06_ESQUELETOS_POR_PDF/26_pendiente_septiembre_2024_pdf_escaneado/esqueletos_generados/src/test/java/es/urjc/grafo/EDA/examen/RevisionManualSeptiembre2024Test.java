package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RevisionManualSeptiembre2024Test {

    @Test
    void ejercicioDebeImplementarse() {
        RevisionManualSeptiembre2024 servicio = new RevisionManualSeptiembre2024();
        assertNotNull(servicio.revisarPDF());
    }
}
