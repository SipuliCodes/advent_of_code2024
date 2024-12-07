package day7;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class Puzzle2 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day7/data.txt");
        long sum = DaySevenUtil.calculatePossibleAnswersSum(data);
        System.out.println("Answer is " + sum);
    }
}
