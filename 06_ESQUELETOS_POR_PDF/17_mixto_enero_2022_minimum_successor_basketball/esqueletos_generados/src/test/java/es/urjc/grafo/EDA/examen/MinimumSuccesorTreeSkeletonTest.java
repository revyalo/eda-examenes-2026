package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class MinimumSuccesorTreeSkeletonTest {

                @Test
            void minimumDebeResolverElEjercicio() {
                MinimumSuccesorTreeSkeleton ejercicio = new MinimumSuccesorTreeSkeleton();

                Object resultado = ejercicio.minimum();

                assertNotNull(resultado, "MinimumSuccesorTree y MaximumPredecesorTree debe producir el resultado esperado del enunciado.");
            }

@Test
            void minimumFromPositionDebeResolverElEjercicio() {
                MinimumSuccesorTreeSkeleton ejercicio = new MinimumSuccesorTreeSkeleton();

                Object resultado = ejercicio.minimumFromPosition();

                assertNotNull(resultado, "MinimumSuccesorTree y MaximumPredecesorTree debe producir el resultado esperado del enunciado.");
            }

@Test
            void iteratorDebeResolverElEjercicio() {
                MinimumSuccesorTreeSkeleton ejercicio = new MinimumSuccesorTreeSkeleton();

                Object resultado = ejercicio.iterator();

                assertNotNull(resultado, "MinimumSuccesorTree y MaximumPredecesorTree debe producir el resultado esperado del enunciado.");
            }

@Test
            void maximumPredecesorDebeResolverElEjercicio() {
                MinimumSuccesorTreeSkeleton ejercicio = new MinimumSuccesorTreeSkeleton();

                Object resultado = ejercicio.maximumPredecesor();

                assertNotNull(resultado, "MinimumSuccesorTree y MaximumPredecesorTree debe producir el resultado esperado del enunciado.");
            }
            }

