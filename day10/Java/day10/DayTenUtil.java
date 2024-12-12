package day10;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DayTenUtil {

    public static ArrayList<Point> findTrailHeads(ArrayList<String> map) {
        ArrayList<Point> trailHeadCoordinates = new ArrayList<>();
        for(int i = 0; i < map.size(); i++) {
            for(int j = 0; j < map.get(i).length(); j++) {
                if(map.get(i).charAt(j) == '0') {
                    trailHeadCoordinates.add(new Point(j, i));
                }
            }
        }
        return trailHeadCoordinates;
    }

    private static void findNextHeight(ArrayList<String> map, Point currentCoordinates, Set<Point> nineCoordinates, int target) {
        int x = currentCoordinates.x;
        int y = currentCoordinates.y;

        if(target == 10) {
            nineCoordinates.add(currentCoordinates);
            return;
        }

        if (x > 0 && map.get(y).charAt(x - 1) - '0' == target) {
            findNextHeight(map, new Point(x - 1, y), nineCoordinates, target + 1);
        }

        if (y > 0 && map.get(y - 1).charAt(x) - '0' == target) {
            findNextHeight(map, new Point(x, y - 1), nineCoordinates, target + 1);
        }

        if (x < map.get(y).length() - 1 && map.get(y).charAt(x + 1) - '0' == target) {
            findNextHeight(map, new Point(x + 1, y), nineCoordinates, target + 1);
        }

        if (y < map.size() - 1 && map.get(y + 1).charAt(x) - '0' == target) {
            findNextHeight(map, new Point(x, y + 1), nineCoordinates, target + 1);
        }
    }

    private static void findNextHeightRating(ArrayList<String> map, Point currentCoordinates, ArrayList<Point> rating, int target) {
        int x = currentCoordinates.x;
        int y = currentCoordinates.y;

        if(target == 10) {
            rating.add(currentCoordinates);
            return;
        }

        if (x > 0 && map.get(y).charAt(x - 1) - '0' == target) {
            findNextHeightRating(map, new Point(x - 1, y), rating, target + 1);
        }

        if (y > 0 && map.get(y - 1).charAt(x) - '0' == target) {
            findNextHeightRating(map, new Point(x, y - 1), rating, target + 1);
        }

        if (x < map.get(y).length() - 1 && map.get(y).charAt(x + 1) - '0' == target) {
            findNextHeightRating(map, new Point(x + 1, y), rating, target + 1);
        }

        if (y < map.size() - 1 && map.get(y + 1).charAt(x) - '0' == target) {
            findNextHeightRating(map, new Point(x, y + 1), rating, target + 1);
        }
    }

    private static int findTrailScore(ArrayList<String> map, Point trailheadCoordinates) {
        Set<Point> nineCoordinates = new HashSet<>();
        findNextHeight(map, trailheadCoordinates, nineCoordinates, 1);

        return nineCoordinates.size();
    }

    private static int findTrailRating(ArrayList<String> map, Point trailheadCoordinates) {
        ArrayList<Point> rating = new ArrayList<>();
        findNextHeightRating(map, trailheadCoordinates, rating, 1);

        return rating.size();
    }

    public static int calculateTrailScoreSum(ArrayList<String> map, ArrayList<Point> trailHeadCoordinates){
        int sum = 0;
        for(var coordinates: trailHeadCoordinates) {
            sum += findTrailScore(map, coordinates);
        }
        return sum;
    }

    public static int calculateTrailRatingSum(ArrayList<String> map, ArrayList<Point> trailHeadCoordinates){
        int sum = 0;
        for(var coordinates: trailHeadCoordinates) {
            sum += findTrailRating(map, coordinates);
        }
        return sum;
    }
}
