package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;
import java.util.LinkedList;

public class ExtendedBreadthFirstTreeIterator<T> implements Iterator<Position<T>> {

    private LinkedList<Position<T>> nodesToVisit = new LinkedList<>();
    private LinkedTree<T> tree;

    public ExtendedBreadthFirstTreeIterator(LinkedTree<T> tree, Position<T> root) {
        this.nodesToVisit.add(root);
        this.tree = tree;
    }

    public ExtendedBreadthFirstTreeIterator(LinkedTree<T> tree) {
        this(tree, tree.root());
    }

    @Override
    public boolean hasNext() {
        return !this.nodesToVisit.isEmpty();
    }

    /**
     * This method visits the nodes of a tree by following a breadth-first order
     */
    @Override
    public Position<T> next() {
        Position<T> currentPosition = this.nodesToVisit.poll();
        if (!tree.isLeaf(currentPosition)) {
            for (Position<T> child : tree.children(currentPosition)) {
                this.nodesToVisit.add(child);
            }
        }
        return currentPosition;
    }

    /**
     * Elimina el último elemento devuelto por next() del árbol.
     * Usa el método remove(Position<T> p) de la clase LinkedTree para eliminar el nodo y su subárbol del árbol.
     * Recuerda que el método remove de la clase LinkedTree elimina tanto el nodo que le pasas como
     * todo lo que cuelga de este. Por lo tanto, en las siguientes llamadas a next, este iterador no recorrerá
     * ni el nodo que se ha eliminado ni ninguno de los que colgaba de este.
     * Es decir, es necesario actualizar las estructuras internas del iterador para evitar visitar nodos que
     * ya no están presentes en el árbol.
     */
    @Override
    public void remove() {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
