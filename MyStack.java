/**
 * The class that implements my Stack collection.
 *
 * @param <T> the data type that will store the MyStack class object.
 */
public class MyStack<T> extends MyArrayList<T> {

    /**
     * The method which return the number of elements in MyStack.
     *
     * @return an integer, the number of elements in MyStack.
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * The method which checks if MyStack is empty.
     *
     * @return a boolean, return true if MyStack is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }


    /**
     * The method which removes the upper element from MyStack and returns that element.
     *
     * @return a T, the element deleted item.
     */
    public T pop() {
        int index = size() - 1;
        return removeByIndex(index);
    }

    /**
     * The method which add specified element to the MyStack.
     *
     * @param element a T, the element to be added.
     */
    public T push(T element) {
        add(element);
        return element;
    }

    /**
     * The method which returns the upper element from MyStack.
     *
     * @return a T, the upper element to be returned.
     */
    public T peek() {
        return get(size() - 1);
    }

    /**
     * The element which returns the index of the first occurrence of the specified element.
     *
     * @param element a T, the specified element.
     * @return an integer, the index of the first occurrence of the specified element.
     */
    public int search(T element) {
        return indexOf(element);
    }
}
