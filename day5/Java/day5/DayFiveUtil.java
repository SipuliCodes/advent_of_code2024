package day5;

import utils.DataHandlerUtil;

import java.util.ArrayList;
import java.util.List;

public class DayFiveUtil {

    public static String returnRuleString(List<String> rules) {
        StringBuilder ruleString = new StringBuilder();
        for(var line: rules) {
            ruleString.append(line);
            ruleString.append(", ");
        }
        ruleString.delete(ruleString.length() - 1, ruleString.length());
        return String.valueOf(ruleString);
    }

    public static ArrayList<String> returnCorrectUpdates(String rule, List<String> changes) {
        ArrayList<String> correctUpdates = new ArrayList<>();

        outerLoop:
        for(var line: changes) {
            String[] numbers = DataHandlerUtil.lineSplitter(line,",");
            for(int i = 0; i < numbers.length; i++){
                for(int j = i + 1; j < numbers.length; j++) {
                    String change = numbers[j] + "|" + numbers[i];
                    if((rule.contains(change))) {
                        continue outerLoop;
                    }
                }
            }
            correctUpdates.add(line);
        }
        return correctUpdates;
    }

    public static ArrayList<String> returnFaultyUpdates(String rule, List<String> changes) {
        ArrayList<String> correctUpdates = new ArrayList<>();

        outerLoop:
        for(var line: changes) {
            String[] numbers = DataHandlerUtil.lineSplitter(line,",");
            for(int i = 0; i < numbers.length; i++){
                for(int j = i + 1; j < numbers.length; j++) {
                    String change = numbers[j] + "|" + numbers[i];
                    if((rule.contains(change))) {
                        correctUpdates.add(line);
                        continue outerLoop;
                    }
                }
            }
        }
        return correctUpdates;
    }

    public static ArrayList<String> fixFaultyUpdates(String rule, ArrayList<String> faultyUpdates) {
        ArrayList<String> correctUpdates = new ArrayList<>();

        for(var line: faultyUpdates) {
            String[] numbers = DataHandlerUtil.lineSplitter(line,",");
            for(int i = 0; i < numbers.length; i++){
                for(int j = i + 1; j < numbers.length; j++) {
                    String change = numbers[j] + "|" + numbers[i];
                    if((rule.contains(change))) {
                        String temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                    }
                }
            }
            StringBuilder fixed = new StringBuilder();
            for(var number: numbers) {
                fixed.append(number);
                fixed.append(",");
            }
            fixed.delete(fixed.length(), fixed.length() + 1);
            correctUpdates.add(String.valueOf(fixed));
        }
        return correctUpdates;
    }

    public static int calculateSumOfMiddleNumbers(ArrayList<String> correctUpdates) {
        int sum = 0;
        for(var line: correctUpdates) {
            String[] numbers = DataHandlerUtil.lineSplitter(line, ",");
            sum += Integer.parseInt(numbers[numbers.length / 2]);
        }
        return sum;
    }
}
