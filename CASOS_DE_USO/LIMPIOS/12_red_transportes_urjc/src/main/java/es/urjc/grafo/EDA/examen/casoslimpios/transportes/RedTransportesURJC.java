package es.urjc.grafo.EDA.examen.casoslimpios.transportes;

public class RedTransportesURJC {

    // TODO: declara aqui los atributos privados que necesites.

    public RedTransportesURJC() {
        // TODO: inicializa tus estructuras.
    }

    public boolean addParada(Parada parada) {
        // TODO: registrar parada sin duplicados.
        throw new UnsupportedOperationException("TODO: addParada");
    }

    public boolean conectar(ConexionTransporte conexion) {
        // TODO: conectar dos paradas existentes.
        throw new UnsupportedOperationException("TODO: conectar");
    }

    public boolean existeTrayecto(String origen, String destino, int maxSaltos) {
        // TODO: comprobar si hay camino con longitud <= maxSaltos.
        throw new UnsupportedOperationException("TODO: existeTrayecto");
    }

    public Iterable<Parada> paradasAlcanzables(String origen, int maxSaltos) {
        // TODO: devolver paradas alcanzables hasta maxSaltos.
        throw new UnsupportedOperationException("TODO: paradasAlcanzables");
    }

    public Parada paradaMasConectada() {
        // TODO: devolver parada con mas vecinos.
        throw new UnsupportedOperationException("TODO: paradaMasConectada");
    }
}
