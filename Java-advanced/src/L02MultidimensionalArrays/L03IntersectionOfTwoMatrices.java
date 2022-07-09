package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        int[][] matrix1 = readMatrix(scanner, rows, columns);
        int[][] matrix2 = readMatrix(scanner, rows, columns);
        int[][] matrix3 = mergeMatrix(matrix1, matrix2);
        printCharMatrix(matrix3);

    }

    private static void printCharMatrix(int[][] matrix3) {
        for (int[] ints : matrix3) {
            for (int j = 0; j < matrix3[0].length; j++) {
                System.out.print((char) ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] mergeMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] output = new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                output[i][j] = matrix1[i][j] == matrix2[i][j] ? matrix1[i][j] : (int) '*';
            }
        }
        return output;
    }

    public static int[][] readMatrix(Scanner scanner, int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> (e.charAt(0))).toArray();
        }
        return matrix;
    }
}
