package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class TraductorWebPrioridades {

            private final HashMap<String, HashMap<String, String>> traducciones = new HashMap<>();
private final HashMap<String, HashSet<String>> palabrasPorIdioma = new HashMap<>();
private final TreeSet<EntradaDiccionario> entradasOrdenadas = new TreeSet<>();
private final PriorityQueue<SolicitudTraduccion> solicitudesPendientes = new PriorityQueue<>();


    public record EntradaDiccionario(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<EntradaDiccionario> {
        @Override
        public int compareTo(EntradaDiccionario other) {
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



    public record SolicitudTraduccion(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<SolicitudTraduccion> {
        @Override
        public int compareTo(SolicitudTraduccion other) {
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



    public void addTraduccion(String idioma, String palabra, String traduccion) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addTraduccion - Traductor web con prioridades");
    }


public String traducir(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar traducir - Traductor web con prioridades");
}


public Iterable<String> palabrasDeIdioma(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar palabrasDeIdioma - Traductor web con prioridades");
}


    public void solicitarTraduccion(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar solicitarTraduccion - Traductor web con prioridades");
    }


public String procesarSiguienteSolicitud(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar procesarSiguienteSolicitud - Traductor web con prioridades");
}


public Iterable<String> palabrasEntre(String ini, String fin) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar palabrasEntre - Traductor web con prioridades");
}

        }
