import java.util.ArrayList;
import java.util.Arrays;

/**
 *  The class that tests the "MyStack" class.
 */
public class TestMyStack {

    // VARIABLES TO TEST MyStack OF TYPE String
    /* the MyStack<String> to be tested */
//    private static final MyStack<String> stack = new MyStack<>();
    /* Default elements of MyStack<String> */
//    private static final String[] ELEMENTS = {"Zero", "One", "Two", "Three"};

    // VARIABLES TO TEST MyStack OF TYPE Integer
    /* the MyStack<Integer> to be tested */
    private static final MyStack<Integer> stack = new MyStack<>();
    /* Default elements of MyStack<Integer> */
    private static final int[] ELEMENTS = {1, 2, 99, 0, -5};

    // VARIABLES TO TEST MyStack OF TYPE Double
    /* the MyStack<Double> to be tested */
//    private static final MyStack<Double> stack = new MyStack<>();
//    /* Default elements of MyStack<Double> */
//    private static final double[] ELEMENTS = {1, 2, 99, 0, -5};

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();
        result.add(checkPush());
        result.add(checkPeek());
        result.add(checkSize());
        result.add(checkPop());
        stack.add(ELEMENTS[2]);
        result.add(checkSearch());
        result.add(checkIsEmpty());
        showResult(result);
    }

    /**
     * The method that checks the work of "push()" method, the MyStack class.
     * @return a String, the String message about correctness of tested method.
     */
    private static String checkPush() {
        boolean isCorrect = true;
        for (int index = 0; index < ELEMENTS.length; index++) {
            String addedElement = String.valueOf(stack.push(ELEMENTS[index]));
            if (!addedElement.equals(String.valueOf(ELEMENTS[index]))) {
                isCorrect = false;
            }
        }
        return forResult("push()", stack.toString().equals(Arrays.toString(ELEMENTS)) && isCorrect);
    }

    /**
     * The method that checks the work of "peek()" method, the MyStack class.
     * @return a String, the String message about correctness of tested method.
     */
    private static String checkPeek() {
        return forResult("peek()", stack.peek().equals(ELEMENTS[ELEMENTS.length - 1]));
    }

    /**
     * The method that checks the work of "size()" method, the MyStack class.
     * @return a String, the String message about correctness of tested method.
     */
    private static String checkSize() {
        int firstsize = stack.size();
        int length = ELEMENTS.length;
        stack.removeByObject(ELEMENTS[length - 1]);
        return forResult("size()", firstsize == length && stack.size() == length - 1);
        }

    /**
     * The method that checks the work of "pop()" method, the MyStack class.
     * @return a String, the String message about correctness of tested method.
     */
    private static String checkPop() {
        String removedElement = "" + stack.pop();
        int currentLength = ELEMENTS.length - 2;
        return forResult("pop()", removedElement.equals(String.valueOf(ELEMENTS[currentLength])) && stack.size() == currentLength);
    }

    /**
     * The method that checks the work of "search()" method, the MyStack class.
     * @return a String, the String message about correctness of tested method.
     */
    private static String checkSearch() {
        return forResult("search()", stack.search(ELEMENTS[0]) == 0 && stack.search(ELEMENTS[2]) == 2);
    }

    /**
     * The method that checks the work of "isEmpty()" method, the MyStack class.
     * @return a String, the String message about correctness of tested method.
     */
    private static String checkIsEmpty() {
        boolean current = stack.isEmpty();
        // remove all element
        stack.clear();
        return forResult("isEmpty()", !current && stack.isEmpty());
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

    /**
     * The method that shows the results of the conducted tests.
     */
    private static void showResult(ArrayList<String> result) {
        for (String message : result) {
            System.out.println(message);
        }
    }
}
