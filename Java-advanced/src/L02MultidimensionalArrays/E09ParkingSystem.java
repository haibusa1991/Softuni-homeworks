package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E09ParkingSystem {
    static int[][] parkingLot;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] parkingLotDimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = parkingLotDimensions[0];
        int c = parkingLotDimensions[1];
        parkingLot = new int[r][];
        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            int[] data = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            int startRow = data[0];
            int wantedR = data[1];
            int wantedC = data[2];

            if (parkingLot[wantedR] == null) {
                parkingLot[wantedR] = new int[c];
            }

            if (parkingLot[wantedR][wantedC] == 1) {
                int targetR = wantedR;
                int targetC = getNearestSpot(wantedR, wantedC);
                if (targetC == -1) {
                    System.out.println("Row " + wantedR + " full");
                } else {
                    parkingLot[targetR][targetC] = 1;
                    System.out.println(getDistance(startRow, targetR, targetC));
                }
            } else {
                parkingLot[wantedR][wantedC] = 1;
                System.out.println(getDistance(startRow, wantedR, wantedC));
            }
            input = scanner.nextLine();
        }
    }

    private static int getNearestSpot(int r, int c) {
        for (int i = 1; i < parkingLot[r].length; i++) {
            int leftIndex = c - i;
            int rightIndex = c + i;
            int left = 1;
            int right = 1;

            if (leftIndex > 0) {
                left = parkingLot[r][leftIndex];
            }
            if (rightIndex < parkingLot[r].length) {
                right = parkingLot[r][rightIndex];
            }

            if (left == 0) {
                return leftIndex;
            } else if (left == 1 && right == 0) {
                return rightIndex;
            }
        }
        return -1;
    }

    private static int getDistance(int startRow, int r, int c) {
        return Math.abs(startRow - r) + c + 1;
    }
}
