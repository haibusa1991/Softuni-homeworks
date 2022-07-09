package lecture02;

import java.util.Scanner;

public class ME02FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] strings = input.split(" ");
            double leftNumber = Double.parseDouble(strings[0]);
            double rightNumber = Double.parseDouble(strings[1]);
            double biggerNumber = Math.abs(Math.max(leftNumber, rightNumber));
            int sum = 0;
            while (biggerNumber > 0) {
                sum += biggerNumber % 10;
                biggerNumber /= 10;
            }
            System.out.println(sum);
        }
    }

}
