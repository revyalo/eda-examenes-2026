package es.urjc.grafo.EDA.examen.iteradores;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class BetweenLevelsIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;
    private final int minLevel;
    private final int maxLevel;

    public BetweenLevelsIterator(BinaryTree<E> tree, int minLevel, int maxLevel) {
        this.tree = tree;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }

    @Override
    public boolean hasNext() {
        // TODO: devuelve true si queda algun nodo entre los niveles pedidos.
        throw new UnsupportedOperationException("TODO: hasNext en BetweenLevelsIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve el siguiente nodo por niveles dentro del rango.
        throw new UnsupportedOperationException("TODO: next en BetweenLevelsIterator");
    }
}
