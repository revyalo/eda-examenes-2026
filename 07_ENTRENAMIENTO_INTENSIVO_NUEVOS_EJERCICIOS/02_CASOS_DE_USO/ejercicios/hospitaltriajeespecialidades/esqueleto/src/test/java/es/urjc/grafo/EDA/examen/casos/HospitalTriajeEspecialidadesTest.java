package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTriajeEspecialidadesTest {


@Test
void registrarPacienteDebeImplementarse() {
    HospitalTriajeEspecialidades servicio = new HospitalTriajeEspecialidades();
    assertDoesNotThrow(() -> servicio.registrarPaciente("A"));
}



@Test
void siguientePacienteDebeImplementarse() {
    HospitalTriajeEspecialidades servicio = new HospitalTriajeEspecialidades();
    assertNotNull(servicio.siguientePaciente("A"));
}



@Test
void pacientesEspecialidadDebeImplementarse() {
    HospitalTriajeEspecialidades servicio = new HospitalTriajeEspecialidades();
    assertNotNull(servicio.pacientesEspecialidad("A"));
}



@Test
void pacientesAntesDeDebeImplementarse() {
    HospitalTriajeEspecialidades servicio = new HospitalTriajeEspecialidades();
    assertNotNull(servicio.pacientesAntesDe(java.time.LocalDateTime.now()));
}



@Test
void cambiarPrioridadDebeImplementarse() {
    HospitalTriajeEspecialidades servicio = new HospitalTriajeEspecialidades();
    assertDoesNotThrow(() -> servicio.cambiarPrioridad("A"));
}



@Test
void altaPacienteDebeImplementarse() {
    HospitalTriajeEspecialidades servicio = new HospitalTriajeEspecialidades();
    assertDoesNotThrow(() -> servicio.altaPaciente("A"));
}

}
