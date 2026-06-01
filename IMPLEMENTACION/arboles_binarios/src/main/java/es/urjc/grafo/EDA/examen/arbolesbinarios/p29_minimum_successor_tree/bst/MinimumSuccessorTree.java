package es.urjc.grafo.EDA.examen.arbolesbinarios.p29_minimum_successor_tree.bst;

import es.urjc.grafo.EDA.utils.Position;

import java.util.Iterator;

public class MinimumSuccessorTree<E extends Comparable<E>> implements Iterable<Position<E>> {

    protected Node<E> root;
    protected int size;

    public Position<E> insert(E value) {
        if (root == null) {
            root = new Node<>(value, null);
            size = 1;
            return root;
        }
        Node<E> current = root;
        Node<E> parent = null;
        while (current != null) {
            parent = current;
            if (value.compareTo(current.element) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        Node<E> created = new Node<>(value, parent);
        if (value.compareTo(parent.element) < 0) {
            parent.left = created;
        } else {
            parent.right = created;
        }
        size++;
        return created;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Position<E> root() {
        if (root == null) {
            throw new IllegalStateException("Arbol vacio");
        }
        return root;
    }

    public Position<E> left(Position<E> position) {
        return check(position).left;
    }

    public Position<E> right(Position<E> position) {
        return check(position).right;
    }

    public Position<E> parent(Position<E> position) {
        return check(position).parent;
    }

    public Position<E> successor(Position<E> position) {
        Node<E> node = check(position);
        if (node.right != null) {
            Node<E> current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        }
        Node<E> current = node;
        Node<E> parent = node.parent;
        while (parent != null && current == parent.right) {
            current = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public Position<E> minimum(Position<E> position) {
        // TODO: devolver la posicion con valor minimo del subarbol con raiz en position.
        throw new UnsupportedOperationException("TODO: minimum(Position)");
    }

    public Position<E> minimum() {
        // TODO: devolver la posicion con valor minimo de todo el arbol.
        throw new UnsupportedOperationException("TODO: minimum()");
    }

    @Override
    public Iterator<Position<E>> iterator() {
        // TODO: devolver un InorderMinimumSuccessorTreeIterator.
        throw new UnsupportedOperationException("TODO: iterator");
    }

    @SuppressWarnings("unchecked")
    protected Node<E> check(Position<E> position) {
        if (!(position instanceof Node<?>)) {
            throw new IllegalArgumentException("Posicion invalida");
        }
        return (Node<E>) position;
    }

    protected static class Node<E> implements Position<E> {
        protected final E element;
        protected Node<E> parent;
        protected Node<E> left;
        protected Node<E> right;

        protected Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        @Override
        public E getElement() {
            return element;
        }
    }
}
