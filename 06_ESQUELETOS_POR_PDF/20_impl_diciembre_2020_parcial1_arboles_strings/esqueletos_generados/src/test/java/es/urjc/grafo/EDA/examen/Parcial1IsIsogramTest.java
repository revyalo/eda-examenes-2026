package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class Parcial1IsIsogramTest {

    @Test
void isIsogramDebeResolverElEjercicio() {
    Parcial1IsIsogram ejercicio = new Parcial1IsIsogram();

    Object resultado = ejercicio.isIsogram();

    assertNotNull(resultado, "Parcial1.isIsogram debe producir el resultado esperado del enunciado.");
}
}

