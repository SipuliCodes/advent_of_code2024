package day9;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class Puzzle1 {

    public static void main(String[] args) {
        String diskMap = DataHandlerUtil.readFile("./day9/data.txt").getFirst();
        ArrayList<String> individualBlocks = DayNineUtil.diskMapToIndividualBlocks(diskMap);
        ArrayList<String> blocksToLeft = DayNineUtil.moveBlocksToLeft(individualBlocks);
        long checkSum = DayNineUtil.calculateCheckSum(blocksToLeft);
        System.out.println("Answer is " + checkSum);
    }

}
