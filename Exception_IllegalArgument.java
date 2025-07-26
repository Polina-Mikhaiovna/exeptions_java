import java.util.Scanner;

public class Exception_IllegalArgument {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float num = scanFloat(sc);
        sc.close();
        System.out.println(num);
    }

    public static float scanFloat(Scanner sc) {
        System.out.println("Enter float number from 1.4e-45 to 3.4028235e+38");
        float number;
        while (true) {
            if (sc.hasNextFloat()) {
                number = sc.nextFloat();
                break;
            } else
                System.out.println("Enter just float number from 1.4e-45 to 3.4028235e+38");
            sc.next();
        }
        return number;
    }
}
