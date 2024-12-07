package day5;

import utils.DataHandlerUtil;

import java.util.ArrayList;
import java.util.List;

public class Puzzle2 {
    public static void main(String[] args) {
        ArrayList<String> data = DataHandlerUtil.readFile("./day5/data.txt");
        List<String> rules = new ArrayList<>();
        List<String> changes = new ArrayList<>();
        String ruleString;

        for(int i = 0; i < data.size(); i++) {
            if(data.get(i).isEmpty()){
                rules = data.subList(0, i - 1);
                changes = data.subList(i+ 1, data.size());
            }
        }

        ruleString = DayFiveUtil.returnRuleString(rules);
        ArrayList<String> faultyUpdates = DayFiveUtil.returnFaultyUpdates(ruleString, changes);
        ArrayList<String> fixedUpdates = DayFiveUtil.fixFaultyUpdates(ruleString, faultyUpdates);
        int sum = DayFiveUtil.calculateSumOfMiddleNumbers(fixedUpdates);
        System.out.println("Answer is " + sum);
    }
}
