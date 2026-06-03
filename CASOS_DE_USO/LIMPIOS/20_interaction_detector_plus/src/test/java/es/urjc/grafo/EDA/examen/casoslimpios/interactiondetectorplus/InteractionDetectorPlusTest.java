package es.urjc.grafo.EDA.examen.casoslimpios.interactiondetectorplus;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InteractionDetectorPlusTest {

    @Test
    void interactionsAccumulateMinutesByDate() {
        Interactions interactions = new Interactions();
        interactions.addInteraction(LocalDate.of(2026, 1, 10), 15);
        interactions.addInteraction(LocalDate.of(2026, 1, 10), 20);
        interactions.addInteraction(LocalDate.of(2026, 1, 12), 5);

        assertTrue(interactions.isOfInterest(LocalDate.of(2026, 1, 10), 35));
        assertEquals(40, interactions.totalMinutesFrom(LocalDate.of(2026, 1, 10)));
    }

    @Test
    void interestTreeUsesOnlyContactsOfInterest() {
        InteractionDetectorPlus detector = new InteractionDetectorPlus();
        detector.storeContact(LocalDate.of(2026, 1, 10), 30, 1, 2);
        detector.storeContact(LocalDate.of(2026, 1, 11), 30, 2, 3);
        detector.storeContact(LocalDate.of(2025, 12, 1), 99, 3, 4);

        assertEquals(Set.of(1, 2, 3), Set.copyOf(detector.getInterestTree(1, LocalDate.of(2026, 1, 1), 20)));
    }

    @Test
    void levelsAndMostConnectedSuspectAreComputedInsideTree() {
        InteractionDetectorPlus detector = new InteractionDetectorPlus();
        detector.storeContact(LocalDate.of(2026, 1, 1), 10, 1, 2);
        detector.storeContact(LocalDate.of(2026, 1, 1), 10, 1, 3);
        detector.storeContact(LocalDate.of(2026, 1, 1), 10, 2, 3);

        assertEquals(Map.of(1, 0, 2, 1, 3, 1), detector.getInterestLevels(1, LocalDate.of(2026, 1, 1), 10));
        assertEquals(1, detector.mostConnectedSuspect(1, LocalDate.of(2026, 1, 1), 10));
    }
}
