package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class WithoutSiblingIteratorSkeletonTest {

                @Test
            void hasNextDebeResolverElEjercicio() {
                WithoutSiblingIteratorSkeleton ejercicio = new WithoutSiblingIteratorSkeleton();

                Object resultado = ejercicio.hasNext();

                assertNotNull(resultado, "WithoutSiblingIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void nextDebeResolverElEjercicio() {
                WithoutSiblingIteratorSkeleton ejercicio = new WithoutSiblingIteratorSkeleton();

                Object resultado = ejercicio.next();

                assertNotNull(resultado, "WithoutSiblingIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeDebeResolverElEjercicio() {
                WithoutSiblingIteratorSkeleton ejercicio = new WithoutSiblingIteratorSkeleton();

                Object resultado = ejercicio.remove();

                assertNotNull(resultado, "WithoutSiblingIterator debe producir el resultado esperado del enunciado.");
            }
            }

