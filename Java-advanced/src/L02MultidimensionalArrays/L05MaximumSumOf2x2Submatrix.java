package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);
        int[][] bestMatrix={};
        int bestMatrixSum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int[][] submatrix = {
                        {matrix[i][j], matrix[i][j+1]},
                        {matrix[i + 1][j], matrix[i + 1][j+1]}};
                if (sumMatrix(submatrix) > bestMatrixSum) {
                    bestMatrix = submatrix;
                    bestMatrixSum = sumMatrix(submatrix);
                }
            }
        }
        printMatrix(bestMatrix);
        System.out.println(bestMatrixSum);

    }

    public static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static int sumMatrix(int[][] matrix) {
        return Arrays.stream(matrix)
                .map(e -> Arrays.stream(e).sum())
                .mapToInt(e -> e).sum();
    }

    public static void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
