public class Exception_NumberFormat {
    public static void main(String[] args) {
        
        String[][] matrix = { { "0", "0", "0", "1" }, { "1", "1", "1", "0" } };
        if (matrix.length == 0) {
            System.out.println("Array = 0. Fill the array!");
        } else {
            int result = sum2d(matrix);
            System.out.println(result);
        }
    }

     public static int sum2d(String[][] arr) {
        int sum = 0;
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                val = tryParseInt(arr[i][j]);
                sum += val;
            }

        }
        return sum;
    }

    public static int tryParseInt(String s) {
        try {
            int val = Integer.parseInt(s);
            return val;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
