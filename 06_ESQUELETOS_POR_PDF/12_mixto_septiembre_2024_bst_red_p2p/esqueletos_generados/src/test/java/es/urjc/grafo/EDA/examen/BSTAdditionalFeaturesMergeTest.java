package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BSTAdditionalFeaturesMergeTest {

    @Test
void mergeDebeResolverElEjercicio() {
    BSTAdditionalFeaturesMerge ejercicio = new BSTAdditionalFeaturesMerge();

    Object resultado = ejercicio.merge();

    assertNotNull(resultado, "AdditionalFeatures.merge sobre BinarySearchTree debe producir el resultado esperado del enunciado.");
}
}

