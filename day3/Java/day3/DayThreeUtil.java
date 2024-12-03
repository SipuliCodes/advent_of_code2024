package day3;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThreeUtil {

    public static ArrayList<Integer> findMul(String line){
        ArrayList<Integer> numbers = new ArrayList<>();

        String regex = "mul\\((\\d+),(\\d+)\\)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(line);

        while(matcher.find()){
            numbers.add(Integer.parseInt(matcher.group(1)));
            numbers.add(Integer.parseInt(matcher.group(2)));
        }

        return numbers;
    }

    public static int calculateSum(ArrayList<Integer> numbers){
        int sum = 0;
        for(int i = 0; i < numbers.size() - 1; i += 2) {
            sum += numbers.get(i) * numbers.get(i+1);
        }
        return sum;
    }
}
