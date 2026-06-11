package es.urjc.grafo.EDA.examen.arboles.arboles_generales_avanzados;

import es.urjc.grafo.EDA.trees.Tree;
import es.urjc.grafo.EDA.trees.nAryTrees.LinkedTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.Collection;

public class GeneralTreeAdvancedOperations {

    public static <E> int height(Tree<E> tree) {
        // TODO: calcular la altura del arbol general.
        throw new UnsupportedOperationException("TODO: height");
    }

    public static <E> Collection<Position<E>> nodesAtDepth(Tree<E> tree, int depth) {
        // TODO: devolver las posiciones que estan exactamente a la profundidad indicada.
        throw new UnsupportedOperationException("TODO: nodesAtDepth");
    }

    public static <E> Iterable<Position<E>> pathToRoot(Tree<E> tree, Position<E> position) {
        // TODO: devolver el camino desde position hasta la raiz, incluyendo ambos extremos.
        throw new UnsupportedOperationException("TODO: pathToRoot");
    }

    public static <E> Position<E> lowestCommonAncestor(Tree<E> tree, Position<E> first, Position<E> second) {
        // TODO: buscar el ancestro comun mas bajo en un arbol general.
        throw new UnsupportedOperationException("TODO: lowestCommonAncestor");
    }

    public static <E> boolean areCousins(Tree<E> tree, Position<E> first, Position<E> second) {
        // TODO: comprobar misma profundidad y distinto padre.
        throw new UnsupportedOperationException("TODO: areCousins");
    }

    public static <E> boolean isPerfect(Tree<E> tree) {
        // TODO: comprobar hojas a la misma profundidad e internos con mismo grado.
        throw new UnsupportedOperationException("TODO: isPerfect");
    }

    public static <E> int levelWithMostNodes(Tree<E> tree) {
        // TODO: devolver el nivel con mayor numero de posiciones.
        throw new UnsupportedOperationException("TODO: levelWithMostNodes");
    }

    public static <E> int subtreeSize(Tree<E> tree, Position<E> position) {
        // TODO: contar position y todos sus descendientes.
        throw new UnsupportedOperationException("TODO: subtreeSize");
    }

    public static <E> int distance(Tree<E> tree, Position<E> first, Position<E> second) {
        // TODO: calcular la distancia entre dos posiciones usando el LCA o caminos a raiz.
        throw new UnsupportedOperationException("TODO: distance");
    }

    public static <E> Iterable<Position<E>> pathBetween(Tree<E> tree,
                                                        Position<E> first,
                                                        Position<E> second) {
        // TODO: devolver el camino completo entre first y second pasando por el LCA.
        throw new UnsupportedOperationException("TODO: pathBetween");
    }

    public static <E> int removeLeaves(LinkedTree<E> tree) {
        // TODO: eliminar todas las hojas del arbol general y devolver cuantas se eliminaron.
        throw new UnsupportedOperationException("TODO: removeLeaves");
    }

    public static <E> LinkedTree<E> copySubtree(Tree<E> tree, Position<E> root) {
        // TODO: crear una copia independiente del subarbol con raiz root.
        throw new UnsupportedOperationException("TODO: copySubtree");
    }

    public static <E, F> boolean isIsomorphic(Tree<E> first, Tree<F> second) {
        // TODO: comparar la forma de dos arboles generales ignorando valores.
        throw new UnsupportedOperationException("TODO: isIsomorphic");
    }
}
