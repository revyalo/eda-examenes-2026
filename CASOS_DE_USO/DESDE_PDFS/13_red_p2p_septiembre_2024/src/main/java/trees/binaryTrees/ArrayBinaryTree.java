package trees.binaryTrees;

import utils.Position;

import java.util.*;

/**
 *
 * @author mayte
 */
public class ArrayBinaryTree<E> implements BinaryTree<E> {

    private static final int CAPACITY = 100;
    private BTPos<E>[] elements;
    private int size;

    private class BTPos<E> implements Position<E> {

        private E element;
        private int index;

        public BTPos(E element, int index) {
            this.element = element;
            this.index = index;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public E getElement() {
            return element;
        }
    }

    public ArrayBinaryTree() {
        this(CAPACITY);
    }

    public ArrayBinaryTree(int capacity) {
        this.elements = new BTPos[capacity];
        this.size = 0;
    }

    private BTPos<E> checkPosition(Position<E> p){
        if (!(p instanceof BTPos)) {
            throw new RuntimeException("The position is invalid");
        }
        return (BTPos<E>) p;
    }

    @Override
    public Position<E> left(Position<E> v) {
        if (!this.hasLeft(v)){
            throw new RuntimeException("No left child");
        }
        BTPos<E> node = checkPosition(v);
        return this.elements[2 * node.getIndex() + 1];
    }

    @Override
    public Position<E> right(Position<E> v) {
        if (!this.hasRight(v)){
            throw new RuntimeException("No right child");
        }
        BTPos<E> node = checkPosition(v);
        return this.elements[2 * node.getIndex() + 2];
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTPos<E> node = checkPosition(v);
        return 2 * node.getIndex() + 1 < this.elements.length && this.elements[2 * node.getIndex() + 1] != null;
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTPos<E> node = checkPosition(v);
        return 2 * node.getIndex() + 2 < this.elements.length && this.elements[2 * node.getIndex() + 2] != null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !this.isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        return !this.hasLeft(p) && !this.hasRight(p);
    }

    @Override
    public boolean isRoot(Position<E> p) {
        BTPos<E> node = this.checkPosition(p);
        return node == this.elements[0];
    }

    @Override
    public Position<E> root() {
        if (this.elements[0] == null) {
            throw new NoSuchElementException();
        }
        return this.elements[0];
    }

    @Override
    public E replace(Position<E> p, E e) {
        BTPos<E> node = this.checkPosition(p);
        E replaced = node.getElement();
        node.setElement(e);
        return replaced;
    }

    @Override
    public Position<E> sibling(Position<E> p) {
        BTPos<E> node = this.checkPosition(p);
        if (this.hasLeft(this.parent(p)) && this.left(this.parent(p)) == p){
            if (this.hasRight(this.parent(p))){
                return this.right(this.parent(p));
            }
            else{
                throw new NoSuchElementException();
            }
        }
        else if (this.hasRight(this.parent(p)) && this.right(this.parent(p)) == p){
            if (this.hasLeft(this.parent(p))){
                return this.left(this.parent(p));
            }
            else{
                throw new NoSuchElementException();
            }
        }
        else{
            throw new RuntimeException();
        }
    }

    @Override
    public Position<E> addRoot(E e) {
        if (this.elements[0] == null) {
            this.elements[0] = new BTPos<>(e, 0);
            return this.root();
        }
        throw new RuntimeException("There is already a root");
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        BTPos<E> node = this.checkPosition(p);
        if (this.hasLeft(node)) {
            throw new RuntimeException("Cannot insert a left child, there is already a left child");
        }
        BTPos<E> newNode = new BTPos<>(e, 2 * node.getIndex() + 1);
        this.resizeIfNecessary(newNode.getIndex());
        this.elements[2 * node.getIndex() + 1] = newNode;
        return newNode;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        BTPos<E> node = this.checkPosition(p);
        if (this.hasRight(node)) {
            throw new RuntimeException("Cannot insert a right child, there is already a right child");
        }
        BTPos<E> newNode = new BTPos<>(e, 2 * node.getIndex() + 2);
        this.resizeIfNecessary(newNode.getIndex());
        this.elements[2 * node.getIndex() + 2] = newNode;
        return newNode;
    }

    private void resizeIfNecessary(int index){
        if (this.elements.length <= index + 1) {
            int newLength = this.elements.length * 2;
            while (newLength < index + 1) {
                newLength *= 2;
            }
            BTPos<E>[] newElements = new BTPos[newLength];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            this.elements = newElements;
        }
    }

