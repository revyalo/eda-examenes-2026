package es.urjc.grafo.EDA.examen.casos;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SistemaMensajesRed {

    private final HashMap<String, MensajeEvento> eventosPorCodigo = new HashMap<>();
    private final HashSet<String> codigosActivos = new HashSet<>();
    private final PriorityQueue<MensajeEvento> colaPrioridad = new PriorityQueue<>(new MensajeEventoComparator());
    private final TreeMap<LocalDateTime, HashSet<String>> eventosPorFecha = new TreeMap<>();
    private final HashMap<String, HashSet<String>> conexiones = new HashMap<>();

    public record MensajeEvento(String codigo, LocalDateTime fecha, int prioridad, String origen, String destino) {
    }

    public static class MensajeEventoComparator implements Comparator<MensajeEvento> {
        @Override
        public int compare(MensajeEvento a, MensajeEvento b) {
            // TODO: ordenar por fecha ascendente, prioridad descendente y codigo ascendente.
            throw new UnsupportedOperationException("TODO: compare MensajeEvento");
        }
    }

    public boolean registrarEvento(MensajeEvento evento) {
        // TODO: insertar sin repetidos y actualizar HashMap, HashSet, TreeMap y PriorityQueue.
        throw new UnsupportedOperationException("TODO: registrarEvento");
    }

    public boolean cancelarEvento(String codigo) {
        // TODO: eliminar de todos los indices sincronizados.
        throw new UnsupportedOperationException("TODO: cancelarEvento");
    }

    public MensajeEvento buscarEvento(String codigo) {
        // TODO: buscar por codigo en tiempo esperado constante.
        throw new UnsupportedOperationException("TODO: buscarEvento");
    }

    public Iterable<MensajeEvento> eventosHasta(LocalDateTime fecha) {
        // TODO: consultar eventos con fecha menor o igual usando TreeMap.
        throw new UnsupportedOperationException("TODO: eventosHasta");
    }

    public void conectar(String origen, String destino) {
        // TODO: crear una conexion no dirigida usando HashMap + HashSet.
        throw new UnsupportedOperationException("TODO: conectar");
    }

    public boolean hayConexionConDistanciaMenorOIgual(String origen, String destino, int k) {
        // TODO: BFS limitado sobre el grafo manual de conexiones.
        throw new UnsupportedOperationException("TODO: hayConexionConDistanciaMenorOIgual");
    }
}
