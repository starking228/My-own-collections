import java.util.ArrayList;
import java.util.Arrays;

/**
 *  The class that tests the "MyArrayList" class.
 */
public class TestArrayList {
    // VARIABLES TO TEST MyArrayList OF TYPE String
    /* the MyArrayList<String> to be tested */
    private static final MyArrayList<String> arrayList = new MyArrayList<String>();
    /* Default elements of MyArrayList<String>*/
    private static final String[] ELEMENTS = {"Zero", "One", "Two", "Three"};
    /* an element that is not contained in the array of default elements, to be added to MyArrayList<String> */
    private static final String NEW_ELEMENT = "newZero";
    /* an element that is not contained in MyArrayList<String> to test the Contains method */
    private static final String NOT_EXIST_ELEMENT = "notExistElement";

    // VARIABLES TO TEST MyArrayList OF TYPE Double
    /* the MyArrayList<Double> to be tested */
//    private static final MyArrayList<Double> arrayList = new MyArrayList<Double>();
    /* Default elements of MyArrayList<Double>*/
//    private static final double[] ELEMENTS = {30, -1.5, 0.1, 22.0, 88};
    /* an element that is not contained in the array of default elements, to be added to MyArrayList<Double> */
//    private static final double NEW_ELEMENT = 20.25;
    /* an element that is not contained in MyArrayList<Double> to test the Contains method */
//    private static final double NOT_EXIST_ELEMENT = -100.5;

    // VARIABLES TO TEST MyArrayList OF TYPE Integer
    /* the MyArrayList<Integer> to be tested */
//    private static final MyArrayList<Integer> arrayList = new MyArrayList<Integer>();
    /* Default elements of MyArrayList<Integer>*/
//    private static final int[] ELEMENTS = {30, -1, 0, 22, 88};
    /* an element that is not contained in the array of default elements, to be added to MyArrayList<Integer> */
//    private static final int NEW_ELEMENT = 200;
    /* an element that is not contained in MyArrayList<Integer> to test the Contains method */
//    private static final int NOT_EXIST_ELEMENT = -100;

    /**
     *  The program which tests "MyArrayList" class;
     */
    public static void main(String[] args) {
        /* ArrayList for save result messages */
        ArrayList<String> result = new ArrayList<>();
        result.add(checkIsEmpty());
        result.add(checkAdd());
        result.add(checkToString());
        result.add(checkGet());
        result.add(checkSize());
        result.add(checkAddByIndex());
        result.add(checkGetFirst());
        result.add(checkGetLast());
        result.add(checkSet());

        // check remove(index)
        int size = arrayList.size();
        String removed = String.valueOf(arrayList.removeByIndex(0));
        result.add(checkRemove(size, removed ,"removeByIndex(index)"));

        // check remove(element)
        arrayList.add(0, NEW_ELEMENT);
        size = arrayList.size();
        removed = String.valueOf(arrayList.removeByObject(NEW_ELEMENT));
        result.add(checkRemove(size, removed, "removeByObject(element)"));

        arrayList.clear();
        addDefaultElement();

        // check contains
        result.add(forResult("contains()",
                arrayList.contains(ELEMENTS[0]) && !arrayList.contains(NOT_EXIST_ELEMENT)));

        // check indexOf
        result.add(checkIndexsOf(arrayList.indexOf(ELEMENTS[2]), 2, "indexOf()"));

        // check lastIndexOf
        result.add(checkIndexsOf(arrayList.lastIndexOf(ELEMENTS[3]), 3, "lastIndexOf()"));

        // show results
        showResult(result);
    }

    /**
     * The method that checks the work of "isEmpty()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkIsEmpty() {
        boolean forCheck = false;
        if (arrayList.isEmpty()) {
            forCheck = true;
        }
        addDefaultElement();
        return forResult("isEmpty()", !arrayList.isEmpty() && forCheck);
    }

    /**
     * The method that checks the work of "add()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkAdd() {
        arrayList.clear();
        addDefaultElement();
        return forResult("add()", arrayList.toString().equals(Arrays.toString(ELEMENTS)));
    }

    /**
     * The method that checks the work of "toString()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkToString() {
        return forResult("toString()", arrayList.toString().equals(Arrays.toString(ELEMENTS)));
    }

    /**
     * The method that checks the work of "get()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkGet() {
        for (int index = 0; index < ELEMENTS.length; index++) {
            if (!arrayList.get(index).equals(ELEMENTS[index])) {
                return forResult("get()", false);
            }
        }
        return forResult("get()", true);
    }

    /**
     * The method that checks the work of "size()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkSize() {
        arrayList.clear();
        int sizeOfEmptyArray = arrayList.size();
        addDefaultElement();
        return forResult("size()", sizeOfEmptyArray == 0 && arrayList.size() == ELEMENTS.length);

    }

    /**
     * The method that checks the work of "add(index)" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkAddByIndex() {
        arrayList.add(0, NEW_ELEMENT);
        return forResult("add(index)", arrayList.get(0).equals(NEW_ELEMENT));
    }

    /**
     * The method that checks the work of "getFirst()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkGetFirst() {
        arrayList.clear();
        addDefaultElement();
        return forResult("getFirst", arrayList.getFirst().equals(ELEMENTS[0]));
    }

    /**
     * The method that checks the work of "getLast()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkGetLast() {
        arrayList.clear();
        addDefaultElement();
        return forResult("getLast()", arrayList.getLast().equals(ELEMENTS[ELEMENTS.length - 1]));
    }

    /**
     * The method that checks the work of "set()" method, the MyArrayList class.
     * @return a String, the string message about correctness of the method.
     */
    private static String checkSet() {
        arrayList.set(0, NEW_ELEMENT);
        return forResult("set()", arrayList.get(0).equals(NEW_ELEMENT));
    }

    /**
     * The method that checks the work of "removeByIndex()" and "removeByObject()" methods, the MyArrayList class.
     * @param size an integer, the size of the MyArrayList before removing the element.
     * @param removed a String, the String value of removed element.
     * @param typeMethod a String, the name of the tested method.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkRemove(int size, String removed, String typeMethod) {
        return forResult(typeMethod, size - arrayList.size() == 1
                && removed.equals("" + NEW_ELEMENT)
                && !arrayList.get(0).equals("" + NEW_ELEMENT));
    }

    /**
     * The method that checks the work of "indexOf()" and "lastIndexOf()" methods, the MyArrayList class.
     * @param index an integer, the index returned by the tested method.
     * @param expected an iteger, the expected index returned by the tested method.
     * @param method a String, the name of the tested method.
     * @return a String, the string message about correctness of the tested method.
     */
    private static String checkIndexsOf(int index, int expected, String method) {
        return forResult(method, index == expected && arrayList.indexOf(NOT_EXIST_ELEMENT) == -1);
    }

    /**
     * The method that fills the test object MyArrayList with elements from the "ELEMENTS" array.
     */
    private static void addDefaultElement() {
        arrayList.clear();
        for (int index = 0; index < ELEMENTS.length; index++) {
            arrayList.add(ELEMENTS[index]);
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
