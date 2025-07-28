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


    }

    public static void doSomething() throws IOException{
        throw new IOException("Exception");
    }
}
