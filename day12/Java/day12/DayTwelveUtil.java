package day12;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class DayTwelveUtil {

    private static void calculateAreaAndPerimeterHelper(HashSet<Point> alreadyBeen, ArrayList<String> map, Point currentCoordinates, int[] areaAndPerimeter, char symbol ) {
        if(alreadyBeen.contains(currentCoordinates)){
            return;
        } else {
            areaAndPerimeter[0] += 1;
            alreadyBeen.add(currentCoordinates);
        }
        int x = currentCoordinates.x;
        int y = currentCoordinates.y;

        if( x > 0 && map.get(y).charAt(x - 1) == symbol) {
            calculateAreaAndPerimeterHelper(alreadyBeen, map, new Point(x-1, y), areaAndPerimeter, symbol);
        } else {
            areaAndPerimeter[1] += 1;
        }

        if( x < map.get(y).length() - 1 && map.get(y).charAt(x + 1) == symbol) {
            calculateAreaAndPerimeterHelper(alreadyBeen, map, new Point(x+1, y), areaAndPerimeter, symbol);
        } else {
            areaAndPerimeter[1] += 1;
        }

        if( y > 0 && map.get(y-1).charAt(x) == symbol) {
            calculateAreaAndPerimeterHelper(alreadyBeen, map, new Point(x, y-1), areaAndPerimeter, symbol);
        } else {
            areaAndPerimeter[1] += 1;
        }

        if( y < map.size() - 1 && map.get(y+1).charAt(x) == symbol) {
            calculateAreaAndPerimeterHelper(alreadyBeen, map, new Point(x, y+1), areaAndPerimeter, symbol);
        } else {
            areaAndPerimeter[1] += 1;
        }

    }
    private static int[] calculateAreaAndPerimeter(HashSet<Point> alreadyBeen, ArrayList<String> map, Point currentCoordinates, char symbol ) {
        int[] areaAndPerimeter = {0, 0};
        calculateAreaAndPerimeterHelper(alreadyBeen, map, currentCoordinates, areaAndPerimeter, symbol);
        return areaAndPerimeter;
    }
    public static int calculatePrice(ArrayList<String> map) {
        int price = 0;
        HashSet<Point> alreadyBeen = new HashSet<Point>();

        for(int y = 0; y < map.size(); y++) {
            for(int x = 0; x < map.get(y).length(); x++) {
                if(alreadyBeen.contains(new Point(x, y))){
                    continue;
                }
                int[] areaAndPerimeter = calculateAreaAndPerimeter(alreadyBeen, map, new Point(x, y), map.get(y).charAt(x));
                price += areaAndPerimeter[0] * areaAndPerimeter[1];
            }
        }
        return price;
    }
}
