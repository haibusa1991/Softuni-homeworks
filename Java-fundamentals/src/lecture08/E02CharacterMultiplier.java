package lecture08;

import java.util.Scanner;

public class E02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        System.out.println(sumSymbols(input));
    }


    private static String compareStrings(String[] input, boolean getLongerString) {
        int str0Len = input[0].length();
        int str1Len = input[1].length();

        if(getLongerString && str0Len>=str1Len){
            return input[0];
        }else if(getLongerString){
            return input[1];
        }else if(str0Len>=str1Len){
            return input[1];
        }else {
            return input[0];
        }
    }

    private static int sumSymbols(String[] input) {
        StringBuilder longString = new StringBuilder(compareStrings(input, true));
        StringBuilder shortString = new StringBuilder(compareStrings(input, false));
        int sum = 0;
        while (longString.length() != 0) {
            if (shortString.length() != 0) {
                sum += longString.charAt(0) * shortString.charAt(0);
                longString.deleteCharAt(0);
                shortString.deleteCharAt(0);
            }else {
                sum+=longString.charAt(0);
                longString.deleteCharAt(0);
            }
        }
        return sum;
    }


}
