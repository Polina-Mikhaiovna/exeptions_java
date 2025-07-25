import java.util.Scanner;

public class Exception_IndexOutOfBounds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Enter index where to write 1: ");
        int index = 0;

        try {
            if (scanner.hasNextInt())
                index = scanner.nextInt();
            scanner.close();
            arr[index] = 1;
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("Index out of bounds");
        }
    }

    
}
