package lecture02;

import java.util.Scanner;

public class E09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentSpice = Integer.parseInt(scanner.nextLine());

        int extractedSpice = 0;
        int daysOperated = 0;
        while (currentSpice >= 100) {
            extractedSpice += currentSpice - 26;
            daysOperated++;
            currentSpice -= 10;
        }
        extractedSpice -= 26;
        if (extractedSpice < 0) extractedSpice = 0;
        System.out.printf("%d\n%d", daysOperated, extractedSpice);
    }
}
