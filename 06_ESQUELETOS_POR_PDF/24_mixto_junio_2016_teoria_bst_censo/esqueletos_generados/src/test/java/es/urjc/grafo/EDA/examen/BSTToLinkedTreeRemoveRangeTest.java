package es.urjc.grafo.EDA.examen;

            import org.junit.jupiter.api.Test;

            import static org.junit.jupiter.api.Assertions.assertNotNull;

            class BSTToLinkedTreeRemoveRangeTest {

                @Test
            void toLinkedTreeDebeResolverElEjercicio() {
                BSTToLinkedTreeRemoveRange ejercicio = new BSTToLinkedTreeRemoveRange();

                Object resultado = ejercicio.toLinkedTree();

                assertNotNull(resultado, "BST.toLinkedTree y BST.removeRange debe producir el resultado esperado del enunciado.");
            }

@Test
            void removeRangeDebeResolverElEjercicio() {
                BSTToLinkedTreeRemoveRange ejercicio = new BSTToLinkedTreeRemoveRange();

                Object resultado = ejercicio.removeRange();

                assertNotNull(resultado, "BST.toLinkedTree y BST.removeRange debe producir el resultado esperado del enunciado.");
            }
            }

