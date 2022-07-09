package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatricesUtil {
    public static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int columns, String delimiter) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(delimiter)).mapToInt(Integer::parseInt).toArray();
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

    private static boolean isValid(int r, int c, int[][] matrix) {
        return !(r < 0
                || r > matrix.length - 1
                || c < 0
                || c > matrix[r].length - 1);
    }
}
