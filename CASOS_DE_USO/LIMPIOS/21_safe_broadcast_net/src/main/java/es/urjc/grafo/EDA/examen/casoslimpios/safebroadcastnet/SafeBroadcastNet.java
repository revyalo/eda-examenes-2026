package es.urjc.grafo.EDA.examen.casoslimpios.safebroadcastnet;

import java.util.Collection;
import java.util.Map;

public class SafeBroadcastNet {

    // TODO: declara las estructuras privadas para routers por IP y conexiones no dirigidas.

    public boolean addRouter(Router router) {
        throw new UnsupportedOperationException("TODO: addRouter");
    }

    public boolean addConnection(String ipA, String ipB) {
        throw new UnsupportedOperationException("TODO: addConnection");
    }

    public Collection<String> routersAlcanzablesConTTL(String ipOrigen, int ttl) {
        throw new UnsupportedOperationException("TODO: routersAlcanzablesConTTL");
    }

    public String centralNode() {
        throw new UnsupportedOperationException("TODO: centralNode");
    }

    public Map<String, String> broadcastTree(String ipOrigen) {
        throw new UnsupportedOperationException("TODO: broadcastTree");
    }
}
