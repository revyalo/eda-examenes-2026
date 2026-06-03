package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.iterador_sin_hermanos;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class WithoutSiblingIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public WithoutSiblingIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: indica si queda algun nodo no raiz sin hermano.
        throw new UnsupportedOperationException("TODO: hasNext en WithoutSiblingIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente posicion sin hermano.
        throw new UnsupportedOperationException("TODO: next en WithoutSiblingIterator");
    }
}
