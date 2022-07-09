package lecture03;

import java.util.Arrays;
import java.util.Scanner;

public class E01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCars = Integer.parseInt(scanner.nextLine());

        int[] train = new int[numCars];
        for (int i = 0; i < numCars; i++) {
            train[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int value : train) {
            System.out.print(value + " ");
        }
        System.out.println("\n" + Arrays.stream(train).sum());
    }
}
