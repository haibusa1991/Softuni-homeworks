package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = readMatrix(scanner);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            if (isValid(input, matrix.length, matrix[0].length)) {
                int[] coordinates = Arrays.stream(input.split(" "))
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                int r1 = coordinates[0];
                int c1 = coordinates[1];
                int r2 = coordinates[2];
                int c2 = coordinates[3];

                String val1 = matrix[r1][c1];
                String val2 = matrix[r2][c2];
                matrix[r1][c1] = val2;
                matrix[r2][c2] = val1;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

    private static boolean isValid(String input, int r, int c) {
        String[] values = input.split(" ");
        if (values.length != 5) {
            return false;
        }
        if (!values[0].equals("swap")) {
            return false;
        }

        int[] coordinates = Arrays.stream(input.split(" ")).skip(1).mapToInt(Integer::parseInt).toArray();
        if (coordinates[0] >= r
                || coordinates[0] < 0
                || coordinates[1] >= c
                || coordinates[1] < 0
                || coordinates[2] >= r
                || coordinates[2] < 0
                || coordinates[3] >= c
                || coordinates[3] < 0) {
            return false;
        }

        return true;
    }

    public static String[][] readMatrix(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = dimensions[0];
        int c = dimensions[1];
        String[][] matrix = new String[r][c];
        for (int i = 0; i < r; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        return matrix;
    }

    public static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
