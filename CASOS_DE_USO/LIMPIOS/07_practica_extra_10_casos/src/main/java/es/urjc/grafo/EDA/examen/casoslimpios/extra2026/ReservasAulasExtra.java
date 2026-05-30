package es.urjc.grafo.EDA.examen.casoslimpios.extra2026;

import java.time.LocalDateTime;

public class ReservasAulasExtra {

    // TODO: declara aqui los atributos privados que necesites.

    public ReservasAulasExtra() {
        // TODO: inicializa tus estructuras.
    }

    public boolean registrarAula(Aula aula) {
        // TODO: registrar aula sin codigo duplicado.
        throw new UnsupportedOperationException("TODO: registrarAula");
    }

    public boolean solicitarReserva(SolicitudReserva solicitud) {
        // TODO: anadir solicitud pendiente.
        throw new UnsupportedOperationException("TODO: solicitarReserva");
    }

    public Reserva procesarSiguienteSolicitud() {
        // TODO: asignar aula valida a la solicitud mas prioritaria.
        throw new UnsupportedOperationException("TODO: procesarSiguienteSolicitud");
    }

    public boolean cancelarReserva(String codigoReserva) {
        // TODO: cancelar reserva y liberar aula.
        throw new UnsupportedOperationException("TODO: cancelarReserva");
    }

    public Iterable<Reserva> reservasEntre(LocalDateTime inicio, LocalDateTime fin) {
        // TODO: devolver reservas en el rango temporal.
        throw new UnsupportedOperationException("TODO: reservasEntre");
    }
}
