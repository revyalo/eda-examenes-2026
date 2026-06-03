package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.inorden_con_remove;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class InordenIteratorWithRemove<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public InordenIteratorWithRemove(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: indica si quedan posiciones del recorrido inorden.
        throw new UnsupportedOperationException("TODO: hasNext en InordenIteratorWithRemove");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente posicion en inorden.
        throw new UnsupportedOperationException("TODO: next en InordenIteratorWithRemove");
    }

    @Override
    public void remove() {
        // TODO: elimina el ultimo nodo devuelto por next si es legal.
        throw new UnsupportedOperationException("TODO: remove en InordenIteratorWithRemove");
    }
}
