package day13;

import java.util.ArrayList;
import java.util.HashMap;

public class DayThirteenUtil {
    public static HashMap<Integer, HashMap<String, HashMap<String, Integer>>> parseLines(ArrayList<String> lines) {
        HashMap<Integer, HashMap<String, HashMap<String, Integer>>> resultMap = new HashMap<>();
        int groupIndex = -1;

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            if (line.startsWith("Button A")) {
                groupIndex++;
                resultMap.put(groupIndex, new HashMap<>());
            }
            if (line.startsWith("Button A")) {
                resultMap.get(groupIndex).put("A", extractCoordinates(line));
            } else if (line.startsWith("Button B")) {
                resultMap.get(groupIndex).put("B", extractCoordinates(line));
            } else if (line.startsWith("Prize")) {
                resultMap.get(groupIndex).put("Prize", extractCoordinates(line));
            }
        }
        return resultMap;
    }
    private static HashMap<String, Integer> extractCoordinates(String line) {
        HashMap<String, Integer> coordinates = new HashMap<>();

        String[] parts = line.split(",");
        for (String part : parts) {
            part = part.trim();
            if (part.contains("X")) {
                coordinates.put("x", Integer.parseInt(part.split("[+=]")[1].trim()));
            } else if (part.contains("Y")) {
                coordinates.put("y", Integer.parseInt(part.split("[+=]")[1].trim()));
            }
        }
        return coordinates;
    }

    public static int[] calculatePushes(HashMap<Integer, HashMap<String, HashMap<String, Integer>>> resultMap){
        int[] pushes = {0, 0};
        for(var key: resultMap.keySet()){
            boolean found = false;
            int aX = resultMap.get(key).get("A").get("x");
            int aY = resultMap.get(key).get("A").get("y");
            int bX = resultMap.get(key).get("B").get("x");
            int bY = resultMap.get(key).get("B").get("y");
            int prizeX = resultMap.get(key).get("Prize").get("x");
            int prizeY = resultMap.get(key).get("Prize").get("y");
            for(int i = 0; i < 101; i++) {
                for(int j = 1; j < 101; j++) {
                    if (aX * i + bX * j == prizeX && aY * i + bY * j == prizeY) {
                        pushes[0] += i;
                        pushes[1] += j;
                        found = true;
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
        }
        return pushes;
    }

    public static int calculateTokens(int[] pushes) {
        return pushes[0] * 3 + pushes[1];
    }
}
