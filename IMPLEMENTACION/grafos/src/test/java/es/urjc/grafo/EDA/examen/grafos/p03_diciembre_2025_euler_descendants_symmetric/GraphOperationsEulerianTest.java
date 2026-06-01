package es.urjc.grafo.EDA.examen.grafos.p03_diciembre_2025_euler_descendants_symmetric;

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
