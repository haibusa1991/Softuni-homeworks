package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = input[0];
        int c = input[1];
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] bestMatrix = new int[3][3];
        int bestMatrixSum = Integer.MIN_VALUE;
        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                int[][] currentMatrix=new int[3][3];
                for (int k = 0; k < 3; k++) {
                    System.arraycopy(matrix[i + k], j, currentMatrix[k], 0, 3);
                }
                if (sumMatrix(currentMatrix) > bestMatrixSum) {
                    bestMatrix = currentMatrix;
                    bestMatrixSum = sumMatrix(currentMatrix);
                }
            }
        }
        System.out.println("Sum = " + bestMatrixSum);
        printMatrix(bestMatrix);
    }

    public static int sumMatrix(int[][] matrix) {
        return Arrays.stream(matrix)
                .map(e -> Arrays.stream(e).sum())
                .mapToInt(e -> e).sum();
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
