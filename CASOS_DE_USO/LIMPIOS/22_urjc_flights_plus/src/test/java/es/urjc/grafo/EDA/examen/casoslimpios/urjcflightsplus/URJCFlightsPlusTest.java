package es.urjc.grafo.EDA.examen.casoslimpios.urjcflightsplus;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class URJCFlightsPlusTest {

    private static List<Flight> list(Iterable<Flight> flights) {
        List<Flight> result = new ArrayList<>();
        for (Flight flight : flights) {
            result.add(flight);
        }
        return result;
    }

    @Test
    void flightsUpdateTemporalAndCodeIndexes() {
        URJCFlightsPlus flights = new URJCFlightsPlus();
        flights.addAirport("MAD");
        flights.addAirport("BCN");
        LocalDateTime t1 = LocalDateTime.of(2026, 1, 1, 8, 0);
        LocalDateTime t2 = LocalDateTime.of(2026, 1, 2, 8, 0);
        Flight old = new Flight("IB1", "MAD", "BCN", t1, 100, 60);
        Flight newer = new Flight("IB2", "MAD", "BCN", t2, 80, 70);

        assertTrue(flights.addFlight(old));
        assertTrue(flights.addFlight(newer));
        assertEquals(List.of(old, newer), list(flights.flightsBetween(t1, t2)));
        assertEquals(1, flights.removeFlightsBefore(t2));
        assertFalse(flights.removeFlight("IB1"));
    }

    @Test
    void directedReachabilityAndCheapestFlightUseStopsDatesAndPrices() {
        URJCFlightsPlus flights = new URJCFlightsPlus();
        flights.addAirport("MAD");
        flights.addAirport("BCN");
        flights.addAirport("PAR");
        LocalDateTime base = LocalDateTime.of(2026, 1, 1, 8, 0);
        Flight expensive = new Flight("F1", "MAD", "BCN", base, 200, 60);
        Flight cheap = new Flight("F2", "MAD", "BCN", base.plusHours(1), 90, 60);
        Flight connection = new Flight("F3", "BCN", "PAR", base.plusHours(2), 70, 90);
        flights.addFlight(expensive);
        flights.addFlight(cheap);
        flights.addFlight(connection);

        assertEquals(Set.of("MAD", "BCN", "PAR"), Set.copyOf(flights.reachableAirports("MAD", 1)));
        assertTrue(flights.existsRouteAfter("MAD", "PAR", base, 1));
        assertEquals(cheap, flights.cheapestDirectFlight("MAD", "BCN", base, base.plusDays(1)));
    }
}
