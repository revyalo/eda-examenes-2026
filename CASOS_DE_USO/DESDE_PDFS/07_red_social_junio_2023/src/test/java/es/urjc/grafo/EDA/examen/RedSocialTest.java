package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedSocialTest {

    @Test
    void perfilesSeguidoresSugerenciasYBots() {
        RedSocial red = new RedSocial();
        Persona ana = red.newProfile("ana");
        Persona luis = red.newProfile("luis");
        Persona eva = red.newProfile("eva");
        Persona noRegistrada = new Persona("ghost");

        assertNotNull(ana);
        assertNull(red.newProfile("ana"));
        assertTrue(red.wantToBeFollower(ana, luis));
        assertTrue(red.wantToBeFollower(eva, luis));
        assertFalse(red.wantToBeFollower(noRegistrada, luis));
        assertEquals(java.util.Set.of(ana, eva), java.util.Set.copyOf(red.followers(luis)));
        assertEquals(java.util.Set.of(luis), java.util.Set.copyOf(red.following(ana)));
        assertEquals(java.util.Set.of(ana, eva), java.util.Set.copyOf(red.suggestions(eva)));
        assertTrue(red.suspiciousBot().contains(ana));
        assertTrue(red.cleanBots().contains(ana));
    }
}
