package trees;

import utils.Pair;
import utils.Position;

import java.util.*;

public class PosOrderTreeIterator<T> implements Iterator<Position<T>> {


    private final Stack<Pair<Position<T>, Boolean>> nodesToVisit;
    private final Tree<T> tree;

    public PosOrderTreeIterator(Tree<T> tree) {
        this(tree, tree.root());
    }

    public PosOrderTreeIterator(Tree<T> tree, Position<T> root) {
        this.tree = tree;
        this.nodesToVisit = new Stack<>();
        nodesToVisit.push(new Pair<>(root, false));
    }

    @Override
    public boolean hasNext() {
        return (!nodesToVisit.isEmpty());
    }

    /**
     * This method visits the nodes of a tree by following a pos-order
     */
    @Override
    public Position<T> next() {
        // Nodo actual
        Pair<Position<T>, Boolean> current = this.nodesToVisit.peek();
        // Si no hemos visitado/anadido sus hijos, los anadimos e iteramos. Si ya los hemos visitado, no entramos aqui y devolveremos este nodo
        if (!current.getSecond()) {
            // Marcamos como anadidos
            current.setSecond(true);
            while (this.tree.children(current.getFirst()).iterator().hasNext()) {
                // Anadimos los hijos a la ED de nodos por visitar
                List<Position<T>> children = new LinkedList<>();
                for (Position<T> child : this.tree.children(current.getFirst())) {
                    children.add(child);
                }
                Collections.reverse(children);
                for (Position<T> child : children) {
                    this.nodesToVisit.push(new Pair<>(child, false));
                }
                // Actualizamos el nodo actual. Pararemos cuando el nodo actual no tenga hijos (es decir, cuando lleguemos al nodo hoja)
                current = this.nodesToVisit.peek();
            }
        }
        // Devolvemos el ultimo nodo de la ED
        return this.nodesToVisit.pop().getFirst();
    }

}
