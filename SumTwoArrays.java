public class SumTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 5, 4, 3, 2, 1 };

        try {
            checkArraysLength(arr1, arr2);
            print2DArray(sumArrays(arr1, arr2));
            print2DArray(difArrays(arr1, arr2));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int[] sumArrays(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = arr1[i] + arr2[i];
        }
        return res;
    }

    public static int[] difArrays(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = arr1[i] - arr2[i];
        }
        return res;
    }

    public static void checkArraysLength(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays are not equal length");
        }
    }

    public static void print2DArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
        System.out.println();
    }
}
