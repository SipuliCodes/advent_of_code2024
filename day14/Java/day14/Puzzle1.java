package day14;

import utils.DataHandlerUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class Puzzle1 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day14/data.txt");
        HashMap<Integer, HashMap<String, HashMap<String, Integer>>> robots = DayFourteenUtil.parseInput(data);
        int safetyScore = DayFourteenUtil.calculateSafetyFactor(robots, 103, 101, 100);
        System.out.println("Answer is " + safetyScore);
    }
}
