package es.urjc.grafo.EDA.examen.casos;

    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class RedElectricaSinGraph {

        private final HashMap<String, Estacion> estaciones = new HashMap<>();
private final HashMap<String, HashSet<String>> red = new HashMap<>();
private final HashMap<String, HashSet<String>> estacionesPorArea = new HashMap<>();
private final TreeSet<Estacion> estacionesPorConsumo = new TreeSet<>();


    public record Estacion(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Estacion> {
        @Override
        public int compareTo(Estacion other) {
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



    public void addEstacion(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addEstacion - Red electrica sin Graph");
    }


    public void connect(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar connect - Red electrica sin Graph");
    }


public boolean estanConectadas(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar estanConectadas - Red electrica sin Graph");
}


public boolean areaAislada(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar areaAislada - Red electrica sin Graph");
}


public String estacionMasCritica(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar estacionMasCritica - Red electrica sin Graph");
}


public Iterable<String> estacionesAlcanzables(String origen, int limite) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar estacionesAlcanzables - Red electrica sin Graph");
}

    }
