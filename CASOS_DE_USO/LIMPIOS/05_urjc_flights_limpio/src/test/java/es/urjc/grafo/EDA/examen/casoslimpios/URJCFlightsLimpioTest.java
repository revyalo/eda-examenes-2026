package es.urjc.grafo.EDA.examen.casoslimpios;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class URJCFlightsLimpioTest {

    private static <E> List<E> toList(Iterable<E> values) {
        List<E> result = new ArrayList<>();
        for (E value : values) {
            result.add(value);
        }
        return result;
    }

    private static <E> Set<E> toSet(Iterable<E> values) {
        return new HashSet<>(toList(values));
    }


        @Test
        void escalasYFechas() {
            URJCFlightsLimpio flights = new URJCFlightsLimpio();
            flights.addAirport(new Aeropuerto("MAD", "Madrid"));
            flights.addAirport(new Aeropuerto("BCN", "Barcelona"));
            flights.addAirport(new Aeropuerto("PAR", "Paris"));
            LocalDateTime ahora = LocalDateTime.of(2026, 1, 1, 10, 0);
            flights.addFlight(new Vuelo("F1", "MAD", "BCN", ahora));
            flights.addFlight(new Vuelo("F2", "BCN", "PAR", ahora.plusHours(2)));
            assertTrue(flights.vueloDirecto("MAD", "BCN"));
            assertFalse(flights.vueloDirecto("MAD", "PAR"));
            assertTrue(flights.conexionConMaxEscalas("MAD", "PAR", 1));
            assertEquals(2, toList(flights.vuelosEntre(ahora.minusMinutes(1), ahora.plusHours(3))).size());
        }

}
