package es.urjc.grafo.EDA.examen;

        import es.urjc.grafo.EDA.trees.binaryTrees.BinaryTree;
        import es.urjc.grafo.EDA.utils.Position;

        import java.util.Iterator;
        import java.util.NoSuchElementException;

        public class LevelLimitedIterator<E> implements Iterator<Position<E>> {

            private final BinaryTree<E> tree;
private final int maxLevel;

            public LevelLimitedIterator(BinaryTree<E> tree, int maxLevel) {
                this.tree = tree;
    this.maxLevel = maxLevel;
            }

            @Override
            public boolean hasNext() {
                // TODO: preparar y consultar el siguiente nodo valido.
                throw new UnsupportedOperationException("TODO: hasNext en LevelLimitedIterator");
            }

            @Override
            public Position<E> next() {
                // TODO: devolver el siguiente nodo segun el recorrido indicado.
                throw new UnsupportedOperationException("TODO: next en LevelLimitedIterator");
            }

            @Override
            public void remove() {
                // TODO: si el enunciado lo pide, eliminar el ultimo nodo devuelto manteniendo el iterador consistente.
                throw new UnsupportedOperationException("TODO: remove en LevelLimitedIterator");
            }
        }
