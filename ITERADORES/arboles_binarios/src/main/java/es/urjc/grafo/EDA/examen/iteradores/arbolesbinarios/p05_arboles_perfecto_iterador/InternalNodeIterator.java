package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p05_arboles_perfecto_iterador;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class InternalNodeIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public InternalNodeIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }


public boolean hasNext() {
    // TODO: completar el iterador.
    throw new UnsupportedOperationException("TODO: InternalNodeIterator");
}


public Position<E> next() {
    // TODO: completar el iterador.
    throw new UnsupportedOperationException("TODO: InternalNodeIterator");
}


public void remove() {
    // TODO: completar siguiendo el enunciado.
    throw new UnsupportedOperationException("TODO: InternalNodeIterator");
}

}
