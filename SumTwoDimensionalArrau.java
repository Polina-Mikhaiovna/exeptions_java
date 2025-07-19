import java.util.Arrays;

public class SumTwoDimensionalArrau {
    public static void main(String[] args) throws RuntimeException {
        int[][] matrix = { { 0, 0, 0, 1 }, { 1, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 1, 1, 0 } };
        System.out.println(Arrays.deepToString(matrix));
        checkRectangularMatrix(matrix);
        System.out.println(matrixSum(matrix));

    }

    public static void checkRectangularMatrix(int[][] matrix) {
        int rowNumber = matrix.length; // количество подмассивов(строк)
        for (int i = 0; i < rowNumber; i++) {
            if (matrix[i].length != rowNumber) {
                throw new RuntimeException("Matrix is not rectangular");
            }
        }
    }

    public static int matrixSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0 || matrix[i][j] == 1)
                    sum += matrix[i][j];
                else
                    throw new RuntimeException("Matrix contains not 0 or 1 numbers");
            }
        }
        return sum;
    }
}
