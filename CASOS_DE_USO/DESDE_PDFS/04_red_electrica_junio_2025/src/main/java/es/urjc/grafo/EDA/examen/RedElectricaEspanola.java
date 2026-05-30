package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class RedElectricaEspanola {

        private final HashMap<String, Area> areas = new HashMap<>();
private final HashMap<String, CentralElectrica> centrales = new HashMap<>();
private final HashMap<String, HashSet<String>> red = new HashMap<>();
private final HashMap<String, HashSet<String>> centralesPorArea = new HashMap<>();
private final TreeSet<CentralElectrica> rankingPotencia = new TreeSet<>();


        public boolean addArea(Area area) {
            // TODO: registrar un area sin duplicados.
            throw new UnsupportedOperationException("TODO: addArea");
        }

        public boolean addCentral(CentralElectrica central) {
            // TODO: registrar una central y todos los indices.
            throw new UnsupportedOperationException("TODO: addCentral");
        }

        public boolean conectar(String origen, String destino) {
            // TODO: anadir una conexion no dirigida entre centrales existentes.
            throw new UnsupportedOperationException("TODO: conectar");
        }

        public Iterable<CentralElectrica> centralesDeArea(String areaId) {
            // TODO: devolver las centrales de un area.
            throw new UnsupportedOperationException("TODO: centralesDeArea");
        }

        public boolean estanConectadas(String origen, String destino) {
            // TODO: comprobar si hay camino entre dos centrales.
            throw new UnsupportedOperationException("TODO: estanConectadas");
        }

        public CentralElectrica centralMasConectada() {
            // TODO: devolver la central con mas conexiones.
            throw new UnsupportedOperationException("TODO: centralMasConectada");
        }

    }
