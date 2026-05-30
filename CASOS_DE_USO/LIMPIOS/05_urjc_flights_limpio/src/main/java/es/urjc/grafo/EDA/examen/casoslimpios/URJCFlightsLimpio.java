package es.urjc.grafo.EDA.examen.casoslimpios;

import java.time.LocalDateTime;

public class URJCFlightsLimpio {

    // TODO: declara aqui los atributos privados que necesites.
    // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.

    public URJCFlightsLimpio() {
        // TODO: inicializa aqui tus estructuras cuando las declares.
    }

    public boolean addAirport(Aeropuerto aeropuerto) {
        // TODO: registrar aeropuerto.
        throw new UnsupportedOperationException("TODO: addAirport");
    }

    public boolean addFlight(Vuelo vuelo) {
        // TODO: registrar vuelo dirigido.
        throw new UnsupportedOperationException("TODO: addFlight");
    }

    public boolean vueloDirecto(String origen, String destino) {
        // TODO: comprobar si hay vuelo directo.
        throw new UnsupportedOperationException("TODO: vueloDirecto");
    }

    public boolean conexionConMaxEscalas(String origen, String destino, int maxEscalas) {
        // TODO: comprobar conexion dirigida; maxEscalas=0 implica vuelo directo.
        throw new UnsupportedOperationException("TODO: conexionConMaxEscalas");
    }

    public Iterable<Vuelo> vuelosEntre(LocalDateTime inicio, LocalDateTime fin) {
        // TODO: devolver vuelos en rango temporal.
        throw new UnsupportedOperationException("TODO: vuelosEntre");
    }
}
