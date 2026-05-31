package es.urjc.grafo.EDA.examen;

public class NetServices {

    // TODO: define aqui los atributos privados necesarios para representar la red.

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

    // TODO: puedes anadir metodos privados auxiliares si los necesitas.
}
