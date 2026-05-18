package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class JuegoLucesAvanzado {

            private final HashMap<String, Bombilla> bombillas = new HashMap<>();
private final HashMap<String, HashSet<String>> conexiones = new HashMap<>();
private final HashSet<String> encendidas = new HashSet<>();
private final PriorityQueue<EventoLuz> eventos = new PriorityQueue<>();


    public record Bombilla(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Bombilla> {
        @Override
        public int compareTo(Bombilla other) {
            int cmp = Integer.compare(other.prioridad, this.prioridad);
            if (cmp != 0) {
                return cmp;
            }
            cmp = Double.compare(other.valor, this.valor);
            if (cmp != 0) {
                return cmp;
            }
            return this.id.compareTo(other.id);
        }
    }



    public record EventoLuz(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<EventoLuz> {
        @Override
        public int compareTo(EventoLuz other) {
            int cmp = Integer.compare(other.prioridad, this.prioridad);
            if (cmp != 0) {
                return cmp;
            }
            cmp = Double.compare(other.valor, this.valor);
            if (cmp != 0) {
                return cmp;
            }
            return this.id.compareTo(other.id);
        }
    }



    public void addBombilla(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addBombilla - Juego de las luces avanzado");
    }


    public void connect(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar connect - Juego de las luces avanzado");
    }


    public void toggle(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar toggle - Juego de las luces avanzado");
    }


public String propagar(String origen, int limite) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar propagar - Juego de las luces avanzado");
}


public Iterable<String> encendidasEnComponente(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar encendidasEnComponente - Juego de las luces avanzado");
}


    public void programarEvento(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar programarEvento - Juego de las luces avanzado");
    }

        }
