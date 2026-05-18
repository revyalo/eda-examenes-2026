package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SistemaMensajesRedTest {
    @Test
    void comparadorDebeImplementarse() {
        SistemaMensajesRed.MensajeEvento a = new SistemaMensajesRed.MensajeEvento("A", LocalDateTime.of(2026, 1, 1, 10, 0), 2, "R1", "R2");
        SistemaMensajesRed.MensajeEvento b = new SistemaMensajesRed.MensajeEvento("B", LocalDateTime.of(2026, 1, 1, 11, 0), 5, "R1", "R3");
        assertTrue(new SistemaMensajesRed.MensajeEventoComparator().compare(a, b) < 0);
    }

    @Test
    void registrarYBuscarEventoDebeImplementarse() {
        SistemaMensajesRed sistema = new SistemaMensajesRed();
        SistemaMensajesRed.MensajeEvento evento = new SistemaMensajesRed.MensajeEvento("M1", LocalDateTime.now(), 3, "R1", "R2");
        assertTrue(sistema.registrarEvento(evento));
        assertEquals(evento, sistema.buscarEvento("M1"));
    }

    @Test
    void eventosHastaDebeImplementarse() {
        SistemaMensajesRed sistema = new SistemaMensajesRed();
        assertNotNull(sistema.eventosHasta(LocalDateTime.now()));
    }

    @Test
    void conexionLimitadaDebeImplementarse() {
        SistemaMensajesRed sistema = new SistemaMensajesRed();
        sistema.conectar("R1", "R2");
        sistema.conectar("R2", "R3");
        assertTrue(sistema.hayConexionConDistanciaMenorOIgual("R1", "R3", 2));
    }
}
