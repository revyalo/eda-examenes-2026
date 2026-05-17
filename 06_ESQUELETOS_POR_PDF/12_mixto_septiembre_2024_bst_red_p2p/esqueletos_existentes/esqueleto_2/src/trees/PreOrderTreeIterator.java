package trees;

import utils.Position;

import java.util.Iterator;
import java.util.LinkedList;

public class PreOrderTreeIterator<T> implements Iterator<Position<T>> {


    private final LinkedList<Position<T>> nodesToVisit;
    private final Tree<T> tree;

    public PreOrderTreeIterator(Tree<T> tree) {
        this(tree, tree.root());
    }

    public PreOrderTreeIterator(Tree<T> tree, Position<T> root) {
        this.tree = tree;
        this.nodesToVisit = new LinkedList<>();
        this.nodesToVisit.add(root);
    }

    @Override
    public boolean hasNext() {
        return (!nodesToVisit.isEmpty());
    }

    /**
     * This method visits the nodes of a tree by following a pre-order
     */
    @Override
    public Position<T> next() {
        Position<T> current = nodesToVisit.removeFirst();
        LinkedList<Position<T>> children = new LinkedList<>();
        // Reverse
        for (Position<T> child : this.tree.children(current)) {
            children.addFirst(child);
        }
        for (Position<T> child : children) {
            this.nodesToVisit.addFirst(child);
        }
        return current;
    }

}
