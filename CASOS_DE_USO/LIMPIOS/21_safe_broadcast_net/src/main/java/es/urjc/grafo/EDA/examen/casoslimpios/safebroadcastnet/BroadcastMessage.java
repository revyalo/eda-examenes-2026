package es.urjc.grafo.EDA.examen.casoslimpios.safebroadcastnet;

import java.time.LocalDateTime;

public record BroadcastMessage(String id, LocalDateTime sendDate, String senderIp, String text) {
}
