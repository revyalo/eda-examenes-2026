package es.urjc.grafo.EDA.examen.ruta;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CNPWarmupExtraTest {
    private CNPWarmup.Opositor opositor() {
        return new CNPWarmup.Opositor("123", "Ana", "Madrid", 7.5, LocalDate.now());
    }

    @Test void rankingYRangosDebenImplementarse() {
        CNPWarmup cnp = new CNPWarmup();
        cnp.addOpositor(opositor());
        cnp.actualizarNota("123", 8.0);
        assertNotNull(cnp.topN(1));
        assertNotNull(cnp.opositoresEntreNotas(5.0, 10.0));
        assertNotNull(cnp.aptosPorProvincia("Madrid"));
    }

    @Test void removeDebeImplementarse() {
        CNPWarmup cnp = new CNPWarmup();
        cnp.addOpositor(opositor());
        assertDoesNotThrow(() -> cnp.removeOpositor("123"));
    }
}
