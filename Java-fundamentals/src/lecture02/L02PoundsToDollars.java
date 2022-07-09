package lecture02;

import java.util.Scanner;

public class L02PoundsToDollars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double pounds = Double.parseDouble(scanner.nextLine());
        System.out.printf("%.3f", pounds * 1.31);
    }
}
