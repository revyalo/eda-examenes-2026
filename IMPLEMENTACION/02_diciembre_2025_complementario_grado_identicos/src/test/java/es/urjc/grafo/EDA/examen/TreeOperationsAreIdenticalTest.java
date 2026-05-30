package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TreeOperationsAreIdenticalTest {

    @Test
void areIdenticalDebeResolverElEjercicio() {
    TreeOperationsAreIdentical ejercicio = new TreeOperationsAreIdentical();

    Object resultado = ejercicio.areIdentical();

    assertNotNull(resultado, "TreeOperations.areIdentical debe producir el resultado esperado del enunciado.");
}
}

