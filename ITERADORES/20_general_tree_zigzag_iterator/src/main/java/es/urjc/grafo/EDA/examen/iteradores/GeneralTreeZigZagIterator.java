package es.urjc.grafo.EDA.examen.iteradores;

import es.urjc.grafo.EDA.trees.Tree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class GeneralTreeZigZagIterator<E> implements Iterator<Position<E>> {

    private final Tree<E> tree;

    public GeneralTreeZigZagIterator(Tree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: indica si quedan posiciones del recorrido zigzag.
        throw new UnsupportedOperationException("TODO: hasNext en GeneralTreeZigZagIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente posicion del recorrido zigzag por niveles.
        throw new UnsupportedOperationException("TODO: next en GeneralTreeZigZagIterator");
    }
}
