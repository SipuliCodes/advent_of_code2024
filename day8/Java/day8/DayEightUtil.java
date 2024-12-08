package day8;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class DayEightUtil {
    public static HashMap<String, ArrayList<Point>> getPositions(ArrayList<String> data) {
        HashMap<String, ArrayList<Point>> positions = new HashMap<>();
        for(int i = 0; i < data.size(); i++) {
            for(int j = 0; j < data.get(i).length(); j++) {
                String symbol = String.valueOf(data.get(i).charAt(j));
                if(!symbol.equals(".")) {
                    Point coordinates = new Point(j, i);
                    if(!positions.containsKey(symbol)) {
                        positions.put(symbol, new ArrayList<>());
                    }
                    positions.get(symbol).add(coordinates);
                }
            }
        }
        return positions;
    }

    public static int calculateAntinodesOnMap(int width, int height, HashMap<String, ArrayList<Point>> positions, ArrayList<String> data) {
        HashSet<String> unique = new HashSet<>();
        for(var key: positions.keySet()) {
            ArrayList<Point> coordinates = positions.get(key);
            for(int i = 0; i < coordinates.size() - 1; i++) {
                for(int j = i+ 1; j < coordinates.size(); j++) {
                    Point firstPoint = coordinates.get(i);
                    Point secondPoint = coordinates.get(j);
                    int xDifference = (int) (secondPoint.getX() - firstPoint.getX());
                    int yDifference = (int) (secondPoint.getY() - firstPoint.getY());
                        int k = 0;
                        while(true) {
                            int firstAntinodeX = (int) (firstPoint.getX() - k * xDifference);
                            int firstAntinodeY = (int) (firstPoint.getY() - k * yDifference);
                            if(firstAntinodeX >= 0 && firstAntinodeX < width && firstAntinodeY >= 0 && firstAntinodeY < height ) {
                                unique.add(firstAntinodeX + "," + firstAntinodeY);
                            } else {
                                break;
                            }
                            k++;
                        }

                        k = 0;
                        while(true) {
                            int secondAntinodeX = (int) (secondPoint.getX() + k * xDifference);
                            int secondAntinodeY = (int) (secondPoint.getY() + k * yDifference);
                            if(secondAntinodeX >= 0 && secondAntinodeX < width && secondAntinodeY >= 0 && secondAntinodeY < height ) {
                                unique.add(secondAntinodeX + "," + secondAntinodeY);
                            } else {
                                break;
                            }
                            k++;
                        }
                }
            }
        }
        return unique.size();
    }
}
