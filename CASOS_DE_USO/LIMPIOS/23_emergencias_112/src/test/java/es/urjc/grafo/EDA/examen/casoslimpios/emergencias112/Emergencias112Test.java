package es.urjc.grafo.EDA.examen.casoslimpios.emergencias112;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class Emergencias112Test {

    @Test
    void priorityComparatorUsesGravityDateAndId() {
        IncidentPriorityComparator comparator = new IncidentPriorityComparator();
        Incident grave = new Incident("A", LocalDateTime.of(2026, 1, 1, 10, 0), "M1", 5, "B1");
        Incident less = new Incident("B", LocalDateTime.of(2026, 1, 1, 9, 0), "M2", 3, "B1");

        assertTrue(comparator.compare(grave, less) < 0);
    }

    @Test
    void incidentsUsePriorityQueueAndTemporalIndex() {
        Emergencias112 emergencias = new Emergencias112();
        emergencias.addBase(new Base("A", 1, "norte"));
        LocalDateTime firstDate = LocalDateTime.of(2026, 1, 1, 10, 0);
        LocalDateTime secondDate = LocalDateTime.of(2026, 1, 1, 11, 0);
        Incident first = new Incident("I1", firstDate, "Madrid", 1, "A");
        Incident second = new Incident("I2", secondDate, "Madrid", 5, "A");

        assertTrue(emergencias.registerIncident(first));
        assertTrue(emergencias.registerIncident(second));
        assertEquals(List.of(first, second), emergencias.incidentsBetween(firstDate, secondDate));
        assertEquals(second, emergencias.attendNextIncident());
        assertEquals(IncidentStatus.ATENDIDO, second.getStatus());
    }

    @Test
    void roadsSupportNearbyBasesAssignmentAndOperationalCenter() {
        Emergencias112 emergencias = new Emergencias112();
        emergencias.addBase(new Base("A", 0, "norte"));
        emergencias.addBase(new Base("B", 1, "centro"));
        emergencias.addBase(new Base("C", 2, "sur"));
        emergencias.addRoad("A", "B");
        emergencias.addRoad("B", "C");
        Incident incident = new Incident("I1", LocalDateTime.of(2026, 1, 1, 10, 0), "Madrid", 4, "A");
        emergencias.registerIncident(incident);

        assertEquals(Set.of("A", "B"), Set.copyOf(emergencias.nearbyBases("A", 1)));
        assertEquals("B", emergencias.assignNearestAvailableBase("I1"));
        assertEquals("B", incident.getAssignedBaseId());
        assertEquals("B", emergencias.operationalCenter());
    }

    @Test
    void cancelOnlyWorksForPendingIncidents() {
        Emergencias112 emergencias = new Emergencias112();
        emergencias.addBase(new Base("A", 1, "norte"));
        Incident incident = new Incident("I1", LocalDateTime.of(2026, 1, 1, 10, 0), "Madrid", 2, "A");
        emergencias.registerIncident(incident);

        assertTrue(emergencias.cancelIncident("I1"));
        assertEquals(IncidentStatus.CANCELADO, incident.getStatus());
        assertFalse(emergencias.cancelIncident("I1"));
    }
}
