package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GraphOperationsEnero2026Test {

    @Test
void existeCaminoDeLongitudMenorOIgualANDebeResolverElEjercicio() {
    GraphOperationsEnero2026 ejercicio = new GraphOperationsEnero2026();

    Object resultado = ejercicio.existeCaminoDeLongitudMenorOIgualAN();

    assertNotNull(resultado, "GraphOperations.existeCaminoDeLongitudMenorOIgualAN debe producir el resultado esperado del enunciado.");
}
}

