package es.urjc.grafo.EDA.examen.casoslimpios;

    import java.time.LocalDate;
    import java.time.LocalDateTime;

    public class RedP2PLimpia {

        // TODO: declara aqui los atributos privados que necesites.
        // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.
        // Estructuras recomendadas para este caso:
        // - HashMap<String, Nodo>
// - HashMap<String, HashSet<String>>
// - HashMap<String, HashSet<String>> para archivos

        public RedP2PLimpia() {
            // TODO: inicializa aqui tus estructuras cuando las declares.
        }


            public boolean addNode(Nodo nodo) {
                // TODO: insertar nodo y preparar sus indices.
                throw new UnsupportedOperationException("TODO: addNode");
            }

            public boolean connect(String a, String b) {
                // TODO: conectar nodos existentes.
                throw new UnsupportedOperationException("TODO: connect");
            }

            public boolean addFile(String nodo, String archivo) {
                // TODO: registrar archivo en nodo e indice inverso.
                throw new UnsupportedOperationException("TODO: addFile");
            }

            public Iterable<Nodo> buscarArchivo(String origen, String archivo, int ttl) {
                // TODO: BFS hasta ttl y devolver nodos alcanzables que tienen el archivo.
                throw new UnsupportedOperationException("TODO: buscarArchivo");
            }

            public boolean shutdownNode(String nodo) {
                // TODO: eliminar nodo de todos los indices y conexiones.
                throw new UnsupportedOperationException("TODO: shutdownNode");
            }

    }
