package es.urjc.grafo.EDA.examen.ruta;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CasesWarmupTest {
    @Test
    void routerWarmupDebeImplementarse() {
        RouterWarmup routers = new RouterWarmup();
        RouterWarmup.Elemento elemento = new RouterWarmup.Elemento("R1", "Router 1", 1, LocalDateTime.now());
        assertDoesNotThrow(() -> routers.addElemento(elemento));
    }
}
