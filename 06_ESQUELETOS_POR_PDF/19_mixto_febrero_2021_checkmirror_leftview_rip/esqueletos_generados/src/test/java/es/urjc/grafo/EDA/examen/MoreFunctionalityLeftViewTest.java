package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MoreFunctionalityLeftViewTest {

    @Test
void leftViewDebeResolverElEjercicio() {
    MoreFunctionalityLeftView ejercicio = new MoreFunctionalityLeftView();

    Object resultado = ejercicio.leftView();

    assertNotNull(resultado, "MoreFunctionality.leftView debe producir el resultado esperado del enunciado.");
}
}

