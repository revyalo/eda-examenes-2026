package es.urjc.grafo.EDA.examen.casoslimpios;

import java.time.LocalDateTime;

public class URJCNetServicesLimpio {

    // TODO: declara aqui los atributos privados que necesites.
    // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.

    public URJCNetServicesLimpio() {
        // TODO: inicializa aqui tus estructuras cuando las declares.
    }

    public boolean addRouter(Router router) {
        // TODO: anadir router si no existe y rechazar null/duplicados.
        throw new UnsupportedOperationException("TODO: addRouter");
    }

    public boolean addConnection(String router1, String router2) {
        // TODO: conectar dos routers existentes sin duplicar aristas.
        throw new UnsupportedOperationException("TODO: addConnection");
    }

    public boolean recibirMensaje(Mensaje mensaje) {
        // TODO: guardar mensaje y permitir despues consultarlo por fecha.
        throw new UnsupportedOperationException("TODO: recibirMensaje");
    }

    public Iterable<Router> routersAlcanzables(String origen, int ttl) {
        // TODO: devolver routers a distancia <= ttl, incluyendo origen.
        throw new UnsupportedOperationException("TODO: routersAlcanzables");
    }

    public Iterable<Mensaje> mensajesHasta(LocalDateTime fecha) {
        // TODO: devolver mensajes con fecha <= fecha.
        throw new UnsupportedOperationException("TODO: mensajesHasta");
    }

    public Router routerCentral() {
        // TODO: devolver el router con menor distancia maxima al resto; null si no conexo.
        throw new UnsupportedOperationException("TODO: routerCentral");
    }
}
