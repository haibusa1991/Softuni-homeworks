package lecture04;

import java.util.Scanner;

public class L11CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washingMachinePrice = Double.parseDouble(scanner.nextLine());
        int toySalePrice = Integer.parseInt(scanner.nextLine());

        int numToys = 0;
        int moneySaved = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 != 0) {
                numToys++;
            } else {
                moneySaved += i * 10 / 2 - 1;
            }
        }

        moneySaved += numToys * toySalePrice;

        if (washingMachinePrice <= moneySaved) {
            System.out.printf("Yes! %.2f", moneySaved - washingMachinePrice);
        } else {
            System.out.printf("No! %.2f", washingMachinePrice - moneySaved);
        }
    }
}
