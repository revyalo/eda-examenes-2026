package es.urjc.grafo.EDA.examen.ruta;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class CNPWarmup {

    private final HashMap<String, Opositor> opositoresPorDni = new HashMap<>();
    private final HashMap<String, HashSet<String>> opositoresPorProvincia = new HashMap<>();
    private final TreeSet<Opositor> rankingPorNota = new TreeSet<>();
    private final TreeMap<Double, HashSet<String>> opositoresPorNota = new TreeMap<>();

    public record Opositor(String dni, String nombre, String provincia, double nota, LocalDate fecha) implements Comparable<Opositor> {
        @Override
        public int compareTo(Opositor other) {
            int cmp = Double.compare(other.nota, this.nota);
            if (cmp != 0) {
                return cmp;
            }
            return this.dni.compareTo(other.dni);
        }
    }

    public void addOpositor(Opositor opositor) {
        // TODO: alta sin duplicados y actualización de índices.
        throw new UnsupportedOperationException("TODO: addOpositor");
    }

    public void removeOpositor(String dni) {
        // TODO: borrar de todos los índices.
        throw new UnsupportedOperationException("TODO: removeOpositor");
    }

    public void actualizarNota(String dni, double nota) {
        // TODO: quitar y reinsertar en TreeSet/TreeMap.
        throw new UnsupportedOperationException("TODO: actualizarNota");
    }

    public Iterable<Opositor> topN(int n) {
        // TODO: devolver mejores n opositores.
        throw new UnsupportedOperationException("TODO: topN");
    }

    public Iterable<Opositor> opositoresEntreNotas(double min, double max) {
        // TODO: consulta por rango usando TreeMap.
        throw new UnsupportedOperationException("TODO: opositoresEntreNotas");
    }

    public Iterable<Opositor> aptosPorProvincia(String provincia) {
        // TODO: filtrar por provincia y nota de aprobado.
        throw new UnsupportedOperationException("TODO: aptosPorProvincia");
    }
}
