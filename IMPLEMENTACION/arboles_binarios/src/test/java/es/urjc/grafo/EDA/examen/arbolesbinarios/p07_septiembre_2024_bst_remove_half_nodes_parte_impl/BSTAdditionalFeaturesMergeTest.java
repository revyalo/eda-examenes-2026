package es.urjc.grafo.EDA.examen.arbolesbinarios.p07_septiembre_2024_bst_remove_half_nodes_parte_impl;

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
