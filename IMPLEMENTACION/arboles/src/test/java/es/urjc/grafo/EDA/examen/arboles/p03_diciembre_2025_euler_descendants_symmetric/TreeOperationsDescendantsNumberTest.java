package es.urjc.grafo.EDA.examen.arboles.p03_diciembre_2025_euler_descendants_symmetric;

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
