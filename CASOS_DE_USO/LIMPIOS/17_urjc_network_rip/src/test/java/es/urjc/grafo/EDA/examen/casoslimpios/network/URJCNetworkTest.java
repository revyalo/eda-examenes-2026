package es.urjc.grafo.EDA.examen.casoslimpios.network;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class URJCNetworkTest {

    @Test
    void routerActualizaRutasConMensajesMejores() {
        Router router = new Router("R1");
        boolean updated = router.receiveMessage(List.of(
                new Message("R2", "R2", 0),
                new Message("R2", "R3", 1)
        ));

        assertTrue(updated);
        assertTrue(router.KnownDestination("R3"));
        assertEquals(2, router.costTo("R3"));
        assertEquals("R2", router.nextHopTo("R3"));
    }

    @Test
    void networkPropagaAlConectarRouterNuevo() {
        Network network = new Network();
        Router r1 = new Router("R1");
        Router r2 = new Router("R2");
        Router r3 = new Router("R3");

        network.connectNewRouter(r1, List.of());
        network.connectNewRouter(r2, List.of(r1));
        network.connectNewRouter(r3, List.of(r2));

        assertTrue(r1.KnownDestination("R3"));
        assertEquals(2, r1.costTo("R3"));
    }
}
