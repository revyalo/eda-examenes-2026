package es.urjc.grafo.EDA.examen.casos;

        import java.time.LocalDateTime;
        import java.util.HashMap;
        import java.util.HashSet;
        import java.util.PriorityQueue;
        import java.util.TreeMap;
        import java.util.TreeSet;

        public class RedP2PBusquedaArchivos {

            private final HashMap<String, Nodo> nodos = new HashMap<>();
private final HashMap<String, HashSet<String>> conexiones = new HashMap<>();
private final HashMap<String, HashSet<String>> archivosPorNodo = new HashMap<>();
private final HashMap<String, HashSet<String>> nodosPorArchivo = new HashMap<>();


    public record Nodo(String id, String nombre, int prioridad, double valor, LocalDateTime fecha) implements Comparable<Nodo> {
        @Override
        public int compareTo(Nodo other) {
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



    public void addNode(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addNode - Red P2P con busqueda de archivos");
    }


    public void addConnection(String a, String b) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addConnection - Red P2P con busqueda de archivos");
    }


    public void addFile(String id) {
        // TODO: actualizar todos los indices necesarios.
        throw new UnsupportedOperationException("TODO: completar addFile - Red P2P con busqueda de archivos");
    }


public Iterable<String> buscarArchivo(String origen, int limite) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar buscarArchivo - Red P2P con busqueda de archivos");
}


public Iterable<String> nodosConArchivo(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar nodosConArchivo - Red P2P con busqueda de archivos");
}


public String nodoMasCompartidor(String id) {
    // TODO: usar las estructuras indicadas en el enunciado.
    throw new UnsupportedOperationException("TODO: completar nodoMasCompartidor - Red P2P con busqueda de archivos");
}

        }
