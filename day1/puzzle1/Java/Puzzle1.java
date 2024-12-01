import java.util.ArrayList;

public class Puzzle1 {
    public static void main(String[] args) {
        String path = "day1/puzzle1/data.txt";

        ArrayList<String> data = DataHandler.readFile(path);
        ArrayList<ArrayList<Integer>> lists = DataHandler.divideDataToLists(data);
        int difference = DataHandler.calculateDifference(lists.get(0), lists.get(1));
        System.out.println("The answer is " + difference);
    }
}