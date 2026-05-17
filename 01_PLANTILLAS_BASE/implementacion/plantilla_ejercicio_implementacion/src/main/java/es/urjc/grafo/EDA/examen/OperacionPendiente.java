package es.urjc.grafo.EDA.examen;

public interface OperacionPendiente<E> {
    boolean add(E element);
    int size();
}
