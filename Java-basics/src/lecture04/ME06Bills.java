package lecture04;

import java.util.Scanner;

public class ME06Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numMonths = Integer.parseInt(scanner.nextLine());

        double electricity = 0;
        int water = 0;
        int internet = 0;
        double other = 0;

        for (int i = 0; i < numMonths; i++) {
            double value = Double.parseDouble(scanner.nextLine());

            electricity += value;
            water += 20;
            internet += 15;
            other += (value + 35) * 1.2;

        }
        System.out.printf("Electricity: %.2f lv\n", electricity);
        System.out.printf("Water: %.2f lv\n", 1.0*water);
        System.out.printf("Internet: %.2f lv\n", 1.0*internet);
        System.out.printf("Other: %.2f lv\n", other);

        double average = (electricity+water+internet+other)/numMonths;
        System.out.printf("Average: %.2f lv",average);

    }
}
