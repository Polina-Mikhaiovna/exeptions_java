// Поиск числа заданного пользователем в консоли внутри массива с обработкой ошибок:
// - малый размер массива,
// - нулевой массив,
// - введённое число не принадлежит массиву,
// - введено не число

import java.util.Scanner;

public class FindNumberInArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int min = 2;
        int inputInt = getInputInt("Enter integer number for finding in array");
        int flag = checkArray(arr, min);
        if (flag != 0) {
            processingErrors(flag);
        } else {
            int result = findIndex(arr, inputInt);
            if (result == -2)
                processingErrors(result);
            else
                System.out.println("Index of number " + inputInt + ": " + result);
        }
    }

    public static int findIndex(int[] arr, int number) {
        int i = 0;
        int index = -2;
        while (i < arr.length) {
            if (arr[i] == number) {
                index = i;
                break;
            } else {
                i++;
            }
        }
        return index;
    }

    public static int checkArray(int[] arr, int min) {
        int length = arr.length;
        if (length == 0) {
            return -3;
        }
        if (length < min) {
            return -1;
        }
        return 0;
    }

    public static boolean processingErrors(int flag) {
        if (flag == -3) {
            System.out.println("Length of array is 0");
            return false;
        }
        if (flag == -1) {
            System.out.println("Length of array is lower than minimum");
            return false;
        }
        if (flag == -2) {
            System.out.println("Number is not in array");
            return false;
        }
        return true;
    }

    public static int getInputInt(String message) {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextInt()) {
            String scan = sc.next();
            System.out.printf("Entered data: \"%s\" is not integer! Try number from -2147483648 to 2147483647/n", scan);
        }
        number = sc.nextInt();
        System.out.println("Вы ввели " + number);
        sc.close();
        return number;
    }
}
