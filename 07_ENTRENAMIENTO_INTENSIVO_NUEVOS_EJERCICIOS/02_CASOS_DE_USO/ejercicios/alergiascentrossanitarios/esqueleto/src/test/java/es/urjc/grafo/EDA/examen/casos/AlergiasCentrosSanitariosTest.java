package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlergiasCentrosSanitariosTest {


@Test
void addCentroDebeImplementarse() {
    AlergiasCentrosSanitarios servicio = new AlergiasCentrosSanitarios();
    assertDoesNotThrow(() -> servicio.addCentro("A"));
}



@Test
void registrarAlergiaDebeImplementarse() {
    AlergiasCentrosSanitarios servicio = new AlergiasCentrosSanitarios();
    assertDoesNotThrow(() -> servicio.registrarAlergia("A", "B"));
}



@Test
void centrosDePuebloDebeImplementarse() {
    AlergiasCentrosSanitarios servicio = new AlergiasCentrosSanitarios();
    assertNotNull(servicio.centrosDePueblo("A"));
}



@Test
void centrosParaAlergiaDebeImplementarse() {
    AlergiasCentrosSanitarios servicio = new AlergiasCentrosSanitarios();
    assertNotNull(servicio.centrosParaAlergia("A"));
}



@Test
void mejorCentroDebeImplementarse() {
    AlergiasCentrosSanitarios servicio = new AlergiasCentrosSanitarios();
    assertNotNull(servicio.mejorCentro("A"));
}



@Test
void topCentrosDebeImplementarse() {
    AlergiasCentrosSanitarios servicio = new AlergiasCentrosSanitarios();
    assertNotNull(servicio.topCentros(1));
}

}
