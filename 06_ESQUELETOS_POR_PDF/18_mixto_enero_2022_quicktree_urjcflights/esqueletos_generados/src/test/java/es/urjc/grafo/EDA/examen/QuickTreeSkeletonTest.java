package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class QuickTreeSkeletonTest {

                @Test
            void searchDebeResolverElEjercicio() {
                QuickTreeSkeleton ejercicio = new QuickTreeSkeleton();

                Object resultado = ejercicio.search();

                assertNotNull(resultado, "QuickTree con search O(1) debe producir el resultado esperado del enunciado.");
            }

@Test
            void insertDebeResolverElEjercicio() {
                QuickTreeSkeleton ejercicio = new QuickTreeSkeleton();

                Object resultado = ejercicio.insert();

                assertNotNull(resultado, "QuickTree con search O(1) debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeDebeResolverElEjercicio() {
                QuickTreeSkeleton ejercicio = new QuickTreeSkeleton();

                Object resultado = ejercicio.remove();

                assertNotNull(resultado, "QuickTree con search O(1) debe producir el resultado esperado del enunciado.");
            }
            }

