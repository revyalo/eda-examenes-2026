package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LigaDeportivaRankingTest {


@Test
void addEquipoDebeImplementarse() {
    LigaDeportivaRanking servicio = new LigaDeportivaRanking();
    assertDoesNotThrow(() -> servicio.addEquipo("A"));
}



@Test
void registrarResultadoDebeImplementarse() {
    LigaDeportivaRanking servicio = new LigaDeportivaRanking();
    assertDoesNotThrow(() -> servicio.registrarResultado("A", "B", 1, 0));
}



@Test
void topEquiposDebeImplementarse() {
    LigaDeportivaRanking servicio = new LigaDeportivaRanking();
    assertNotNull(servicio.topEquipos(1));
}



@Test
void equiposConPuntosEntreDebeImplementarse() {
    LigaDeportivaRanking servicio = new LigaDeportivaRanking();
    assertNotNull(servicio.equiposConPuntosEntre(1, 5));
}



@Test
void programarPartidoDebeImplementarse() {
    LigaDeportivaRanking servicio = new LigaDeportivaRanking();
    assertDoesNotThrow(() -> servicio.programarPartido("A"));
}



@Test
void siguientePartidoDebeImplementarse() {
    LigaDeportivaRanking servicio = new LigaDeportivaRanking();
    assertNotNull(servicio.siguientePartido("A"));
}

}
