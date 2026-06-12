package es.urjc.grafo.EDA.examen.arbolesbinarios.metricas_y_recorridos_binarios;

import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
import es.urjc.grafo.EDA.trees.binaryTrees.LinkedBinaryTree;
import es.urjc.grafo.EDA.utils.Position;

import java.util.List;
import java.util.Map;

public class BinaryTreeTraversalOperations {

    public static <E> int height(BinaryTree<E> tree) {
        // TODO: calcular altura del arbol binario.
        throw new UnsupportedOperationException("TODO: height");
    }

    public static <E> int countLeaves(BinaryTree<E> tree) {
        // TODO: contar posiciones sin hijos.
        throw new UnsupportedOperationException("TODO: countLeaves");
    }

    public static <E, F> boolean hasSameShape(BinaryTree<E> first, BinaryTree<F> second) {
        // TODO: comparar estructura ignorando valores.
        throw new UnsupportedOperationException("TODO: hasSameShape");
    }

    public static <E> boolean isBalanced(BinaryTree<E> tree) {
        // TODO: comprobar balance de alturas en todos los nodos.
        throw new UnsupportedOperationException("TODO: isBalanced");
    }

    public static <E> int diameter(BinaryTree<E> tree) {
        // TODO: devolver la longitud del camino mas largo entre dos nodos.
        throw new UnsupportedOperationException("TODO: diameter");
    }

    public static <E> int width(BinaryTree<E> tree) {
        // TODO: devolver el maximo numero de nodos en un nivel.
        throw new UnsupportedOperationException("TODO: width");
    }

    public static <E> Iterable<Position<E>> nodesAtLevel(BinaryTree<E> tree, int level) {
        // TODO: devolver posiciones situadas en el nivel indicado.
        throw new UnsupportedOperationException("TODO: nodesAtLevel");
    }

    public static <E> Iterable<Position<E>> nodesAtDistanceK(BinaryTree<E> tree,
                                                             Position<E> target,
                                                             int k) {
        // TODO: devolver posiciones a distancia exactamente k del nodo target.
        throw new UnsupportedOperationException("TODO: nodesAtDistanceK");
    }

    public static <E> Iterable<E> zigZagTraversal(BinaryTree<E> tree) {
        // TODO: recorrido por niveles alternando izquierda-derecha y derecha-izquierda.
        throw new UnsupportedOperationException("TODO: zigZagTraversal");
    }

    public static <E> Map<Integer, List<E>> verticalOrder(BinaryTree<E> tree) {
        // TODO: agrupar elementos por coordenada horizontal.
        throw new UnsupportedOperationException("TODO: verticalOrder");
    }

    public static <E> Iterable<E> pathToNode(BinaryTree<E> tree, E value) {
        // TODO: devolver camino de raiz al primer nodo con value mediante backtracking.
        throw new UnsupportedOperationException("TODO: pathToNode");
    }

    public static <E> Position<E> lowestCommonAncestor(BinaryTree<E> tree, Position<E> first, Position<E> second) {
        // TODO: devolver ancestro comun mas bajo en arbol binario.
        throw new UnsupportedOperationException("TODO: lowestCommonAncestor");
    }

    public static <E> boolean isSubtree(BinaryTree<E> tree, BinaryTree<E> candidate) {
        // TODO: comprobar si candidate aparece dentro de tree con la misma forma y los mismos valores.
        throw new UnsupportedOperationException("TODO: isSubtree");
    }

    public static <E> int pruneBelowDepth(LinkedBinaryTree<E> tree, int maxDepth) {
        // TODO: eliminar todos los nodos situados a profundidad mayor que maxDepth.
        throw new UnsupportedOperationException("TODO: pruneBelowDepth");
    }

    public static <E> void mirror(BinaryTree<E> tree) {
        // TODO: convertir el arbol en su espejo si la implementacion permite modificar enlaces.
        throw new UnsupportedOperationException("TODO: mirror");
    }
}
