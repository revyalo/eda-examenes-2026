package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class LeafLevelOrderIteratorWithRemove<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public LeafLevelOrderIteratorWithRemove(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: preparar el siguiente nodo valido para hojas en anchura.
        throw new UnsupportedOperationException("TODO: hasNext en LeafLevelOrderIteratorWithRemove");
    }

    @Override
    public Position<E> next() {
        // TODO: devolver el siguiente nodo del recorrido pedido.
        throw new UnsupportedOperationException("TODO: next en LeafLevelOrderIteratorWithRemove");
    }

    @Override
    public void remove() {
        // TODO: eliminar correctamente el ultimo nodo devuelto.
        throw new UnsupportedOperationException("TODO: remove en LeafLevelOrderIteratorWithRemove");
    }
}
