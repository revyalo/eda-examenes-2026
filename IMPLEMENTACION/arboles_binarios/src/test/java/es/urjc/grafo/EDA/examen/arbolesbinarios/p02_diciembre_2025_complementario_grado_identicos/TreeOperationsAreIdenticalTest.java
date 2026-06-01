package es.urjc.grafo.EDA.examen.arbolesbinarios.p02_diciembre_2025_complementario_grado_identicos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TreeOperationsAreIdenticalTest {

    @Test
void areIdenticalDebeResolverElEjercicio() {
    TreeOperationsAreIdentical ejercicio = new TreeOperationsAreIdentical();

    Object resultado = ejercicio.areIdentical();

    assertNotNull(resultado, "TreeOperations.areIdentical debe producir el resultado esperado del enunciado.");
}
}
