package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class JuegoLuces {

        private final HashMap<String, Bombilla> bombillas = new HashMap<>();
private final HashMap<String, HashSet<String>> conexiones = new HashMap<>();
private final HashSet<String> encendidas = new HashSet<>();
private final PriorityQueue<EventoLuz> eventos = new PriorityQueue<>();


        public boolean addBombilla(Bombilla bombilla) {
            // TODO: registrar bombilla unica.
            throw new UnsupportedOperationException("TODO: addBombilla");
        }

        public boolean connect(String a, String b) {
            // TODO: conectar bombillas.
            throw new UnsupportedOperationException("TODO: connect");
        }

        public boolean toggle(String id) {
            // TODO: cambiar estado.
            throw new UnsupportedOperationException("TODO: toggle");
        }

        public int propagar(String origen, int distancia) {
            // TODO: cambiar estado hasta distancia indicada.
            throw new UnsupportedOperationException("TODO: propagar");
        }

        public int encendidasEnComponente(String id) {
            // TODO: contar encendidas en la componente.
            throw new UnsupportedOperationException("TODO: encendidasEnComponente");
        }

    }
