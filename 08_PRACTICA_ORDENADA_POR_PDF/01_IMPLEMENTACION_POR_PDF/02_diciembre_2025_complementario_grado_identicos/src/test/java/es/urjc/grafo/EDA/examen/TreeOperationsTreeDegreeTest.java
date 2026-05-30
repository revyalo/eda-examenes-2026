package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TreeOperationsTreeDegreeTest {

    @Test
void treeDegreeDebeResolverElEjercicio() {
    TreeOperationsTreeDegree ejercicio = new TreeOperationsTreeDegree();

    Object resultado = ejercicio.treeDegree();

    assertNotNull(resultado, "TreeOperations.treeDegree debe producir el resultado esperado del enunciado.");
}
}

