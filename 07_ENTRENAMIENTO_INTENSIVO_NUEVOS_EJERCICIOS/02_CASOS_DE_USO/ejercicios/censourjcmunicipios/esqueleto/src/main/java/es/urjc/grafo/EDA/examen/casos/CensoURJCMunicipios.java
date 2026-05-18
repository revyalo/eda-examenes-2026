package es.urjc.grafo.EDA.examen.casos;

    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class CensoURJCMunicipios {

        private final HashMap<String, Habitante> habitantesPorDni = new HashMap<>();
private final HashMap<String, HashSet<String>> habitantesPorMunicipio = new HashMap<>();
private final TreeMap<Integer, HashSet<String>> habitantesPorEdad = new TreeMap<>();
private final TreeSet<Municipio> municipiosPorPoblacion = new TreeSet<>();


    public record Habitante(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Habitante> {
        @Override
        public int compareTo(Habitante other) {
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



    public record Municipio(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Municipio> {
        @Override
        public int compareTo(Municipio other) {
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



    public void addHabitante(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addHabitante - Censo URJC por municipios");
    }


    public void removeHabitante(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar removeHabitante - Censo URJC por municipios");
    }


public Iterable<String> habitantesMunicipio(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar habitantesMunicipio - Censo URJC por municipios");
}


public Iterable<String> habitantesEntreEdades(int min, int max) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar habitantesEntreEdades - Censo URJC por municipios");
}


public String municipioMasPoblado(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar municipioMasPoblado - Censo URJC por municipios");
}


    public void moverHabitante(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar moverHabitante - Censo URJC por municipios");
    }

    }
