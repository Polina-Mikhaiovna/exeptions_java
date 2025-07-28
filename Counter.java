import java.io.IOException;

public class Counter implements AutoCloseable {
    int i = 0;
    boolean closed = false;

    public void add() throws IOException{
        if (closed) {
            throw new IOException("Source is closed");
        }
        else{
            i += 1;
            System.out.printf("Counter upgrade %d to %d\n", i-1, i);}
    }

    @Override
    public void close() throws Exception {
        closed = true;
    }
}
