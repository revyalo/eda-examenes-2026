package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class BasketballLeague {

        private final HashMap<String, Team> teams = new HashMap<>();
private final TreeSet<Team> ranking = new TreeSet<>();
private final TreeMap<Integer, HashSet<String>> teamsByPoints = new TreeMap<>();


        public boolean addTeam(Team team) {
            // TODO: registrar equipo unico.
            throw new UnsupportedOperationException("TODO: addTeam");
        }

        public boolean recordResult(String winner, String loser) {
            // TODO: actualizar puntos y ranking.
            throw new UnsupportedOperationException("TODO: recordResult");
        }

        public Iterable<Team> topTeams(int n) {
            // TODO: devolver mejores equipos.
            throw new UnsupportedOperationException("TODO: topTeams");
        }

        public Iterable<Team> teamsBetweenPoints(int min, int max) {
            // TODO: consulta por rango.
            throw new UnsupportedOperationException("TODO: teamsBetweenPoints");
        }

    }
