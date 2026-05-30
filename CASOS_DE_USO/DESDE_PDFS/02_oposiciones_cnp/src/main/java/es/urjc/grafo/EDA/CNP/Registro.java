package es.urjc.grafo.EDA.CNP;

import java.util.*;

public class Registro {

    // TODO: definir los atributos de la clase

    /**
     * Crea un nuevo registro a partir de un iterable de opositores.
     *
     * @param opositores iterable con los opositores iniciales.
     */
    public Registro(Iterable<Opositor> opositores) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve un iterable con todos los opositores registrados.
     *
     * @return iterable sobre los {@link Opositor} presentes en el registro.
     */
    public Iterable<Opositor> opositores() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve el número de opositores actualmente registrados.
     *
     * @return tamaño del registro (número de opositores).
     */
    public int size() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Recupera el opositor con el DNI indicado.
     *
     * @param dni DNI del opositor.
     * @return el {@link Opositor} con ese DNI, o {@code null} si no existe.
     */
    public Opositor getOpositor(Integer dni) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Añade un nuevo opositor al registro.
     *
     * Si ya existe un opositor con el mismo DNI, no se realiza la inserción
     * y el método devuelve {@code false}. Si la inserción tiene éxito, el
     * método devuelve {@code true}.
     *
     * @param opositor opositor a añadir.
     * @return {@code true} si el opositor se ha añadido correctamente;
     *         {@code false} si ya existía un opositor con el mismo DNI.
     */
    public boolean addOpositor(Opositor opositor) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve la nota media mínima registrada entre todos los opositores.
     *
     * @return la nota media mínima.
     * @throws NoSuchElementException si no hay opositores registrados.
     */
    public double getMinNotaMedia() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve la nota media máxima registrada entre todos los opositores.
     *
     * @return la nota media máxima.
     * @throws NoSuchElementException si no hay opositores registrados.
     */
    public double getMaxNotaMedia() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve un iterable con los opositores que tienen la peor nota media.
     *
     * @return iterable con los opositores con la peor nota media.
     * @throws NoSuchElementException si no hay opositores registrados.
     */
    public Iterable<Opositor> OpositoresConPeorNota() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve un iterable con los opositores que tienen la mejor nota media.
     *
     * @return iterable con los opositores con la mejor nota media.
     * @throws NoSuchElementException si no hay opositores registrados.
     */
    public Iterable<Opositor> OpositoresConMejorNota() {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve los opositores cuya nota media es mayor o igual que el valor
     * proporcionado.
     *
     * @param notaMedia umbral de nota media.
     * @return iterable sobre los opositores con nota media superior o igual a {@code notaMedia}.
     */
    public Iterable<Opositor> getOpositoresConNotaMediaSuperiorA(double notaMedia) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve los opositores cuya nota media es estrictamente inferior al
     * valor proporcionado.
     *
     * @param notaMedia umbral de nota media.
     * @return iterable sobre los opositores con nota media inferior a {@code notaMedia}.
     */
    public Iterable<Opositor> getOpositoresConNotaMediaInferiorA(double notaMedia) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Devuelve los opositores cuya nota media está en el rango [min, max).
     * El límite inferior es inclusivo y el superior es exclusivo.
     *
     * @param min límite inferior (incluido).
     * @param max límite superior (no incluido).
     * @return iterable sobre los opositores con nota media en el rango.
     */
    public Iterable<Opositor> getOpositoresConNotaMediaEnElRango(double min, double max) {
        // TODO
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private class OpositoresIterator implements Iterator<Opositor> {

        // TODO: definir los atributos de la clase y el constructor

        @Override
        public boolean hasNext() {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Opositor next() {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    private class OpositoresIterable implements Iterable<Opositor> {

        // TODO: definir los atributos de la clase y el constructor

        @Override
        public Iterator<Opositor> iterator() {
            // TODO
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

}
