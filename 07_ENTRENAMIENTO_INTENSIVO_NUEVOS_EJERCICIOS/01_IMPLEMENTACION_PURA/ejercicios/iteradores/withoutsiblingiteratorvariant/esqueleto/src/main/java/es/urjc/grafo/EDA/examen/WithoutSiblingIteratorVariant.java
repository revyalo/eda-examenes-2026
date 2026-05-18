package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class WithoutSiblingIteratorVariant<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public WithoutSiblingIteratorVariant(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: preparar y consultar el siguiente nodo valido.
        throw new UnsupportedOperationException("TODO: hasNext en WithoutSiblingIteratorVariant");
    }

    @Override
    public Position<E> next() {
        // TODO: devolver el siguiente nodo segun el recorrido indicado.
        throw new UnsupportedOperationException("TODO: next en WithoutSiblingIteratorVariant");
    }

    @Override
    public void remove() {
        // TODO: eliminar el ultimo nodo devuelto cuando el ejercicio lo pida.
        throw new UnsupportedOperationException("TODO: remove en WithoutSiblingIteratorVariant");
    }
}
