package Exam;

import java.util.Scanner;

public class T01PcStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double cpuPrice = Double.parseDouble(scanner.nextLine());
        double videoPrice = Double.parseDouble(scanner.nextLine());
        double ramPrice = Double.parseDouble(scanner.nextLine());
        int numRamSticks = Integer.parseInt(scanner.nextLine());
        double discount = Double.parseDouble(scanner.nextLine());

        double finalPrice = ((cpuPrice + videoPrice) * (1 - discount) + ramPrice * numRamSticks) * 1.57;

        System.out.printf("Money needed - %.2f leva.", finalPrice);
    }
}
