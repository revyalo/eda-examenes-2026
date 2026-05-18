package es.urjc.grafo.EDA.examen.casos;

    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class RegistroCNPAvanzado {

        private final HashMap<String, Opositor> opositoresPorDni = new HashMap<>();
private final HashMap<String, HashSet<String>> opositoresPorProvincia = new HashMap<>();
private final TreeSet<Opositor> rankingPorNota = new TreeSet<>();
private final TreeMap<Double, HashSet<String>> opositoresPorNota = new TreeMap<>();


    public record Opositor(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Opositor> {
        @Override
        public int compareTo(Opositor other) {
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



    public void addOpositor(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addOpositor - Registro CNP avanzado");
    }


    public void actualizarNota(String id, double valor) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar actualizarNota - Registro CNP avanzado");
    }


public Iterable<String> top(int n) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar top - Registro CNP avanzado");
}


public Iterable<String> aptosPorProvincia(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar aptosPorProvincia - Registro CNP avanzado");
}


public Iterable<String> opositoresEntreNotas(double min, double max) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar opositoresEntreNotas - Registro CNP avanzado");
}


    public void eliminarOpositor(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar eliminarOpositor - Registro CNP avanzado");
    }

    }
