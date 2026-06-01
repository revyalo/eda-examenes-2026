package es.urjc.grafo.EDA.examen.iteradores.arboles.p08_extra_leaf_iterator.iteradores;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class LeafIterator<E> implements Iterator<Position<E>> {

    private final LinkedTree<E> tree;

    public LeafIterator(LinkedTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: devuelve true si queda alguna hoja pendiente.
        throw new UnsupportedOperationException("TODO: hasNext en LeafIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente hoja en orden por niveles.
        throw new UnsupportedOperationException("TODO: next en LeafIterator");
    }
}
