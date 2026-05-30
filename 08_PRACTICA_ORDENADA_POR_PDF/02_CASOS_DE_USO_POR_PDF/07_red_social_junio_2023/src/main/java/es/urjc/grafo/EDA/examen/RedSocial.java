package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class RedSocial {

        private final HashMap<String, Persona> personas = new HashMap<>();
private final HashMap<String, HashSet<String>> seguidos = new HashMap<>();
private final HashMap<String, HashSet<String>> seguidores = new HashMap<>();
private final HashMap<String, HashSet<String>> personasPorCiudad = new HashMap<>();
private final TreeSet<Persona> rankingPopularidad = new TreeSet<>();


        public boolean addPersona(Persona persona) {
            // TODO: registrar persona e indices.
            throw new UnsupportedOperationException("TODO: addPersona");
        }

        public boolean seguir(String origen, String destino) {
            // TODO: anadir relacion dirigida.
            throw new UnsupportedOperationException("TODO: seguir");
        }

        public boolean dejarDeSeguir(String origen, String destino) {
            // TODO: eliminar relacion dirigida.
            throw new UnsupportedOperationException("TODO: dejarDeSeguir");
        }

        public boolean sonAmigos(String a, String b) {
            // TODO: comprobar seguimiento mutuo.
            throw new UnsupportedOperationException("TODO: sonAmigos");
        }

        public Iterable<Persona> sugerencias(String nick) {
            // TODO: devolver amigos de amigos no seguidos.
            throw new UnsupportedOperationException("TODO: sugerencias");
        }

    }
