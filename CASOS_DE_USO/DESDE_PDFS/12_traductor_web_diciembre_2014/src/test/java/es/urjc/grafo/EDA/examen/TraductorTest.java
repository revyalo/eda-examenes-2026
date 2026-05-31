package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraductorTest {

    @Test
    void traductorInsertaBuscaYListaTraducciones() {
        Traductor t = new Traductor();
        t.anadir("Hola", "Hello", "Ingles");
        t.anadir("Hola", "Bonjour", "Frances");
        t.anadir("Pulse aqui", "Press here", "Ingles");

        assertEquals("Hello", t.traducir("Hola", "Ingles"));
        assertEquals("Bonjour", t.traducir("Hola", "Frances"));
        assertNull(t.traducir("Hola", "Aleman"));
        assertEquals(java.util.Set.of(
                new Traduccion("Hello", "Ingles"),
                new Traduccion("Bonjour", "Frances")
        ), java.util.Set.copyOf(t.traducciones("Hola")));
    }
}
