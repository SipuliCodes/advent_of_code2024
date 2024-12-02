package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHandlerUtil {
    public static ArrayList<String> readFile(String path) {
        ArrayList<String> fileData = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                fileData.add(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        return fileData;
    }

    public static String[] lineSplitter(String line, String separator){
        return line.split(separator);
    }

    public static ArrayList<Integer> stringListToIntList(String[] list) {
        ArrayList<Integer> intList = new ArrayList<>();
        for(String character: list) {
            try{
                intList.add(Integer.parseInt(character));
            } catch (NumberFormatException e){
                System.out.println("Was not a number");
            }
        }
        return intList;
    }
}
