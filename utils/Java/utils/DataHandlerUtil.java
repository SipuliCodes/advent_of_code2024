package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static Integer[] findSymbolCoordinates(ArrayList<String> list, String symbol) {
        Pattern pattern = Pattern.compile(Pattern.quote(symbol));

        Integer[] coordinates = {0, 0};

        for(int i = 0; i < list.size(); i++) {
            Matcher matcher = pattern.matcher(list.get(i));
            if(matcher.find()){
                coordinates[0] = matcher.start();
                coordinates[1] = i;
                break;
            }
        }
        return coordinates;
    }
}
