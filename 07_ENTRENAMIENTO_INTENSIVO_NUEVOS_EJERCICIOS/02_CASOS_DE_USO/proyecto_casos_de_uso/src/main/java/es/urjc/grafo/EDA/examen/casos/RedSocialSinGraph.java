package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class RedSocialSinGraph {

            private final HashMap<String, Persona> personas = new HashMap<>();
private final HashMap<String, HashSet<String>> seguidos = new HashMap<>();
private final HashMap<String, HashSet<String>> seguidores = new HashMap<>();
private final TreeSet<Persona> rankingPopularidad = new TreeSet<>();
private final HashMap<String, HashSet<String>> personasPorCiudad = new HashMap<>();


    public record Persona(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Persona> {
        @Override
        public int compareTo(Persona other) {
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



    public void addPersona(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addPersona - Red social sin usar Graph");
    }


    public void seguir(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar seguir - Red social sin usar Graph");
    }


    public void dejarDeSeguir(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar dejarDeSeguir - Red social sin usar Graph");
    }


public boolean sonAmigos(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar sonAmigos - Red social sin usar Graph");
}


public Iterable<String> sugerencias(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar sugerencias - Red social sin usar Graph");
}


public String influencerCiudad(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar influencerCiudad - Red social sin usar Graph");
}

        }
