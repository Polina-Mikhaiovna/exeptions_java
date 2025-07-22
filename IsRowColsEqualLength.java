public class IsRowColsEqualLength {
    public static void main(String[] args) {
        Integer[][] matrix = { { 1, 2, 3, 4 },
                { 1, 2, null, null },
                { 1, 2, 3, 4 },
                { 1, null, null, null } };
        System.out.println(matrix[1].length);
        isRowColsEqualLength(matrix);
    }

    public static void isRowColsEqualLength(Integer[][] matrix) {
        int colElements = 0;
        int rowElements = 0;
        for(int i = 0; i < matrix.length; i++){
            rowElements = 0;
            colElements = 0;
            for(int j = 0; j < matrix.length; j++){
                if(matrix[i][j] != null) rowElements ++;
            }
            System.out.printf("RowElement at matrix[%d] = %d\n", i, rowElements);
            
            for (int j = 0; j < matrix.length; j++){
                if (matrix[j][i] != null) colElements++;
            }
            if (rowElements == colElements) System.out.printf("Rows and columns at index [%d] are equal\n", i);
        }

    }
    // int rows = matrix.length;
    // int count = 0;
    // for(int i = 0; i < rows; i++){
    // for (int j = 0; j < rows; j++){
    // if
    // }
    // if(rows == matrix[i].length){
    // count++;
    // }
    // else throw new RuntimeException("Some pair of rows and columns have not equal
    // length");
    // break;
    // }
    // return count;
    // }

}
