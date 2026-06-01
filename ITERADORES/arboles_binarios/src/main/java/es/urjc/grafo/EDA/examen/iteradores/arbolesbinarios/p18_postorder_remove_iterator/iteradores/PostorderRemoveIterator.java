package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p18_postorder_remove_iterator.iteradores;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class PostorderRemoveIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public PostorderRemoveIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: indica si quedan posiciones en postorden.
        throw new UnsupportedOperationException("TODO: hasNext en PostorderRemoveIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente posicion en postorden.
        throw new UnsupportedOperationException("TODO: next en PostorderRemoveIterator");
    }

    @Override
    public void remove() {
        // TODO: elimina el ultimo nodo devuelto por next si es legal.
        throw new UnsupportedOperationException("TODO: remove en PostorderRemoveIterator");
    }
}
