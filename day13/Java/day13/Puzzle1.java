package day13;

import utils.DataHandlerUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class Puzzle1 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day13/data.txt");
        HashMap<Integer, HashMap<String, HashMap<String, Integer>>> coordinates = DayThirteenUtil.parseLines(data);
        int[] pushes = DayThirteenUtil.calculatePushes(coordinates);
        int tokens = DayThirteenUtil.calculateTokens(pushes);
        System.out.println("Answer is " + tokens);
    }
}
