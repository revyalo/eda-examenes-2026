package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class HospitalTriajeEspecialidadesTest {

    @Test
    void primerMetodoDebeImplementarse() {
        HospitalTriajeEspecialidades servicio = new HospitalTriajeEspecialidades();
        assertDoesNotThrow(() -> servicio.registrarPaciente("A"));
    }
}
