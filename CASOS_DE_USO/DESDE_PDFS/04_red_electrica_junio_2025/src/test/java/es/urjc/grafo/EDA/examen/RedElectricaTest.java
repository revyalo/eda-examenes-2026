package es.urjc.grafo.EDA.examen;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RedElectricaTest {

    @Test
    void areaGestionaCentralesOrdenadasPorPotencia() {
        Area area = new Area("Norte");
        CentralElectrica c100 = new CentralElectrica("C100", 100);
        CentralElectrica c200 = new CentralElectrica("C200", 200);

        assertTrue(area.anadirCentral(c200));
        assertTrue(area.anadirCentral(c100));
        assertFalse(area.anadirCentral(new CentralElectrica("C100-bis", 100)));
        assertEquals(300, area.potenciaMaxima());
        assertEquals(0, area.generacion());
        assertTrue(area.encender(c100));
        assertEquals(100, area.generacion());
        assertIterableEquals(java.util.List.of(c100), area.encendidas());
        assertIterableEquals(java.util.List.of(c200), area.apagadas());
    }

    @Test
    void redDetectaAreasActivasYColapsoEnUnSalto() {
        Area norte = new Area("Norte");
        Area sur = new Area("Sur");
        Area centro = new Area("Centro");
        norte.anadirCentral(new CentralElectrica("N1", 50));
        sur.anadirCentral(new CentralElectrica("S1", 60));
        centro.anadirCentral(new CentralElectrica("C1", 70));
        norte.maxEnergy();
        sur.maxEnergy();

        RedElectrica red = new RedElectrica();
        red.anadirArea(norte);
        red.anadirArea(sur);
        red.anadirArea(centro);
        assertTrue(red.conectarAreas(norte, centro));
        assertTrue(red.conectarAreas(sur, centro));

        assertEquals(110, red.energiaGeneradaActualmente());
        assertEquals(Set.of(norte, sur), Set.copyOf(red.areasActivas()));
        assertTrue(red.colapsoDescontrolado(java.util.List.of(centro)));
    }
}
