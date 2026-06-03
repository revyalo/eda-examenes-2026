package es.urjc.grafo.EDA.examen.casoslimpios.registrocnpplus;

public class RegistroCNPPlus {

    // TODO: declara como maximo dos propiedades privadas.
    // Debes elegir una estructura para DNI y otra ordenada por nota media.

    public RegistroCNPPlus(Iterable<Opositor> opositores) {
        // TODO: inicializar estructuras e insertar opositores sin duplicados.
        throw new UnsupportedOperationException("TODO: constructor RegistroCNPPlus");
    }

    public Iterable<Opositor> opositores() {
        throw new UnsupportedOperationException("TODO: opositores");
    }

    public int size() {
        throw new UnsupportedOperationException("TODO: size");
    }

    public Opositor getOpositor(Integer dni) {
        throw new UnsupportedOperationException("TODO: getOpositor");
    }

    public boolean addOpositor(Opositor opositor) {
        throw new UnsupportedOperationException("TODO: addOpositor");
    }

    public boolean removeOpositor(Integer dni) {
        throw new UnsupportedOperationException("TODO: removeOpositor");
    }

    public double getMinNotaMedia() {
        throw new UnsupportedOperationException("TODO: getMinNotaMedia");
    }

    public double getMaxNotaMedia() {
        throw new UnsupportedOperationException("TODO: getMaxNotaMedia");
    }

    public Iterable<Opositor> getOpositoresConNotaMediaSuperiorA(double notaMedia) {
        throw new UnsupportedOperationException("TODO: getOpositoresConNotaMediaSuperiorA");
    }

    public Iterable<Opositor> getOpositoresConNotaMediaEnElRango(double min, double max) {
        throw new UnsupportedOperationException("TODO: getOpositoresConNotaMediaEnElRango");
    }

    public Iterable<Opositor> getTopK(int k) {
        throw new UnsupportedOperationException("TODO: getTopK");
    }
}
