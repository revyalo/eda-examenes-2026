package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExtendedBreadthFirstTreeIteratorRemoveTest {

    @Test
void removeDebeResolverElEjercicio() {
    ExtendedBreadthFirstTreeIteratorRemove ejercicio = new ExtendedBreadthFirstTreeIteratorRemove();

    Object resultado = ejercicio.remove();

    assertNotNull(resultado, "ExtendedBreadthFirstTreeIterator.remove debe producir el resultado esperado del enunciado.");
}
}

