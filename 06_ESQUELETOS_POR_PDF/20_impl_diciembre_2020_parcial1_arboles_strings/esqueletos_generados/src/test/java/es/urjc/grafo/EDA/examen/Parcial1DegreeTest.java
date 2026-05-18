package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Parcial1DegreeTest {

    @Test
void degreeDebeResolverElEjercicio() {
    Parcial1Degree ejercicio = new Parcial1Degree();

    Object resultado = ejercicio.degree();

    assertNotNull(resultado, "Parcial1.degree debe producir el resultado esperado del enunciado.");
}
}

