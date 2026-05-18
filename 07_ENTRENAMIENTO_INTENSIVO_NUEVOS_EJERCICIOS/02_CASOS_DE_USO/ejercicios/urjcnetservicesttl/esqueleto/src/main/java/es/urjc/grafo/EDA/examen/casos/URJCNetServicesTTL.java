package es.urjc.grafo.EDA.examen.casos;

    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class URJCNetServicesTTL {

        private final HashMap<String, Router> routers = new HashMap<>();
private final HashMap<String, HashSet<String>> conexiones = new HashMap<>();
private final HashMap<String, Mensaje> mensajes = new HashMap<>();
private final TreeMap<LocalDateTime, HashSet<String>> mensajesPorFecha = new TreeMap<>();


    public record Router(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Router> {
        @Override
        public int compareTo(Router other) {
            int cmp = Integer.compare(other.prioridad, this.prioridad);
            if (cmp != 0) {
                return cmp;
            }
            cmp = Double.compare(other.valor, this.valor);
            if (cmp != 0) {
                return cmp;
            }
            return this.id.compareTo(other.id);
        }
    }



    public record Mensaje(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Mensaje> {
        @Override
        public int compareTo(Mensaje other) {
            int cmp = Integer.compare(other.prioridad, this.prioridad);
            if (cmp != 0) {
                return cmp;
            }
            cmp = Double.compare(other.valor, this.valor);
            if (cmp != 0) {
                return cmp;
            }
            return this.id.compareTo(other.id);
        }
    }



    public void addRouter(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addRouter - URJCNetServices 2: red de routers con TTL");
    }


    public void addConnection(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addConnection - URJCNetServices 2: red de routers con TTL");
    }


    public void recibirMensaje(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar recibirMensaje - URJCNetServices 2: red de routers con TTL");
    }


public Iterable<String> routersAlcanzables(String origen, int limite) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar routersAlcanzables - URJCNetServices 2: red de routers con TTL");
}


    public void borrarMensajesAntiguos(LocalDateTime fecha) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar borrarMensajesAntiguos - URJCNetServices 2: red de routers con TTL");
    }


public String routerMasConectado(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar routerMasConectado - URJCNetServices 2: red de routers con TTL");
}

    }
