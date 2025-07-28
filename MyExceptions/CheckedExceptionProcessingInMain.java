package MyExceptions;
import java.io.IOException;

public class CheckedExceptionProcessingInMain {
    public static void main(String[] args) throws Exception {
        try {
            doSomething();
        } catch (IOException e){
            System.out.println(e.getClass().getName());
            System.out.println(e.getMessage());
        }

        try (Counter counter = new Counter()){
            counter.add();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        // Counter counter = new Counter();
        // counter.close();
        // counter.add();
        try {
            System.out.println(divide(4, 0));
        } catch (DivisionByZeroException e){
            System.out.println(e.getMessage());
        }
        Object[] objects = new Object[]{4, 5, null, 1};
        IsEmptyElement isEmptyElement = new IsEmptyElement();
        try{
            System.out.println(isEmptyElement.IsEmpty(objects[2]));
        }catch (EmptyElementException e){
            System.out.println(e.getClass().getName());
        }

    }

    public static void doSomething() throws IOException{
        throw new IOException("Exception");
    }

    public static float divide(int a, int b) throws DivisionByZeroException{
        if (b == 0){
            throw new DivisionByZeroException("Exception: DivisionByZero", null);
        }
        
        return a / b;
    }
}
