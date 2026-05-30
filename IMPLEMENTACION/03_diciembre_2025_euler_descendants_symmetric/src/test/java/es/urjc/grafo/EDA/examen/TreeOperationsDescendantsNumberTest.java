package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TreeOperationsDescendantsNumberTest {

    @Test
void descendantsNumberDebeResolverElEjercicio() {
    TreeOperationsDescendantsNumber ejercicio = new TreeOperationsDescendantsNumber();

    Object resultado = ejercicio.descendantsNumber();

    assertNotNull(resultado, "TreeOperations.descendantsNumber debe producir el resultado esperado del enunciado.");
}
}

