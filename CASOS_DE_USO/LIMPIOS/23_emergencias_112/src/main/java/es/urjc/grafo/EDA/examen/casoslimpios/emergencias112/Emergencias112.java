package es.urjc.grafo.EDA.examen.casoslimpios.emergencias112;

import java.time.LocalDateTime;
import java.util.Collection;

public class Emergencias112 {

    // TODO: declara estructuras privadas para bases, carreteras, incidentes, fechas y prioridad.

    public boolean addBase(Base base) {
        throw new UnsupportedOperationException("TODO: addBase");
    }

    public boolean addRoad(String baseA, String baseB) {
        throw new UnsupportedOperationException("TODO: addRoad");
    }

    public boolean registerIncident(Incident incident) {
        throw new UnsupportedOperationException("TODO: registerIncident");
    }

    public Incident attendNextIncident() {
        throw new UnsupportedOperationException("TODO: attendNextIncident");
    }

    public Collection<Incident> incidentsBetween(LocalDateTime from, LocalDateTime to) {
        throw new UnsupportedOperationException("TODO: incidentsBetween");
    }

    public Collection<String> nearbyBases(String baseId, int maxRoads) {
        throw new UnsupportedOperationException("TODO: nearbyBases");
    }

    public String assignNearestAvailableBase(String incidentId) {
        throw new UnsupportedOperationException("TODO: assignNearestAvailableBase");
    }

    public String operationalCenter() {
        throw new UnsupportedOperationException("TODO: operationalCenter");
    }

    public boolean cancelIncident(String incidentId) {
        throw new UnsupportedOperationException("TODO: cancelIncident");
    }
}
