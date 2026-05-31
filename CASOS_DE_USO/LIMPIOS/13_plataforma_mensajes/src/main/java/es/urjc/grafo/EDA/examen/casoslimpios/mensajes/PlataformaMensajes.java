package es.urjc.grafo.EDA.examen.casoslimpios.mensajes;

import java.time.LocalDateTime;

public class PlataformaMensajes {

    // TODO: declara aqui los atributos privados que necesites.

    public PlataformaMensajes() {
        // TODO: inicializa tus estructuras.
    }

    public boolean addUsuario(UsuarioPlataforma usuario) {
        // TODO: registrar usuario sin duplicados.
        throw new UnsupportedOperationException("TODO: addUsuario");
    }

    public boolean seguir(String origen, String destino) {
        // TODO: crear relacion dirigida origen -> destino.
        throw new UnsupportedOperationException("TODO: seguir");
    }

    public boolean enviarMensaje(MensajePlataforma mensaje) {
        // TODO: registrar mensaje si su emisor existe y no esta duplicado.
        throw new UnsupportedOperationException("TODO: enviarMensaje");
    }

    public Iterable<UsuarioPlataforma> usuariosAlcanzables(String origen, int saltos) {
        // TODO: devolver usuarios alcanzables siguiendo relaciones hasta saltos.
        throw new UnsupportedOperationException("TODO: usuariosAlcanzables");
    }

    public int borrarMensajesHasta(LocalDateTime fecha) {
        // TODO: borrar mensajes con fecha <= fecha.
        throw new UnsupportedOperationException("TODO: borrarMensajesHasta");
    }

    public UsuarioPlataforma usuarioCentral() {
        // TODO: devolver usuario que minimiza distancia maxima; null si no procede.
        throw new UnsupportedOperationException("TODO: usuarioCentral");
    }
}
