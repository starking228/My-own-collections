
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 */
public class MyLinkedListOneWay<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private Node<T> findNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public static class Node<T> {

        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public boolean add(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return true;
    }

    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = new Node<>(element);
        } else if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<T> beforeNewNode = findNode(index - 1);
            newNode.next = beforeNewNode.next;
            beforeNewNode.next = newNode;
        }
        size++;
    }

    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        findNode(index).element = element;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return findNode(index).element;
    }

    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        } else {
            return head.element;
        }
    }

    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        } else {
            return tail.element;
        }
    }

    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement;
        if (index == 0) {
            removedElement = head.element;
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node<T> beforeNewNode = findNode(index - 1);
            removedElement = beforeNewNode.next.element;
            beforeNewNode.next = beforeNewNode.next.next;
            if (index == size - 1) {
                tail = beforeNewNode;
            }
        }
        size--;
        return removedElement;
    }

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

    public void clear() {
        head = tail = null;
        size = 0;
    }
}
