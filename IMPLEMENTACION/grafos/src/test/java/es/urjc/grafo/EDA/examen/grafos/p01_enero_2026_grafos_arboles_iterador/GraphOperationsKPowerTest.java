package es.urjc.grafo.EDA.examen.grafos.p01_enero_2026_grafos_arboles_iterador;

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
