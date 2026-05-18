package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class LeafIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public LeafIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: preparar y consultar el siguiente nodo valido.
        throw new UnsupportedOperationException("TODO: hasNext en LeafIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devolver el siguiente nodo segun el recorrido indicado.
        throw new UnsupportedOperationException("TODO: next en LeafIterator");
    }

    @Override
    public void remove() {
        // TODO: eliminar el ultimo nodo devuelto cuando el ejercicio lo pida.
        throw new UnsupportedOperationException("TODO: remove en LeafIterator");
    }
}
