import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DataHandler {

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

    public static ArrayList<ArrayList<Integer>> divideDataToLists(ArrayList<String> data) {
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        for(String line: data){
            String[] parts = line.split(" {3}");
            try {
                firstList.add(Integer.parseInt(parts[0]));
                secondList.add(Integer.parseInt(parts[1]));
            } catch (NumberFormatException e) {
                System.out.println("Was not a number");
            }
        }
        ArrayList<ArrayList<Integer>> bothLists = new ArrayList<>();

        bothLists.add(firstList);
        bothLists.add(secondList);

        return  bothLists;
    }

    public static int calculateDifference(ArrayList<Integer> firstList, ArrayList<Integer> secondList){
        Collections.sort(firstList);
        Collections.sort(secondList);
        int difference = 0;
        for(int i = 0; i < firstList.size(); i++) {
            difference += Math.abs(firstList.get(i)- secondList.get(i));
        }
        return difference;
    }

    public static HashMap<Integer, Integer> amountsOfNumber(ArrayList<Integer> list) {
        HashMap<Integer, Integer> numberAmounts = new HashMap<>();
        for(int i: list) {
            int amount = 0;
            for(int number: list) {
                if(number == i){
                    amount++;
                }
            }
            if(amount > 0) {
                numberAmounts.put(i, amount);
            }
        }
        return numberAmounts;
    }

    public static int calculateSimilarity(HashMap<Integer, Integer> firstNumberAmounts, HashMap<Integer, Integer> secondNumberAmounts) {
        int similarityScore = 0;
        for(int i: firstNumberAmounts.keySet()) {
            if(firstNumberAmounts.containsKey(i) && secondNumberAmounts.containsKey(i)) {
                similarityScore += i * firstNumberAmounts.get(i) * secondNumberAmounts.get(i);
            }
        }

        return similarityScore;
    }
}
