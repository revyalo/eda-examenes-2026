package es.urjc.grafo.EDA.examen.iteradores;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;
import java.util.LinkedList;

public class ExtendedBreadthFirstTreeIterator<E> implements Iterator<Position<E>> {

    private LinkedList<Position<E>> nodesToVisit = new LinkedList<>();
    private LinkedTree<E> tree;

    public ExtendedBreadthFirstTreeIterator(LinkedTree<E> tree, Position<E> root) {
        this.nodesToVisit.add(root);
        this.tree = tree;
    }

    public ExtendedBreadthFirstTreeIterator(LinkedTree<E> tree) {
        this(tree, tree.root());
    }

    @Override
    public boolean hasNext() {
        return !this.nodesToVisit.isEmpty();
    }

    @Override
    public Position<E> next() {
        Position<E> currentPosition = this.nodesToVisit.poll();
        if (!tree.isLeaf(currentPosition)) {
            for (Position<E> child : tree.children(currentPosition)) {
                this.nodesToVisit.add(child);
            }
        }
        return currentPosition;
    }

    @Override
    public void remove() {
        // TODO: elimina el ultimo nodo devuelto por next y limpia la cola de nodos pendientes.
        throw new UnsupportedOperationException("TODO: remove en ExtendedBreadthFirstTreeIterator");
    }
}
