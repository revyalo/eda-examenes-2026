package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TreeOperationsMonticuloTest {

    @Test
void cumplePropiedadesMonticuloDebeResolverElEjercicio() {
    TreeOperationsMonticulo ejercicio = new TreeOperationsMonticulo();

    Object resultado = ejercicio.cumplePropiedadesMonticulo();

    assertNotNull(resultado, "TreeOperations.cumplePropiedadesMonticulo debe producir el resultado esperado del enunciado.");
}
}

