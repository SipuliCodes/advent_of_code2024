package day3;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class Puzzle1 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day3/data.txt");

        int sum = 0;

        for (var line : data) {
            sum += DayThreeUtil.calculateSum(DayThreeUtil.findMul(line));
        }

        System.out.println("Answer is " + sum);
    }
}
