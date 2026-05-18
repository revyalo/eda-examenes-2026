package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class NAryTreeClearCopyTest {

                @Test
            void clearDebeResolverElEjercicio() {
                NAryTreeClearCopy ejercicio = new NAryTreeClearCopy();

                Object resultado = ejercicio.clear();

                assertNotNull(resultado, "Arbol n-ario: clear y copy debe producir el resultado esperado del enunciado.");
            }

@Test
            void copyDebeResolverElEjercicio() {
                NAryTreeClearCopy ejercicio = new NAryTreeClearCopy();

                Object resultado = ejercicio.copy();

                assertNotNull(resultado, "Arbol n-ario: clear y copy debe producir el resultado esperado del enunciado.");
            }
            }

