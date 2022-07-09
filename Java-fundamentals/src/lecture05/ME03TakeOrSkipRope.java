package lecture05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME03TakeOrSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> numbers = new ArrayList<>();
        List<String> letters = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                numbers.add(Integer.parseInt(Character.toString(input.charAt(i))));
            } else {
                letters.add(Character.toString(input.charAt(i)));
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }
        String output = "";
        int hop = 0;
        for (int i = 0; i < letters.size(); i++) {
            if (hop > takeList.size() - 1) {
                break;
            }
            int numCharsToTake = takeList.get(hop);
            for (int j = i; j < i + numCharsToTake; j++) {
                if (j < letters.size()) {
                    output += letters.get(j);
                }
            }
            i += numCharsToTake;
            int numCharsToSkip = skipList.get(hop);
            i += numCharsToSkip - 1;
            hop++;
        }
        System.out.println(output);
    }
}
