package day7;

import utils.DataHandlerUtil;

import java.util.ArrayList;

public class DaySevenUtil {

    private static ArrayList<String> generateCombinations(int n) {
        ArrayList<String> result = new ArrayList<>();
        generateCombinationsHelper("", n, result);
        return result;
    }

    private static void generateCombinationsHelper(String current, int n, ArrayList<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        generateCombinationsHelper(current + "+", n, result);

        generateCombinationsHelper(current + "*", n, result);
    }
    private static boolean isEqual(long answer, ArrayList<Long> numbers, String operations) {
        long sum = numbers.getFirst();
        for(int i = 1; i < numbers.size(); i++) {
            char operation = operations.charAt(i-1);
            if(operation == '*') {
                sum *= numbers.get(i);
            } else if (operation == '+') {
                sum += numbers.get(i);
            }
        }
        return sum == answer;
    }

    public static long calculatePossibleAnswersSum(ArrayList<String> data) {
        long sum = 0;
        for(var line: data) {
            String[] firstSplit = DataHandlerUtil.lineSplitter(line, ": ");
            long answer = Long.parseLong(firstSplit[0]);
            String[] numbersInString = DataHandlerUtil.lineSplitter(firstSplit[1], " ");
            ArrayList<Long> numbers = new ArrayList<>();
            for(var num: numbersInString) {
                numbers.add(Long.parseLong(num));
            }
            ArrayList<String> operations = generateCombinations(numbers.size());
            for(var operation: operations) {
                if(isEqual(answer, numbers, operation)) {
                    sum += answer;
                    System.out.println();
                    break;
                }
            }
        }
        return sum;
    }
}
