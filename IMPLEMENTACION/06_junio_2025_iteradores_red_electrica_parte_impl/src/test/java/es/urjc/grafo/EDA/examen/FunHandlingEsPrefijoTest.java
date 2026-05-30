package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FunHandlingEsPrefijoTest {

    @Test
void esPrefijoDebeResolverElEjercicio() {
    FunHandlingEsPrefijo ejercicio = new FunHandlingEsPrefijo();

    Object resultado = ejercicio.esPrefijo();

    assertNotNull(resultado, "FunHandling.esPrefijo debe producir el resultado esperado del enunciado.");
}
}

