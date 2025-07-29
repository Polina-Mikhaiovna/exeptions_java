package MyExceptions;

import java.io.IOException;

public class CheckedExceptionProcessingInMain {
    public static void main(String[] args) throws Exception {

        // method doSomething() is throw a IOException
        try {
            doSomething();
        } catch (IOException e) {
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }

        // try-with-resources, class Counter implements AutoCloseable
        try (Counter counter = new Counter()) {
            counter.add();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // DivisionByZeroException
        try {
            System.out.println(divide(4, 0));
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        }
        // EmptyElementException
        Object[] objects = new Object[] { 4, 5, null, 1 };
        IsEmptyElement isEmptyElement = new IsEmptyElement();
        try {
            System.out.println(isEmptyElement.IsEmpty(objects[2]));
        } catch (EmptyElementException e) {
            System.out.println(e.getClass().getName());
        }

        // MyArraySizeException
        System.out.println("\n\n********MyArraySizeException********\n");
        String[] a = { "1", "2", "3", "4" };
        String[] b = { "9", "8", "7", "6"};
        try {
            checkArraysSize(a, b);
            System.out.println(calculateSum(a, b));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void doSomething() throws IOException {
        throw new IOException("Exception");
    }

    public static float divide(int a, int b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException("Exception: DivisionByZero", null);
        }
        return a / b;
    }

    public static void checkArraysSize(String[] firstArray, String[] secondArray) throws MyArraySizeException {
        if (firstArray.length != 4 || secondArray.length != 4) {
            throw new MyArraySizeException();
        }
    }

    public static int calculateSum(String[] a, String[] b) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            try {
                int valueA = Integer.parseInt(a[i]);
                int valueB = Integer.parseInt(b[i]);
                sum += valueA + valueB;
            } catch (NumberFormatException e) {
                throw new MyArrayDataException(e.getMessage());
            }
        }
        return sum;
    }
}
