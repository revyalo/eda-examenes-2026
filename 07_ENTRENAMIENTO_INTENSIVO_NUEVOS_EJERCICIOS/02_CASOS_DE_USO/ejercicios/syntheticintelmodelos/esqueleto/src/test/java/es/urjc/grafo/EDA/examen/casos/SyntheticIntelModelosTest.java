package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SyntheticIntelModelosTest {


@Test
void addModeloDebeImplementarse() {
    SyntheticIntelModelos servicio = new SyntheticIntelModelos();
    assertDoesNotThrow(() -> servicio.addModelo("A"));
}



@Test
void addDependenciaDebeImplementarse() {
    SyntheticIntelModelos servicio = new SyntheticIntelModelos();
    assertDoesNotThrow(() -> servicio.addDependencia("A", "B"));
}



@Test
void dependeDirectamenteDebeImplementarse() {
    SyntheticIntelModelos servicio = new SyntheticIntelModelos();
    assertTrue(servicio.dependeDirectamente("A"));
}



@Test
void dependeIndirectamenteDebeImplementarse() {
    SyntheticIntelModelos servicio = new SyntheticIntelModelos();
    assertTrue(servicio.dependeIndirectamente("A"));
}



@Test
void topModelosDebeImplementarse() {
    SyntheticIntelModelos servicio = new SyntheticIntelModelos();
    assertNotNull(servicio.topModelos(1));
}



@Test
void modelosEntrePrecisionDebeImplementarse() {
    SyntheticIntelModelos servicio = new SyntheticIntelModelos();
    assertNotNull(servicio.modelosEntrePrecision("A", 1.0));
}

}
