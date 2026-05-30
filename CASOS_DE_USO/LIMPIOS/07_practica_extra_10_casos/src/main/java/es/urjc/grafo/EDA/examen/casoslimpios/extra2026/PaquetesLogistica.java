package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDate;

public class PaquetesLogistica {

    // TODO: declara aqui los atributos privados que necesites.

    public PaquetesLogistica() {
        // TODO: inicializa tus estructuras.
    }

    public boolean registrarPaquete(Paquete paquete) {
        // TODO: registrar paquete sin localizador duplicado.
        throw new UnsupportedOperationException("TODO: registrarPaquete");
    }

    public Paquete siguienteEntrega() {
        // TODO: devolver y eliminar el paquete mas prioritario.
        throw new UnsupportedOperationException("TODO: siguienteEntrega");
    }

    public Iterable<Paquete> paquetesVencidosHasta(LocalDate fecha) {
        // TODO: devolver paquetes con fecha limite <= fecha.
        throw new UnsupportedOperationException("TODO: paquetesVencidosHasta");
    }

    public boolean reprogramar(String localizador, LocalDate nuevaFecha) {
        // TODO: cambiar fecha limite manteniendo tus atributos coherentes.
        throw new UnsupportedOperationException("TODO: reprogramar");
    }

    public int eliminarDestino(String destino) {
        // TODO: eliminar todos los paquetes de un destino.
        throw new UnsupportedOperationException("TODO: eliminarDestino");
    }
}
