package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class URJCFlightsSinGraph {

            private final HashMap<String, Aeropuerto> aeropuertos = new HashMap<>();
private final HashMap<String, HashSet<String>> vuelosSalientes = new HashMap<>();
private final HashMap<String, HashSet<String>> vuelosEntrantes = new HashMap<>();
private final TreeMap<LocalDateTime, HashSet<String>> vuelosPorHora = new TreeMap<>();
private final HashMap<String, Vuelo> vuelosPorCodigo = new HashMap<>();


    public record Aeropuerto(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Aeropuerto> {
        @Override
        public int compareTo(Aeropuerto other) {
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



    public record Vuelo(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Vuelo> {
        @Override
        public int compareTo(Vuelo other) {
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



    public void addAirport(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addAirport - URJCFlights sin Graph");
    }


    public void addFlight(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addFlight - URJCFlights sin Graph");
    }


public boolean hayVueloDirecto(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar hayVueloDirecto - URJCFlights sin Graph");
}


public boolean hayConexionConEscalas(String origen, int limite) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar hayConexionConEscalas - URJCFlights sin Graph");
}


public Iterable<String> vuelosEntreFechas(LocalDateTime fecha) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar vuelosEntreFechas - URJCFlights sin Graph");
}


public String aeropuertoConMasSalidas(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar aeropuertoConMasSalidas - URJCFlights sin Graph");
}

        }
