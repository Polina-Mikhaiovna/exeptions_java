import java.util.Scanner;

public class IsInputStringEmpty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter something: ");
            isStrEmpty(sc);
            System.out.println("Thanks");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static void isStrEmpty(Scanner sc) {
        String input = null;
        input = sc.nextLine();
        if (input.trim().isEmpty()) {
            throw new RuntimeException("You can't enter empty string");
        }
    }
}
