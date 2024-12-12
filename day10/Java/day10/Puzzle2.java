package day10;

import utils.DataHandlerUtil;

import java.awt.*;
import java.util.ArrayList;

public class Puzzle2 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day10/data.txt");
        ArrayList<Point> trailHeadCoordinates = DayTenUtil.findTrailHeads(data);
        int trailScoreSum = DayTenUtil.calculateTrailRatingSum(data, trailHeadCoordinates);
        System.out.println("Answer is "+ trailScoreSum);
    }
}
