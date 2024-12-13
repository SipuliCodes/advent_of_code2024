package day11;

import utils.DataHandlerUtil;

public class Puzzle1 {
    public static void main(String[] args) {
        String[] line = DataHandlerUtil.lineSplitter(DataHandlerUtil.readFile("./day11/data.txt").getFirst(), " ");
        int stones = DayElevenUtil.stonesAfterBlinks(line, 25);
        System.out.println("Answer is " + stones);
    }
}
