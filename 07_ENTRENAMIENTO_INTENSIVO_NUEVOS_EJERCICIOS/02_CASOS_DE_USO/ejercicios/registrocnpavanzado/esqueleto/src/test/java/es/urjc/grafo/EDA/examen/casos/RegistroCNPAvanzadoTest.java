package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroCNPAvanzadoTest {


@Test
void addOpositorDebeImplementarse() {
    RegistroCNPAvanzado servicio = new RegistroCNPAvanzado();
    assertDoesNotThrow(() -> servicio.addOpositor("A"));
}



@Test
void actualizarNotaDebeImplementarse() {
    RegistroCNPAvanzado servicio = new RegistroCNPAvanzado();
    assertDoesNotThrow(() -> servicio.actualizarNota("A", 1.0));
}



@Test
void topDebeImplementarse() {
    RegistroCNPAvanzado servicio = new RegistroCNPAvanzado();
    assertNotNull(servicio.top(1));
}



@Test
void aptosPorProvinciaDebeImplementarse() {
    RegistroCNPAvanzado servicio = new RegistroCNPAvanzado();
    assertNotNull(servicio.aptosPorProvincia("A"));
}



@Test
void opositoresEntreNotasDebeImplementarse() {
    RegistroCNPAvanzado servicio = new RegistroCNPAvanzado();
    assertNotNull(servicio.opositoresEntreNotas(1.0, 10.0));
}



@Test
void eliminarOpositorDebeImplementarse() {
    RegistroCNPAvanzado servicio = new RegistroCNPAvanzado();
    assertDoesNotThrow(() -> servicio.eliminarOpositor("A"));
}

}
