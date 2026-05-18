package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraductorWebPrioridadesTest {


@Test
void addTraduccionDebeImplementarse() {
    TraductorWebPrioridades servicio = new TraductorWebPrioridades();
    assertDoesNotThrow(() -> servicio.addTraduccion("es", "hola", "hello"));
}



@Test
void traducirDebeImplementarse() {
    TraductorWebPrioridades servicio = new TraductorWebPrioridades();
    assertNotNull(servicio.traducir("A"));
}



@Test
void palabrasDeIdiomaDebeImplementarse() {
    TraductorWebPrioridades servicio = new TraductorWebPrioridades();
    assertNotNull(servicio.palabrasDeIdioma("A"));
}



@Test
void solicitarTraduccionDebeImplementarse() {
    TraductorWebPrioridades servicio = new TraductorWebPrioridades();
    assertDoesNotThrow(() -> servicio.solicitarTraduccion("A"));
}



@Test
void procesarSiguienteSolicitudDebeImplementarse() {
    TraductorWebPrioridades servicio = new TraductorWebPrioridades();
    assertNotNull(servicio.procesarSiguienteSolicitud("A"));
}



@Test
void palabrasEntreDebeImplementarse() {
    TraductorWebPrioridades servicio = new TraductorWebPrioridades();
    assertNotNull(servicio.palabrasEntre("a", "z"));
}

}
