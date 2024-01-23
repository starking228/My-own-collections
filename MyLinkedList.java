import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * The class that implements my LinkedList collection.
 *
 * @param <T> the data type that will store the MyLinkedList class object.
 */
public class MyLinkedList<T> implements Iterable<T> {

    /* The first node at the MyLinkedList */
    private Node<T> head;
    /* The last node at the MyLinkedList */
    private Node<T> tail;

    /* The size of the MyLinkedList */
    private int size;

    /**
     * The method which returns element at the specified index.
     *
     * @param index an integer, the specified index.
     * @return a Node<T>, the element at the specified index.
     */
    private Node<T> findNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * The inner class which implements a node for a MyLinkedList.
     *
     * @param <T> The type of data that will be stored in the node.
     */
    public static class Node<T> {

        /* The data stored in the node */
        T element;
        /* A reference to the next node in the MyLinkedList */
        Node<T> next;
        /* A reference to the previous node in the MyLinkedList. */
        Node<T> previous;

        /**
         * The constructor that creates a new node with a given element.
         *
         * @param element a T, the element that will be stored in the node.
         */
        public Node(T element) {
            this.element = element;
        }

    }

    /**
     * The method which checks if MyLinkedList is empty.
     *
     * @return a boolean, return true if MyLinkedList is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        String result = "[";
        Node<T> current = head;
        while (current != null) {
            result += current.element;
            if (current.next != null) {
                result += ", ";
            }
            current = current.next;
        }
        result += "]";
        return result;
    }


    /**
     * The method which return the number of elements in MyLinkedList.
     *
     * @return an integer, the number of elements in MyLinkedList.
     */
    public int size() {
        return size;
    }

    /**
     * The method which adds specified element to the tail of MyLinkedList.
     *
     * @param element a T, the specified element.
     * @return a boolean, returns true if the addition was successful, false otherwise.
     */
    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    /**
     * The method which adds the specified element to the specified place in the MyLinkedList (by index).
     *
     * @param index   an integer, the specified index.
     * @param element a T, the specified element.
     */
    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = new Node<>(element);
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
            head.next.previous = head;
        } else if (index == size) {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<T> beforeNewNode = findNode(index - 1);
            newNode.next = beforeNewNode.next;
            newNode.previous = beforeNewNode;
            beforeNewNode.next = newNode;
            newNode.next.previous = newNode;
        }
        size++;
    }

    /**
     * The method sets the specified element to the specified node (by index).
     *
     * @param index   an integer, the specified index.
     * @param element a T, the specified element.
     */
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        findNode(index).element = element;
    }

    /**
     * The method which returns element at the specified node (by index).
     *
     * @param index an integer, the specified index.
     * @return a T, the element that stored at specified node by index.
     */
    public T get(int index) {
        Objects.checkIndex(index, size);
        return findNode(index).element;
    }

    /**
     * The method which return the first element at the MyLinkedList.
     *
     * @return a T, the first element at the MyLinkedList.
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        } else {
            return head.element;
        }
    }

    /**
     * The method which return the last element at the MyLinkedList.
     *
     * @return a T, the last element at the MyLinkedList.
     */
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        } else {
            return tail.element;
        }
    }

    /**
     * The method which remove node by specified index from the MyLinkedList.
     *
     * @param index an integer, the specified index.
     * @return a T, the removed element.
     */
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = head.element;
            head = head.next;
            head.previous = null;
            if (head == null) {
                tail = null;
            }
        } else if (index == size - 1) {
            removedElement = tail.element;
            tail = tail.previous;
            tail.next = null;
        } else {
            Node<T> beforeNewNode = findNode(index - 1);
            removedElement = beforeNewNode.next.element;
            beforeNewNode.next.next.previous = beforeNewNode;
            beforeNewNode.next = beforeNewNode.next.next;

        }
        size--;
        return removedElement;
    }

    /**
     * The method which determines whether the specified element is contained in the MyLinkedList.
     *
     * @param element a T, the element that is being searched for in the MyLinkedList.
     * @return a boolean, return true if MyLinkedList contains specified element, false otherwise.
     */
    public boolean contains(T element) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.element.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * The element which clears the MyLinkedList.
     */
    public void clear() {
        head = tail = null;
        size = 0;
    }

    /**
     * The method which returns an iterator for traversing the elements of MyLinkedList.
     *
     * @return An iterator to traverse the elements of MyArrayList.
     */
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    /**
     * Inner class that implements the Iterator interface for traversing MyLinkedList elements.
     */
    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        /**
         * Сhecks if the next element exists.
         *
         * @return a boolean, returns true if the next element exists, false if otherwise.
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * The method which returns the next element.
         *
         * @return a T, the next element.
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.element;
            current = current.next;
            return data;
        }
    }
}
