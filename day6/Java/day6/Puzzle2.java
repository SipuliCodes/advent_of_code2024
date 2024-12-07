package day6;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class Puzzle2 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day6/data.txt");
        int ways = DaySixUtil.calculateWaysToLoop(data);
        System.out.println("Answer is " + ways);
    }
}
