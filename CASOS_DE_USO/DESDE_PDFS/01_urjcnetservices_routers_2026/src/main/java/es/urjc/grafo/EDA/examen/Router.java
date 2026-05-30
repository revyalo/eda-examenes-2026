package es.urjc.grafo.EDA.examen;

import java.net.InetAddress;
import java.util.Date;

public class Router {


    public Router(InetAddress ip) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Recibe un mensaje que debe difundirse a toda la red.
     * Si el mensaje no se había recibido anteriormente, el método devolverá true.
     * En caso contrario, devolverá false.
     * Si el mensaje es null, se debe lanzar la excepción IllegalArgumentException.
     *
     * @param message mensaje que debe difundirse
     * @return true si el mensaje debe difundirse, false si ya se había difundido previamente
     */
    public boolean mensajeDeDifusion(Message message) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Borra todos los mensajes cuya fecha sea igual o anterior a la fecha dada.
     *
     * @param fecha fecha de corte
     * @return número de mensajes borrados
     */
    public int borrarMensajesAntiguos(Date fecha) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
