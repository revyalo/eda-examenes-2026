package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.camino_hasta_raiz;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class PathIteratorToRoot<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;
    private final Position<E> start;

    public PathIteratorToRoot(BinaryTree<E> tree, Position<E> start) {
        this.tree = tree;
        this.start = start;
    }

    @Override
    public boolean hasNext() {
        // TODO: devuelve true si queda algun ancestro por visitar.
        throw new UnsupportedOperationException("TODO: hasNext en PathIteratorToRoot");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve el nodo actual y prepara su padre.
        throw new UnsupportedOperationException("TODO: next en PathIteratorToRoot");
    }
}
