import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class RandomExceptionsClass {
    public static void main(String[] args) throws IOException {
        printHi("");
        ArrayList<String> stringArraysList = new ArrayList<String>();
        stringArraysList.addAll(callMethod1());

        int a = 10, b = 5;
        printHi("");
        int div = callMethod2(a, b);
        System.out.println(div);
        printHi("");
    }

    private static void printHi(String s) {
        System.out.println("Hello World, it's me!");
    }

    private static LinkedList<String> callMethod1() throws IOException {
        callMethod2(100000000, 10);
        LinkedList<String> ll = new LinkedList<String>();
        return ll;
    }

    public static int callMethod2(int a, int b) throws IOException {
        printHi("");
        String home = System.getProperty("user.home");
        String filePath = home + "/git_workspase/exeptions/";
        FileInputStream fis = new FileInputStream(filePath + "1.txt");
        fis.read();
        if (fis.available() > 0) {
            fis.close();
            throw new RuntimeException("Not all byite is read");
        } else {
            fis.close();
            int num = callMethod4("1240");
            System.out.println(num);
        }
        int res = 0;
        if (b == 0) throw new RuntimeException("Division by zero");
        return res;
    }

    private static int callMethod4(String s) {
        fillArrayOfStrings(s);
        int i = Integer.parseInt(s);
        return i;
    }

    private static void fillArrayOfStrings(String s) {
        printHi("");
        String[] strings = new String[5];
        for (int i = 1; i < strings.length; i++) {
            strings[i] = s;
        }
    }
}
