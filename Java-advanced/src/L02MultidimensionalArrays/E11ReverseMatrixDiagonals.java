package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class E11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = tokens[0];
        int c = tokens[1];
        int[][] matrix = new int[r][];
        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                int r2 = matrix.length - j - 1;
                int c2 = c + j - i - 1;
                if (isValid(r2, c2, matrix)) {
                    System.out.print(matrix[r2][c2] + " ");
                } else {
                    break;
                }
            }
            System.out.println();
        }

        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < r; j++) {
                int r2 = r - 2 - j-i;
                int c2 = j;
                if (isValid(r2, c2, matrix)) {
                    System.out.print(matrix[r2][c2] + " ");
                } else {
                    break;
                }
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
