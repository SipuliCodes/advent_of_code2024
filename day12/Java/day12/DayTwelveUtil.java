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

    private static int calculateCorners(ArrayList<String> map, Point currentCoordinates, char symbol) {
        int cornerAmount = 0;
        int x = currentCoordinates.x;
        int y = currentCoordinates.y;

        if(x > 0 && y > 0 && map.get(y).charAt(x-1) == symbol && map.get(y-1).charAt(x) == symbol && map.get(y-1).charAt(x-1) != symbol) {
            cornerAmount++;
        }

        if(x < map.getFirst().length() - 1 && y > 0 && map.get(y).charAt(x+1) == symbol && map.get(y-1).charAt(x) == symbol && map.get(y-1).charAt(x+1) != symbol) {
            cornerAmount++;
        }

        if(x > 0 && y < map.size() - 1 && map.get(y).charAt(x-1) == symbol && map.get(y+1).charAt(x) == symbol && map.get(y+1).charAt(x-1) != symbol) {
            cornerAmount++;
        }

        if(x < map.getFirst().length() - 1 && y < map.size() - 1 && map.get(y).charAt(x+1) == symbol && map.get(y+1).charAt(x) == symbol && map.get(y+1).charAt(x+1) != symbol) {
            cornerAmount++;
        }

        if(x > 0 && y > 0 && map.get(y).charAt(x-1) != symbol && map.get(y-1).charAt(x) != symbol) {
            cornerAmount++;
        }

        if(x < map.getFirst().length() - 1 && y > 0 && map.get(y).charAt(x+1) != symbol && map.get(y-1).charAt(x) != symbol ) {
            cornerAmount++;
        }

        if(x > 0 && y < map.size() - 1 && map.get(y).charAt(x-1) != symbol && map.get(y+1).charAt(x) != symbol) {
            cornerAmount++;
        }

        if(x < map.getFirst().length() - 1 && y < map.size() - 1 && map.get(y).charAt(x+1) != symbol && map.get(y+1).charAt(x) != symbol ) {
            cornerAmount++;
        }

        if(x == 0 && y == 0 || x==0 && y == map.size() - 1 || x == map.getFirst().length() - 1 && y == 0 || x == map.getFirst().length() - 1 && y == map.size() - 1) {
            cornerAmount++;
        }

        if(x == 0 && y > 0 && map.get(y - 1).charAt(x) != symbol){
            cornerAmount++;
        }
        if(x == 0 && y < map.size() - 1 && map.get(y + 1).charAt(x) != symbol){
            cornerAmount++;
        }

        if(x == map.getFirst().length() - 1 && y > 0 && map.get(y - 1).charAt(x) != symbol){
            cornerAmount++;
        }
        if(x == map.getFirst().length() - 1 && y < map.size() - 1 && map.get(y + 1).charAt(x) != symbol){
            cornerAmount++;
        }

        if(y == 0 && x > 0 && map.get(y).charAt(x-1) != symbol){
            cornerAmount++;
        }
        if(y == 0 && x < map.getFirst().length() - 1 && map.get(y).charAt(x+1) != symbol){
            cornerAmount++;
        }

        if(y == map.size() - 1 && x > 0 && map.get(y).charAt(x-1) != symbol){
            cornerAmount++;
        }
        if(y == map.size() - 1 && x < map.getFirst().length() - 1 && map.get(y).charAt(x+1) != symbol){
            cornerAmount++;
        }

        return cornerAmount;
    }

    private static void calculateAreaAndSideHelper(HashSet<Point> alreadyBeen, ArrayList<String> map, Point currentCoordinates, int[] areaAndSides, char symbol) {
        if(alreadyBeen.contains(currentCoordinates)){
            return;
        } else {
            areaAndSides[0] += 1;
            alreadyBeen.add(currentCoordinates);
        }
        int x = currentCoordinates.x;
        int y = currentCoordinates.y;

        areaAndSides[1] += calculateCorners(map, currentCoordinates, symbol);

        if( x > 0 && map.get(y).charAt(x - 1) == symbol) {
            calculateAreaAndSideHelper(alreadyBeen, map, new Point(x-1, y), areaAndSides, symbol);
        }

        if( x < map.get(y).length() - 1 && map.get(y).charAt(x + 1) == symbol) {
            calculateAreaAndSideHelper(alreadyBeen, map, new Point(x+1, y), areaAndSides, symbol);
        }

        if( y > 0 && map.get(y-1).charAt(x) == symbol) {
            calculateAreaAndSideHelper(alreadyBeen, map, new Point(x, y-1), areaAndSides, symbol);
        }

        if( y < map.size() - 1 && map.get(y+1).charAt(x) == symbol) {
            calculateAreaAndSideHelper(alreadyBeen, map, new Point(x, y+1), areaAndSides, symbol);
        }

    }
    private static int[] calculateAreaAndSide(HashSet<Point> alreadyBeen, ArrayList<String> map, Point currentCoordinates, char symbol ) {
        int[] areaAndSides = {0, 0};

        calculateAreaAndSideHelper(alreadyBeen, map, currentCoordinates, areaAndSides, symbol);
        return areaAndSides;
    }
    public static int calculateDiscountPrice(ArrayList<String> map) {
        int price = 0;
        HashSet<Point> alreadyBeen = new HashSet<Point>();

        for(int y = 0; y < map.size(); y++) {
            for(int x = 0; x < map.get(y).length(); x++) {
                if(alreadyBeen.contains(new Point(x, y))){
                    continue;
                }
                int[] areaAndSides = calculateAreaAndSide(alreadyBeen, map, new Point(x, y), map.get(y).charAt(x));
                price += areaAndSides[0] * areaAndSides[1];
            }
        }
        return price;
    }
}
