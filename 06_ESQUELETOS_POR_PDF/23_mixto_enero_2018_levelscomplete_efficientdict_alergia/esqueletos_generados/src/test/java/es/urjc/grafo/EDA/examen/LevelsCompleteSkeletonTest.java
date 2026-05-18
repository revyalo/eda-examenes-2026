package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LevelsCompleteSkeletonTest {

    @Test
void levelsCompleteDebeResolverElEjercicio() {
    LevelsCompleteSkeleton ejercicio = new LevelsCompleteSkeleton();

    Object resultado = ejercicio.levelsComplete();

    assertNotNull(resultado, "LevelsComplete.levelsComplete debe producir el resultado esperado del enunciado.");
}
}

