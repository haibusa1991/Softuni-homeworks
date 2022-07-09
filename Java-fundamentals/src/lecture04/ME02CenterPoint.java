package lecture04;

import java.util.Arrays;
import java.util.Scanner;

public class ME02CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] point1 = new int[2];
        int[] point2 = new int[2];

        for (int i = 0; i < 2; i++) {
            point1[i] = Integer.parseInt(scanner.nextLine());

        }

        for (int i = 0; i < 2; i++) {
            point2[i] = Integer.parseInt(scanner.nextLine());
        }
        double point1Distance = getDistanceToCenter(point1[0], point1[1]);
        double point2Distance = getDistanceToCenter(point2[0], point2[1]);

        if (point1Distance <= point2Distance) {
            printCoordinates(point1);
        } else {
            printCoordinates(point2);
        }
    }

    public static double getDistanceToCenter(int x, int y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }


    private static void printCoordinates(int[] point) {
        System.out.println(Arrays.toString(point)
                .replace('[', '(')
                .replace(']', ')'));
    }
}
