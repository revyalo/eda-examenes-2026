package es.urjc.grafo.EDA.examen.casoslimpios.safebroadcastnet;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SafeBroadcastNetTest {

    @Test
    void routerStoresMessagesByIdAndDate() {
        Router router = new Router("10.0.0.1");
        BroadcastMessage old = new BroadcastMessage("m1", LocalDateTime.of(2026, 1, 1, 10, 0), "10.0.0.1", "hola");
        BroadcastMessage newer = new BroadcastMessage("m2", LocalDateTime.of(2026, 1, 2, 10, 0), "10.0.0.1", "adios");

        assertTrue(router.mensajeDeDifusion(old));
        assertFalse(router.mensajeDeDifusion(old));
        assertTrue(router.mensajeDeDifusion(newer));
        assertEquals(List.of(old, newer), router.mensajesEntre(old.sendDate(), newer.sendDate()));
        assertEquals(1, router.borrarMensajesAntiguos(old.sendDate()));
        assertFalse(router.conoceMensaje("m1"));
    }

    @Test
    void networkUsesBfsForTtlCenterAndBroadcastTree() {
        SafeBroadcastNet net = new SafeBroadcastNet();
        net.addRouter(new Router("A"));
        net.addRouter(new Router("B"));
        net.addRouter(new Router("C"));
        net.addConnection("A", "B");
        net.addConnection("B", "C");

        assertEquals(Set.of("A", "B"), Set.copyOf(net.routersAlcanzablesConTTL("A", 1)));
        assertEquals("B", net.centralNode());
        assertEquals(Map.of("A", null, "B", "A", "C", "B"), net.broadcastTree("A"));
    }
}
