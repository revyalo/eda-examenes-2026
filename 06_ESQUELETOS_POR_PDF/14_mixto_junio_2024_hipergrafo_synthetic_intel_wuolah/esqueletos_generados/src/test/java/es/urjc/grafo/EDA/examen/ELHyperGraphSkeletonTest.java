package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class ELHyperGraphSkeletonTest {

                @Test
            void insertHyperedgeDebeResolverElEjercicio() {
                ELHyperGraphSkeleton ejercicio = new ELHyperGraphSkeleton();

                Object resultado = ejercicio.insertHyperedge();

                assertNotNull(resultado, "ELHyperGraph / hipergrafo debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeHyperedgeDebeResolverElEjercicio() {
                ELHyperGraphSkeleton ejercicio = new ELHyperGraphSkeleton();

                Object resultado = ejercicio.removeHyperedge();

                assertNotNull(resultado, "ELHyperGraph / hipergrafo debe producir el resultado esperado del enunciado.");
            }

@Test
            void incidentHyperedgesDebeResolverElEjercicio() {
                ELHyperGraphSkeleton ejercicio = new ELHyperGraphSkeleton();

                Object resultado = ejercicio.incidentHyperedges();

                assertNotNull(resultado, "ELHyperGraph / hipergrafo debe producir el resultado esperado del enunciado.");
            }
            }

