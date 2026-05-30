package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDateTime;

public class SubastasExtra {

    // TODO: declara aqui los atributos privados que necesites.

    public SubastasExtra() {
        // TODO: inicializa tus estructuras.
    }

    public boolean crearSubasta(Producto producto) {
        // TODO: crear subasta sin id duplicado.
        throw new UnsupportedOperationException("TODO: crearSubasta");
    }

    public boolean pujar(Puja puja) {
        // TODO: aceptar solo pujas validas y superiores.
        throw new UnsupportedOperationException("TODO: pujar");
    }

    public Puja ganador(String producto) {
        // TODO: devolver la mejor puja de un producto.
        throw new UnsupportedOperationException("TODO: ganador");
    }

    public Iterable<Producto> cerrarSubastasHasta(LocalDateTime fecha) {
        // TODO: cerrar y devolver subastas con cierre <= fecha.
        throw new UnsupportedOperationException("TODO: cerrarSubastasHasta");
    }

    public Iterable<Producto> productosMasCaros(int n) {
        // TODO: devolver productos por precio actual descendente.
        throw new UnsupportedOperationException("TODO: productosMasCaros");
    }
}
