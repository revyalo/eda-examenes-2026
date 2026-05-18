package es.urjc.grafo.EDA.examen.ruta;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CasesWarmupExtraTest {
    @Test void routerCniP2PDebenImplementarse() {
        RouterWarmup.Elemento r = new RouterWarmup.Elemento("A", "A", 1, LocalDateTime.now());
        RouterWarmup router = new RouterWarmup();
        router.addElemento(r);
        router.addRelacion("A", "B");
        assertTrue(router.conectadoConLimite("A", "B", 1));

        CNIWarmup cni = new CNIWarmup();
        cni.addElemento(new CNIWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
        assertNotNull(cni.topN(1));

        P2PWarmup p2p = new P2PWarmup();
        p2p.addElemento(new P2PWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
        assertNotNull(p2p.topN(1));
    }

    @Test void flightsRankingHospitalHipergrafoDebenImplementarse() {
        FlightsWarmup flights = new FlightsWarmup();
        flights.addElemento(new FlightsWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
        assertNotNull(flights.topN(1));

        RankingWarmup ranking = new RankingWarmup();
        ranking.addElemento(new RankingWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
        assertNotNull(ranking.topN(1));

        HospitalWarmup hospital = new HospitalWarmup();
        hospital.addElemento(new HospitalWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
        assertNotNull(hospital.topN(1));

        HypergraphMapsWarmup hyper = new HypergraphMapsWarmup();
        hyper.addElemento(new HypergraphMapsWarmup.Elemento("A", "A", 1, LocalDateTime.now()));
        assertNotNull(hyper.topN(1));
    }
}
