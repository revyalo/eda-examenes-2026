package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MoreFunctionalityIsPerfectTest {

    @Test
void isPerfectDebeResolverElEjercicio() {
    MoreFunctionalityIsPerfect ejercicio = new MoreFunctionalityIsPerfect();

    Object resultado = ejercicio.isPerfect();

    assertNotNull(resultado, "MoreFunctionality.isPerfect debe producir el resultado esperado del enunciado.");
}
}

