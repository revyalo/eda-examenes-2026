package heap;

import java.util.Comparator;



/**
 *
 * @author mayte
 * @param <T>
 */
public class DefaultComparator<T> implements Comparator<T> {

    /**
     * Compares two given elements
     *
     * @param o1
     * @param o2
     * @return a negative integer if o1 is less than o2, zero if
     * o1 equals o2, or a positive integer if
     * o1 is greater than o2
     */
    @Override
    public int compare(T o1, T o2) {
        return ((Comparable<T>)o1).compareTo(o2);
    }
    
}
