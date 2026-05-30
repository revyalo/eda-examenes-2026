package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class GraphOperationsEulerianTest {

    @Test
void isEulerianGraphDebeResolverElEjercicio() {
    GraphOperationsEulerian ejercicio = new GraphOperationsEulerian();

    Object resultado = ejercicio.isEulerianGraph();

    assertNotNull(resultado, "GraphOperations.isEulerianGraph debe producir el resultado esperado del enunciado.");
}
}

