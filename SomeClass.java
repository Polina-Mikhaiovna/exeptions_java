import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class SomeClass {
    public static void main(String[] args) {

        InputStream inputStream;
        try {
            String[] strings = { "asdf", "asdf" };
            String strings1 = strings[0];
            test();
            inputStream = new FileInputStream("sdafgdsaf");
            System.out.printf("%s %s", inputStream, strings1);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Я всё равно выполнился!");
        }
        System.out.println("Я жив!");
    }

    public static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        reader.close();
    }
}
