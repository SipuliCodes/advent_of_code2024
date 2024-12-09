package day9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class DayNineUtil {
    public static ArrayList<String> diskMapToIndividualBlocks(String diskMap){
        ArrayList<String> individualBlocks = new ArrayList<>();
        int id = 0;
        for(int i = 0; i < diskMap.length(); i++) {
            int count = Integer.parseInt(String.valueOf(diskMap.charAt(i)));
            if (i % 2 == 0) {
                individualBlocks.addAll(Collections.nCopies(count, String.valueOf(id)));
                id++;
            } else {
                individualBlocks.addAll(Collections.nCopies(count, "."));
            }
        }

        return individualBlocks;
    }

    public static ArrayList<String> moveBlocksToLeft(ArrayList<String> individualBlocks) {
        ArrayList<String> individualBlocksToLeft = new ArrayList<>();
        int start = 0;
        int end = individualBlocks.size() - 1;
        while(true) {
            if (!Objects.equals(individualBlocks.get(start), ".")) {
                individualBlocksToLeft.add(individualBlocks.get(start));
                start++;
            }

            if (Objects.equals(individualBlocks.get(end), ".")) {
                end--;
            }

            if (!Objects.equals(individualBlocks.get(end), ".") && Objects.equals(individualBlocks.get(start), ".")) {
                individualBlocksToLeft.add(individualBlocks.get(end));
                start++;
                end--;
            }

            if(start > end) {
                break;
            }
        }

        return individualBlocksToLeft;
    }

    public static long calculateCheckSum(ArrayList<String> blocks) {
        long checkSum = 0;
        for(int i = 0; i < blocks.size(); i++) {

            checkSum += i * Long.parseLong(String.valueOf(blocks.get(i)));
        }
        return checkSum;
    }

}
