import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashMap;

public class Puzzle2 {
    public static void main(String[] args) {
        String path = "day1/puzzle1/data.txt";

        ArrayList<String> data = DataHandler.readFile(path);
        ArrayList<ArrayList<Integer>> lists = DataHandler.divideDataToLists(data);
        HashMap<Integer, Integer> firstNumberAmount = DataHandler.amountsOfNumber(lists.get(0));
        HashMap<Integer, Integer> secondNumberAmount = DataHandler.amountsOfNumber(lists.get(1));
        int similarity = DataHandler.calculateSimilarity(firstNumberAmount, secondNumberAmount);
        System.out.println("Answer is " + similarity);
    }
}
