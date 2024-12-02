package day2;

import java.util.ArrayList;

public class SafeCheckerWithProblemDampener {

    private static boolean isDecreaseSafe(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int difference = list.get(i) - list.get(i + 1);
            if (difference > 3 || difference < 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncreaseSafe(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int difference = list.get(i) - list.get(i + 1);
            if (difference < -3 || difference > -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean decreaseSafe(ArrayList<Integer> list) {
        if (isDecreaseSafe(list)) {
            return true;
        }
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> listCopy = new ArrayList<>(list);
                listCopy.remove(i);
                if (isDecreaseSafe(listCopy)) {
                    return true;
                }
            }
        return false;
    }

    public static boolean increaseSafe(ArrayList<Integer> list) {
        if (isIncreaseSafe(list)) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> listCopy = new ArrayList<>(list);
                listCopy.remove(i);
                if (isIncreaseSafe(listCopy)) {
                    return true;
                }
            }
        return false;
    }
}
