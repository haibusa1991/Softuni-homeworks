package L02MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class L07FindTheRealQueen {
    private static final int n = 8; // size of matrix

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> e.charAt(0))
                    .toArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 113 && isReal(matrix, i, j)) { // 113 -> 'q'
                    System.out.println((i) + " " + (j));
                }
            }
        }
    }

    private static boolean isReal(int[][] matrix, int row, int column) {
        int queensFound = 0;
        for (int i = 0; i < n; i++) {
            if (matrix[i][column] == 113) {
                queensFound++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (matrix[row][i] == 113) {
                queensFound++;
            }
        }

        //r1 - starting row of left diagonal
        //c1 - starting column of left diagonal
        //r2 - end row of left diagonal
        //c2 - end column of left diagonal

        int r1 = Math.max(row - column, 0);
        int c1 = Math.max(column - row, 0);
        int r2 = n - 1 - c1;
        int c2 = n - 1 - r1;
        for (int i = 0; i < r2 - r1+1; i++) {
            if (matrix[r1 + i][c1 + i] == 113) {
                queensFound++;
            }
        }

        //r3 - starting row of right diagonal
        //c3 - starting column of right diagonal
        //r4 - end row of right diagonal
        //c4 - end column of right diagonal

        int r3 = Math.max(row - (n - 1 - column), 0);
        int c3 = Math.min(row + column, n - 1);
        int r4 = c3;
        int c4 = r3;

        for (int i = 0; i < r4 - r3 + 1; i++) {
            if (matrix[r3 + i][c3 - i] == 113) {
                queensFound++;
            }
        }
        return queensFound == 4;
    }
}
