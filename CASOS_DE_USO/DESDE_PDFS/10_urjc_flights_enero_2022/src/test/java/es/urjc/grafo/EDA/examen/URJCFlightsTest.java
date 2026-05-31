package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class URJCFlightsTest {

    @Test
    void aeropuertosConexionesVuelosEItinerarios() {
        URJCFlights flights = new URJCFlights();
        Airport madrid = new Airport("Madrid");
        Airport paris = new Airport("Paris");
        Airport berlin = new Airport("Berlin");

        assertTrue(flights.newAirport(madrid));
        assertTrue(flights.newAirport(paris));
        assertTrue(flights.newAirport(berlin));
        assertFalse(flights.newAirport(new Airport("Madrid")));

        flights.newConnection(madrid, java.util.List.of(new URJCFlights.Connection(paris, 1103)));
        flights.newConnection(paris, java.util.List.of(new URJCFlights.Connection(berlin, 878)));
        assertEquals(java.util.Set.of(paris), java.util.Set.copyOf(flights.availableAirportsConnection(madrid)));

        Flight direct = new Flight(madrid, paris, LocalDateTime.of(2026, 1, 1, 10, 0));
        Flight second = new Flight(paris, berlin, LocalDateTime.of(2026, 1, 1, 14, 0));
        assertTrue(flights.newFlight(madrid, direct));
        assertTrue(flights.newFlight(paris, second));
        assertIterableEquals(java.util.List.of(direct), flights.availableFlights(madrid));
        assertIterableEquals(java.util.List.of(direct, second), flights.searchItinerary(madrid, berlin));
        assertNull(flights.searchItinerary(berlin, madrid));
    }

    @Test
    void conexionConAeropuertoNoRegistradoLanzaExcepcion() {
        URJCFlights flights = new URJCFlights();
        Airport madrid = new Airport("Madrid");
        Airport paris = new Airport("Paris");
        assertTrue(flights.newAirport(madrid));

        assertThrows(IllegalArgumentException.class,
                () -> flights.newConnection(madrid, java.util.List.of(new URJCFlights.Connection(paris, 1103))));
    }
}
