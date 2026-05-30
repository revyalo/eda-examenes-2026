package es.urjc.grafo.EDA.examen;

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

