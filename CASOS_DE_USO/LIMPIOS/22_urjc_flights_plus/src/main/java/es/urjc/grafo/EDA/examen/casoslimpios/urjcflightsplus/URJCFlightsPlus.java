package es.urjc.grafo.EDA.examen.casoslimpios.urjcflightsplus;

import java.time.LocalDateTime;
import java.util.Collection;

public class URJCFlightsPlus {

    // TODO: declara estructuras por codigo de vuelo, aeropuertos, salidas dirigidas e indice temporal.

    public boolean addAirport(String airportCode) {
        throw new UnsupportedOperationException("TODO: addAirport");
    }

    public boolean addFlight(Flight flight) {
        throw new UnsupportedOperationException("TODO: addFlight");
    }

    public boolean removeFlight(String flightCode) {
        throw new UnsupportedOperationException("TODO: removeFlight");
    }

    public int removeFlightsBefore(LocalDateTime date) {
        throw new UnsupportedOperationException("TODO: removeFlightsBefore");
    }

    public Iterable<Flight> flightsBetween(LocalDateTime from, LocalDateTime to) {
        throw new UnsupportedOperationException("TODO: flightsBetween");
    }

    public Collection<String> reachableAirports(String origin, int maxStops) {
        throw new UnsupportedOperationException("TODO: reachableAirports");
    }

    public boolean existsRouteAfter(String origin, String destination, LocalDateTime date, int maxStops) {
        throw new UnsupportedOperationException("TODO: existsRouteAfter");
    }

    public Flight cheapestDirectFlight(String origin, String destination, LocalDateTime from, LocalDateTime to) {
        throw new UnsupportedOperationException("TODO: cheapestDirectFlight");
    }
}
