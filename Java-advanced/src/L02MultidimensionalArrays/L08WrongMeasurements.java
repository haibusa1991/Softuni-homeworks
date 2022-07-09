package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] originMatrix = new int[n][];
        for (int i = 0; i < n; i++) {
            originMatrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] wrongValueAddress = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wrongValue = originMatrix[wrongValueAddress[0]][wrongValueAddress[1]];

        int[][] correctedMatrix = new int[n][];

        for (int i = 0; i < originMatrix.length; i++) {
            correctedMatrix[i] = new int[originMatrix[i].length];
            for (int j = 0; j < originMatrix[i].length; j++) {
                if (originMatrix[i][j] == wrongValue) {
                    int correctValue = 0;
                    if (i - 1 >= 0 && originMatrix[i - 1][j] != wrongValue) {
                        correctValue += originMatrix[i - 1][j];
                    }

                    if (i + 1 < originMatrix.length && originMatrix[i + 1][j] != wrongValue) {
                        correctValue += originMatrix[i + 1][j];
                    }

                    if (j - 1 >= 0 && originMatrix[i][j - 1] != wrongValue) {
                        correctValue += originMatrix[i][j - 1];
                    }

                    if (j + 1 < originMatrix[i].length && originMatrix[i][j + 1] != wrongValue) {
                        correctValue += originMatrix[i][j + 1];
                    }

                    correctedMatrix[i][j] = correctValue;
                } else {
                    correctedMatrix[i][j] = originMatrix[i][j];
                }
            }
        }
        printMatrix(correctedMatrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
