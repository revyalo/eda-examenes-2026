package es.urjc.grafo.EDA.examen;

import java.util.Objects;
import java.util.SortedSet;

public class Area {

    private final String nombre;

    // TODO: define aqui los atributos privados necesarios.

    public Area(String nombre) {
        this.nombre = nombre;
        // TODO: inicializar las estructuras elegidas.
    }

    public String getNombre() {
        return nombre;
    }

    public boolean encender(CentralElectrica c) {
        // TODO: encender la central si pertenece al area y estaba apagada.
        throw new UnsupportedOperationException("TODO: encender");
    }

    public boolean apagar(CentralElectrica c) {
        // TODO: apagar la central si pertenece al area y estaba encendida.
        throw new UnsupportedOperationException("TODO: apagar");
    }

    public boolean anadirCentral(CentralElectrica c) {
        // TODO: anadir la central si no hay otra con la misma potencia.
        throw new UnsupportedOperationException("TODO: anadirCentral");
    }

    public SortedSet<CentralElectrica> encendidas() {
        // TODO: devolver centrales encendidas ordenadas por potencia.
        throw new UnsupportedOperationException("TODO: encendidas");
    }

    public SortedSet<CentralElectrica> apagadas() {
        // TODO: devolver centrales apagadas ordenadas por potencia.
        throw new UnsupportedOperationException("TODO: apagadas");
    }

    public int generacion() {
        // TODO: devolver la energia producida actualmente en O(1).
        throw new UnsupportedOperationException("TODO: generacion");
    }

    public int potenciaMaxima() {
        // TODO: devolver la potencia maxima total en O(1).
        throw new UnsupportedOperationException("TODO: potenciaMaxima");
    }

    public int completeShutDown() {
        // TODO: apagar todas las centrales encendidas y devolver cuantas se apagaron.
        throw new UnsupportedOperationException("TODO: completeShutDown");
    }

    public int maxEnergy() {
        // TODO: encender todas las centrales apagadas y devolver cuantas se encendieron.
        throw new UnsupportedOperationException("TODO: maxEnergy");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Area other)) {
            return false;
        }
        return Objects.equals(nombre, other.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
