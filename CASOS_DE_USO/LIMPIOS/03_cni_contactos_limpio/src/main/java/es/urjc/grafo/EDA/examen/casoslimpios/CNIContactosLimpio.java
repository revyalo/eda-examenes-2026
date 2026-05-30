package es.urjc.grafo.EDA.examen.casoslimpios;

    import java.time.LocalDate;
    import java.time.LocalDateTime;

    public class CNIContactosLimpio {

        // TODO: declara aqui los atributos privados que necesites.
        // No hay estructuras creadas a proposito: debes elegirlas e inicializarlas tu.
        // Estructuras recomendadas para este caso:
        // - HashMap<Integer, Agente>
// - HashMap<Integer, HashSet<Integer>>
// - TreeMap<LocalDate, HashSet<Contacto>>

        public CNIContactosLimpio() {
            // TODO: inicializa aqui tus estructuras cuando las declares.
        }


            public boolean addAgente(Agente agente) {
                // TODO: registrar agente sin duplicados.
                throw new UnsupportedOperationException("TODO: addAgente");
            }

            public boolean registrarContacto(Contacto contacto) {
                // TODO: guardar contacto e indexar por fecha.
                throw new UnsupportedOperationException("TODO: registrarContacto");
            }

            public boolean contactoDirecto(int a, int b) {
                // TODO: comprobar contacto directo.
                throw new UnsupportedOperationException("TODO: contactoDirecto");
            }

            public Iterable<Agente> grupoDeRiesgo(int origen, LocalDate desde, int minutosMinimos) {
                // TODO: BFS usando solo contactos con fecha >= desde y minutos >= minutosMinimos.
                throw new UnsupportedOperationException("TODO: grupoDeRiesgo");
            }

            public boolean posibleCadena(int origen, int destino, int maxSaltos) {
                // TODO: comprobar si hay camino con longitud <= maxSaltos.
                throw new UnsupportedOperationException("TODO: posibleCadena");
            }

    }
