package es.urjc.grafo.EDA.examen.iteradores.arbolesbinarios.p05_junio_2022_level_iterator.iteradores;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class LevelIterator<E> implements Iterator<Position<E>> {

    private final BinaryTree<E> tree;

    public LevelIterator(BinaryTree<E> tree) {
        this.tree = tree;
    }

    @Override
    public boolean hasNext() {
        // TODO: devuelve true si queda alguna posicion pendiente por niveles.
        throw new UnsupportedOperationException("TODO: hasNext en LevelIterator");
    }

    @Override
    public Position<E> next() {
        // TODO: devuelve la siguiente posicion en anchura.
        throw new UnsupportedOperationException("TODO: next en LevelIterator");
    }

    @Override
    public void remove() {
        // TODO: elimina el ultimo nodo devuelto si el árbol lo permite.
        throw new UnsupportedOperationException("TODO: remove en LevelIterator");
    }
}
