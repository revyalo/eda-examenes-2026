package es.urjc.grafo.EDA.examen.grafos.p04_hipergrafo;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class ImplementacionHipergrafoTest {

                @Test
            void insertHyperedgeDebeResolverElEjercicio() {
                ImplementacionHipergrafo ejercicio = new ImplementacionHipergrafo();

                Object resultado = ejercicio.insertHyperedge();

                assertNotNull(resultado, "AdjacencyMapUndirectedHyperGraph / ELHyperGraph debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeHyperedgeDebeResolverElEjercicio() {
                ImplementacionHipergrafo ejercicio = new ImplementacionHipergrafo();

                Object resultado = ejercicio.removeHyperedge();

                assertNotNull(resultado, "AdjacencyMapUndirectedHyperGraph / ELHyperGraph debe producir el resultado esperado del enunciado.");
            }

@Test
            void incidentHyperedgesDebeResolverElEjercicio() {
                ImplementacionHipergrafo ejercicio = new ImplementacionHipergrafo();

                Object resultado = ejercicio.incidentHyperedges();

                assertNotNull(resultado, "AdjacencyMapUndirectedHyperGraph / ELHyperGraph debe producir el resultado esperado del enunciado.");
            }

@Test
            void degreeDebeResolverElEjercicio() {
                ImplementacionHipergrafo ejercicio = new ImplementacionHipergrafo();

                Object resultado = ejercicio.degree();

                assertNotNull(resultado, "AdjacencyMapUndirectedHyperGraph / ELHyperGraph debe producir el resultado esperado del enunciado.");
            }
            }
