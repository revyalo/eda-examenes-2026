package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MoreFunctionalityCheckMirrorTest {

    @Test
void checkMirrorDebeResolverElEjercicio() {
    MoreFunctionalityCheckMirror ejercicio = new MoreFunctionalityCheckMirror();

    Object resultado = ejercicio.checkMirror();

    assertNotNull(resultado, "MoreFunctionality.checkMirror debe producir el resultado esperado del enunciado.");
}
}

