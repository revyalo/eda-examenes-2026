package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class ReverseInordenBTIteratorSkeletonTest {

                @Test
            void hasNextDebeResolverElEjercicio() {
                ReverseInordenBTIteratorSkeleton ejercicio = new ReverseInordenBTIteratorSkeleton();

                Object resultado = ejercicio.hasNext();

                assertNotNull(resultado, "ReverseInordenBTIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void nextDebeResolverElEjercicio() {
                ReverseInordenBTIteratorSkeleton ejercicio = new ReverseInordenBTIteratorSkeleton();

                Object resultado = ejercicio.next();

                assertNotNull(resultado, "ReverseInordenBTIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeDebeResolverElEjercicio() {
                ReverseInordenBTIteratorSkeleton ejercicio = new ReverseInordenBTIteratorSkeleton();

                Object resultado = ejercicio.remove();

                assertNotNull(resultado, "ReverseInordenBTIterator debe producir el resultado esperado del enunciado.");
            }
            }

