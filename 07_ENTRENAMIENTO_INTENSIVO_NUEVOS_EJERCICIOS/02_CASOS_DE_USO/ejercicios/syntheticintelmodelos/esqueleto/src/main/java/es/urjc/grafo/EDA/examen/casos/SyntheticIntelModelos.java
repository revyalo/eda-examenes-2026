package es.urjc.grafo.EDA.examen.casos;

    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class SyntheticIntelModelos {

        private final HashMap<String, ModeloIA> modelos = new HashMap<>();
private final HashMap<String, HashSet<String>> dependencias = new HashMap<>();
private final HashMap<String, HashSet<String>> modelosPorEmpresa = new HashMap<>();
private final TreeSet<ModeloIA> rankingPrecision = new TreeSet<>();
private final TreeMap<Double, HashSet<String>> modelosPorPrecision = new TreeMap<>();


    public record ModeloIA(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<ModeloIA> {
        @Override
        public int compareTo(ModeloIA other) {
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



    public void addModelo(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addModelo - Synthetic Intel: red de modelos de IA");
    }


    public void addDependencia(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addDependencia - Synthetic Intel: red de modelos de IA");
    }


public boolean dependeDirectamente(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar dependeDirectamente - Synthetic Intel: red de modelos de IA");
}


public boolean dependeIndirectamente(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar dependeIndirectamente - Synthetic Intel: red de modelos de IA");
}


public Iterable<String> topModelos(int n) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar topModelos - Synthetic Intel: red de modelos de IA");
}


public Iterable<String> modelosEntrePrecision(String id, double valor) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar modelosEntrePrecision - Synthetic Intel: red de modelos de IA");
}

    }
