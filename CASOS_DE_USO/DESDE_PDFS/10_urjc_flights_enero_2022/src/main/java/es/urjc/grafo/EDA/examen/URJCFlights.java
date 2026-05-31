package es.urjc.grafo.EDA.examen;

import java.util.Collection;
import java.util.List;

public class URJCFlights {

    // TODO: define aqui los atributos privados necesarios.

    public boolean newAirport(Airport airport) {
        // TODO: insertar aeropuerto desde el que la compania puede operar.
        throw new UnsupportedOperationException("TODO: newAirport");
    }

    public void newConnection(Airport origin, List<Connection> connections) {
        // TODO: anadir conexiones disponibles con distancia; lanzar excepcion si un aeropuerto no existe.
        throw new UnsupportedOperationException("TODO: newConnection");
    }

    public boolean newFlight(Airport origin, Flight flight) {
        // TODO: anadir vuelo si existe conexion con el destino.
        throw new UnsupportedOperationException("TODO: newFlight");
    }

    public Collection<Airport> availableAirportsConnection(Airport airport) {
        // TODO: devolver aeropuertos con los que puede operar airport.
        throw new UnsupportedOperationException("TODO: availableAirportsConnection");
    }

    public Collection<Flight> availableFlights(Airport airport) {
        // TODO: devolver vuelos cuyo origen sea airport.
        throw new UnsupportedOperationException("TODO: availableFlights");
    }

    public Collection<Flight> searchItinerary(Airport origin, Airport destination) {
        // TODO: devolver vuelos necesarios para ir de origin a destination, priorizando directos, o null.
        throw new UnsupportedOperationException("TODO: searchItinerary");
    }

    public record Connection(Airport airport, int distance) {
    }
}
