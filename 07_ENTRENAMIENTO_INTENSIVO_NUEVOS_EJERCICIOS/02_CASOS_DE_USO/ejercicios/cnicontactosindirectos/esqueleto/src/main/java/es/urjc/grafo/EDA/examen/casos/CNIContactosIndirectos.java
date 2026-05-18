package es.urjc.grafo.EDA.examen.casos;

    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class CNIContactosIndirectos {

        private final HashMap<String, Agente> agentes = new HashMap<>();
private final HashMap<String, HashSet<String>> contactos = new HashMap<>();
private final HashMap<String, HashSet<String>> contactosPorZona = new HashMap<>();
private final TreeMap<LocalDateTime, HashSet<String>> interaccionesPorFecha = new TreeMap<>();


    public record Agente(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Agente> {
        @Override
        public int compareTo(Agente other) {
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



    public void addAgente(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addAgente - CNI: detector de contactos indirectos");
    }


    public void registrarContacto(String a, String b, LocalDateTime fecha) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar registrarContacto - CNI: detector de contactos indirectos");
    }


public boolean hanInteractuado(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar hanInteractuado - CNI: detector de contactos indirectos");
}


public boolean posibleCadenaContagio(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar posibleCadenaContagio - CNI: detector de contactos indirectos");
}


public Iterable<String> grupoDeAgente(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar grupoDeAgente - CNI: detector de contactos indirectos");
}


public Iterable<String> interaccionesAntesDe(LocalDateTime fecha) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar interaccionesAntesDe - CNI: detector de contactos indirectos");
}

    }
