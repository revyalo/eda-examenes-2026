package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CNIContactosIndirectosTest {


@Test
void addAgenteDebeImplementarse() {
    CNIContactosIndirectos servicio = new CNIContactosIndirectos();
    assertDoesNotThrow(() -> servicio.addAgente("A"));
}



@Test
void registrarContactoDebeImplementarse() {
    CNIContactosIndirectos servicio = new CNIContactosIndirectos();
    assertDoesNotThrow(() -> servicio.registrarContacto("A", "B", java.time.LocalDateTime.now()));
}



@Test
void hanInteractuadoDebeImplementarse() {
    CNIContactosIndirectos servicio = new CNIContactosIndirectos();
    assertTrue(servicio.hanInteractuado("A"));
}



@Test
void posibleCadenaContagioDebeImplementarse() {
    CNIContactosIndirectos servicio = new CNIContactosIndirectos();
    assertTrue(servicio.posibleCadenaContagio("A"));
}



@Test
void grupoDeAgenteDebeImplementarse() {
    CNIContactosIndirectos servicio = new CNIContactosIndirectos();
    assertNotNull(servicio.grupoDeAgente("A"));
}



@Test
void interaccionesAntesDeDebeImplementarse() {
    CNIContactosIndirectos servicio = new CNIContactosIndirectos();
    assertNotNull(servicio.interaccionesAntesDe(java.time.LocalDateTime.now()));
}

}
