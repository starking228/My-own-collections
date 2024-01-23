import java.util.ArrayList;

/**
 *  The class that tests the "MyQueue" class.
 */
public class TestMyQueue {
    // VARIABLES TO TEST MyArrayList OF TYPE String
    /* the MyQueue<String> to be tested */
//    private static final MyQueue<String> list = new MyQueue<>();
    /* Default elements of MyQueue<String>*/
//    private static final String[] ELEMENTS = {"Zero", "One", "Two", "Three"};

    // VARIABLES TO TEST MyArrayList OF TYPE Integer
    /* the MyQueue<Integer> to be tested */
//    private static final MyQueue<Integer> list = new MyQueue<>();
    /* Default elements of MyQueue<Integer>*/
//    private static final int[] ELEMENTS = {1,2,3,4};

    // VARIABLES TO TEST MyArrayList OF TYPE Double
    /* the MyQueue<Double> to be tested */
    private static final MyQueue<Double> list = new MyQueue<>();
    /* Default elements of MyQueue<Double>*/
    private static final double[] ELEMENTS = {1.1,2.2,3.3,4.4};

    /* size of the default elements array */
    private static final int ELEMENTS_SIZE = ELEMENTS.length;

    public static void main(String args[]) {
        ArrayList<String> result = new ArrayList<>();

        result.add(checkAdd());
        result.add(checkOffer());
        result.add(checkPeek());
        addDefaultElement();
        result.add(checkElement());
        result.add(checkRemove());
        result.add(checkPoll());


        showResult(result);
    }

    /**
     * The method that checks the work of "add()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkAdd() {
        addDefaultElement();
        return forResult("add()", !list.isEmpty());
    }

    /**
     * The method that checks the work of "offer()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkOffer() {
        list.clear();
        ArrayList<String> isCorrect = new ArrayList<>();
        for (int index = 0; index < ELEMENTS_SIZE; index++) {
            isCorrect.add(String.valueOf(list.offer(ELEMENTS[index])));
        }
        return forResult("offer()", (!list.isEmpty()) && !isCorrect.contains("false"));
    }

    /**
     * The method that checks the work of "peek()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkPeek() {
        String first = String.valueOf(list.peek());
        list.clear();
        String firstNull = String.valueOf(list.peek());
        return forResult("peek()", (first.equals(String.valueOf(ELEMENTS[0])) && firstNull.equals("null")));
    }

    /**
     * The method that checks the work of "element()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkElement() {
        return forResult("element()", list.element().equals(ELEMENTS[0]));
    }

    /**
     * The method that checks the work of "remove()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkRemove() {
        String removed = String.valueOf(ELEMENTS[0]);
        return forResult("remove()", (String.valueOf(list.remove()).equals(removed) && !list.contains(ELEMENTS[0])));
    }

    /**
     * The method that checks the work of "poll()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkPoll() {
        String element = String.valueOf(list.poll());
        list.clear();
        return forResult("poll()", element.equals(String.valueOf(ELEMENTS[1])) && list.poll() == null);
    }

    /**
     * The method that fills the test object MyArrayList with elements from the "ELEMENTS" array.
     */
    private static void addDefaultElement() {
        list.clear();
        for (int index = 0; index < ELEMENTS_SIZE; index++) {
            list.add(ELEMENTS[index]);
        }
    }

    /**
     * The method that shows the results of the conducted tests.
     */
    private static void showResult(ArrayList<String> result) {
        for (String message : result) {
            System.out.println(message);
        }
    }

    /**
     * The method that generates and returns a message about the correctness of the tested method.
     * @param method a String, the name of the tested method.
     * @param isCorrect a boolean, the boolean that shows correctness of the tested method.
     * @return a String, the String message about the correctness of the tested method.
     */
    private static String forResult(String method, boolean isCorrect) {
        return (isCorrect) ? "Work of the " + method + " method is correct"
                : "Work of the " + method + " method is incorrect";
    }
}
