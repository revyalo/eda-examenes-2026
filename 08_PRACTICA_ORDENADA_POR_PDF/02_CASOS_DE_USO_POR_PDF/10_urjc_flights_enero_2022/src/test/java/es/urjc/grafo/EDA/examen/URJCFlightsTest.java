package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class URJCFlightsTest {

        @Test
        void vuelosBasicos() {
            URJCFlights flights = new URJCFlights();
            assertTrue(flights.addAirport(new Airport("MAD", "Madrid")));
            assertTrue(flights.addAirport(new Airport("BCN", "Barcelona")));
            assertTrue(flights.addFlight(new Flight("F1", "MAD", "BCN", LocalDateTime.now())));
            assertTrue(flights.directFlight("MAD", "BCN"));
            assertTrue(flights.connectionWithMaxStops("MAD", "BCN", 0));
            assertNotNull(flights.flightsUntil(LocalDateTime.now().plusDays(1)));
        }

}
