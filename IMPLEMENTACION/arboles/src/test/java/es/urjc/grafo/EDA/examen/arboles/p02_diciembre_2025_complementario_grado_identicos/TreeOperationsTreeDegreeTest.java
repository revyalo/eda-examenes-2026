package es.urjc.grafo.EDA.examen.arboles.p02_diciembre_2025_complementario_grado_identicos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TreeOperationsTreeDegreeTest {

    @Test
void treeDegreeDebeResolverElEjercicio() {
    TreeOperationsTreeDegree ejercicio = new TreeOperationsTreeDegree();

    Object resultado = ejercicio.treeDegree();

    assertNotNull(resultado, "TreeOperations.treeDegree debe producir el resultado esperado del enunciado.");
}
}
