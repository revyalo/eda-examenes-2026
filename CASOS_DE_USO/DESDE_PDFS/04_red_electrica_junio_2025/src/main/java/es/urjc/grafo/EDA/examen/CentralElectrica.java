package es.urjc.grafo.EDA.examen;

import java.util.Objects;

public class CentralElectrica implements Comparable<CentralElectrica> {

    private final String nombre;
    private final int potencia;
    private boolean encendida;

    public CentralElectrica(String nombre, int potencia) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.encendida = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public boolean estaEncendida() {
        return encendida;
    }

    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }

    @Override
    public int compareTo(CentralElectrica other) {
        int byPower = Integer.compare(this.potencia, other.potencia);
        if (byPower != 0) {
            return byPower;
        }
        return this.nombre.compareTo(other.nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CentralElectrica other)) {
            return false;
        }
        return Objects.equals(nombre, other.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
