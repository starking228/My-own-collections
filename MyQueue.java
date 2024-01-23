/**
 * The class that implements my Queue collection.
 *
 * @param <T> the data type that will store the MyQueue class object.
 */
public class MyQueue<T> extends MyLinkedList<T> {

    /**
     * The method which adds specified element to the MyQueue.
     *
     * @param element a T, the specified element.
     * @return a boolean, returns true if the addition was successful, false otherwise.
     */
    public boolean add(T element) {
        try {
            return super.add(element);
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Error while adding");
        }
    }

    /**
     * The method which adds specified element to the MyQueue.
     *
     * @param element a T, the specified element.
     * @return a boolean, returns true if the addition was successful, false otherwise.
     */
    public boolean offer(T element) {
        return super.add(element);
    }

    /**
     * The method that returns first element of the MyQueue.
     * @return a T, the first element of the MyQueue, if MyQueue is empty it throws a NoSuchElementException exception.
     */
    public T element() {
        return super.getFirst();
    }

    /**
     * The method that returns first element of the MyQueue.
     * @return a T, the first element of the MyQueue, if MyQueue is empty returns null.
     */
    public T peek() {
        if (super.isEmpty()) {
            return null;
        } else {
            return super.getFirst();
        }
    }

    /**
     * The method that remove first element from MyQueue and return it.
     * @return a T, the removed element from MyQueue, if MyQueue is empty it throws a outOfBoundsCheckIndex exception.
     */
    public T remove() {
        return super.remove(0);
    }

    /**
     * The method that remove first element from MyQueue and return it.
     * @return a T, the removed element from MyQueue, if MyQueue is empty returns null.
     */
    public T poll() {
        if (super.isEmpty()) {
            return null;
        } else {
            return super.remove(0);
        }
    }
}
