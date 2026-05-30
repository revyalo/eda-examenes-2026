package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TreeOperationsIsSymmetricTest {

    @Test
void isSymmetricDebeResolverElEjercicio() {
    TreeOperationsIsSymmetric ejercicio = new TreeOperationsIsSymmetric();

    Object resultado = ejercicio.isSymmetric();

    assertNotNull(resultado, "TreeOperations.isSymmetric debe producir el resultado esperado del enunciado.");
}
}

