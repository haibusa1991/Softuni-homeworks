package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int columns = dimensions[1];
        int[][] matrix = readMatrix(scanner, rows, columns, ", ");
        System.out.println(rows);
        System.out.println(columns);
        int sum = Arrays.stream(matrix)
                .map(e -> Arrays.stream(e).sum())
                .mapToInt(e -> e).sum();
        System.out.println(sum);
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int columns, String delimiter) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(delimiter)).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
