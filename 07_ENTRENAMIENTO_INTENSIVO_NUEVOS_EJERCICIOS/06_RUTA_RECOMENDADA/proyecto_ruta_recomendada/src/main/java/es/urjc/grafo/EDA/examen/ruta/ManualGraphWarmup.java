package es.urjc.grafo.EDA.examen.ruta;

import java.util.HashMap;
import java.util.HashSet;

public class ManualGraphWarmup {

    private final HashMap<String, HashSet<String>> adj = new HashMap<>();

    public void addVertex(String id) {
        // TODO: añadir vértice si no existe.
        throw new UnsupportedOperationException("TODO: addVertex");
    }

    public void addEdge(String a, String b) {
        // TODO: crear arista no dirigida usando HashMap + HashSet.
        throw new UnsupportedOperationException("TODO: addEdge");
    }

    public HashSet<String> dfsReachable(String origin) {
        // TODO: devolver alcanzables con DFS.
        throw new UnsupportedOperationException("TODO: dfsReachable");
    }

    public boolean existsPathDFS(String origin, String destination) {
        // TODO: comprobar camino cualquiera.
        throw new UnsupportedOperationException("TODO: existsPathDFS");
    }

    public HashSet<String> bfs(String origin) {
        // TODO: recorrido BFS.
        throw new UnsupportedOperationException("TODO: bfs");
    }

    public int distance(String origin, String destination) {
        // TODO: distancia mínima con BFS; -1 si no hay camino.
        throw new UnsupportedOperationException("TODO: distance");
    }

    public boolean existsPathLessOrEqual(String origin, String destination, int n) {
        // TODO: camino de longitud <= n.
        throw new UnsupportedOperationException("TODO: existsPathLessOrEqual");
    }

    public int connectedComponents() {
        // TODO: contar componentes conexas.
        throw new UnsupportedOperationException("TODO: connectedComponents");
    }

    public boolean isConnected() {
        // TODO: comprobar si hay una sola componente.
        throw new UnsupportedOperationException("TODO: isConnected");
    }

    public ManualGraphWarmup complementary() {
        // TODO: construir complementario.
        throw new UnsupportedOperationException("TODO: complementary");
    }
}
