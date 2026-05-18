package es.urjc.grafo.EDA.examen.ruta;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class CNIWarmup {

    private final HashMap<String, Elemento> elementos = new HashMap<>();
    private final HashMap<String, HashSet<String>> relaciones = new HashMap<>();
    private final HashMap<String, HashSet<String>> indiceSecundario = new HashMap<>();
    private final TreeMap<LocalDateTime, HashSet<String>> porFecha = new TreeMap<>();
    private final TreeSet<Elemento> ranking = new TreeSet<>();
    private final PriorityQueue<Elemento> prioridad = new PriorityQueue<>();

    public record Elemento(String id, String nombre, int prioridad, LocalDateTime fecha) implements Comparable<Elemento> {
        @Override
        public int compareTo(Elemento other) {
            int cmp = Integer.compare(other.prioridad, this.prioridad);
            if (cmp != 0) {
                return cmp;
            }
            return this.id.compareTo(other.id);
        }
    }

    public void addElemento(Elemento elemento) {
        // TODO: alta sin duplicados y actualización de índices necesarios.
        throw new UnsupportedOperationException("TODO: addElemento - CNI contactos indirectos con BFS limitado");
    }

    public void addRelacion(String a, String b) {
        // TODO: añadir relación dirigida/no dirigida según el caso.
        throw new UnsupportedOperationException("TODO: addRelacion - CNI contactos indirectos con BFS limitado");
    }

    public boolean conectadoConLimite(String origen, String destino, int limite) {
        // TODO: BFS manual sobre HashMap<String, HashSet<String>>.
        throw new UnsupportedOperationException("TODO: conectadoConLimite - CNI contactos indirectos con BFS limitado");
    }

    public Iterable<Elemento> topN(int n) {
        // TODO: devolver ranking usando TreeSet/PriorityQueue según proceda.
        throw new UnsupportedOperationException("TODO: topN - CNI contactos indirectos con BFS limitado");
    }
}
