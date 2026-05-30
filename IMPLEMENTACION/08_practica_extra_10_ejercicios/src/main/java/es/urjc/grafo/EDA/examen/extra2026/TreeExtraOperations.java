package es.urjc.grafo.EDA.examen.extra2026;

import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.trees.nAryTrees.NAryTree;
import es.urjc.grafo.EDA.utils.Position;

public class TreeExtraOperations {

    public static <E> boolean isAlmostComplete(LinkedBinaryTree<E> tree) {
        // TODO: comprueba la casi completitud mediante recorrido por niveles.
        throw new UnsupportedOperationException("TODO: isAlmostComplete");
    }

    public static <E> Position<E> lowestCommonAncestor(LinkedBinaryTree<E> tree,
                                                       Position<E> first,
                                                       Position<E> second) {
        // TODO: devuelve el ancestro comun mas bajo de first y second.
        throw new UnsupportedOperationException("TODO: lowestCommonAncestor");
    }

    public static <E> int width(NAryTree<E> tree) {
        // TODO: devuelve el maximo numero de nodos en un mismo nivel.
        throw new UnsupportedOperationException("TODO: width");
    }

    public static <E> Iterable<Position<E>> descendantsAtDistanceK(NAryTree<E> tree,
                                                                   Position<E> start,
                                                                   int k) {
        // TODO: devuelve descendientes de start exactamente a distancia k.
        throw new UnsupportedOperationException("TODO: descendantsAtDistanceK");
    }
}
