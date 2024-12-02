package day2;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class Puzzle2 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day2/data.txt");
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        int safeLines = 0;

        for(String line: data){
            ArrayList<Integer> safeCheckLine = DataHandlerUtil.stringListToIntList(DataHandlerUtil.lineSplitter(line, " "));
            if(SafeCheckerWithProblemDampener.decreaseSafe(safeCheckLine) || SafeCheckerWithProblemDampener.increaseSafe(safeCheckLine)) {
                safeLines++;
            }
        }

        System.out.println("Answer is " + safeLines);
    }
}
