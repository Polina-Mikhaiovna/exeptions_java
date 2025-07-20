import java.util.ArrayList;

public class FindNullsInArray {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, null, 6, null};
        ArrayList<Integer> elements = checkNullInArray(array);
        System.out.println("Index of null element/s is/are: " + elements);
    }

    public static ArrayList<Integer> checkNullInArray(Integer[] array){
        ArrayList<Integer> elements = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                elements.add(i);
            }
        }
        return elements;
    }
    
}
