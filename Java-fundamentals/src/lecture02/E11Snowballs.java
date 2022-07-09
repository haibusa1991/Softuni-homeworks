package lecture02;

import java.util.Scanner;

public class E11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double[] bestValues = {0, 0, 0, 0};
        for (int i = 0; i < n; i++) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());
            double value = Math.pow((1.0 * snow / time), quality);
            if (value > bestValues[3]) {
                bestValues[0] = snow;
                bestValues[1] = time;
                bestValues[2] = quality;
                bestValues[3] = value;
            }

        }
        System.out.printf("%.0f : %.0f = %.0f (%.0f)", bestValues[0], bestValues[1], bestValues[3], bestValues[2]);
    }
}
