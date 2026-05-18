package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class InternalNodeIterator2016Test {

                @Test
            void hasNextDebeResolverElEjercicio() {
                InternalNodeIterator2016 ejercicio = new InternalNodeIterator2016();

                Object resultado = ejercicio.hasNext();

                assertNotNull(resultado, "InternalNodeIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void nextDebeResolverElEjercicio() {
                InternalNodeIterator2016 ejercicio = new InternalNodeIterator2016();

                Object resultado = ejercicio.next();

                assertNotNull(resultado, "InternalNodeIterator debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeDebeResolverElEjercicio() {
                InternalNodeIterator2016 ejercicio = new InternalNodeIterator2016();

                Object resultado = ejercicio.remove();

                assertNotNull(resultado, "InternalNodeIterator debe producir el resultado esperado del enunciado.");
            }
            }

