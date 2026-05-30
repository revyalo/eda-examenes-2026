package es.urjc.grafo.EDA.examen.iteradores;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class SkipLeavesIterator<E> implements Iterator<Position<E>> {

    private final LinkedTree<E> tree;

    public SkipLeavesIterator(LinkedTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: devuelve true si queda algun nodo interno pendiente.
        throw new UnsupportedOperationException("TODO: hasNext en SkipLeavesIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve el siguiente nodo interno por niveles.
        throw new UnsupportedOperationException("TODO: next en SkipLeavesIterator");
    }
}
