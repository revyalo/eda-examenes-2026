package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GraphOperationsComplementaryTest {

    @Test
void complementaryDebeResolverElEjercicio() {
    GraphOperationsComplementary ejercicio = new GraphOperationsComplementary();

    Object resultado = ejercicio.complementary();

    assertNotNull(resultado, "GraphOperations.complementary debe producir el resultado esperado del enunciado.");
}
}

