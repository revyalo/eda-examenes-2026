package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class SyntheticIntel {

        private final HashMap<String, ModeloIA> modelos = new HashMap<>();
private final HashMap<String, HashSet<String>> dependencias = new HashMap<>();
private final HashMap<String, HashSet<String>> modelosPorEmpresa = new HashMap<>();
private final TreeMap<Double, HashSet<String>> modelosPorPrecision = new TreeMap<>();
private final TreeSet<ModeloIA> rankingPrecision = new TreeSet<>();


        public boolean addModelo(ModeloIA modelo) {
            // TODO: registrar un modelo unico.
            throw new UnsupportedOperationException("TODO: addModelo");
        }

        public boolean addDependencia(String modelo, String dependencia) {
            // TODO: registrar una dependencia dirigida.
            throw new UnsupportedOperationException("TODO: addDependencia");
        }

        public boolean dependeDirectamente(String modelo, String dependencia) {
            // TODO: comprobar arista directa.
            throw new UnsupportedOperationException("TODO: dependeDirectamente");
        }

        public boolean dependeIndirectamente(String modelo, String dependencia) {
            // TODO: comprobar camino dirigido.
            throw new UnsupportedOperationException("TODO: dependeIndirectamente");
        }

        public Iterable<ModeloIA> modelosEntrePrecision(double min, double max) {
            // TODO: consulta por rango.
            throw new UnsupportedOperationException("TODO: modelosEntrePrecision");
        }

    }