    @Override
    public E remove(Position<E> p) {
        if (this.hasLeft(p) || this.hasRight(p)) {
            throw new RuntimeException("Has children, so I cannot remove");
        }
        BTPos<E> node = this.checkPosition(p);
        this.elements[node.getIndex()] = null;
        return node.getElement();
    }

    public E cut(Position<E> p) {
        BTPos<E> node = this.checkPosition(p);

        this.recursiveRemove(node);

        return node.getElement();
    }

    private void recursiveRemove(Position<E> p){
        if (this.hasLeft(p)){
            recursiveRemove(this.left(p));
        }
        if (this.hasRight(p)){
            recursiveRemove(this.right(p));
        }
        this.elements[((BTPos<E>) p).getIndex()] = null;
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        BTPos<E> node1 = this.checkPosition(p1);
        BTPos<E> node2 = this.checkPosition(p2);
        int index1 = node1.getIndex();
        int index2 = node2.getIndex();
        E elementTemp = node1.getElement();
        this.elements[index1].setElement(node2.getElement());
        this.elements[index2].setElement(elementTemp);
    }

    @Override
    public boolean isEmpty() {
        return this.elements[0] == null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        BTPos<E> node = this.checkPosition(v);
        if (this.isRoot(node)) {
            throw new RuntimeException("Root has no parent");
        }
        return this.elements[(int) Math.floor( (double) (node.getIndex() - 1) / 2 )];
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        BTPos<E> node = this.checkPosition(v);
        List<Position<E>> children = new ArrayList<>(2);
        if (this.hasLeft(node) || this.hasRight(node)) {
            if (this.hasLeft(node)) {
                children.add(this.left(node));
            }
            if (this.hasRight(node)) {
                children.add(this.right(node));
            }
        }
        return children;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new InorderBinaryTreeIterator<>(this);
    }

    @Override
    public void attachLeft(Position<E> h, BinaryTree<E> t1) {
        if (this.hasLeft(h)) {
            throw new RuntimeException("Cannot attach a left child, there is already a left child");
        }
        Position<E> root = this.insertLeft(h, t1.root().getElement());
        this.attachRecursive(root, t1, t1.root());
    }

    private void attachRecursive(Position<E> positionTree, BinaryTree<E> subtree, Position<E> positionSubtree) {
        if (subtree.hasLeft(positionSubtree)) {
            this.insertLeft(positionTree, subtree.left(positionSubtree).getElement());
            this.attachRecursive(this.left(positionTree), subtree, subtree.left(positionSubtree));
        }
        if (subtree.hasRight(positionSubtree)) {
            this.insertRight(positionTree, subtree.right(positionSubtree).getElement());
            this.attachRecursive(this.right(positionTree), subtree, subtree.right(positionSubtree));
        }
    }

    @Override
    public void attachRight(Position<E> h, BinaryTree<E> t1) {
        if (this.hasRight(h)) {
            throw new RuntimeException("Cannot attach a right child, there is already a right child");
        }
        Position<E> root = this.insertRight(h, t1.root().getElement());
        this.attachRecursive(root, t1, t1.root());
    }

    @Override
    public BinaryTree<E> subTree(Position<E> h) {
        BTPos<E> node = this.checkPosition(h);
        BinaryTree<E> subtree = new ArrayBinaryTree<>(); // Podriamos calcular la altura maxima del nuevo subarbol considerando la profundidad del nodo a partir del cual vamos a obtener el subarbol y la altura del arbol actual para construir el nuevo subarbol con la capacidad adecuada.
        subtree.addRoot(node.getElement());
        Queue<BTPos<E>> nodesQueue = new LinkedList<>();
        Queue<BTPos<E>> subTreeNodesQueue = new LinkedList<>();
        subTreeNodesQueue.add((BTPos<E>) subtree.root());
        nodesQueue.add(node);
        while (!nodesQueue.isEmpty()) {
            BTPos<E> currentParent = nodesQueue.poll();
            BTPos<E> currentParentInSubtree = subTreeNodesQueue.poll();
            if (this.hasLeft(currentParent)) {
                BTPos<E> inserted = (BTPos<E>) subtree.insertLeft(currentParentInSubtree, this.left(currentParent).getElement());
                nodesQueue.add((BTPos<E>) this.left(currentParent));
                subTreeNodesQueue.add(inserted);
            }
            if (this.hasRight(currentParent)) {
                BTPos<E> inserted = (BTPos<E>) subtree.insertRight(currentParentInSubtree, this.right(currentParent).getElement());
                nodesQueue.add((BTPos<E>) this.right(currentParent));
                subTreeNodesQueue.add(inserted);
            }
        }

        return subtree;
    }
    
}
