package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class LinkedTernaryTreeSkeletonTest {

                @Test
            void addRootDebeResolverElEjercicio() {
                LinkedTernaryTreeSkeleton ejercicio = new LinkedTernaryTreeSkeleton();

                Object resultado = ejercicio.addRoot();

                assertNotNull(resultado, "LinkedTernaryTree debe producir el resultado esperado del enunciado.");
            }

@Test
            void insertFirstDebeResolverElEjercicio() {
                LinkedTernaryTreeSkeleton ejercicio = new LinkedTernaryTreeSkeleton();

                Object resultado = ejercicio.insertFirst();

                assertNotNull(resultado, "LinkedTernaryTree debe producir el resultado esperado del enunciado.");
            }

@Test
            void insertSecondDebeResolverElEjercicio() {
                LinkedTernaryTreeSkeleton ejercicio = new LinkedTernaryTreeSkeleton();

                Object resultado = ejercicio.insertSecond();

                assertNotNull(resultado, "LinkedTernaryTree debe producir el resultado esperado del enunciado.");
            }

@Test
            void insertThirdDebeResolverElEjercicio() {
                LinkedTernaryTreeSkeleton ejercicio = new LinkedTernaryTreeSkeleton();

                Object resultado = ejercicio.insertThird();

                assertNotNull(resultado, "LinkedTernaryTree debe producir el resultado esperado del enunciado.");
            }
            }

