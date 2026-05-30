package es.urjc.grafo.EDA.examen.iteradores;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class ReverseInordenBTIteratorWithRemove<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public ReverseInordenBTIteratorWithRemove(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: indica si queda alguna posicion en inorden inverso.
        throw new UnsupportedOperationException("TODO: hasNext en ReverseInordenBTIteratorWithRemove");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente posicion derecha-raiz-izquierda.
        throw new UnsupportedOperationException("TODO: next en ReverseInordenBTIteratorWithRemove");
    }

    @Override
    public void remove() {
        // TODO: elimina el ultimo nodo devuelto manteniendo consistente el iterador.
        throw new UnsupportedOperationException("TODO: remove en ReverseInordenBTIteratorWithRemove");
    }
}
