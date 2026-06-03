package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.inorden_inverso;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class ReverseInordenBTIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public ReverseInordenBTIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: indica si queda alguna posicion pendiente en inorden inverso.
        throw new UnsupportedOperationException("TODO: hasNext en ReverseInordenBTIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente posicion en orden derecha-raiz-izquierda.
        throw new UnsupportedOperationException("TODO: next en ReverseInordenBTIterator");
    }

    @Override
    public void remove() {
        // TODO opcional: si no se soporta, lanza UnsupportedOperationException.
        throw new UnsupportedOperationException("TODO: remove en ReverseInordenBTIterator");
    }
}
