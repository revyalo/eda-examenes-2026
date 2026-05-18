package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URJCNetServicesTTLTest {


@Test
void addRouterDebeImplementarse() {
    URJCNetServicesTTL servicio = new URJCNetServicesTTL();
    assertDoesNotThrow(() -> servicio.addRouter("A"));
}



@Test
void addConnectionDebeImplementarse() {
    URJCNetServicesTTL servicio = new URJCNetServicesTTL();
    assertDoesNotThrow(() -> servicio.addConnection("A", "B"));
}



@Test
void recibirMensajeDebeImplementarse() {
    URJCNetServicesTTL servicio = new URJCNetServicesTTL();
    assertDoesNotThrow(() -> servicio.recibirMensaje("A"));
}



@Test
void routersAlcanzablesDebeImplementarse() {
    URJCNetServicesTTL servicio = new URJCNetServicesTTL();
    assertNotNull(servicio.routersAlcanzables("A", 1));
}



@Test
void borrarMensajesAntiguosDebeImplementarse() {
    URJCNetServicesTTL servicio = new URJCNetServicesTTL();
    assertDoesNotThrow(() -> servicio.borrarMensajesAntiguos(java.time.LocalDateTime.now()));
}



@Test
void routerMasConectadoDebeImplementarse() {
    URJCNetServicesTTL servicio = new URJCNetServicesTTL();
    assertNotNull(servicio.routerMasConectado("A"));
}

}
