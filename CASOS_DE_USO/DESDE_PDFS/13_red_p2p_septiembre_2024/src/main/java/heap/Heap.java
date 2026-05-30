package heap;

import java.util.*;


public class Heap<E> implements HeapInterface<E> {

    private static final int CAPACITY = 100;
    private ArrayList<E> heap;
    private Comparator<E> comparator;

    public Heap (){
        this(new DefaultComparator<>());
    }

    public Heap(Comparator<E> c){
        this(c, CAPACITY);
    }

    public Heap(int size){
        this(new DefaultComparator<>(), size);
    }

    public Heap(Comparator<E> comparator, int size){
        this.heap = new ArrayList<>(size);
        this.comparator = comparator;
    }

    // Returns the index of the parent
    // of the element at ith index.
    private int parent (int i){
        return (i - 1) / 2;
    }

    // Returns the index of the left child.
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    // Returns the index of the
    // right child.
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private boolean hasLeft(int i){
        return this.leftChild(i) < this.heap.size();
    }

    private boolean hasRight(int i){
        return this.rightChild(i) < this.heap.size();
    }

    //siftUp
    //move a node up in the tree, as long as needed; used to restore heap condition after insertion.
    private void siftUp(int i){
       while (i > 0){ // Mientras no llegue a la raiz
           int parent = this.parent(i);
           if (this.comparator.compare(this.heap.get(i), this.heap.get(parent)) < 0){
               this.swap(i, parent);
               i = parent;
           }
           else break;
       }
    }

    //siftDown
    //move a node down in the tree, similar to sift-up; used to restore heap condition after deletion or replacement.
    private void siftDown(int i){
        while (this.hasLeft(i)){
            // Get the smallest child
            int smallestIndex = leftChild(i);
            if (this.hasRight(i) && this.comparator.compare(
                    this.heap.get(smallestIndex),
                    this.heap.get(this.rightChild(i)))
                    > 0){
                smallestIndex = rightChild(i);
            }
            if (this.comparator.compare(
                    this.heap.get(smallestIndex),
                    this.heap.get(i))
                    < 0){
                this.swap(i, smallestIndex);
                i = smallestIndex;
            }
            else{
                break;
            }
        }
    }
       
    @Override
    public boolean add(E e) {
        this.heap.add(e);
        this.siftUp(this.heap.size() - 1);
        return true;
    }

    @Override
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @Override
    public Iterator<E> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<E>{

        private class WrappedComparator<T extends Map.Entry<E, Integer>> implements Comparator<T>{

            private Comparator<E> comparator = Heap.this.comparator;

            public int compare(T o1, T o2){
                return this.comparator.compare(o1.getKey(), o2.getKey());
            }

        }

        private Heap<Map.Entry<E, Integer>> auxHeap;
        private WrappedComparator<Map.Entry<E, Integer>> comparator;

        public HeapIterator(){
            this.comparator = new WrappedComparator<>();
            this.auxHeap = new Heap<>(this.comparator, heap.size());
            this.auxHeap.add(new AbstractMap.SimpleEntry<>(heap.get(0), 0));
        }

        @Override
        public boolean hasNext() {
            return this.auxHeap.size() > 0;
        }

        private Map.Entry<E, Integer> getLeft(Map.Entry<E, Integer> item){
            int indexLeftChild = 2 * item.getValue() + 1;
            if (indexLeftChild < heap.size()) {
                return new AbstractMap.SimpleEntry<>(heap.get(indexLeftChild), indexLeftChild);
            }
            else return null;
        }

        private Map.Entry<E, Integer> getRight(Map.Entry<E, Integer> item){
            int indexRightChild = 2 * item.getValue() + 2;
            if (indexRightChild < heap.size()) {
                return new AbstractMap.SimpleEntry<>(heap.get(indexRightChild), indexRightChild);
            }
            else return null;
        }

        @Override
        public E next() {
            Map.Entry<E, Integer> result = this.auxHeap.remove();
            Map.Entry<E, Integer> left = this.getLeft(result);
            Map.Entry<E, Integer> right = this.getRight(result);
            if (left != null){
                this.auxHeap.add(left);
            }
            if (right != null){
                this.auxHeap.add(right);
            }
            return result.getKey();
        }
    }

    @Override
    public E remove() {
        if (this.heap.isEmpty()){
            return null;
        }
        E result = this.heap.get(0);
        this.swap(0, this.heap.size() - 1);
        this.heap.remove(this.heap.size() - 1);
        this.siftDown(0);
        return result;
    }

    private void swap(int i, int j){
        E temp = this.heap.get(i);
        this.heap.set(i, this.heap.get(j));
        this.heap.set(j, temp);
    }

    @Override 
    public E peak(){
        return this.heap.get(0);
    }

    @Override
    public boolean isEmpty() {
	    return this.heap.isEmpty();
    }

    @Override
    public int size() {
        return this.heap.size();
    }

    @Override
    public void clear() {
        this.heap.clear();
    }
     
    
}
