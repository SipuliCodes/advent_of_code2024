package day6;

import utils.DataHandlerUtil;

import java.util.ArrayList;
import java.util.HashSet;

enum Direction {
    UP, DOWN, LEFT, RIGHT;
}
public class DaySixUtil {

    public static int calculateWaysToLoop(ArrayList<String> map) {
        Direction direction = Direction.UP;
        Integer[] coordinates = DataHandlerUtil.findSymbolCoordinates(map, "^");
        int x = coordinates[0];
        int y = coordinates[1];

        int ways = 0;

        HashSet<String> visited = new HashSet<>();

        try {
            while (true) {
                String currentPosition = x + "," + y;
                if(visited.contains(currentPosition)) {
                    ways++;
                }

                if (!visited.contains(currentPosition)) {
                    visited.add(currentPosition);
                }

                switch (direction) {
                    case UP:
                        y -= 1;
                        if(map.get(y).charAt(x) == '#') {
                            direction = Direction.RIGHT;
                            y += 1;
                            x += 1;
                        }
                        break;
                    case RIGHT:
                        x += 1;
                        if(map.get(y).charAt(x) == '#') {
                            direction = Direction.DOWN;
                            x -= 1;
                            y += 1;
                        }
                        break;
                    case DOWN:
                        y += 1;
                        if(map.get(y).charAt(x) == '#') {
                            direction = Direction.LEFT;
                            y -= 1;
                            x -= 1;
                        }
                        break;
                    case LEFT:
                        x -= 1;
                        if(map.get(y).charAt(x) == '#') {
                            direction = Direction.UP;
                            x += 1;
                            y -= 1;
                        }
                        break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Got out of map");
        }

        return ways;
    }
    public static int calculateSteps(ArrayList<String> map) {
        Direction direction = Direction.UP;
        Integer[] coordinates = DataHandlerUtil.findSymbolCoordinates(map, "^");
        int x = coordinates[0];
        int y = coordinates[1];

        int steps = 0;

        HashSet<String> visited = new HashSet<>();

        try {
            while (true) {
                String currentPosition = x + "," + y;

                if (!visited.contains(currentPosition)) {
                    visited.add(currentPosition);
                    steps++;
                }

                switch (direction) {
                    case UP:
                        y -= 1;
                        if(map.get(y).charAt(x) == '#') {
                            direction = Direction.RIGHT;
                            y += 1;
                            x += 1;
                        }
                        break;
                    case RIGHT:
                        x += 1;
                        if(map.get(y).charAt(x) == '#') {
                            direction = Direction.DOWN;
                            x -= 1;
                            y += 1;
                        }
                        break;
                    case DOWN:
                        y += 1;
                        if(map.get(y).charAt(x) == '#') {
                            direction = Direction.LEFT;
                            y -= 1;
                            x -= 1;
                        }
                        break;
                    case LEFT:
                        x -= 1;
                        if(map.get(y).charAt(x) == '#') {
                            direction = Direction.UP;
                            x += 1;
                            y -= 1;
                        }
                        break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Got out of map");
        }

        return steps;
    }
}
