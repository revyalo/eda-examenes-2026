package es.urjc.grafo.EDA.examen.arbolesbinarios.abb_minimo_sucesor;

import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class InorderMinimumSuccessorTreeIterator<E extends Comparable<E>> implements Iterator<Position<E>> {

    private final MinimumSuccessorTree<E> tree;
    private Position<E> next;

    public InorderMinimumSuccessorTreeIterator(MinimumSuccessorTree<E> tree) {
        this.tree = tree;
        // TODO: inicializar next con el minimo del arbol si no esta vacio.
    }

    @Override
    public boolean hasNext() {
        // TODO: indicar si queda alguna posicion por visitar.
        throw new UnsupportedOperationException("TODO: hasNext");
    }

    @Override
    public Position<E> next() {
        // TODO: devolver la posicion actual y avanzar usando successor.
        throw new UnsupportedOperationException("TODO: next");
    }
}
