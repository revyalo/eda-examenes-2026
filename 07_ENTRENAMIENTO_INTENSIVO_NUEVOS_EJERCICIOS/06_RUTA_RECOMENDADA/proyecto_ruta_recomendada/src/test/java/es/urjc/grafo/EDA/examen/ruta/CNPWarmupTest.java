package es.urjc.grafo.EDA.examen.ruta;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CNPWarmupTest {
    @Test
    void addOpositorDebeImplementarse() {
        CNPWarmup cnp = new CNPWarmup();
        CNPWarmup.Opositor opositor = new CNPWarmup.Opositor("123", "Ana", "Madrid", 7.5, LocalDate.now());
        assertDoesNotThrow(() -> cnp.addOpositor(opositor));
    }
}
