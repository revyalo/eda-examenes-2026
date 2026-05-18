package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class HipergrafoProyectosParticipantes {

            private final HashMap<String, Proyecto> proyectos = new HashMap<>();
private final HashMap<String, Participante> participantes = new HashMap<>();
private final HashMap<String, HashSet<String>> participantesPorProyecto = new HashMap<>();
private final HashMap<String, HashSet<String>> proyectosPorParticipante = new HashMap<>();


    public record Proyecto(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Proyecto> {
        @Override
        public int compareTo(Proyecto other) {
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



    public record Participante(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Participante> {
        @Override
        public int compareTo(Participante other) {
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



    public void addProyecto(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addProyecto - Hipergrafo de proyectos y participantes usando solo mapas");
    }


    public void addParticipante(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addParticipante - Hipergrafo de proyectos y participantes usando solo mapas");
    }


    public void asignar(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar asignar - Hipergrafo de proyectos y participantes usando solo mapas");
    }


public Iterable<String> participantesRelacionados(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar participantesRelacionados - Hipergrafo de proyectos y participantes usando solo mapas");
}


public Iterable<String> proyectosComunes(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar proyectosComunes - Hipergrafo de proyectos y participantes usando solo mapas");
}


public Iterable<String> grupoExpandido(String origen, int limite) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar grupoExpandido - Hipergrafo de proyectos y participantes usando solo mapas");
}

        }
