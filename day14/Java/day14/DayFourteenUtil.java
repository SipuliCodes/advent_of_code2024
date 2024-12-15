package day14;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DayFourteenUtil {
    public static HashMap<Integer, HashMap<String, HashMap<String, Integer>>> parseInput(ArrayList<String> data) {
        HashMap<Integer, HashMap<String, HashMap<String, Integer>>> resultMap = new HashMap<>();

        int index = 0;
        for (String line : data) {
            line = line.trim();

            String[] parts = line.split(" ");
            HashMap<String, HashMap<String, Integer>> entryMap = new HashMap<>();

            for (String part : parts) {
                if (part.startsWith("p=")) {
                    entryMap.put("p", extractCoordinates(part.substring(2)));
                } else if (part.startsWith("v=")) {
                    entryMap.put("v", extractCoordinates(part.substring(2)));
                }
            }
            resultMap.put(index++, entryMap);
        }

        return resultMap;
    }

    private static HashMap<String, Integer> extractCoordinates(String coordinateString) {
        HashMap<String, Integer> coordinates = new HashMap<>();
        String[] values = coordinateString.split(",");
        coordinates.put("x", Integer.parseInt(values[0]));
        coordinates.put("y", Integer.parseInt(values[1]));
        return coordinates;
    }
    private static void calculateRobotPositionInXSecondsHelper(int[] quadrants, int height, int width, ArrayList<Point> alreadyBeen, int currentX, int currentY, int xVelocity, int yVelocity, int counter, int secondsLeft) {
        Point currentCoordinates = new Point(currentX, currentY);
        if( !alreadyBeen.contains(currentCoordinates) && secondsLeft > 0) {
            alreadyBeen.add(currentCoordinates);
            int newX = currentX + xVelocity;
            int newY = currentY + yVelocity;
            if(newX < 0) {
                newX = width + newX;
            }
            if(newX >= width) {
                newX = newX - width;
            }
            if(newY < 0) {
                newY = height + newY;
            }
            if(newY >= height) {
                newY = newY - height;
            }
            calculateRobotPositionInXSecondsHelper(quadrants, height, width, alreadyBeen, newX, newY, xVelocity, yVelocity, counter + 1, secondsLeft-1 );
        } else {
            Point lastPoint = new Point(currentX, currentY);
            if (secondsLeft > 0 && counter > 0) {
                int index = secondsLeft % alreadyBeen.size();
                lastPoint = alreadyBeen.get(index);
            }
            int lastX = lastPoint.x;
            int lastY = lastPoint.y;
            int centerX = width / 2;
            int centerY = height / 2;
            if (lastX < centerX && lastY < centerY) {
                quadrants[0] += 1;
            }
            if (lastX > centerX && lastY < centerY) {
                quadrants[1] += 1;
            }
            if (lastX < centerX && lastY > centerY) {
                quadrants[2] += 1;
            }
            if (lastX > centerX && lastY > centerY) {
                quadrants[3] += 1;
            }
        }
    }
    private static void calculateRobotPositionInXSeconds(int[] quadrants, int height, int width, int currentX, int currentY, int xVelocity, int yVelocity, int seconds) {
        int counter = 0;
        ArrayList<Point> alreadyBeen = new ArrayList<>();
        calculateRobotPositionInXSecondsHelper(quadrants, height, width, alreadyBeen, currentX, currentY, xVelocity, yVelocity, counter, seconds);

    }
    public static int calculateSafetyFactor(HashMap<Integer, HashMap<String, HashMap<String, Integer>>> robots, int height, int width, int seconds){
        int[] quadrants = {0, 0, 0, 0};
        for(var key: robots.keySet()) {
                int currentX = robots.get(key).get("p").get("x");
                int currentY = robots.get(key).get("p").get("y");
                int xVelocity = robots.get(key).get("v").get("x");
                int yVelocity = robots.get(key).get("v").get("y");
                calculateRobotPositionInXSeconds(quadrants, height, width, currentX, currentY, xVelocity, yVelocity, seconds);
        }
        return quadrants[0] * quadrants[1] * quadrants[2] * quadrants[3];
    }
}
