package es.urjc.grafo.EDA.examen.arbolesbinarios.p29_minimum_successor_tree.bst;

import es.urjc.grafo.EDA.utils.Position;

public class MaximumPredecessorTree<E extends Comparable<E>> extends MinimumSuccessorTree<E> {

    @Override
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
            if (value.compareTo(current.getElement()) > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        Node<E> created = new Node<>(value, parent);
        if (value.compareTo(parent.getElement()) > 0) {
            parent.left = created;
        } else {
            parent.right = created;
        }
        size++;
        return created;
    }

    public Position<E> predecessor(Position<E> position) {
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

    public Position<E> maximum(Position<E> position) {
        // TODO: devolver la posicion con valor maximo del subarbol con raiz en position.
        throw new UnsupportedOperationException("TODO: maximum(Position)");
    }

    public Position<E> maximum() {
        // TODO: devolver la posicion con valor maximo de todo el arbol.
        throw new UnsupportedOperationException("TODO: maximum()");
    }
}
