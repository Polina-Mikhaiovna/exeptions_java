import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWriteLine {
    public static void main(String[] args) throws IOException {
        String source = "/home/oldfathw/git_workspase/exeptions/names.txt";
        String destination = "/home/oldfathw/git_workspase/exeptions/forRWLine.txt";
        rwLine(Paths.get(source), Paths.get(destination));
    }

    public static void rwLine(Path pathRead, Path pathWrite) throws IOException {

        try (BufferedReader in = Files.newBufferedReader(pathRead);
                BufferedWriter out = Files.newBufferedWriter(pathWrite);) {
            out.write(in.readLine());
        }
    }

}
