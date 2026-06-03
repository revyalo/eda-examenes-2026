package es.urjc.grafo.EDA.examen.casoslimpios.safebroadcastnet;

import java.time.LocalDateTime;

public class Router {

    private final String ip;
    // TODO: declara las estructuras privadas para mensajes por id y por fecha.

    public Router(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public boolean mensajeDeDifusion(BroadcastMessage message) {
        throw new UnsupportedOperationException("TODO: mensajeDeDifusion");
    }

    public int borrarMensajesAntiguos(LocalDateTime date) {
        throw new UnsupportedOperationException("TODO: borrarMensajesAntiguos");
    }

    public Iterable<BroadcastMessage> mensajesEntre(LocalDateTime from, LocalDateTime to) {
        throw new UnsupportedOperationException("TODO: mensajesEntre");
    }

    public boolean conoceMensaje(String messageId) {
        throw new UnsupportedOperationException("TODO: conoceMensaje");
    }
}
