package es.urjc.grafo.EDA.examen.casoslimpios.network;

import java.util.List;

public class Router {

    private final String id;
    // TODO: declara aqui la tabla de rutas y estructuras auxiliares.

    public Router(String id) {
        this.id = id;
        // TODO: inicializar la tabla con el propio router si lo consideras necesario.
    }

    public String getId() {
        return id;
    }

    public List<Message> advertise() {
        // TODO: devolver mensajes con todos los destinos conocidos por este router.
        throw new UnsupportedOperationException("TODO: advertise");
    }

    public boolean receiveMessage(List<Message> messages) {
        // TODO: aplicar RIP y devolver true si se actualiza alguna ruta.
        throw new UnsupportedOperationException("TODO: receiveMessage");
    }

    public boolean KnownDestination(String destination) {
        // TODO: devolver true si destination esta en la tabla de rutas.
        throw new UnsupportedOperationException("TODO: KnownDestination");
    }

    public int costTo(String destination) {
        // TODO: devolver el coste conocido hasta destination.
        throw new UnsupportedOperationException("TODO: costTo");
    }

    public String nextHopTo(String destination) {
        // TODO: devolver el vecino por el que se llega a destination.
        throw new UnsupportedOperationException("TODO: nextHopTo");
    }
}
