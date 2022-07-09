package lecture02;

import java.util.Scanner;

public class L12RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNum = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= totalNum; i++) {
            int currentNum = i;
            int sumOfDigits = 0;
            while (currentNum > 0) {
                sumOfDigits += currentNum % 10;
                currentNum = currentNum / 10;
            }
            boolean isSpecial = false;
            isSpecial = (sumOfDigits == 5) || (sumOfDigits == 7) || (sumOfDigits == 11);
            String isSpecialString = "";
            if (isSpecial) {
                isSpecialString = "True";
            } else {
                isSpecialString = "False";
            }
            System.out.printf("%d -> %s%n", i, isSpecialString);
        }

    }
}
