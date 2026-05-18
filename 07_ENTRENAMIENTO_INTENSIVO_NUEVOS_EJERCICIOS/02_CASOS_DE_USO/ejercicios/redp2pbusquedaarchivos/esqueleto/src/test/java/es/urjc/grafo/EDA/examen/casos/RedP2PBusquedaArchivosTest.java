package es.urjc.grafo.EDA.examen.casos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedP2PBusquedaArchivosTest {


@Test
void addNodeDebeImplementarse() {
    RedP2PBusquedaArchivos servicio = new RedP2PBusquedaArchivos();
    assertDoesNotThrow(() -> servicio.addNode("A"));
}



@Test
void addConnectionDebeImplementarse() {
    RedP2PBusquedaArchivos servicio = new RedP2PBusquedaArchivos();
    assertDoesNotThrow(() -> servicio.addConnection("A", "B"));
}



@Test
void addFileDebeImplementarse() {
    RedP2PBusquedaArchivos servicio = new RedP2PBusquedaArchivos();
    assertDoesNotThrow(() -> servicio.addFile("A"));
}



@Test
void buscarArchivoDebeImplementarse() {
    RedP2PBusquedaArchivos servicio = new RedP2PBusquedaArchivos();
    assertNotNull(servicio.buscarArchivo("A", 1));
}



@Test
void nodosConArchivoDebeImplementarse() {
    RedP2PBusquedaArchivos servicio = new RedP2PBusquedaArchivos();
    assertNotNull(servicio.nodosConArchivo("A"));
}



@Test
void nodoMasCompartidorDebeImplementarse() {
    RedP2PBusquedaArchivos servicio = new RedP2PBusquedaArchivos();
    assertNotNull(servicio.nodoMasCompartidor("A"));
}

}
