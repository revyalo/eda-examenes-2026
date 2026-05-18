package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class InternalNodeIteratorSkeletonTest {

                @Test
            void hasNextDebeResolverElEjercicio() {
                InternalNodeIteratorSkeleton ejercicio = new InternalNodeIteratorSkeleton();

                Object resultado = ejercicio.hasNext();

                assertNotNull(resultado, "InternalNodeIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void nextDebeResolverElEjercicio() {
                InternalNodeIteratorSkeleton ejercicio = new InternalNodeIteratorSkeleton();

                Object resultado = ejercicio.next();

                assertNotNull(resultado, "InternalNodeIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeDebeResolverElEjercicio() {
                InternalNodeIteratorSkeleton ejercicio = new InternalNodeIteratorSkeleton();

                Object resultado = ejercicio.remove();

                assertNotNull(resultado, "InternalNodeIterator debe producir el resultado esperado del enunciado.");
            }
            }

