package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayOfLightTest {

    @Test
    void cambiarEstadoAfectaALuzYSusVecinas() {
        Light l1 = new Light(1, false);
        Light l2 = new Light(2, false);
        Light l3 = new Light(3, true);
        PlayOfLight game = new PlayOfLight(
                java.util.List.of(l1, l2, l3),
                java.util.List.of(new Light[]{l1, l2}, new Light[]{l1, l3})
        );

        game.changeTheState(l1);
        assertTrue(l1.isOn());
        assertTrue(l2.isOn());
        assertFalse(l3.isOn());
        assertIterableEquals(java.util.List.of(l1, l2), game.lightsOn());
        assertIterableEquals(java.util.List.of(l3), game.lightsOff());
    }

    @Test
    void finYActualizacionDePartida() {
        Light l1 = new Light(1, true);
        Light l2 = new Light(2, true);
        PlayOfLight game = new PlayOfLight(
                java.util.List.of(l1, l2),
                java.util.List.<Light[]>of(new Light[]{l1, l2})
        );

        assertTrue(game.endOfGame());
        game.updateGame();
        assertIterableEquals(java.util.List.of(), game.lightsOn());
    }
}
