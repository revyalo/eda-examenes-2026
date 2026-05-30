package trees;

import utils.Position;

import java.util.*;

public class DepthFirstTreeIterator<T> implements Iterator<Position<T>> {

    Stack<Position<T>> nodesToVisit = new Stack<>();
    Tree<T> tree;

    public DepthFirstTreeIterator(Tree<T> tree, Position<T> root) {
        this.nodesToVisit.add(root);
        this.tree = tree;
    }

    public DepthFirstTreeIterator(Tree<T> tree) {
        this(tree, tree.root());
    }
    
    @Override
    public boolean hasNext() {
        return !this.nodesToVisit.isEmpty();
    }

    /**
     * This method visits the nodes of a tree by following a depth-first order
     */
    @Override
    public Position<T> next() {
        Position<T> currentPosition = this.nodesToVisit.pop();
        if (!tree.isLeaf(currentPosition)) {
            List<Position<T>> children = new LinkedList<>();
            children.addAll((Collection<? extends Position<T>>) tree.children(currentPosition));
            Collections.reverse(children);
            for (Position<T> child : children) {
                this.nodesToVisit.push(child);
            }
        }
        return currentPosition;
    }

   
}
