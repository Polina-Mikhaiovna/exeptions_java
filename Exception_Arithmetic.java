public class Exception_Arithmetic {

    public static void main(String[] args) {
        int d = 0;
        int[] intArray = new int[10];
        try {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}