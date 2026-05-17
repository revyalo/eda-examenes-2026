package es.urjc.grafo.EDA.examen;

import es.urjc.grafo.EDA.trees.Tree;
import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Comparator;

public class TreeOperations {

    public static <E> void printTree(Tree<E> t) {
        TreeOperations.auxPrintTree(t, t.root(), "");
    }

    private static <E> void auxPrintTree(Tree<E> t, Position<E> p, String prefix) {
        System.out.println(prefix + p.getElement());
        for (Position<E> ch : t.children(p)) {
            auxPrintTree(t, ch, prefix + "  ");
        }
    }

    /**
     * Verifica si un árbol binario cumple las propiedades de un montículo (heap):
     * 1. Propiedad de orden: Para cada nodo, su valor es menor o igual al de sus hijos según el comparador dado.
     * 2. Propiedad de estructura: El árbol está casi completo, es decir, todos los niveles están llenos
     * excepto posiblemente el último. En el último nivel, los nodos están lo más a la izquierda posible.
     * @param tree árbol binario a verificar
     * @param comparator comparador para definir el orden de los elementos
     * @param <E>
     * @return true si el árbol cumple las propiedades de un montículo, false en caso contrario
     */
    public static <E> boolean cumplePropiedadesMonticulo(BinaryTree<E> tree, Comparator<E> comparator) {
        // TODO
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
