import java.util.ArrayList;
import java.util.Arrays;

/**
 *  The class that tests the "MyLinkedList" class.
 */
public class TestMyLinkedList {

    // VARIABLES TO TEST MyLinkedList OF TYPE String
    /* the MyLinkedList<String> to be tested */
//    private static final MyLinkedList<String> list = new MyLinkedList<>();
    /* Default elements of MyLinkedList<String>*/
//    private static final String[] ELEMENTS = {"Zero", "One", "Two", "Three"};
//    private static final String FIRST_FOR_SET = "new first", LAST_FOR_SET = "new last", NO_EXIST_ELEMENT = "no_exist";
//    private static final String LAST = "LAST", SECOND = "SECOND";

    // VARIABLES TO TEST MyLinkedList OF TYPE Integer
    /* the MyLinkedList<Integer> to be tested */
    private static final MyLinkedList<Integer> list = new MyLinkedList<>();
    /* Default elements of MyLinkedList<Integer>*/
    private static final int[] ELEMENTS = {1, 2, 3, 4};
    private static final int FIRST_FOR_SET = 11, LAST_FOR_SET = 44, NO_EXIST_ELEMENT = -100;
    private static final int LAST = 111, SECOND = 222;

    // VARIABLES TO TEST MyLinkedList OF TYPE Double
    /* the MyLinkedList<Double> to be tested */
//    private static final MyLinkedList<Double> list = new MyLinkedList<>();
    /* Default elements of MyLinkedList<Double>*/
//    private static final double[] ELEMENTS = {1.1, 2.1, 3.2, 4.25};
//    private static final double FIRST_FOR_SET = 11.5, LAST_FOR_SET = 44.5, NO_EXIST_ELEMENT = -100.05;
//    private static final double LAST = 999.5, SECOND = 222.1;

    public static void main(String[] args) {
        ArrayList<String> result = new ArrayList<>();

        result.add(checkAdd());
        result.add(checkGetFirst());
        result.add(checkGetLast());
        result.add(checkClear());
        result.add(checkIsEmpty());
        result.add(checkSize());
        result.add(checkGet());
        result.add(checkAddWithIndex());
        result.add(checkSet());
        list.clear();
        addDefaultElements();
        result.add(checkRemove());
        result.add(checkContains());

        showResult(result);
    }

    /**
     * The method that checks the work of "add()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkAdd() {
        addDefaultElements();
        return forResult("add()", list.toString().equals(Arrays.toString(ELEMENTS)));
    }

    /**
     * The method that checks the work of "getFirst()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkGetFirst() {
        return forResult("getFirst()", list.getFirst().equals(ELEMENTS[0]));
    }

    /**
     * The method that checks the work of "getLast()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkGetLast() {
        return forResult("geLast()", list.getLast().equals(ELEMENTS[ELEMENTS.length - 1]));
    }

    /**
     * The method that checks the work of "clear()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkClear() {
        list.clear();
        return forResult("clear()", list.isEmpty());
    }

    /**
     * The method that checks the work of "isEmpty()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkIsEmpty() {
        list.clear();
        return forResult("isEmpty()", list.isEmpty());
    }

    /**
     * The method that checks the work of "size()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkSize() {
        list.clear();
        int currentSize = list.size();
        addDefaultElements();
        return forResult("size()", currentSize == 0 && list.size() == ELEMENTS.length);
    }

    /**
     * The method that checks the work of "get()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkGet() {
        return forResult("get(index)", (String.valueOf(list.get(0)).equals(String.valueOf(ELEMENTS[0]))
                && String.valueOf(list.get(1)).equals(String.valueOf(ELEMENTS[1]))
                && String.valueOf(list.get(ELEMENTS.length - 1)).equals(String.valueOf(ELEMENTS[ELEMENTS.length - 1]))
        ));
    }

    /**
     * The method that checks the work of "add(index)" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkAddWithIndex() {
        list.add(list.size(), LAST);
        list.add(1, SECOND);
        return forResult("add(by index)", (String.valueOf(list.getLast()).equals(String.valueOf(LAST))
                && String.valueOf(list.get(1)).equals(String.valueOf(SECOND))));
    }

    /**
     * The method that checks the work of "set()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkSet() {
        list.set(0, FIRST_FOR_SET);
        list.set(list.size() - 1, LAST_FOR_SET);
        return forResult("set()",
                (String.valueOf(list.getFirst()).equals(String.valueOf(FIRST_FOR_SET))
                        && String.valueOf(list.getLast()).equals(String.valueOf(LAST_FOR_SET))
                ));
    }

    /**
     * The method that checks the work of "remove()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkRemove() {
        String second = String.valueOf(list.get(2));
        int size = list.size();
        list.remove(2);
        return forResult("remove(index)",
                (!String.valueOf(list.get(2)).equals(second) && list.size() == size - 1));
    }

    /**
     * The method that checks the work of "contains()" method, the MyLinkedList class.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkContains() {
        return forResult("contains()",
                (list.contains(ELEMENTS[0]) && !list.contains(NO_EXIST_ELEMENT)));
    }

    /**
     * The method that fills the test object MyLinkedList with elements from the "ELEMENTS" array.
     */
    private static void addDefaultElements() {
        list.clear();
        for (int index = 0; index < ELEMENTS.length; index++) {
            list.add(ELEMENTS[index]);
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

    /**
     * The method that shows the results of the conducted tests.
     */
    private static void showResult(ArrayList<String> result) {
        for (String message : result) {
            System.out.println(message);
        }
    }
}
