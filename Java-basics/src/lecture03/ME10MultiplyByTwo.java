package lecture03;

import java.util.Scanner;

public class ME10MultiplyByTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = 0;

        while (input >= 0) {
            input = Double.parseDouble(scanner.nextLine());
            if (input >= 0) {
                System.out.printf("Result: %.2f\n", input * 2);
            }
        }
        System.out.println("Negative number!");
    }
}
