package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class EfficientDictSkeletonTest {

                @Test
            void putDebeResolverElEjercicio() {
                EfficientDictSkeleton ejercicio = new EfficientDictSkeleton();

                Object resultado = ejercicio.put();

                assertNotNull(resultado, "EfficientDict debe producir el resultado esperado del enunciado.");
            }

@Test
            void getDebeResolverElEjercicio() {
                EfficientDictSkeleton ejercicio = new EfficientDictSkeleton();

                Object resultado = ejercicio.get();

                assertNotNull(resultado, "EfficientDict debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeDebeResolverElEjercicio() {
                EfficientDictSkeleton ejercicio = new EfficientDictSkeleton();

                Object resultado = ejercicio.remove();

                assertNotNull(resultado, "EfficientDict debe producir el resultado esperado del enunciado.");
            }

@Test
            void entriesDebeResolverElEjercicio() {
                EfficientDictSkeleton ejercicio = new EfficientDictSkeleton();

                Object resultado = ejercicio.entries();

                assertNotNull(resultado, "EfficientDict debe producir el resultado esperado del enunciado.");
            }
            }

