package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDate;

public class BibliotecaExtra {

    // TODO: declara aqui los atributos privados que necesites.

    public BibliotecaExtra() {
        // TODO: inicializa tus estructuras.
    }

    public boolean addLibro(Libro libro) {
        // TODO: registrar libro sin ISBN duplicado.
        throw new UnsupportedOperationException("TODO: addLibro");
    }

    public boolean prestarLibro(String isbn, String usuario, LocalDate fechaDevolucion) {
        // TODO: prestar libro actualizando fecha y contador.
        throw new UnsupportedOperationException("TODO: prestarLibro");
    }

    public boolean reservarLibro(ReservaLibro reserva) {
        // TODO: registrar reserva pendiente.
        throw new UnsupportedOperationException("TODO: reservarLibro");
    }

    public Iterable<Libro> devolucionesHasta(LocalDate fecha) {
        // TODO: devolver libros con devolucion vencida.
        throw new UnsupportedOperationException("TODO: devolucionesHasta");
    }

    public Iterable<Libro> librosTopPrestados(int n) {
        // TODO: devolver libros mas prestados.
        throw new UnsupportedOperationException("TODO: librosTopPrestados");
    }
}
