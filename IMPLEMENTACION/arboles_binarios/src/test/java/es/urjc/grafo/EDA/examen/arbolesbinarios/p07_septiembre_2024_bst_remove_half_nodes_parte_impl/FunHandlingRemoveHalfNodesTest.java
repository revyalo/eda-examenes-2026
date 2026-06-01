package es.urjc.grafo.EDA.examen.arbolesbinarios.p07_septiembre_2024_bst_remove_half_nodes_parte_impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FunHandlingRemoveHalfNodesTest {

    @Test
void removeHalfNodesDebeResolverElEjercicio() {
    FunHandlingRemoveHalfNodes ejercicio = new FunHandlingRemoveHalfNodes();

    Object resultado = ejercicio.removeHalfNodes();

    assertNotNull(resultado, "FunHandling.removeHalfNodes debe producir el resultado esperado del enunciado.");
}
}
