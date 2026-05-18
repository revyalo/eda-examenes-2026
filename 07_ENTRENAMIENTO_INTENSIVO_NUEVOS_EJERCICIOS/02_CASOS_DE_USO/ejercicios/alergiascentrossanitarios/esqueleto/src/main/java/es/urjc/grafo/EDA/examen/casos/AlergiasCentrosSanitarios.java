package es.urjc.grafo.EDA.examen.casos;

    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class AlergiasCentrosSanitarios {

        private final HashMap<String, Centro> centros = new HashMap<>();
private final HashMap<String, HashSet<String>> centrosPorPueblo = new HashMap<>();
private final HashMap<String, HashSet<String>> centrosPorAlergia = new HashMap<>();
private final TreeSet<Centro> rankingCentrosPorPacientes = new TreeSet<>();


    public record Centro(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Centro> {
        @Override
        public int compareTo(Centro other) {
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



    public void addCentro(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addCentro - Alergias y centros sanitarios");
    }


    public void registrarAlergia(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar registrarAlergia - Alergias y centros sanitarios");
    }


public Iterable<String> centrosDePueblo(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar centrosDePueblo - Alergias y centros sanitarios");
}


public Iterable<String> centrosParaAlergia(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar centrosParaAlergia - Alergias y centros sanitarios");
}


public String mejorCentro(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar mejorCentro - Alergias y centros sanitarios");
}


public Iterable<String> topCentros(int n) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar topCentros - Alergias y centros sanitarios");
}

    }
