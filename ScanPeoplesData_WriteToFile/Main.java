package ScanPeoplesData_WriteToFile;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n************************************************************************");
        System.out.println("********Введите ваши данные через пробел в произвольном порядке********");
        System.out.println("************************************************************************\n");
        System.out.println(
                "Фамилия Имя Отчество дата рождения(в формате дд.мм.гггг) номер телефона(только цифры без форматирования)"
                        + " пол(символ латиницей f или m):\n\n");
        String data;
        String[] dataArray;

        try (Scanner scanner = new Scanner(System.in);) {
            data = scanInputString(scanner);
            dataArray = parsString(data);
            try {
                checkDataFormat(dataArray);
                Path path = createFileWithName(dataArray[0] + ".txt");
                writeDataToFile(path, dataArray);
                System.out.println("Даные корректны. Записываем их в файл \"Ваша_фамилия.txt\"");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String scanInputString(Scanner scanner) {
        String data = new String();
        boolean isData = false;
        while (!isData) {
            if (scanner.hasNextLine()) {
                data = scanner.nextLine();
                int checkCode = checkData(data);
                if (checkCode == 0) {
                    isData = true;
                } else if (checkCode == 1) {
                    System.out.println("Данных введено слишком много. Попробуйте снова");
                } else {
                    System.out.println("Введённых данных недостаточно. Попробуйте снова");
                }
            }
        }
        return data;
    }

    public static int checkData(String data) {
        int checkCode = 0;
        int lines = data.split(" ").length;
        if (lines == 6) {
            checkCode = 0;
        } else if (lines < 6) {
            checkCode = -1;
        } else {
            checkCode = 1;
        }
        return checkCode;
    }

    // формат возвращаемой строки
    // <Фамилия><Имя><Отчество><датарождения><номертелефона><пол>
    public static String[] parsString(String data) {
        String[] parsData = data.split(" ");
        int len = parsData.length;
        String[] tempArr = new String[6];

        for (int i = 0; i < len; i++) {
            String current = parsData[i];

            if (isValidDate(current)) {
                tempArr[3] = current;
            } else if (current.equalsIgnoreCase("f") || current.equalsIgnoreCase("m")) {
                tempArr[5] = current;
            } else if (current.matches("\\d+")) {
                tempArr[4] = current;
            } else if (current.matches("^[a-zA-Zа-яА-Я]+$")) {
                if (tempArr[0] == null)
                    tempArr[0] = current;
                else if (tempArr[1] == null)
                    tempArr[1] = current;
                else if (tempArr[2] == null)
                    tempArr[2] = current;
            }
        }
        System.out.println(Arrays.toString(tempArr));
        return tempArr;
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static void checkDataFormat(String[] data) throws RuntimeException {
        if (data[0] == null) {
            throw new RuntimeException("Ошибка в фамилии");
        }
        if (data[1] == null) {
            throw new RuntimeException("Ошибка в имени");
        }
        if (data[2] == null) {
            throw new RuntimeException("Ошибка в отчестве");
        }
        if (data[3] == null) {
            throw new RuntimeException("Ошибка в дате рождения");
        }
        if (data[4] == null) {
            throw new RuntimeException("Ошибка в номере телефона");
        }
        if (data[5] == null) {
            throw new RuntimeException("Ошибка в указании пола");
        }
    }

    public static Path createFileWithName(String fileName) {
        String home = System.getProperty("user.home");
        Path file = Paths.get(home, "/git_workspase/exeptions/ScanPeoplesData_WriteToFile", fileName);
        return file;
    }

    public static void writeDataToFile(Path path, String[] data) {
        try (FileWriter fw = new FileWriter(path.toFile(), true)) {
            for (String name : data) {
                fw.write("<" + name + ">");
            }
            fw.write("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getStackTrace());
        }

    }
}
