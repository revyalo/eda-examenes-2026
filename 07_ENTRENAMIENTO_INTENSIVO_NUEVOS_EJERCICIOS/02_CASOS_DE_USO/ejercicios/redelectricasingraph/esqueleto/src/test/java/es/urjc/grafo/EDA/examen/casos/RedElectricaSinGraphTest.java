package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedElectricaSinGraphTest {


@Test
void addEstacionDebeImplementarse() {
    RedElectricaSinGraph servicio = new RedElectricaSinGraph();
    assertDoesNotThrow(() -> servicio.addEstacion("A"));
}



@Test
void connectDebeImplementarse() {
    RedElectricaSinGraph servicio = new RedElectricaSinGraph();
    assertDoesNotThrow(() -> servicio.connect("A", "B"));
}



@Test
void estanConectadasDebeImplementarse() {
    RedElectricaSinGraph servicio = new RedElectricaSinGraph();
    assertTrue(servicio.estanConectadas("A"));
}



@Test
void areaAisladaDebeImplementarse() {
    RedElectricaSinGraph servicio = new RedElectricaSinGraph();
    assertTrue(servicio.areaAislada("A"));
}



@Test
void estacionMasCriticaDebeImplementarse() {
    RedElectricaSinGraph servicio = new RedElectricaSinGraph();
    assertNotNull(servicio.estacionMasCritica("A"));
}



@Test
void estacionesAlcanzablesDebeImplementarse() {
    RedElectricaSinGraph servicio = new RedElectricaSinGraph();
    assertNotNull(servicio.estacionesAlcanzables("A", 1));
}

}
