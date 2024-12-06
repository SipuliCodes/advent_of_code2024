package day6;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class Puzzle1 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day6/data.txt");
        int steps = DaySixUtil.calculateSteps(data);
        System.out.println("Answer is " + steps);
    }
}
