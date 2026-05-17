package es.urjc.grafo.EDA.mapas;

import es.urjc.grafo.EDA.utils.Pair;

public class MapaDireccionamientoAbiertoLineal2026<K, V> extends AbstractMapaDireccionamientoAbierto<K, V> {

    public MapaDireccionamientoAbiertoLineal2026() {
        super();
    }

    public MapaDireccionamientoAbiertoLineal2026(int capacity) {
        super(capacity);
    }

    public MapaDireccionamientoAbiertoLineal2026(int capacity, double loadFactor) {
        super(capacity, loadFactor);
    }

    @Override
    protected Pair<Boolean, Integer> findEntry(K key) {
        // TODO: implementar búsqueda con prueba lineal.
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    protected void rehash(int desiredCapacity) {
        // TODO: crear una tabla nueva y reinsertar únicamente entradas activas.
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
