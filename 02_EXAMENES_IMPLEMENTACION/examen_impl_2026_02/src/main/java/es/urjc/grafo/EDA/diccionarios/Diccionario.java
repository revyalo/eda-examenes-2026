package es.urjc.grafo.EDA.diccionarios;

import es.urjc.grafo.EDA.mapas.MapaEncadenamientoSeparado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * A dictionary behaves similarly to a map, but allows multiple entries with the same key.
 *
 * @param <K>
 * @param <V>
 */
public class Diccionario<K, V> extends MapaEncadenamientoSeparado<K, V> implements Dictionary<K, V> {

    /**
     * Añade una nueva entrada al diccionario.
     * Si ya existe una entrada con la clave dada, se añade una nueva entrada sin eliminar la anterior.
     * El valor devuelto es siempre null y se puede ignorar.
     * En realidad, este método no necesita devolver nada.
     * Sin embargo, por no sobrecomplicar la jerarquía de clases,
     * se mantiene el mismo prototipo que en la interfaz Mapa
     * y aprovechamos la implementación de MapaEncadenamientoSeparado.
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key, V value) {
        ArrayList<MapEntry<K, V>> bucket = this.table[hashValue(key)];
        if (bucket == null) {
            bucket = new ArrayList<>();
            this.table[hashValue(key)] = bucket;
        }
        size++;
        bucket.add(new MapEntry<>(key, value));
        if (this.needToResize()) {
            this.rehash(this.table.length * 2);
        }
        return null;
    }

    /**
     * Elimina una entrada con la clave dada.
     * Si hay varias entradas con la misma clave, se elimina una de ellas (cualquiera).
     * Si no hay ninguna entrada con dicha clave, no se hace nada y se devuelve null.
     * El valor devuelto es el valor asociado a la entrada eliminada,
     * o null si no se ha eliminado ninguna entrada.
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) {
        return super.remove(key);
    }

    /**
     * Elimina todas las entradas con la clave dada.
     * Devuelve un Iterable con todos los valores asociados a las entradas eliminadas.
     *
     * @param key la clave cuyas entradas se desean eliminar
     * @return un Iterable con los valores de las entradas eliminadas
     */
    public Iterable<V> removeAll(K key) {
        ArrayList<MapEntry<K, V>> bucket = this.table[hashValue(key)];
        ArrayList<V> removedValues = new ArrayList<>();
        if (bucket == null){
            return removedValues;
        }
        Iterator<MapEntry<K, V>> iterator = bucket.iterator();
        while(iterator.hasNext()){
            MapEntry<K, V> entry = iterator.next();

            if(entry.getKey().equals(key)){
                removedValues.add(entry.getValue());
                iterator.remove();
                this.size--;
            }

        }

        return removedValues;

    }

    /**
     * Devuelve un Iterable que contiene todos los valores asociados a la clave key.
     *
     * @param key used in the search
     * @return un Iterable con todos los valores asociados a la clave key
     */
    @Override
    public Iterable<V> getAll(K key) {
        ArrayList<MapEntry<K, V>> bucket = this.table[hashValue(key)];
        return new BucketKeyValuesIterable(bucket, key);

    }

    @Override
    public Iterator<Map.Entry<K, V>> iterator() {
        return new EntryIterator();
    }

    private class BucketKeyValuesIterable implements Iterable<V> {

        private final ArrayList<MapEntry<K, V>> bucket;
        private final K key;


        public BucketKeyValuesIterable(ArrayList<MapEntry<K, V>> bucket, K key) {
            this.bucket = bucket;
            this.key = key;
        }

        @Override
        public Iterator<V> iterator() {
            return new BucketKeyValuesIterator(this.bucket, this.key);
        }
    }

    private class BucketKeyValuesIterator implements Iterator<V> {

        private final Iterator<MapEntry<K, V>> iterador;
        private final K key;
        private MapEntry<K, V> next;




        public BucketKeyValuesIterator(ArrayList<MapEntry<K, V>> bucket, K key) {
            this.key = key;

            if(bucket != null){
                this.iterador = bucket.iterator();
                findNext();

            }else{
                this.iterador = null;
                this.next = null;
            }
        }

        private void findNext(){
            if(iterador == null){
                this.next = null;
                return;
            }

            while(iterador.hasNext()){
                MapEntry<K, V> entrada = iterador.next();
                if(entrada.getKey().equals(this.key)){
                    this.next = entrada;
                    return;
                }
            }
            this.next = null;
        }

        @Override
        public boolean hasNext() {
            return this.next != null;
        }

        @Override
        public V next() {
            if (!hasNext()){
                throw new NoSuchElementException("No hay elementos");
            }

            V value = this.next.getValue();

            findNext();

            return value;
        }
    }

}
