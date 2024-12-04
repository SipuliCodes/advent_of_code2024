package day4;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class Puzzle2 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day4/data.txt");
        int amount = DayFourUtil.findMASAmount(data);
        System.out.println("Answer is " + amount);
    }
}
