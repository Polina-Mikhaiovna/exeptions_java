public class SumTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 5, 4, 3, 2, 1 };
        int len = arr1.length;
        int[] res = new int[len];

        res = sumArrays(arr1, arr2);
        for(int i = 0; i < res.length; i++){
            System.out.printf("%d ", res[i]);
        }
        System.out.println();

    }

    public static void checkArray(){
        
    }

    public static int[] sumArrays(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++){
            res[i] = arr1[i] + arr2[i];
        }
        return res;
    }
}
