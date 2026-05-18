package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class URJCFlightsSinGraphTest {


@Test
void addAirportDebeImplementarse() {
    URJCFlightsSinGraph servicio = new URJCFlightsSinGraph();
    assertDoesNotThrow(() -> servicio.addAirport("A"));
}



@Test
void addFlightDebeImplementarse() {
    URJCFlightsSinGraph servicio = new URJCFlightsSinGraph();
    assertDoesNotThrow(() -> servicio.addFlight("A"));
}



@Test
void hayVueloDirectoDebeImplementarse() {
    URJCFlightsSinGraph servicio = new URJCFlightsSinGraph();
    assertTrue(servicio.hayVueloDirecto("A"));
}



@Test
void hayConexionConEscalasDebeImplementarse() {
    URJCFlightsSinGraph servicio = new URJCFlightsSinGraph();
    assertTrue(servicio.hayConexionConEscalas("A", 1));
}



@Test
void vuelosEntreFechasDebeImplementarse() {
    URJCFlightsSinGraph servicio = new URJCFlightsSinGraph();
    assertNotNull(servicio.vuelosEntreFechas(java.time.LocalDateTime.now()));
}



@Test
void aeropuertoConMasSalidasDebeImplementarse() {
    URJCFlightsSinGraph servicio = new URJCFlightsSinGraph();
    assertNotNull(servicio.aeropuertoConMasSalidas("A"));
}

}
