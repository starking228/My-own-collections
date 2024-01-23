import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * The class that implements my ArrayList collection.
 *
 * @param <T> the data type that will store the MyArrayList class object.
 */
public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;

    private int size = 0;

    /* simple constructor */
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * constructor with specified capacity.
     *
     * @param specifiedCapacity an integer, the specified capacity.
     */
    public MyArrayList(int specifiedCapacity) {
        if (specifiedCapacity <= 0) {
            throw new IllegalArgumentException("Minimum Capacity is equal to 1!");
        } else {
            elements = new Object[specifiedCapacity];
        }
    }

    private void moreCapacityIfNeeded() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    /**
     * The method which return the number of elements in list.
     *
     * @return an integer, the number of elements in list.
     */
    public int size() {
        return size;
    }

    /**
     * The method which checks if list is empty.
     *
     * @return a boolean, return true if list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * The method which add specified element to the list of elements.
     *
     * @param element a T, the element to be added.
     */
    public void add(T element) {
        moreCapacityIfNeeded();
        elements[size] = element;
        size++;
    }

    /**
     * The method which adds an element to the location at the specified index.
     *
     * @param index   an integer, the specified index.
     * @param element a T, the element to be added.
     */
    public void add(int index, T element) {
        Objects.checkIndex(index, size + 1);
        moreCapacityIfNeeded();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    /**
     * The method which returns the element at the specified index.
     *
     * @param index an integer, the specified index.
     * @return a T, the element to be returned.
     */
    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }

    /**
     * The method which get first element (element at index 0) if list is not empty.
     *
     * @return a T, the first element.
     */
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty!");
        }
        return (T) elements[0];
    }

    /**
     * The method which get last element if list is not empty.
     *
     * @return a T, the last element.
     */
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Array is empty!");
        }
        return (T) elements[size - 1];
    }

    /**
     * The method which set element at the specified index.
     *
     * @param index   an integer, the specified index.
     * @param element a T, the element to be setted.
     */
    public void set(int index, T element) {
        Objects.checkIndex(index, size);
        elements[index] = element;
    }

    /**
     * The method which removes the element at the specified index and returns that element.
     *
     * @param index an integer, the specified index.
     * @return a T, the element deleted item.
     */
    public T removeByIndex(int index) {
        Objects.checkIndex(index, size);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        return removedElement;
    }

    /**
     * The method which removes specified element.
     *
     * @param element a T, the specified element.
     * @return a T, the element deleted item.
     */
    public T removeByObject(T element) {
        return removeByIndex(indexOf(element));
    }

    /**
     * The method which determines whether the specified element is contained in the list of elements.
     *
     * @param element a T, the element that is being searched for in the list.
     * @return a boolean, return true if list contains specified element, false otherwise.
     */
    public boolean contains(T element) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The element which clears the list.
     */
    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * The element which returns the index of the first occurrence of the specified element.
     *
     * @param element a T, the specified element.
     * @return an integer, the index of the first occurrence of the specified element.
     */
    public int indexOf(T element) {
        for (int index = 0; index < size; index++) {
            if (elements[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * The method which returns the index of the last occurrence of the specified element.
     *
     * @param element a T, the specified element.
     * @return an integer, the index of the last occurrence of the specified element.
     */
    public int lastIndexOf(T element) {
        for (int index = size - 1; index >= 0; index--) {
            if (elements[index].equals(element)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * The method that returns all elements as a string.
     *
     * @return a String, the string containing all elements in the format "[element1, element2, ...]".
     */
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += elements[i];
            if (i < size - 1) {
                result += ", ";
            }
        }

        result += "]";
        return result;
    }

    /**
     * The method which returns an iterator for traversing the elements of MyArrayList.
     *
     * @return An iterator to traverse the elements of MyArrayList.
     */
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    /**
     * Inner class that implements the Iterator interface for traversing MyArrayList elements.
     */
    private class MyIterator implements Iterator<T> {
        private int index = 0;

        /**
         * Сhecks if the next element exists.
         *
         * @return a boolean, returns true if the next element exists, false if otherwise.
         */
        @Override
        public boolean hasNext() {
            return index < size;
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
            return (T) elements[index++];
        }
    }
}
