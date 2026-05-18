package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class LevelIteratorSkeletonTest {

                @Test
            void hasNextDebeResolverElEjercicio() {
                LevelIteratorSkeleton ejercicio = new LevelIteratorSkeleton();

                Object resultado = ejercicio.hasNext();

                assertNotNull(resultado, "LevelIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void nextDebeResolverElEjercicio() {
                LevelIteratorSkeleton ejercicio = new LevelIteratorSkeleton();

                Object resultado = ejercicio.next();

                assertNotNull(resultado, "LevelIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeDebeResolverElEjercicio() {
                LevelIteratorSkeleton ejercicio = new LevelIteratorSkeleton();

                Object resultado = ejercicio.remove();

                assertNotNull(resultado, "LevelIterator debe producir el resultado esperado del enunciado.");
            }
            }

