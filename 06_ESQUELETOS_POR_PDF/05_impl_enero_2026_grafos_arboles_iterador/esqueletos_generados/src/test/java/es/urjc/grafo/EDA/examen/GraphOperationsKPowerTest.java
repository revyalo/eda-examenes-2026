package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GraphOperationsKPowerTest {

    @Test
void kPowerDebeResolverElEjercicio() {
    GraphOperationsKPower ejercicio = new GraphOperationsKPower();

    Object resultado = ejercicio.kPower();

    assertNotNull(resultado, "GraphOperations.kPower debe producir el resultado esperado del enunciado.");
}
}

