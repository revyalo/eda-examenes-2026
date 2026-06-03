package es.urjc.grafo.EDA.examen.casoslimpios.emergencias112;

import java.time.LocalDateTime;

public class Incident {

    private final String id;
    private final LocalDateTime date;
    private final String locality;
    private final int gravity;
    private final String referenceBaseId;
    private IncidentStatus status;
    private String assignedBaseId;

    public Incident(String id, LocalDateTime date, String locality, int gravity, String referenceBaseId) {
        this.id = id;
        this.date = date;
        this.locality = locality;
        this.gravity = gravity;
        this.referenceBaseId = referenceBaseId;
        this.status = IncidentStatus.PENDIENTE;
    }

    public String getId() { return id; }

    public LocalDateTime getDate() { return date; }

    public String getLocality() { return locality; }

    public int getGravity() { return gravity; }

    public String getReferenceBaseId() { return referenceBaseId; }

    public IncidentStatus getStatus() { return status; }

    public void setStatus(IncidentStatus status) { this.status = status; }

    public String getAssignedBaseId() { return assignedBaseId; }

    public void setAssignedBaseId(String assignedBaseId) { this.assignedBaseId = assignedBaseId; }
}
