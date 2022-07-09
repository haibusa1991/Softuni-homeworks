package lecture02;

import java.util.Scanner;

public class L09CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cent = Integer.parseInt(scanner.nextLine());
        int years = cent * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double mins = hours * 60;
        System.out.printf("%d centuries = %d years = %.0f days = %.0f hours = %.0f minutes",
                cent, years, days, hours, mins);
    }
}
