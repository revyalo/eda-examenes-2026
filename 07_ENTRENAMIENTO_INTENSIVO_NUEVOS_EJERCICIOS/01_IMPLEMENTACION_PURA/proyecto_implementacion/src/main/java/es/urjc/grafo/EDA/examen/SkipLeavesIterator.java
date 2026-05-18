package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SkipLeavesIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public SkipLeavesIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: preparar y consultar el siguiente nodo valido.
        throw new UnsupportedOperationException("TODO: hasNext en SkipLeavesIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devolver el siguiente nodo segun el recorrido indicado.
        throw new UnsupportedOperationException("TODO: next en SkipLeavesIterator");
    }

    @Override
    public void remove() {
        // TODO: si el enunciado lo pide, eliminar el ultimo nodo devuelto manteniendo el iterador consistente.
        throw new UnsupportedOperationException("TODO: remove en SkipLeavesIterator");
    }
}
