package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HipergrafoProyectosParticipantesTest {


@Test
void addProyectoDebeImplementarse() {
    HipergrafoProyectosParticipantes servicio = new HipergrafoProyectosParticipantes();
    assertDoesNotThrow(() -> servicio.addProyecto("A"));
}



@Test
void addParticipanteDebeImplementarse() {
    HipergrafoProyectosParticipantes servicio = new HipergrafoProyectosParticipantes();
    assertDoesNotThrow(() -> servicio.addParticipante("A"));
}



@Test
void asignarDebeImplementarse() {
    HipergrafoProyectosParticipantes servicio = new HipergrafoProyectosParticipantes();
    assertDoesNotThrow(() -> servicio.asignar("A", "B"));
}



@Test
void participantesRelacionadosDebeImplementarse() {
    HipergrafoProyectosParticipantes servicio = new HipergrafoProyectosParticipantes();
    assertNotNull(servicio.participantesRelacionados("A"));
}



@Test
void proyectosComunesDebeImplementarse() {
    HipergrafoProyectosParticipantes servicio = new HipergrafoProyectosParticipantes();
    assertNotNull(servicio.proyectosComunes("A"));
}



@Test
void grupoExpandidoDebeImplementarse() {
    HipergrafoProyectosParticipantes servicio = new HipergrafoProyectosParticipantes();
    assertNotNull(servicio.grupoExpandido("A", 1));
}

}
