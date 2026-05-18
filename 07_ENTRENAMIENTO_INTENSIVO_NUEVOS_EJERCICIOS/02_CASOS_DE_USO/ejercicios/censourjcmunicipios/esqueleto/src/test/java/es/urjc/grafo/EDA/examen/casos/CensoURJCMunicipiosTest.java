package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CensoURJCMunicipiosTest {


@Test
void addHabitanteDebeImplementarse() {
    CensoURJCMunicipios servicio = new CensoURJCMunicipios();
    assertDoesNotThrow(() -> servicio.addHabitante("A"));
}



@Test
void removeHabitanteDebeImplementarse() {
    CensoURJCMunicipios servicio = new CensoURJCMunicipios();
    assertDoesNotThrow(() -> servicio.removeHabitante("A"));
}



@Test
void habitantesMunicipioDebeImplementarse() {
    CensoURJCMunicipios servicio = new CensoURJCMunicipios();
    assertNotNull(servicio.habitantesMunicipio("A"));
}



@Test
void habitantesEntreEdadesDebeImplementarse() {
    CensoURJCMunicipios servicio = new CensoURJCMunicipios();
    assertNotNull(servicio.habitantesEntreEdades(1, 5));
}



@Test
void municipioMasPobladoDebeImplementarse() {
    CensoURJCMunicipios servicio = new CensoURJCMunicipios();
    assertNotNull(servicio.municipioMasPoblado("A"));
}



@Test
void moverHabitanteDebeImplementarse() {
    CensoURJCMunicipios servicio = new CensoURJCMunicipios();
    assertDoesNotThrow(() -> servicio.moverHabitante("A"));
}

}
