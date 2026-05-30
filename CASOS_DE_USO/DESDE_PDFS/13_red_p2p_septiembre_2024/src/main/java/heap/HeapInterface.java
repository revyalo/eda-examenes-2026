package heap;

import java.util.Comparator;
import java.util.Iterator;



/**
 *
 * @author mayte
 * @param <E>
 */
public interface HeapInterface<E> {
    /**
     * Inserts the specified element into this Heap
     * @param e
     * @return true if the element is correctly added
     */
    public boolean add(E e);
    
    /**
     * Returns the comparator used to order the elements in this heap.
     * @return the comparator used to order the elements in this heap
     */
    public Comparator<? super E> comparator();
    
    /**
     * Returns an iterator over the elements in this heap. 
     * The iterator does not return the elements in any particular order.
     * @return an iterator over the elements in this heap
     */
    public Iterator<E> iterator();
    
    /**
     * Retrieves and removes the top of the heap. 
     * @return the element at the top
     */
    public E remove();
    
    /**
     * Retrieves but does not remove the top of the heap
     * @return the element at the top
     */
    public E peak();
    
    /**
     * @return true if the heap is empty, false in other case
     */
    public boolean isEmpty();
    
    /**
     * 
     * @return the number of elements in the heap
     */
    public int size();
    
    /**
     * Removes all of the elements from this priority queue.
     */
    public void clear();
}
