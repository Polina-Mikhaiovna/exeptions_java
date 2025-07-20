public class FindNullsInArray {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, null, 6, null};
        checkNullInArray(array);
    }
    
    public static void checkNullInArray(Integer[] array){
        StringBuilder indexes = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                indexes.append(Integer.toString(i)).append(" ");
            }
        }
        System.out.printf("Element with index %s is null\n", indexes);
    }
    
}
