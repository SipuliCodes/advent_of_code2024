package day8;

import day8.DayEightUtil;
import utils.DataHandlerUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Puzzle1 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day8/data.txt");
        HashMap<String, ArrayList<Point>> positions = DayEightUtil.getPositions(data);
        int width = data.getFirst().length();
        int height = data.size();
        int amount = DayEightUtil.calculateAntinodesOnMap(width, height, positions, data);
        System.out.println("Answer is " + amount);
    }
}
