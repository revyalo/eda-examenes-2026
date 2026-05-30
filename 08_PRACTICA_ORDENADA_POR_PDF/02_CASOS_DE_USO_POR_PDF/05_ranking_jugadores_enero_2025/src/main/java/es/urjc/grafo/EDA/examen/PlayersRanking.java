package es.urjc.grafo.EDA.examen;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.util.HashMap;
    import java.util.HashSet;
    import java.util.PriorityQueue;
    import java.util.TreeMap;
    import java.util.TreeSet;

    public class PlayersRanking {

        private final HashMap<String, Player> playersByNick = new HashMap<>();
private final TreeSet<Player> rankingByScore = new TreeSet<>();
private final TreeSet<Player> rankingByName = new TreeSet<>(new NameComparator());
private final TreeMap<Integer, HashSet<String>> playersByScore = new TreeMap<>();


        public boolean addPlayer(Player player) {
            // TODO: insertar un jugador si no existe su nick.
            throw new UnsupportedOperationException("TODO: addPlayer");
        }

        public boolean updateScore(String nick, int newScore) {
            // TODO: actualizar puntuacion y reindexar rankings.
            throw new UnsupportedOperationException("TODO: updateScore");
        }

        public Iterable<Player> top(int n) {
            // TODO: devolver los n mejores jugadores.
            throw new UnsupportedOperationException("TODO: top");
        }

        public Iterable<Player> playersBetweenScores(int min, int max) {
            // TODO: buscar por rango de puntuacion.
            throw new UnsupportedOperationException("TODO: playersBetweenScores");
        }

        public Player findByNick(String nick) {
            // TODO: buscar por identificador.
            throw new UnsupportedOperationException("TODO: findByNick");
        }

    }
