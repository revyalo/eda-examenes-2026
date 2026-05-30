package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class CensoURJC {

        private final HashMap<String, Habitante> habitantes = new HashMap<>();
private final HashMap<String, HashSet<String>> habitantesPorMunicipio = new HashMap<>();
private final TreeMap<Integer, HashSet<String>> habitantesPorEdad = new TreeMap<>();
private final TreeSet<Habitante> rankingEdad = new TreeSet<>();


        public boolean addHabitante(Habitante habitante) {
            // TODO: insertar habitante sin DNI repetido.
            throw new UnsupportedOperationException("TODO: addHabitante");
        }

        public boolean removeHabitante(String dni) {
            // TODO: borrar de todos los indices.
            throw new UnsupportedOperationException("TODO: removeHabitante");
        }

        public Iterable<Habitante> habitantesMunicipio(String municipio) {
            // TODO: consulta por municipio.
            throw new UnsupportedOperationException("TODO: habitantesMunicipio");
        }

        public Iterable<Habitante> habitantesEntreEdades(int min, int max) {
            // TODO: consulta de rango.
            throw new UnsupportedOperationException("TODO: habitantesEntreEdades");
        }

        public boolean moverHabitante(String dni, String nuevoMunicipio) {
            // TODO: actualizar municipio e indices.
            throw new UnsupportedOperationException("TODO: moverHabitante");
        }

    }
