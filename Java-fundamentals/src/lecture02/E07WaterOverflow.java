package lecture02;

import java.util.Scanner;

public class E07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int currentVolume = 0;
        for (int i = 0; i < n; i++) {
            int currentAmount = Integer.parseInt(scanner.nextLine());
            if (currentVolume + currentAmount > 255) {
                System.out.println("Insufficient capacity!");
            } else {
                currentVolume += currentAmount;
            }

        }
        System.out.println(currentVolume);
    }
}
