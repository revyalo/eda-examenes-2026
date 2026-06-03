package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.anchura_niveles_pares;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class BreadthFirstEvenLevelIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public BreadthFirstEvenLevelIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: devuelve true si queda algun nodo en nivel par.
        throw new UnsupportedOperationException("TODO: hasNext en BreadthFirstEvenLevelIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve el siguiente nodo de nivel par en anchura.
        throw new UnsupportedOperationException("TODO: next en BreadthFirstEvenLevelIterator");
    }
}
