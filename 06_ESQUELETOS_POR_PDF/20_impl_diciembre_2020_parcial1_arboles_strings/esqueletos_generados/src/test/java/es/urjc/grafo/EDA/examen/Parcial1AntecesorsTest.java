package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Parcial1AntecesorsTest {

    @Test
void antecesorsDebeResolverElEjercicio() {
    Parcial1Antecesors ejercicio = new Parcial1Antecesors();

    Object resultado = ejercicio.antecesors();

    assertNotNull(resultado, "Parcial1.antecesors debe producir el resultado esperado del enunciado.");
}
}

