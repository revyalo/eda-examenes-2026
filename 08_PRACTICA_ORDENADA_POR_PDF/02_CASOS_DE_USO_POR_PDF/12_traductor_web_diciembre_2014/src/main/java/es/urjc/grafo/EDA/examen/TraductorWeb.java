package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class TraductorWeb {

        private final HashMap<String, HashMap<String, String>> traducciones = new HashMap<>();
private final HashMap<String, HashSet<String>> palabrasPorIdioma = new HashMap<>();
private final TreeSet<EntradaDiccionario> entradasOrdenadas = new TreeSet<>();


        public boolean addTraduccion(String idioma, String palabra, String traduccion) {
            // TODO: registrar traduccion.
            throw new UnsupportedOperationException("TODO: addTraduccion");
        }

        public String traducir(String idioma, String palabra) {
            // TODO: buscar traduccion.
            throw new UnsupportedOperationException("TODO: traducir");
        }

        public Iterable<String> palabrasDeIdioma(String idioma) {
            // TODO: devolver palabras conocidas.
            throw new UnsupportedOperationException("TODO: palabrasDeIdioma");
        }

        public Iterable<EntradaDiccionario> palabrasEntre(String ini, String fin) {
            // TODO: consulta alfabetica.
            throw new UnsupportedOperationException("TODO: palabrasEntre");
        }

    }
