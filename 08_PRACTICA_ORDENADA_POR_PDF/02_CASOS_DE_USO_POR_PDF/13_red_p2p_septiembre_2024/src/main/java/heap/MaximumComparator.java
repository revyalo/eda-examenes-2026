package heap;

import java.util.Comparator;

public class MaximumComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return -1 * ((Comparable<T>)o1).compareTo(o2);
    }
}
