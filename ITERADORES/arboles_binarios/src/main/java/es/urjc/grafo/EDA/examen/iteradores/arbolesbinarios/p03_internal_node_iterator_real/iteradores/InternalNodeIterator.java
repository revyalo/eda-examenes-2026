package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p03_internal_node_iterator_real.iteradores;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class InternalNodeIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public InternalNodeIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: devuelve true solo si queda algun nodo interno por visitar.
        throw new UnsupportedOperationException("TODO: hasNext en InternalNodeIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente posicion interna.
        throw new UnsupportedOperationException("TODO: next en InternalNodeIterator");
    }
}
