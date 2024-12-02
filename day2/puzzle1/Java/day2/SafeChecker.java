package day2;

import java.util.ArrayList;

public class SafeChecker {
    public static boolean decreaseSafe(ArrayList<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            int difference = list.get(i) - list.get(i+1);
            if (difference > 3 || difference < 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean increaseSafe(ArrayList<Integer> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            int difference = list.get(i) - list.get(i+1);
            if (difference < -3 || difference > -1) {
                return false;
            }
        }
        return true;
    }
}
