package es.urjc.grafo.EDA.examen;

import java.time.LocalDateTime;

    public class URJCFlights {

        // TODO: define aqui los atributos privados necesarios.


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
