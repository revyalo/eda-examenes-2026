package es.urjc.grafo.EDA.examen.casoslimpios;

    import java.time.LocalDate;
    import java.time.LocalDateTime;

    public class URJCNetServicesLimpio {

        // TODO: declara aqui los atributos privados que necesites.
        // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.
        // Estructuras recomendadas para este caso:
        // - HashMap<String, Router>
// - HashMap<String, HashSet<String>>
// - HashMap<String, Mensaje>
// - TreeMap<LocalDateTime, HashSet<String>>

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
                // TODO: guardar mensaje e indexarlo por fecha.
                throw new UnsupportedOperationException("TODO: recibirMensaje");
            }

            public Iterable<Router> routersAlcanzables(String origen, int ttl) {
                // TODO: BFS limitado; devolver routers a distancia <= ttl, incluyendo origen.
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
