package lecture02;

import java.util.Scanner;

public class L01MetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());
        System.out.printf("%.2f", 1.0 * meters / 1000);
    }
}
