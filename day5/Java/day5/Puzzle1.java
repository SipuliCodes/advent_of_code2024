package day5;

import utils.DataHandlerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Puzzle1 {
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
        ArrayList<String> correctUpdates = DayFiveUtil.returnCorrectUpdates(ruleString, changes);
        int sum = DayFiveUtil.calculateSumOfMiddleNumbers(correctUpdates);
        System.out.println("Answer is " + sum);
    }
}
