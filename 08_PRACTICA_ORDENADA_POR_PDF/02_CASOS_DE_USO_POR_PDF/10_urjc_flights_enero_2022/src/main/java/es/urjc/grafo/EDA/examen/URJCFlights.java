package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class URJCFlights {

        private final HashMap<String, Airport> airports = new HashMap<>();
private final HashMap<String, Flight> flights = new HashMap<>();
private final HashMap<String, HashSet<String>> outgoing = new HashMap<>();
private final HashMap<String, HashSet<String>> incoming = new HashMap<>();
private final TreeMap<LocalDateTime, HashSet<String>> flightsByTime = new TreeMap<>();


        public boolean addAirport(Airport airport) {
            // TODO: registrar aeropuerto.
            throw new UnsupportedOperationException("TODO: addAirport");
        }

        public boolean addFlight(Flight flight) {
            // TODO: registrar vuelo dirigido.
            throw new UnsupportedOperationException("TODO: addFlight");
        }

        public boolean directFlight(String origin, String destination) {
            // TODO: comprobar arista directa.
            throw new UnsupportedOperationException("TODO: directFlight");
        }

        public boolean connectionWithMaxStops(String origin, String destination, int stops) {
            // TODO: BFS limitado por escalas.
            throw new UnsupportedOperationException("TODO: connectionWithMaxStops");
        }

        public Iterable<Flight> flightsUntil(LocalDateTime time) {
            // TODO: consulta temporal.
            throw new UnsupportedOperationException("TODO: flightsUntil");
        }

    }
