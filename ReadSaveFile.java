import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

public class ReadSaveFile {
    public static void main(String[] args) {
        HashMap<String, Integer> nameInt = new HashMap<>();
        Path file = createPath();
        nameInt = readFileToHashMap(file);
        writeHashMapToFile(nameInt, file);
        printHashMap(nameInt);
    }

    public static Path createPath() {
        String home = System.getProperty("user.home");
        Path file = Paths.get(home, "/git_workspase/exeptions/", "names.txt");
        return file;
    }

    public static HashMap<String, Integer> readFileToHashMap(Path file) {
        HashMap<String, Integer> nameInt = new HashMap<>();
        String[] tmp;
        int value;
        try (InputStream in = Files.newInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tmp = line.split("=");
                value = tryParseInt(tmp[1]);
                if (value == 0) {
                    nameInt.put(tmp[0], tmp[0].length());
                    
                    
                } else {
                    nameInt.put(tmp[0], value);
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return nameInt;
    }

    public static int tryParseInt(String s) {
        try {
            int val = Integer.parseInt(s);
            return val;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static void writeHashMapToFile(HashMap<String, Integer> map, Path file){
       try(FileWriter fw = new FileWriter(file.toFile(), false)) {
			for (String name : map.keySet()){
                fw.write(name + "=" + map.get(name) + "\n");
            }
            fw.flush();
		} catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
    }

    public static void printHashMap(HashMap<String, Integer> nameInt) {
        for (HashMap.Entry<String, Integer> entry : nameInt.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}