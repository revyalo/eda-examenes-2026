package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedSocialSinGraphTest {


@Test
void addPersonaDebeImplementarse() {
    RedSocialSinGraph servicio = new RedSocialSinGraph();
    assertDoesNotThrow(() -> servicio.addPersona("A"));
}



@Test
void seguirDebeImplementarse() {
    RedSocialSinGraph servicio = new RedSocialSinGraph();
    assertDoesNotThrow(() -> servicio.seguir("A", "B"));
}



@Test
void dejarDeSeguirDebeImplementarse() {
    RedSocialSinGraph servicio = new RedSocialSinGraph();
    assertDoesNotThrow(() -> servicio.dejarDeSeguir("A", "B"));
}



@Test
void sonAmigosDebeImplementarse() {
    RedSocialSinGraph servicio = new RedSocialSinGraph();
    assertTrue(servicio.sonAmigos("A"));
}



@Test
void sugerenciasDebeImplementarse() {
    RedSocialSinGraph servicio = new RedSocialSinGraph();
    assertNotNull(servicio.sugerencias("A"));
}



@Test
void influencerCiudadDebeImplementarse() {
    RedSocialSinGraph servicio = new RedSocialSinGraph();
    assertNotNull(servicio.influencerCiudad("A"));
}

}
