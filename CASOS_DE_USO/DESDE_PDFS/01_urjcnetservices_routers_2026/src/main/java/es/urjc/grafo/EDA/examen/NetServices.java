package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.graphs.Vertex;
import es.urjc.grafo.EDA.trees.Tree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.LinkedList;
import java.util.List;

public class NetServices {


    /**
     * Añade un router a la red.
     * Si el router ya existe en la red, el método devolverá false.
     * Si el router no existe en la red, se añadirá y el método devolverá true.
     *
     * @param router el router a añadir
     * @return true si el router se añadió, false si ya existía
     */
    public boolean addRouter(Router router) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Añade una conexión entre dos routers.
     * Si alguno de los routers no existe en la red, el método devolverá false.
     * Si ambos routers existen, se añadirá la conexión y el método devolverá true.
     *
     * @param router1 un router
     * @param router2 otro router
     * @return true si la conexión se añadió, false si alguno de los routers no existe
     */
    public boolean addConnection(Router router1, Router router2) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Calcula el nodo central de la red.
     * El nodo central es aquel que minimiza la distancia máxima a cualquier otro nodo de la red.
     * Es decir, tras calcular el árbol de expansión mínimo para la red, el nodo central es la raíz de dicho árbol.
     * Si la red no tiene routers, se lanzará una excepción.
     * Si la red no es conexa, se devolverá null.
     *
     * @return el router que es el nodo central de la red, o null si la red no es conexa.
     */
    public Router centralNode() {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Comprueba si la red es conexa.
     *
     * @return true si la red es conexa, false en caso contrario.
     */
    private boolean isConnected() {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Calcula el árbol de expansión mínimo de la red.
     * Para ello, basta con calcular el árbol de expansión para cada nodo de la red
     * y quedarse con el árbol de menor altura.
     * El árbol de expansión de un nodo de la red se puede calcular con el
     * método GraphAlgorithms.expansionTree().
     *
     * @return el árbol de expansión mínimo.
     */
    private Tree<Vertex<Router>> minimumExpansionTree() {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Calcula la altura de un árbol.
     *
     * @param tree el árbol del que se quiere calcular la altura.
     * @return la altura del árbol.
     */
    private int height(Tree<Vertex<Router>> tree) {
        // BFS adaptado para calcular la altura de un árbol.
        List<Position<Vertex<Router>>> currentLevel = new LinkedList<>();
        currentLevel.addLast(tree.root());
        int height = 0;
        while (!currentLevel.isEmpty()) {
            List<Position<Vertex<Router>>> nextLevel = new LinkedList<>();
            for (Position<Vertex<Router>> node : currentLevel) {
                for (Position<Vertex<Router>> child : tree.children(node)) {
                    nextLevel.addLast(child);
                }
            }
            currentLevel = nextLevel;
            height++;
        }
        return height - 1;
    }
}
