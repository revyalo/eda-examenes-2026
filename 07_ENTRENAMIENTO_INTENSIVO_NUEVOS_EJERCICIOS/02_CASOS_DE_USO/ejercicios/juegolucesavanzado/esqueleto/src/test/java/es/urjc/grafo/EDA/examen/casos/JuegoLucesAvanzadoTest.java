package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JuegoLucesAvanzadoTest {


@Test
void addBombillaDebeImplementarse() {
    JuegoLucesAvanzado servicio = new JuegoLucesAvanzado();
    assertDoesNotThrow(() -> servicio.addBombilla("A"));
}



@Test
void connectDebeImplementarse() {
    JuegoLucesAvanzado servicio = new JuegoLucesAvanzado();
    assertDoesNotThrow(() -> servicio.connect("A", "B"));
}



@Test
void toggleDebeImplementarse() {
    JuegoLucesAvanzado servicio = new JuegoLucesAvanzado();
    assertDoesNotThrow(() -> servicio.toggle("A"));
}



@Test
void propagarDebeImplementarse() {
    JuegoLucesAvanzado servicio = new JuegoLucesAvanzado();
    assertNotNull(servicio.propagar("A", 1));
}



@Test
void encendidasEnComponenteDebeImplementarse() {
    JuegoLucesAvanzado servicio = new JuegoLucesAvanzado();
    assertNotNull(servicio.encendidasEnComponente("A"));
}



@Test
void programarEventoDebeImplementarse() {
    JuegoLucesAvanzado servicio = new JuegoLucesAvanzado();
    assertDoesNotThrow(() -> servicio.programarEvento("A"));
}

}
