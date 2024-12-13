package day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayElevenUtil {
    private static ArrayList<String> blink(ArrayList<String> line) {
        ArrayList<String> newLine = new ArrayList<>();

        for(var stone: line){
            if(stone.equals("0")){
                newLine.add("1");
            } else if(stone.length() % 2 == 0) {
                newLine.add(stone.substring(0, stone.length() / 2));
                newLine.add(String.valueOf(Long.parseLong(stone.substring(stone.length() / 2))));
            } else {
                newLine.add(String.valueOf(Long.parseLong(stone) * 2024));
            }
        }

        return newLine;
    }

    public static int stonesAfterBlinks(String[] line, int timesToBlink) {
        ArrayList<String> newLine = new ArrayList<>(Arrays.asList(line));

        for(int i = 0; i < timesToBlink; i++) {
            newLine = blink(newLine);
        }

        return newLine.size();
    }
}
