package day4;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayFourUtil {

    public static int findXMASAmount(ArrayList<String> data){
        int amount = 0;
        for(int i = 0; i < data.size(); i++) {
            String regex = "X";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(data.get(i));

            while(matcher.find()) {
                if(i >= 3) {
                    for(int j = -1; j <= 1; j++) {
                        try {
                            if (data.get(i - 1).charAt(matcher.start() + j) == 'M') {
                                if (data.get(i - 2).charAt(matcher.start() + 2 * j) == 'A') {
                                    if (data.get(i - 3).charAt(matcher.start() + 3 * j) == 'S') {
                                        amount++;
                                    }
                                }
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                        }
                    }
                }

                if(matcher.start() >= 3) {
                    if (data.get(i).charAt(matcher.start() - 1) == 'M') {
                        if (data.get(i).charAt(matcher.start() - 2) == 'A') {
                            if (data.get(i).charAt(matcher.start() - 3) == 'S') {
                                amount++;
                            }
                        }
                    }
                }

                if(matcher.start() <= data.get(i).length() - 4) {
                    if (data.get(i).charAt(matcher.start() + 1) == 'M') {
                        if (data.get(i).charAt(matcher.start() + 2) == 'A') {
                            if (data.get(i).charAt(matcher.start() + 3) == 'S') {
                                amount++;
                            }
                        }
                    }
                }

                if(i <= data.size() - 4) {
                    for(int j = -1; j <= 1; j++) {
                        try {
                            if (data.get(i + 1).charAt(matcher.start() + j) == 'M') {
                                if (data.get(i + 2).charAt(matcher.start() + 2 * j) == 'A') {
                                    if (data.get(i + 3).charAt(matcher.start() + 3 * j) == 'S') {
                                        amount++;
                                    }
                                }
                            }
                        } catch (StringIndexOutOfBoundsException e) {
                        }
                    }
                }
            }
        }
        return amount;
    }

    public static int findMASAmount(ArrayList<String> data) {
        int amount = 0;
        for(int i = 1; i < data.size() - 1; i++) {
            String regex = "A";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(data.get(i));

            while(matcher.find()){
                boolean bottomLeftS = false;
                boolean bottomRightS = false;
                if (matcher.start() > 0 && matcher.end() < data.get(i).length()) {
                    if ((data.get(i - 1).charAt(matcher.start() - 1) == 'S' ||
                            data.get(i - 1).charAt(matcher.start() - 1) == 'M')) {
                        bottomRightS = data.get(i - 1).charAt(matcher.start() - 1) == 'M';
                        if ((data.get(i - 1).charAt(matcher.start() + 1) == 'S' ||
                                data.get(i - 1).charAt(matcher.start() + 1) == 'M')) {
                            bottomLeftS = data.get(i - 1).charAt(matcher.start() + 1) == 'M';
                            if ((data.get(i + 1).charAt(matcher.start() + 1) == 'S' && bottomRightS) ||
                                    (data.get(i + 1).charAt(matcher.start() + 1) == 'M' && !bottomRightS)) {

                                if ((data.get(i + 1).charAt(matcher.start() - 1) == 'S' && bottomLeftS) ||
                                        (data.get(i + 1).charAt(matcher.start() - 1) == 'M' && !bottomLeftS)) {
                                    System.out.println("y: "+ i + "x: " + matcher.start());
                                        amount++;
                                }
                            }
                        }
                    }
                }

            }
        }
        return amount;
    }
}
