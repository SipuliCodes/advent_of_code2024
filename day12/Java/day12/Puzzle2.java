package day12;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class Puzzle2 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day12/data.txt");
        int price = DayTwelveUtil.calculateDiscountPrice(data);
        System.out.println("Answer is " + price);
    }
}
