package day3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayThreeUtil {
    static boolean findDo = false;

    public static String lineModifier(String line) {
        StringBuilder newLine = new StringBuilder();
        int firstCharacter = 0;

        String regex = "do\\(\\)|don't\\(\\)";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(line);

        while(matcher.find()){
            if(Objects.equals(matcher.group(), "don't()") && !findDo) {
                newLine.append(line, firstCharacter, matcher.end());
                firstCharacter = matcher.end();
                findDo = true;
            }
            if(Objects.equals(matcher.group(), "do()") && findDo) {
                firstCharacter = matcher.end();
                findDo = false;
            }
        }

        if(!findDo) {
            newLine.append(line, firstCharacter, line.length());
        }

        return String.valueOf(newLine);
    }

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
