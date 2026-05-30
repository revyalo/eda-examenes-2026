package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDateTime;

public class VuelosExtra {

    // TODO: declara aqui los atributos privados que necesites.

    public VuelosExtra() {
        // TODO: inicializa tus estructuras.
    }

    public boolean addAirport(AeropuertoExtra aeropuerto) {
        // TODO: registrar aeropuerto.
        throw new UnsupportedOperationException("TODO: addAirport");
    }

    public boolean addFlight(VueloExtra vuelo) {
        // TODO: registrar vuelo dirigido.
        throw new UnsupportedOperationException("TODO: addFlight");
    }

    public boolean conexionConMaxEscalas(String origen, String destino, int maxEscalas) {
        // TODO: comprobar conexion dirigida con maxEscalas.
        throw new UnsupportedOperationException("TODO: conexionConMaxEscalas");
    }

    public Iterable<VueloExtra> vuelosEntre(LocalDateTime inicio, LocalDateTime fin) {
        // TODO: devolver vuelos en el rango.
        throw new UnsupportedOperationException("TODO: vuelosEntre");
    }

    public AeropuertoExtra aeropuertoConMasSalidas() {
        // TODO: devolver aeropuerto con mayor grado de salida.
        throw new UnsupportedOperationException("TODO: aeropuertoConMasSalidas");
    }
}
