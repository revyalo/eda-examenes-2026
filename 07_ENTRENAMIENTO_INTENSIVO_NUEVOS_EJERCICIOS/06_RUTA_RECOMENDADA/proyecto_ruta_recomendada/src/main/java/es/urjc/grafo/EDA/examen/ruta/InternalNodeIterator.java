package es.urjc.grafo.EDA.examen.ruta;

import es.urjc.grafo.EDA.trees.Tree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class InternalNodeIterator<E> implements Iterator<Position<E>> {

    private final Tree<E> tree;

    public InternalNodeIterator(Tree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: indicar si queda algún nodo interno por visitar.
        throw new UnsupportedOperationException("TODO: hasNext");
    }

    @Override
    public Position<E> next() {
        // TODO: devolver el siguiente nodo interno.
        throw new UnsupportedOperationException("TODO: next");
    }

    @Override
    public void remove() {
        // TODO: si procede, eliminar el último nodo devuelto manteniendo el iterador consistente.
        throw new UnsupportedOperationException("TODO: remove");
    }
}
