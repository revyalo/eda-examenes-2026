package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class LigaDeportivaRanking {

            private final HashMap<String, Equipo> equipos = new HashMap<>();
private final HashMap<String, HashSet<String>> jugadoresPorEquipo = new HashMap<>();
private final TreeSet<Equipo> rankingEquipos = new TreeSet<>();
private final TreeMap<Integer, HashSet<String>> equiposPorPuntos = new TreeMap<>();
private final PriorityQueue<Partido> partidosPendientes = new PriorityQueue<>();


    public record Equipo(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Equipo> {
        @Override
        public int compareTo(Equipo other) {
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



    public record Partido(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Partido> {
        @Override
        public int compareTo(Partido other) {
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



    public void addEquipo(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addEquipo - Liga deportiva y ranking de equipos");
    }


    public void registrarResultado(String e1, String e2, int p1, int p2) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar registrarResultado - Liga deportiva y ranking de equipos");
    }


public Iterable<String> topEquipos(int n) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar topEquipos - Liga deportiva y ranking de equipos");
}


public Iterable<String> equiposConPuntosEntre(int min, int max) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar equiposConPuntosEntre - Liga deportiva y ranking de equipos");
}


    public void programarPartido(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar programarPartido - Liga deportiva y ranking de equipos");
    }


public String siguientePartido(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar siguientePartido - Liga deportiva y ranking de equipos");
}

        }
